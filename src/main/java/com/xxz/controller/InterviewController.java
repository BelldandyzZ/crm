package com.xxz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxz.annotations.Permission;
import com.xxz.bean.*;
import com.xxz.listener.DemoDataListener;
import com.xxz.mapper.CustomerMapper;
import com.xxz.mapper.EmployeeMapper;
import com.xxz.mapper.InterviewMapper;
import com.xxz.mapper.ProjectMapper;
import com.xxz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private RoleService roleService;

    //条件查询
    @RequestMapping("/interviews")
    public String queryAll(Model model, String iCompany, String cRename, String eRename,HttpSession session,
                           @RequestParam(defaultValue = "1") Integer pageNum) throws UnsupportedEncodingException {

        session.setAttribute("jobTypes", dicValueService.getAllJobType());
        session.setAttribute("companyTypes", dicValueService.getAllCompanyType());
        session.setAttribute("progressTypes", dicValueService.getAllProgress());
        session.setAttribute("schoolTypes", dicValueService.getAllSchoolType());
        session.setAttribute("dicvalueTypes", dicValueService.getAllDicType());
        session.setAttribute("pNames", projectService.getAllProjectName());
//=====================================================================================================


        PageHelper.startPage(pageNum,  10);
        List<Interview> interviewList = interviewService.queryAllInterview(iCompany, cRename, eRename);
        PageInfo<Interview> itwPageInfo = new PageInfo<>(interviewList, 5);
        model.addAttribute("itwPageInfo", itwPageInfo);
        //将当前查询数据存储到sessino中是，实现条件导出
        session.setAttribute("interviewListExcel", interviewList);
        //回显条件
        model.addAttribute("iCompany", iCompany);
        model.addAttribute("cRename", cRename);
        model.addAttribute("reERename", eRename);
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
    @RequestMapping("/queryById/{iId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("iId") Integer iId, HttpServletResponse response) throws IOException {
        Interview interview = interviewService.queryById(iId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",interview);
//        response.getWriter().println(Interview);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    public String itwAdd(Interview interview, String[] cRenames, String eRename){
        System.out.println("==============================================");
        System.out.println("queryAll-interviews-confition:" + cRenames + "-" + eRename);
        interviewService.itwAdd(interview, cRenames,eRename);
        return "redirect:/interview/interviews";
    }

    //删除员工
    @RequestMapping("/del/{iId}")
    public String cusDel(@PathVariable("iId") Integer iId){
        System.out.println(iId);
        //删除业务
        boolean result = interviewService.itwDel(iId);
        //重定向到empList界面展示最新数据
        return "redirect:/interview/interviews";
    }

    //修改
    @RequestMapping("/update")
    public String cusUpdate(Interview interview){
        //调用目标接口实现信息修改
        boolean result = interviewService.itwUpdate(interview);
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
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("访谈信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Interview> interviewList = (List<Interview>) session.getAttribute("interviewListExcel");
        for (Interview interview : interviewList) {
            //设置客户姓名
            Customer customer = customerService.queryById(interview.getcId());
            if(customer != null){
                interview.setcRename(customer.getcRename());
            }else {
                interview.setcRename("无");
            }
            //我方员工姓名
            Employee employee = empService.queryById(interview.geteId());
            if(employee != null){
                if (employee.getRename() == null || employee.getRename().equals("")){
                    interview.seteRename("未知");
                }else{
                    interview.seteRename(employee.getRename());
                }
            }else{
                interview.seteRename("无");
            }

            //设置拜访类型
            Project project = projectService.queryById(interview.getpId());
            if(project != null){
                interview.setpName(project.getpName());
            }else{
                interview.setpName("无");
            }

        }
        //正序
        Collections.reverse(interviewList);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Interview.class).sheet("拜访记录模板").doWrite(interviewList);
    }


}
