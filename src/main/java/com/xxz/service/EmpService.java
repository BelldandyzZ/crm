package com.xxz.service;

import com.xxz.bean.Employee;
import com.xxz.bean.EmployeeExample;
import com.xxz.mapper.EmployeeMapper;
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
public class EmpService {

    @Autowired
    private EmployeeMapper employeeMapper;


    /*登录empLogin*/
    public Employee empLogin(String ename, String epwd ){
        if(ename != null && !ename.equals("") && epwd != null && !epwd.equals("")){
//            EmployeeExample employeeExample = new EmployeeExample();
//            employeeExample.createCriteria().andENameEqualTo(ename).andEPwdEqualTo(epwd);
//            List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
            Employee emp = employeeMapper.login(ename, epwd);
            if(emp != null){
                return emp;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }


    /*查询所有*/
    public List<Employee> queryAllEmp(String rename, String eJob, String eBirthday){
        //样本
        EmployeeExample employeeExample = new EmployeeExample();
        //条件盒子
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        //追加条件
        if (rename != null){
            criteria.andRenameLike("%" + rename + "%");
        }
        if(eJob != null && !eJob.equals("")){
            criteria.andEJobEqualTo(eJob);
        }
        if(eBirthday != null && !eBirthday.equals("")){
            criteria.andEBirthdayGreaterThanOrEqualTo(eBirthday);
        }
        //查询
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        //超管不展示
//        for (Employee employee : employeeList) {
//            if(employee.getRename().equals("超管")){
//                employeeList.remove(employee);
//                break;
//            }
//        }
        //倒叙
//        Collections.reverse(employeeList);
        return employeeList;
    }

    /*根据ID查询*/
    public Employee queryById(Integer eId){
       return employeeMapper.selectByPrimaryKey(eId);
    }

    /*添加员工*/
    public boolean empAdd(Employee employee){
        //调用接口将数据添加到数据库
        int addResult = employeeMapper.insertSelective(employee);
        return addResult > 0 ? true : false;
    }

    /*删除员工*/
    public boolean empDel(Integer eId){
        //删除业务
        int delResult = employeeMapper.deleteByPrimaryKey(eId);
        return delResult > 0 ? true : false;
    }

    /*员工修改*/
    public boolean empUpdate(Employee employee){
        //调用目标接口实现信息修改
        int updateResult = employeeMapper.updateByPrimaryKeySelective(employee);
        return updateResult > 0 ? true : false;
    }


    /*excel导入数据库*/
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
