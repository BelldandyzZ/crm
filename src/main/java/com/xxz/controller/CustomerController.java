package com.xxz.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxz.annotations.Permission;
import com.xxz.bean.Customer;
import com.xxz.listener.DemoDataListener;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private RoleService roleService;

    //条件查询
    @RequestMapping("/customers")
    @Permission("1010")
    public String queryAll(Model model, String cRename, String cName, String cJob, HttpSession session,
    @RequestParam(defaultValue = "1") Integer pageNum) throws UnsupportedEncodingException {
        session.setAttribute("jobTypes", dicValueService.getAllJobType());
        session.setAttribute("companyTypes", dicValueService.getAllCompanyType());
        session.setAttribute("progressTypes", dicValueService.getAllProgress());
        session.setAttribute("schoolTypes", dicValueService.getAllSchoolType());
        session.setAttribute("dicvalueTypes", dicValueService.getAllDicType());
        session.setAttribute("pNames", projectService.getAllProjectName());
        session.setAttribute("allType", dicValueService.getAllType());
//=====================================================================================================
        System.out.println("queryAll-customers-confition:" + cRename + "-" + cName + "-" + cJob);
        PageHelper.startPage(pageNum,  10);
        List<Customer> customerList = customerService.queryAllCus(cRename, cName, cJob);
        PageInfo<Customer> cusPageInfo = new PageInfo<>(customerList, 5);
        System.out.println("条件查询结果：" + cusPageInfo);
        model.addAttribute("cusPageInfo", cusPageInfo);
        //条件导出excel
        session.setAttribute("customerListExcel", customerList);
        //条件回显
        model.addAttribute("cRename", cRename);
        model.addAttribute("cName", cName);
        model.addAttribute("cJob", cJob);
        return "customer/customer";
    }

    //id查询
    @RequestMapping("/queryById/{cId}")
    @ResponseBody
    @Permission("1010")
    public Map<String,Object> queryById(@PathVariable("cId") Integer cId, HttpServletResponse response) throws IOException {
        Customer customer = customerService.queryById(cId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",customer);
//        response.getWriter().println(Customer);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    @Permission("1020")
    public String cusAdd(Customer customer){
        System.out.println("add cus..." + customer);
        //调用接口将数据添加到数据库
        boolean result = customerService.cusAdd(customer);
        if (result){
            System.out.println("cus操作成功！");
        }else {
            System.out.println("cus操作成功！");
        }
        return "redirect:/customer/customers";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    @Permission("1030")
    public String cusDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        boolean result = customerService.cusDel(eId);
        if (result){
            System.out.println("cus操作成功！");
        }else {
            System.out.println("cus操作成功！");
        }
        //重定向到empList界面展示最新数据
        return "redirect:/customer/customers";
    }

    //修改
    @RequestMapping("/update")
    @Permission("1040")
    public String cusUpdate(Customer customer){
        //展示emp
        System.out.println(customer);
        //调用目标接口实现信息修改
        boolean result = customerService.cusUpdate(customer);
        if (result){
            System.out.println("cus操作成功！");
        }else {
            System.out.println("cus操作成功！");
        }
        //重定向到empMenu界面
        return "redirect:/customer/customers";
    }

    /*excel导入导出*/
    @RequestMapping(value = "/excelInport", method = RequestMethod.POST)
    public String excelInport(MultipartFile activityFile){
        System.out.println("文件名：" + activityFile.getOriginalFilename());
        // 解析Excel
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(activityFile.getInputStream(), Customer.class, new DemoDataListener<Customer>()).build();
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
        return "redirect:/customer/customers";
    }

    //导出
    @Permission("1060")
    @RequestMapping("/excelOutput") //ResponseEntity<byte[]>
    public void excelOutput(HttpSession session, HttpServletResponse response) throws IOException {
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");



        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("客户信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Customer> customers = (List<Customer>) session.getAttribute("customerListExcel");
        //正序
        Collections.reverse(customers);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Customer.class)
                .sheet("客户信息模板")
                .doWrite(customers);
    }

    //excelOutputModel
    @RequestMapping("/excelOutputModel") //ResponseEntity<byte[]>
    public void excelOutputModel(HttpSession session, HttpServletResponse response) throws IOException {
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("客户信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setcRename("张三");
        customer.setcName("xxx学院");
        customer.setcCieType("学校");
        customer.setcDepart("xx部门");
        customer.setcJob("销售");
        customer.setcTele("137xxxxxxxx");
        customer.setcPost("xxx@xx.com");
        customer.setcHobby("游泳xxx");
        customer.setcRemark("xxx良好");
        customers.add(customer);
        //正序
        Collections.reverse(customers);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Customer.class)
                .sheet("客户信息模板")
                .doWrite(customers);
    }
}
