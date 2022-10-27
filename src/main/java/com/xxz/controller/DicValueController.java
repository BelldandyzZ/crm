package com.xxz.controller;

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

    @Autowired
    private RoleService roleService;


    /*查询所有*/
    @RequestMapping("/dics")
    public String queryAllDic(Model model , String vValue, String type, HttpSession session){
        session.setAttribute("jobTypes", dicValueService.getAllJobType());
        session.setAttribute("companyTypes", dicValueService.getAllCompanyType());
        session.setAttribute("progressTypes", dicValueService.getAllProgress());
        session.setAttribute("schoolTypes", dicValueService.getAllSchoolType());
        session.setAttribute("dicvalueTypes", dicValueService.getAllDicType());
        session.setAttribute("pNames", projectService.getAllProjectName());
        session.setAttribute("allType", dicValueService.getAllType());
//=====================================================================================================



        List<DicValue> dicValues = dicValueService.queryAllDic(vValue, type);
        model.addAttribute("dicValues", dicValues);



        return "dicvalue\\dicvalue";
    }

    /*新增*/
    @RequestMapping("/add")
    public String add(DicValue dicValue, String type){
        boolean result = dicValueService.add(dicValue, type);
        return "redirect:/dic/dics";
    }

    /*根据vId查询进行修改*/
    @RequestMapping("/queryById/{vId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("vId") Integer vId, HttpServletResponse response) throws IOException {

        DicValue dicValue = dicValueService.queryById(vId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",dicValue);
        return stringObjectHashMap;
    }

    /*修改*/
    @RequestMapping("/update")
    public String update(DicValue dicValue, String type){
        System.out.println(dicValue);
        boolean result = dicValueService.update(dicValue, type);
        return "redirect:/dic/dics";
    }
    /*删除*/
    @RequestMapping("/del/{vId}")
    public String del(@PathVariable("vId") Integer vId){
        boolean result = dicValueService.del(vId);
        return "redirect:/dic/dics";
    }

    /*统计报表*/
    @RequestMapping("/echartsData")
    @ResponseBody
    public List<String[]> echartsObjs(String empName,
                                      @RequestParam(required = false) Date startTime,
                                      @RequestParam(required = false)Date endTime ){//根据用户，时间断查询
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
                String pMoney = project.getpMoeny();
//                //会不会有W
//                if (pMoney.contains("W")){
//
//                }
                allPriceInterger += Double.parseDouble(pMoney);

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
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println(echartsObjs);
        //将数据打成OBJ数组
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
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println("========================================================");
//        System.out.println(data);
//        for (String[] datum : data) {
//            for (String s : datum) {
//                System.out.println(s);
//            }
//        }
        return data;
    }
}
