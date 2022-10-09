package com.xxz.controller;

import com.xxz.bean.DicValue;
import com.xxz.service.DicValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dic")
public class DicValueController {

    @Autowired
    private DicValueService dicValueService;

    /*查询所有*/
    @RequestMapping("/dics")
    public String queryAllDic(Model model , String vValue, String typeCode){
        List<DicValue> dicValues = dicValueService.queryAllDic(vValue, typeCode);
        model.addAttribute("dicValues", dicValues);
        return "dicvalue\\dicvalue";
    }

    /*新增*/
    @RequestMapping("/add")
    public String add(DicValue dicValue){
        boolean result = dicValueService.add(dicValue);
        return "redirect:/dic/dics";
    }

    /*修改*/
    @RequestMapping("/update")
    public String update(DicValue dicValue){
        boolean result = dicValueService.update(dicValue);
        return "redirect:/dic/dics";
    }
    /*删除*/
    @RequestMapping("/del")
    public String del(Integer vid){
        boolean result = dicValueService.del(vid);
        return "redirect:/dic/dics";
    }

}
