package com.xxz.service;

import com.xxz.bean.DicValue;
import com.xxz.bean.DicValueExample;
import com.xxz.mapper.DicValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class DicValueService {

    @Autowired
    private DicValueMapper dicValueMapper;

    /*获取所有字段*/
    public List<DicValue> queryAllDic(String vValue, String typeCode){
        DicValueExample dicValueExample = new DicValueExample();
        DicValueExample.Criteria criteria = dicValueExample.createCriteria();
        if(vValue != null && !vValue.equals("")){
            criteria.andVValueLike("%" + vValue + "%");
        }
        if(typeCode != null && !typeCode.equals("")){
            criteria.andTypeCodeEqualTo(typeCode);
        }
        List<DicValue> dicValues = dicValueMapper.selectByExample(dicValueExample);
        return dicValues;
    }

    //获取所有jobType职位
    public List<String> getAllJobType(){
        ArrayList<String> jobTypeList = new ArrayList<>();
        //
        DicValueExample dicValueExample = new DicValueExample();
        dicValueExample.createCriteria().andTypeCodeEqualTo("jobType");
        List<DicValue> dicValueList = dicValueMapper.selectByExample(dicValueExample);
        for (DicValue dicValue : dicValueList) {
            jobTypeList.add(dicValue.getvValue());
        }
        return jobTypeList;
    }

    //添加jobType
    public boolean add(DicValue dicValue){
        int result = dicValueMapper.insertSelective(dicValue);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
    //删除jobType
    public boolean del(Integer vId){
        int result = dicValueMapper.deleteByPrimaryKey(vId);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
    //修改jobType
    public boolean update(DicValue dicValue){
        int result = dicValueMapper.updateByPrimaryKey(dicValue);
        if(result > 0){
            return true;
        }else {
            return false;
        }
    }
    //获取所有CompanyType公司类型
    public List<String> getAllCompanyType(){
        ArrayList<String> jobTypeList = new ArrayList<>();
        //
        DicValueExample dicValueExample = new DicValueExample();
        dicValueExample.createCriteria().andTypeCodeEqualTo("companyType");
        List<DicValue> dicValueList = dicValueMapper.selectByExample(dicValueExample);
        for (DicValue dicValue : dicValueList) {
            jobTypeList.add(dicValue.getvValue());
        }
        return jobTypeList;
    }

    //添加companyType

    //删除companyType

    //修改companyType

    //获取所有progress项目进程
    public List<String> getAllProgress(){
        ArrayList<String> jobTypeList = new ArrayList<>();
        //
        DicValueExample dicValueExample = new DicValueExample();
        dicValueExample.createCriteria().andTypeCodeEqualTo("progress");
        List<DicValue> dicValueList = dicValueMapper.selectByExample(dicValueExample);
        for (DicValue dicValue : dicValueList) {
            jobTypeList.add(dicValue.getvValue());
        }
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println("===========================================================");
        System.out.println(jobTypeList);
        return jobTypeList;
    }

    //添加progress

    //删除progress

    //修改progress


}
