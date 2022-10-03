package com.xxz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.xxz.bean.Employee;
import com.xxz.bean.EmployeeExample;
import com.xxz.listener.DemoDataListener;
import com.xxz.mapper.EmployeeMapper;
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
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/login")
    public String empLogin(String ename, String epwd, HttpSession session){
        System.out.println(ename + "----" + epwd);
        if(ename != null && !ename.equals("") && epwd != null && !epwd.equals("")){
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andENameEqualTo(ename).andEPwdEqualTo(epwd);
            Employee employee = employeeMapper.selectByExample(employeeExample).get(0);
            if(employee != null){
                session.setAttribute("emp", employee);
            }
        }
        return "index";
    }

    //条件查询
    @RequestMapping("/emps")
    public String queryAll(Model model,String rename, String eJob, String eBirthday) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll emp by confition:" + rename + "-" + eJob + "-" + eBirthday);
        //样本
        EmployeeExample employeeExample = new EmployeeExample();
        //条件盒子
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //追加条件
        if (rename != null){
            criteria.andRenameLike("%" + rename + "%");
        }
        if(eJob != null && !eJob.equals("")){
            criteria.andEJobEqualTo(eJob);
        }
        if(eBirthday != null && !eBirthday.equals("")){
            criteria.andEBirthdayEqualTo(eBirthday);
        }
        //查询
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        System.out.println("条件查询结果：" + employeeList);
        model.addAttribute("empList", employeeList);
        return "employees/employee";
    }

    //id查询
    @RequestMapping("/queryById/{eId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("eId") Integer eId, HttpServletResponse response) throws IOException {
        Employee employee = employeeMapper.selectByPrimaryKey(eId);
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
        employeeMapper.insertSelective(employee);
        return "redirect:/emp/emps";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    public String empDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        employeeMapper.deleteByPrimaryKey(eId);
        //重定向到empList界面展示最新数据
        return "redirect:/emp/emps";
    }

    //修改
    @RequestMapping("/update")
    public String empUpdate(Employee employee){
        //展示emp
        System.out.println(employee);
        //调用目标接口实现信息修改
        employeeMapper.updateByPrimaryKeySelective(employee);
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
        List<Employee> employees = employeeMapper.selectByExample(null);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Employee.class).sheet("模板").doWrite(employees);
        System.out.println("excelOutput.................");
    }


}
