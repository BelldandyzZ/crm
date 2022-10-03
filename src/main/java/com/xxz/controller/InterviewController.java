package com.xxz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.xxz.bean.*;
import com.xxz.listener.DemoDataListener;
import com.xxz.mapper.CustomerMapper;
import com.xxz.mapper.EmployeeMapper;
import com.xxz.mapper.InterviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    //条件查询
    @RequestMapping("/interviews")
    public String queryAll(Model model, String iCompany, String cRename, String eRename) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll-interviews-confition:" + iCompany + "-" + cRename + "-" + eRename);
        //样本
        InterviewExample interviewExample = new InterviewExample();
        //条件盒子
        InterviewExample.Criteria criteria = interviewExample.createCriteria();
        //追加条件
        if (iCompany != null && !iCompany.equals("")){
            criteria.andICompanyLike("%" + iCompany + "%");
        }
        if(cRename != null && !cRename.equals("")){
            //样本
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andCRenameEqualTo(cRename);
            Customer cus = customerMapper.selectByExample(customerExample).get(0);
            //包含cids
            criteria.andCIdEqualTo(cus.getcId());
        }
        if(eRename != null && !eRename.equals("")){
            //样本
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andRenameEqualTo(eRename);
            Employee emp = employeeMapper.selectByExample(employeeExample).get(0);
            criteria.andEIdEqualTo(emp.geteId());
        }
        //============================================================================
        //(1)查询
        List<Interview> interviewList = interviewMapper.selectByExample(interviewExample);
        for (Interview interview : interviewList) {
            //设置客户姓名
            interview.setcRename(customerMapper.selectByPrimaryKey(interview.getcId()).getcRename());
            //我方员工姓名
            interview.seteRename(employeeMapper.selectByPrimaryKey(interview.geteId()).getRename());
            //设置拜访类型
            interview.setpName("农村购物致富商城系统项目");
        }
        System.out.println("条件查询结果：" + interviewList);
        model.addAttribute("interviewList", interviewList);
        //============================================================================
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        List<Customer> customerList = customerMapper.selectByExample(null);
        List<Employee> employeeList = employeeMapper.selectByExample(null);
        //获取所有客户单位
        Set<String> companySet = new HashSet<>();
        //获取所有客户名称
        Set<String> cRenameSet = new HashSet<>();
        //获取所有我方员工姓名
        Set<String> eRenameSet = new TreeSet<>();
        //去重
        for (Customer customer : customerList) {
            companySet.add(customer.getcName());
            cRenameSet.add(customer.getcRename());
        }
        for (Employee employee : employeeList) {
            eRenameSet.add(employee.getRename());
        }
        model.addAttribute("companySet",companySet );
        model.addAttribute("cRenameSet",cRenameSet );
        model.addAttribute("eRenameSet",eRenameSet );
        return "interview/interview";
    }

    //id查询
    @RequestMapping("/queryById/{cId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("cId") Integer cId, HttpServletResponse response) throws IOException {
        Interview interview = interviewMapper.selectByPrimaryKey(cId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",interview);
//        response.getWriter().println(Interview);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    public String cusAdd(Interview interview){
        System.out.println("add cus..." + interview);
        //调用接口将数据添加到数据库
        interviewMapper.insertSelective(interview);
        return "redirect:/interview/interviews";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    public String cusDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        interviewMapper.deleteByPrimaryKey(eId);
        //重定向到empList界面展示最新数据
        return "redirect:/interview/interviews";
    }

    //修改
    @RequestMapping("/update")
    public String cusUpdate(Interview interview){
        //展示emp
        System.out.println(interview);
        //调用目标接口实现信息修改
        interviewMapper.updateByPrimaryKeySelective(interview);
        //重定向到empMenu界面
        return "redirect:/interview/interviews";
    }

    /*excel导入导出*/
    @RequestMapping(value = "/excelInport", method = RequestMethod.POST)
    public String excelInport(MultipartFile importFile){
        System.out.println("文件名：" + importFile.getOriginalFilename());
//        System.out.println("input.........................");
//        String fileName = "E:\\员工信息表.xlsx";
//        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//        EasyExcel.read(fileName, Employee.class, new DemoDataListener()).sheet().doRead();
        // 解析Excel
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(importFile.getInputStream(), Interview.class, new DemoDataListener<Interview>()).build();
            ReadSheet readSheet = EasyExcelFactory.readSheet(0).build();
            excelReader.read(readSheet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (excelReader != null) {
                excelReader.finish();
            }
        }
        //重定向到empMenu界面
        return "redirect:/interview/interviews";
    }

    //导出
    @RequestMapping("/excelOutput") //ResponseEntity<byte[]>
    public void excelOutput(HttpSession session, HttpServletResponse response) throws IOException {
        //获取本机桌面地址
//        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//        String PATH = desktopDir.getAbsolutePath() + "\\";
//        String fileName = PATH + "员工信息表.xlsx";
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("访谈信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Interview> interviewList = interviewMapper.selectByExample(null);
        for (Interview interview : interviewList) {
            //设置客户姓名
            interview.setcRename(customerMapper.selectByPrimaryKey(interview.getcId()).getcRename());
            //我方员工姓名
            interview.seteRename(employeeMapper.selectByPrimaryKey(interview.geteId()).getRename());
            //设置拜访类型
            interview.setpName("农村购物致富商城系统项目");
        }
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Interview.class).sheet("模板").doWrite(interviewList);
        System.out.println("excelOutput.................");
    }


}
