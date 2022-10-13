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
import com.xxz.service.CustomerService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //条件查询
    @RequestMapping("/customers")
    @Permission("1010")
    public String queryAll(Model model, String cRename, String cName, String cJob,
    @RequestParam(defaultValue = "1") Integer pageNum) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll-customers-confition:" + cRename + "-" + cName + "-" + cJob);
        if (pageNum <=0){
            pageNum = 1;
        }
        /**/
        PageHelper.startPage(pageNum,  10);
        List<Customer> customerList = customerService.queryAllCus(cRename, cName, cJob);
        PageInfo<Customer> cusPageInfo = new PageInfo<>(customerList, 5);
        System.out.println("条件查询结果：" + cusPageInfo);
        model.addAttribute("cusPageInfo", cusPageInfo);
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
    public String excelInport(MultipartFile importFile){
        System.out.println("文件名：" + importFile.getOriginalFilename());
//        System.out.println("input.........................");
//        String fileName = "E:\\员工信息表.xlsx";
//        //EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
//        EasyExcel.read(fileName, Employee.class, new DemoDataListener()).sheet().doRead();
        // 解析Excel
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(importFile.getInputStream(), Customer.class, new DemoDataListener<Customer>()).build();
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
        //获取本机桌面地址
//        File desktopDir = FileSystemView.getFileSystemView() .getHomeDirectory();
//        String PATH = desktopDir.getAbsolutePath() + "\\";
//        String fileName = PATH + "员工信息表.xlsx";
        //设置响应头和响应体格式，告诉浏览器是什么文件，对应解析
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename="
                + URLEncoder.encode("客户信息", "UTF-8") + ".xlsx");
        //获取目标数据
        List<Customer> customers = customerService.queryAllCus(null, null, null);
        //响应到浏览器
        EasyExcel.write(response.getOutputStream(), Customer.class).sheet("模板").doWrite(customers);
        System.out.println("excelOutput.................");
    }

}
