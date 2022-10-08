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
import com.xxz.mapper.ProjectMapper;
import com.xxz.service.CustomerService;
import com.xxz.service.EmpService;
import com.xxz.service.InterviewService;
import com.xxz.service.ProjectService;
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
    private InterviewService interviewService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private ProjectService projectService;

    //条件查询
    @RequestMapping("/interviews")
    public String queryAll(Model model, String iCompany, String cRename, String eRename) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll-interviews-confition:" + iCompany + "-" + cRename + "-" + eRename);

        List<Interview> interviewList = interviewService.queryAllInterview(iCompany, cRename, eRename);
        System.out.println(interviewList);
        model.addAttribute("interviewList", interviewList);
        //============================================================================
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        List<Customer> customerList = customerService.queryAllCus(null, null, null);
        List<Employee> employeeList = empService.queryAllEmp(null, null, null);
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
        Interview interview = interviewService.queryById(cId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",interview);
//        response.getWriter().println(Interview);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    public String itwAdd(Interview interview, String[] cRenames, String eRename){
        interviewService.itwAdd(interview, cRenames,eRename);
        return "redirect:/interview/interviews";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    public String cusDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        boolean result = interviewService.itwDel(eId);
        if(result){
            System.out.println("操作成功！");
        }else{
            System.out.println("操作失败！");
        }
        //重定向到empList界面展示最新数据
        return "redirect:/interview/interviews";
    }

    //修改
    @RequestMapping("/update")
    public String cusUpdate(Interview interview){
        //展示emp
        System.out.println(interview);
        //调用目标接口实现信息修改
        boolean result = interviewService.itwUpdate(interview);
        if(result){
            System.out.println("操作成功！");
        }else{
            System.out.println("操作失败！");
        }
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
        List<Interview> interviewList = interviewService.queryAllInterview(null, null, null);
        for (Interview interview : interviewList) {
            //设置客户姓名
            interview.setcRename(customerService.queryById(interview.getcId()).getcRename());
            //我方员工姓名
            interview.seteRename(empService.queryById(interview.geteId()).getRename());
            //设置拜访类型
            interview.setpName(projectService.queryById(interview.getpId()).getpName());
        }
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Interview.class).sheet("模板").doWrite(interviewList);
        System.out.println("excelOutput.................");
    }


}
