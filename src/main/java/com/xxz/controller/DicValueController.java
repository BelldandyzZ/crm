package com.xxz.controller;

import com.xxz.annotations.Permission;
import com.xxz.bean.*;
import com.xxz.bean.vo.EchartsObj;
import com.xxz.mapper.PaymentBackMapper;
import com.xxz.service.DicValueService;
import com.xxz.service.EmpService;
import com.xxz.service.ProjectService;
import com.xxz.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.*;

@Controller
@RequestMapping("/dic")
public class DicValueController {

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    EmpService empService;

    @Autowired
    ProjectService projectService;

    @Autowired
    PaymentBackMapper paymentBackMapper;



    /*查询所有*/
    @RequestMapping("/dics")
    @Permission("501010")
    public String queryAllDic(Model model , String vValue, String type, HttpSession session){

//=====================================================================================================



        List<DicValue> dicValues = dicValueService.queryAllDic(vValue, type);
        model.addAttribute("dicValues", dicValues);



        return "dicvalue\\dicvalue";
    }

    /*新增*/
    @Permission("501020")
    @RequestMapping("/add")
    public String add(DicValue dicValue, String type){
        boolean result = dicValueService.add(dicValue, type);
        return "redirect:/dic/dics";
    }

    /*根据vId查询进行修改*/
    @RequestMapping("/queryById/{vId}")
    @ResponseBody
    @Permission("501010")
    public Map<String,Object> queryById(@PathVariable("vId") Integer vId, HttpServletResponse response) throws IOException {

        DicValue dicValue = dicValueService.queryById(vId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",dicValue);
        return stringObjectHashMap;
    }

    /*修改*/
    @RequestMapping("/update")
    @Permission("501030")
    public String update(DicValue dicValue, String type){
        boolean result = dicValueService.update(dicValue, type);
        return "redirect:/dic/dics";
    }
    /*删除*/
    @RequestMapping("/del/{vId}")
    @Permission("501040")
    public String del(@PathVariable("vId") Integer vId){
        boolean result = dicValueService.del(vId);
        return "redirect:/dic/dics";
    }


    /*统计报表*/
    @RequestMapping("/echartsData")
    @ResponseBody
    @Permission("40")
    public List<String[]> echartsObjs(String empName,
                                      String startTime,
                                      String endTime) throws UnsupportedEncodingException {//根据用户，时间断查询


        List<EchartsObj> echartsObjs = new ArrayList<EchartsObj>();
        //获取所有员工信息
        List<Employee> employeeList = empService.queryAllEmp(empName, null, null);
        for (Employee employee : employeeList) {
            EchartsObj echartsObj = new EchartsObj();
            echartsObj.seteId(employee.geteId());
            echartsObj.setEmpName(employee.getRename());
            echartsObjs.add(echartsObj);
        }
        for (EchartsObj echartsObj : echartsObjs) {
            //通过每个员工获取每个员工所有项目总金额总回款
            List<Project> projects = projectService.queryAllProject(null, null, null, echartsObj.getEmpName());
            //累加所有项目金额
            //所有金额 - 回款金额 = 待回款金额
            String allPrice = "0"; //所有金额
            Double allPriceInterger = Double.parseDouble(allPrice);
            String allBackPrice = "0"; //回款金额
            Double allBackPriceInteger = Double.parseDouble(allBackPrice);
            String allPreBackPrice = "0"; //待回款金额
            Double allPreBackPriceInteger = Double.parseDouble(allPreBackPrice);
            //================================================
            for (Project project : projects) {
                String proStartTimeStr = "";
                String[] proSplit = project.getStartTime().split("-");
                for (String s : proSplit) {
                    proStartTimeStr += s;
                }
                //==============================
               if(startTime != null && !startTime.equals("")){
                   String conStartTimeStr = "";
                   String[] con_split = startTime.split("-");
                   for (String s : con_split) {
                       conStartTimeStr += s;
                   }
                   //如果项目启动时间小于目标条件时间，则跳过
                   if(Integer.parseInt(proStartTimeStr) < Integer.parseInt(conStartTimeStr)){
                       continue;
                   }
               }


                String proEndTimeStr = "";
                if(project.getEndTime() != null){
                    String[] proSplit2 = project.getEndTime().split("-");
                    for (String s : proSplit2) {
                        proEndTimeStr += s;
                    }
                }
                if(endTime != null && !endTime.equals("")){
                    String conEndTimeStr = "";
                    String[] con_split = endTime.split("-");
                    for (String s : con_split) {
                        conEndTimeStr += s;
                    }
                    //如果项目启动时间小于目标条件时间，则跳过
                    if(Integer.parseInt(proEndTimeStr) > Integer.parseInt(conEndTimeStr)){
                        continue;
                    }
                }
                //==============================
                String pMoney = project.getpMoeny();
//                //会不会有W
//                if (pMoney.contains("W")){
//
//                }
                if(pMoney == null || pMoney.equals("")){
                    allPriceInterger += new Double(0);
                }else{
                    allPriceInterger += Double.parseDouble(pMoney);
                }

                //计算当前项目回款金额
                Integer pbId = project.getPbId(); //当前项目PBId
                PaymentBackExample paymentBackExample = new PaymentBackExample();
                paymentBackExample.createCriteria().andPbIdBetween(pbId, pbId+999);
                //当前项目所有回款
                List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample);
                //累加
                for (PaymentBack paymentBack : paymentBacks) {
                    allBackPriceInteger += Double.parseDouble(paymentBack.getPbMoney() + "");
                }
                //
            }
            //==============================================================
            allPreBackPriceInteger = allPriceInterger - allBackPriceInteger;
            allPrice = allPriceInterger + "";
            allBackPrice = allBackPriceInteger + "";
            allPreBackPrice = allPreBackPriceInteger + "";
            //追加到每一个对象EchartsOBj中
            echartsObj.setBackPrice(allBackPrice);
            echartsObj.setPreBackPrice(allPreBackPrice);
        }

        Object[] objectsArr = echartsObjs.toArray();
//        Object[] objects = new Object[objectsArr.length + 1];
        List<String[]> data = new ArrayList<>();
        /*追加前缀*/
        String[] echartsObj = new String[3];
        echartsObj[0] = "empName";
        echartsObj[1] = "回款金额";
        echartsObj[2] = "待回款金额";
//        objects[0] = echartsObj;
        data.add(echartsObj);
        //后续数据追加
        for (EchartsObj obj : echartsObjs) {
            String[] echartsObj2 = new String[4];
            echartsObj2[0] = obj.getEmpName();
            echartsObj2[1] = obj.getBackPrice();
            echartsObj2[2] = obj.getPreBackPrice();
            echartsObj2[3] = String.valueOf(obj.geteId());
            //            objects[i + 1] = echartsObj2;
            data.add(echartsObj2);
        }

        return data;
    }

