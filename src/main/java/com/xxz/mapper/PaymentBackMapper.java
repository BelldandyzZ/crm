package com.xxz.mapper;

import com.xxz.bean.PaymentBack;
import com.xxz.bean.PaymentBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaymentBackMapper {
    int countByExample(PaymentBackExample example);

    int deleteByExample(PaymentBackExample example);

    int insert(PaymentBack record);

    int insertSelective(PaymentBack record);

    List<PaymentBack> selectByExample(PaymentBackExample example);

    int updateByExampleSelective(@Param("record") PaymentBack record, @Param("example") PaymentBackExample example);

    int updateByExample(@Param("record") PaymentBack record, @Param("example") PaymentBackExample example);
}