package com.xxz.mapper;

import com.xxz.bean.DicValue;
import com.xxz.bean.DicValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DicValueMapper {
    @Select("select code from type_dic where type = #{type}")
    String selectCodeByType(@Param("type") String type);

    @Select("select type from type_dic where code = #{code}")
    String selectTypeByCode(@Param("code") String code);

    @Select("select distinct type from type_dic")
    List<String> selectAllType();

    int countByExample(DicValueExample example);

    int deleteByExample(DicValueExample example);

    int deleteByPrimaryKey(Integer vId);

    int insert(DicValue record);

    int insertSelective(DicValue record);

    List<DicValue> selectByExample(DicValueExample example);

    DicValue selectByPrimaryKey(Integer vId);

    int updateByExampleSelective(@Param("record") DicValue record, @Param("example") DicValueExample example);

    int updateByExample(@Param("record") DicValue record, @Param("example") DicValueExample example);

    int updateByPrimaryKeySelective(DicValue record);

    int updateByPrimaryKey(DicValue record);
}