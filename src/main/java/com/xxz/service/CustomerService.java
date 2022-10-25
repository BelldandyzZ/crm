package com.xxz.service;

import com.xxz.bean.Customer;
import com.xxz.bean.CustomerExample;
import com.xxz.mapper.CustomerMapper;
import com.xxz.mapper.InterviewMapper;
import com.xxz.utils.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class CustomerService {

    @Autowired
    private InterviewMapper interviewMapper;


    @Autowired
    private CustomerMapper customerMapper;

    /*查询所有客户*/

    public List<Customer> queryAllCus(String cRename, String cName, String cJob){
        //样本
        CustomerExample customerExample = new CustomerExample();
        //条件盒子
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        //追加条件
        if (cRename != null){
            criteria.andCRenameLike("%" + cRename + "%");
        }
        if(cJob != null && !cJob.equals("")){
            criteria.andCJobEqualTo(cJob);
        }
        if(cName != null && !cName.equals("")){
            criteria.andCNameEqualTo(cName);
        }
        //查询
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        //倒叙
        Collections.reverse(customerList);
        return customerList;
    }

    /*查询客户通过IDbyCid*/
    public Customer queryById(Integer cId){
        Customer customer = customerMapper.selectByPrimaryKey(cId);
        return customer;
    }

    /*新增客户*/
    public boolean cusAdd(Customer customer){
        //调用接口将数据添加到数据库
        int addResult = customerMapper.insertSelective(customer);
        return addResult > 0 ? true : false;
    }

    /*删除客户ById*/
    public boolean cusDel(Integer eId){
        //删除业务
        int delResult = customerMapper.deleteByPrimaryKey(eId);

        int res = interviewMapper.deleteInterviewByCustomerId(eId);

        return delResult > 0 ? true : false;
    }

    /*修改客户cus*/
    public boolean cusUpdate(Customer customer){
        //调用目标接口实现信息修改
        int updateResult = customerMapper.updateByPrimaryKeySelective(customer);
        return updateResult > 0 ? true : false;
    }



    /*excel导入*/
    public int insertCus(Customer customer){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into customer values(null,?,?,?,?,?,?,?,?,?)";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getcRename());
            preparedStatement.setString(2, customer.getcName());
            preparedStatement.setString(3, customer.getcDepart());
            preparedStatement.setString(4, customer.getcCieType());
            preparedStatement.setString(5, customer.getcJob());
            preparedStatement.setString(6, customer.getcTele());
            preparedStatement.setString(7, customer.getcPost());
            preparedStatement.setString(8, customer.getcHobby());
            preparedStatement.setString(9, customer.getcRemark());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, null);
        }
        return -1;
    }

}
