package com.xxz.service;

import com.xxz.bean.DicValue;
import com.xxz.bean.DicValueExample;
import com.xxz.mapper.DicValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Transactional
@Service
public class DicValueService {

    @Autowired
    private DicValueMapper dicValueMapper;

    /*获取所有字段*/
    public List<DicValue> queryAllDic(String vValue, String type){
        DicValueExample dicValueExample = new DicValueExample();
        DicValueExample.Criteria criteria = dicValueExample.createCriteria();
        if(vValue != null && !vValue.equals("")){
            criteria.andVValueLike("%" + vValue + "%");
        }
        if(type != null && !type.equals("")){
            String typeCode = dicValueMapper.selectCodeByType(type);
            criteria.andTypeCodeEqualTo(typeCode);
        }
        List<DicValue> dicValues = dicValueMapper.selectByExample(dicValueExample);
        for (DicValue dicValue : dicValues) {
            dicValue.setType(dicValueMapper.selectTypeByCode(dicValue.getTypeCode()));
        }
        //倒叙
//        Collections.reverse(dicValues);
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
    public boolean add(DicValue dicValue, String type){
        dicValue.setTypeCode(dicValueMapper.selectCodeByType(type));
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
    public boolean update(DicValue dicValue, String type){
        dicValue.setTypeCode(dicValueMapper.selectCodeByType(type));
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
        return jobTypeList;
    }

    public List<String> getAllSchoolType() {
        ArrayList<String> jobTypeList = new ArrayList<>();
        //
        DicValueExample dicValueExample = new DicValueExample();
        dicValueExample.createCriteria().andTypeCodeEqualTo("schoolType");
        List<DicValue> dicValueList = dicValueMapper.selectByExample(dicValueExample);
        for (DicValue dicValue : dicValueList) {
            jobTypeList.add(dicValue.getvValue());
        }
        return jobTypeList;
    }

    public List<String> getAllDicType() {
        List<DicValue> dicValues = dicValueMapper.selectByExample(null);
        HashSet<String> strings = new HashSet<>();
        for (DicValue dicValue : dicValues) {
            strings.add(dicValue.getTypeCode());
        }
        return new ArrayList<>(strings);
    }

    public List<String> getAllType(){
        return dicValueMapper.selectAllType();
    }

    public DicValue queryById(Integer vId) {
        DicValue dicValue = dicValueMapper.selectByPrimaryKey(vId);

        dicValue.setType(dicValueMapper.selectTypeByCode(dicValue.getTypeCode()));

        return dicValue;
    }

    //添加progress

    //删除progress

    //修改progress


}
