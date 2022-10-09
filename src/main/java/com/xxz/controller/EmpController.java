package com.xxz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxz.bean.Employee;
import com.xxz.bean.EmployeeExample;
import com.xxz.listener.DemoDataListener;
import com.xxz.mapper.EmployeeMapper;
import com.xxz.service.DicValueService;
import com.xxz.service.EmpService;
import com.xxz.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/login")
    public String empLogin(String ename, String epwd, HttpSession session){
        System.out.println(ename + "----" + epwd);
        Employee employee = empService.empLogin(ename, epwd);
        List<String> allProgress = dicValueService.getAllProgress();
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(allProgress);
        if(employee != null){
            session.setAttribute("emp", employee);
            session.setAttribute("jobTypes", dicValueService.getAllJobType());
            session.setAttribute("companyTypes", dicValueService.getAllCompanyType());
            session.setAttribute("progressTypes", allProgress);
            session.setAttribute("pNames", projectService.getAllProjectName());
            return "index";
        }else{
            return "login";
        }
    }

    //条件查询
    @RequestMapping("/emps")
    public String queryAll(Model model,String rename, String eJob, String eBirthday,
                          @RequestParam(defaultValue = "1") Integer pageNum) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll emp by confition:" + rename + "-" + eJob + "-" + eBirthday);
        if (pageNum <=0){
            pageNum = 1;
        }
        /**/
        PageHelper.startPage(pageNum,  10);

        List<Employee> employeeList = empService.queryAllEmp(rename, eJob, eBirthday);

        PageInfo<Employee> empPageInfo = new PageInfo<>(employeeList, 5);
        System.out.println("条件查询结果：" + empPageInfo.getList());
        model.addAttribute("empPageInfo", empPageInfo);
        //回显条件
        model.addAttribute("rename", rename);
        model.addAttribute("eJob", eJob);
        model.addAttribute("eBirthday", eBirthday);
        return "employees/employee";
    }

    //id查询
    @RequestMapping("/queryById/{eId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("eId") Integer eId, HttpServletResponse response) throws IOException {

        Employee employee = empService.queryById(eId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",employee);
//        response.getWriter().println(employee);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    public String empAdd(Employee employee){
        System.out.println("add emp..." + employee);
        //调用接口将数据添加到数据库
        boolean result = empService.empAdd(employee);
        if (result){
            System.out.println("emp操作成功！");
        }else {
            System.out.println("emp操作失败！");
        }
        return "redirect:/emp/emps";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    public String empDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        boolean result = empService.empDel(eId);
        if (result){
            System.out.println("emp操作成功！");
        }else {
            System.out.println("emp操作失败！");
        }
        //重定向到empList界面展示最新数据
        return "redirect:/emp/emps";
    }

    //修改
    @RequestMapping("/update")
    public String empUpdate(Employee employee){
        //展示emp
        System.out.println(employee);
        //调用目标接口实现信息修改
        boolean result = empService.empUpdate(employee);
        if (result){
            System.out.println("emp操作成功！");
        }else {
            System.out.println("emp操作失败！");
        }
        //重定向到empMenu界面
        return "redirect:/emp/emps";
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
            excelReader = EasyExcelFactory.read(importFile.getInputStream(), Employee.class, new DemoDataListener<Employee>()).build();
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
        return "redirect:/emp/emps";
    }

    //导出
    @RequestMapping("/excelOutput") //ResponseEntity<byte[]>
    public void excelOutput(HttpSession session,HttpServletResponse response) throws IOException {
        //获取本机桌面地址
//        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//        String PATH = desktopDir.getAbsolutePath() + "\\";
//        String fileName = PATH + "员工信息表.xlsx";
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("员工信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Employee> employees = empService.queryAllEmp(null, null, null);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Employee.class).sheet("模板").doWrite(employees);
        System.out.println("excelOutput.................");
    }


}
