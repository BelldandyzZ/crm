package com.xxz.mapper;

import com.xxz.bean.PaymentBack;
import com.xxz.bean.PaymentBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface PaymentBackMapper {
    int countByExample(PaymentBackExample example);

    int deleteByExample(PaymentBackExample example);

    int insert(PaymentBack record);

    int insertSelective(PaymentBack record);

    List<PaymentBack> selectByExample(PaymentBackExample example);

    int updateByExampleSelective(@Param("record") PaymentBack record, @Param("example") PaymentBackExample example);

    int updateByExample(@Param("record") PaymentBack record, @Param("example") PaymentBackExample example);

    @Update("update payment_back set pb_money = #{pbMoney}, pb_order = #{pbOrder}, pb_time = #{pbTime} where pb_id = #{pbId}")
    int updatePayBack(PaymentBack record);
}