package com.xxz.service;

import com.xxz.bean.Customer;
import com.xxz.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerService {

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