    /*统计报表2*/
    @RequestMapping("/echartsDataDetail")
    @ResponseBody
    @Permission("40")
    public List<String[]> echartsDataDtail(String empName,
                                      String startTime,
                                      String endTime
            , Integer eId, HttpSession session, Model model) throws UnsupportedEncodingException {//根据用户，时间断查询


        EchartsObj echartsObjs = new EchartsObj();
        //获取所有员工信息
        Employee employee = empService.queryById(eId);

        //回显条件
//        session.setAttribute("eRname", employee.getRename());
//        model.addAttribute("empName", employee.getRename());
            //通过每个员工获取每个员工所有项目总金额总回款
            List<Project> projects = projectService.queryAllProject(null, null, null, employee.getRename());

        List<EchartsObj> echartsObjList = new ArrayList<>();




            for (Project project : projects) {
                String proStartTimeStr = "";
                if(project.getStartTime() != null){
                    String[] proSplit = project.getStartTime().split("-");
                    for (String s : proSplit) {
                        proStartTimeStr += s;
                    }
                }
                //==============================
                if(startTime != null && !startTime.equals("")){
                    String conStartTimeStr = "";
                    String[] con_split = startTime.split("-");
                    for (String s : con_split) {
                        conStartTimeStr += s;
                    }
                    //如果项目启动时间小于目标条件时间，则跳过
                    if(Integer.parseInt(proStartTimeStr) < Integer.parseInt(conStartTimeStr)){
                        continue;
                    }
                }


                String proEndTimeStr = "";
                if(project.getEndTime() != null){
                    String[] proSplit2 = project.getEndTime().split("-");
                    for (String s : proSplit2) {
                        proEndTimeStr += s;
                    }
                }
                if(endTime != null && !endTime.equals("")){
                    String conEndTimeStr = "";
                    String[] con_split = endTime.split("-");
                    for (String s : con_split) {
                        conEndTimeStr += s;
                    }
                    //如果项目启动时间小于目标条件时间，则跳过
                    if(Integer.parseInt(proEndTimeStr) > Integer.parseInt(conEndTimeStr)){
                        continue;
                    }
                }



                EchartsObj echartsObj = new EchartsObj();
                echartsObj.setEmpName(project.getpName());
                echartsObj.seteId(project.getpId());
                //累加所有项目金额
                //所有金额 - 回款金额 = 待回款金额
                String allPrice = "0"; //所有金额
                Double allPriceInterger = Double.parseDouble(allPrice);
                String allBackPrice = "0"; //回款金额
                Double allBackPriceInteger = Double.parseDouble(allBackPrice);
                String allPreBackPrice = "0"; //待回款金额
                Double allPreBackPriceInteger = Double.parseDouble(allPreBackPrice);
                //================================================

                //==============================
                String pMoney = project.getpMoeny();
//                //会不会有W
//                if (pMoney.contains("W")){
//
//                }
                if(pMoney == null || pMoney.equals("")){
                    allPriceInterger += new Double(0);
                }else{
                    allPriceInterger += Double.parseDouble(pMoney);
                }


                //计算当前项目回款金额
                Integer pbId = project.getPbId(); //当前项目PBId
                PaymentBackExample paymentBackExample = new PaymentBackExample();
                paymentBackExample.createCriteria().andPbIdBetween(pbId, pbId+999);
                //当前项目所有回款
                List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample);
                //累加
                for (PaymentBack paymentBack : paymentBacks) {
                    allBackPriceInteger += Double.parseDouble(paymentBack.getPbMoney() + "");
                }
                //


                //==============================================================
                allPreBackPriceInteger = allPriceInterger - allBackPriceInteger;
                allPrice = allPriceInterger + "";
                allBackPrice = allBackPriceInteger + "";
                allPreBackPrice = allPreBackPriceInteger + "";
                //追加到每一个对象EchartsOBj中
                echartsObj.setBackPrice(allBackPrice);
                echartsObj.setPreBackPrice(allPreBackPrice);

                echartsObjList.add(echartsObj);
            }
        //将数据打成OBJ数组
        Object[] objectsArr = echartsObjList.toArray();
//        Object[] objects = new Object[objectsArr.length + 1];
        List<String[]> data = new ArrayList<>();
        /*追加前缀*/
        String[] echartsObj = new String[3];
        echartsObj[0] = "empName";
        echartsObj[1] = "回款金额";
        echartsObj[2] = "待回款金额";
//        objects[0] = echartsObj;
        data.add(echartsObj);
        //后续数据追加
        for (EchartsObj obj : echartsObjList) {
            String[] echartsObj2 = new String[4];
            echartsObj2[0] = obj.getEmpName();
            echartsObj2[1] = obj.getBackPrice();
            echartsObj2[2] = obj.getPreBackPrice();
            echartsObj2[3] = String.valueOf(obj.geteId());
            //            objects[i + 1] = echartsObj2;
            data.add(echartsObj2);
        }
        return data;
    }
}
