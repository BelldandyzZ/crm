package com.xxz.controller;

import com.xxz.bean.Customer;
import com.xxz.bean.CustomerExample;
import com.xxz.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerMapper customerMapper;

    //条件查询
    @RequestMapping("/customers")
    public String queryAll(Model model, String rename, String eJob, String eBirthday) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll emp by confition:" + rename + "-" + eJob + "-" + eBirthday);
        //样本
        CustomerExample customerExample = new CustomerExample();
        //条件盒子
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        //追加条件
//        if (rename != null){
//            criteria.andRenameLike("%" + rename + "%");
//        }
//        if(eJob != null && !eJob.equals("")){
//            criteria.andEJobEqualTo(eJob);
//        }
//        if(eBirthday != null && !eBirthday.equals("")){
//            criteria.andEBirthdayEqualTo(eBirthday);
//        }
        //查询
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        System.out.println("条件查询结果：" + customerList);
        model.addAttribute("customerList", customerList);
        return "customer/customer";
    }

    //id查询
    @RequestMapping("/queryById/{cId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("cId") Integer cId, HttpServletResponse response) throws IOException {
        Customer customer = customerMapper.selectByPrimaryKey(cId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",customer);
//        response.getWriter().println(Customer);
        return stringObjectHashMap;
    }

    //新增员工
    @RequestMapping("/add")
    public String cusAdd(Customer customer){
        System.out.println("add cus..." + customer);
        //调用接口将数据添加到数据库
        customerMapper.insertSelective(customer);
        return "redirect:/customer/customers";
    }

    //删除员工
    @RequestMapping("/del/{eId}")
    public String cusDel(@PathVariable("eId") Integer eId){
        System.out.println(eId);
        //删除业务
        customerMapper.deleteByPrimaryKey(eId);
        //重定向到empList界面展示最新数据
        return "redirect:/customer/customers";
    }

    //修改
    @RequestMapping("/update")
    public String cusUpdate(Customer customer){
        //展示emp
        System.out.println(customer);
        //调用目标接口实现信息修改
        customerMapper.updateByPrimaryKeySelective(customer);
        //重定向到empMenu界面
        return "redirect:/customer/customers";
    }

    /*excel导入导出*/
    @RequestMapping("excelInport")
    public String excelInport(){

        return "redirect:/customer/customers";
    }

    @RequestMapping("excelOutput")
    public String excelOutput(){
        return "redirect:/customer/customers";
    }

}
