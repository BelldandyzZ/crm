package com.xxz.service;

import com.xxz.bean.Employee;
import com.xxz.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpService {

    public int insertEmp(Employee employee){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "insert into employee values(null,?,?,?,?,?,?,?,?,?,?)";
            connection = JdbcUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getRename());
            preparedStatement.setString(2, employee.geteName());
            preparedStatement.setString(3, employee.getePwd());
            preparedStatement.setString(4, employee.geteBirthday());
            preparedStatement.setString(5, employee.geteSchool());
            preparedStatement.setString(6, employee.geteJob());
            preparedStatement.setString(7, employee.geteStartTime());
            preparedStatement.setString(8, employee.geteSocialPosition());
            preparedStatement.setString(9, employee.geteHonor());
            preparedStatement.setString(10, employee.geteRemark());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(connection, preparedStatement, null);
        }

        return -1;
    }
}
