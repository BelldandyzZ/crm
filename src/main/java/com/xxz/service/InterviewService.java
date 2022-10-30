package com.xxz.service;

import com.xxz.bean.*;
import com.xxz.mapper.CustomerMapper;
import com.xxz.mapper.EmployeeMapper;
import com.xxz.mapper.InterviewMapper;
import com.xxz.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
public class InterviewService {

    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ProjectMapper projectMapper;

    /*查询所有*/
    public List<Interview> queryAllInterview(String iCompany, String cRename, String eRename){

        System.out.println(iCompany + "-" + cRename + "="  + eRename);
        System.out.println(iCompany + "-" + cRename + "="  + eRename);
        System.out.println(iCompany + "-" + cRename + "="  + eRename);
        System.out.println(iCompany + "-" + cRename + "="  + eRename);

        //样本
        InterviewExample interviewExample = new InterviewExample();
        //条件盒子
        InterviewExample.Criteria criteria = interviewExample.createCriteria();
        //追加条件
        if (iCompany != null && !iCompany.equals("")){
            criteria.andICompanyLike("%" + iCompany + "%");
        }
        if(cRename != null && !cRename.equals("")){
            //样本
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andCRenameLike("%" + cRename + "%");
            List<Customer> customers = customerMapper.selectByExample(customerExample);
            if(customers.size() > 0){
                //获取当前客户对应的所有拜访记录
                List<Integer> cids = new ArrayList<>();
                for (Customer customer : customers) {
                    cids.add(customer.getcId());
                }
                //包含cids
                criteria.andCIdIn(cids);
            }else {
                criteria.andCIdEqualTo(99999999);
            }
        }
        if(eRename != null && !eRename.equals("")){
            //样本
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andRenameEqualTo(eRename);
            Employee emp = employeeMapper.selectByExample(employeeExample).get(0);
            criteria.andEIdEqualTo(emp.geteId());
        }
//============================================================================
        //(1)查询拜访记录
        List<Interview> interviewList = interviewMapper.selectByExample(interviewExample);

        //删除的拜访[健壮性]
        ArrayList<Interview> delItws = new ArrayList<>();

        for (Interview interview : interviewList) {
            //设置客户姓名
            if(interview.getcId() != null && !interview.getcId().equals("")){
                Customer customer = customerMapper.selectByPrimaryKey(interview.getcId());
                if(customer != null){
                    interview.setcRename(customer.getcRename());
                }else{
//                    interviewList.remove(interview);
//                    delItws.add(interview);
//                    interviewMapper.deleteByPrimaryKey(interview.getiId());
                    continue;
                }
            }
            //我方员工姓名
            if(interview.geteId() != null && !interview.geteId().equals("")){
                Employee employee = employeeMapper.selectByPrimaryKey(interview.geteId());
                if(employee != null){
                    interview.seteRename(employee.getRename());
                }else{
//                    interviewList.remove(interview);
//                    delItws.add(interview);
//                    interviewMapper.deleteByPrimaryKey(interview.getiId());
                    continue;
                }
            }
            //设置拜访类型
            if(interview.getpName() == null || interview.getpName().equals("")){
                Project project = projectMapper.selectByPrimaryKey(interview.getpId());
                if(project != null){
                    interview.setpName(project.getpName());
                }else {
//                    interviewList.remove(interview);
//                    delItws.add(interview);
//                    interviewMapper.deleteByPrimaryKey(interview.getiId());
                    continue;
                }
            }
        }
        interviewList.removeAll(delItws);
        //倒叙
//        Collections.reverse(interviewList);
        return interviewList;
    }

    /*通过ID查询*/
    public Interview queryById(Integer cId){
        Interview interview = interviewMapper.selectByPrimaryKey(cId);
        interview.seteRename(employeeMapper.selectByPrimaryKey(interview.geteId()).getRename());
        interview.setcRename(customerMapper.selectByPrimaryKey(interview.getcId()).getcRename());
        if(interview.getpId() != 0 && interview.getpId() != -1){
            interview.setpName(projectMapper.selectByPrimaryKey(interview.getpId()).getpName());
        }else {
            interview.setpName(interview.getpId() + "");
        }
        return interview;
    }

    /*新增拜访*/
    public void itwAdd(Interview interview, String[] cRenames, String eRename){
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("======================="+interview.getpName()+"===========================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");
        System.out.println("===================================================");

        if(!interview.getpName().equals("0") && !interview.getpName().equals("-1")){
            ProjectExample projectExample = new ProjectExample();
            projectExample.createCriteria().andPNameEqualTo(interview.getpName());
            List<Project> projects = projectMapper.selectByExample(projectExample);
            if(projects.size() > 0){
                interview.setpId(projects.get(0).getpId());
            }
        }else{
            interview.setpId(Integer.valueOf(interview.getpName()));
        }
        //获取eid并且设置到interview对象中添加到数据库
        if (eRename != null && !eRename.equals("")){
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andRenameEqualTo(eRename);
            Integer eid = employeeMapper.selectByExample(employeeExample).get(0).geteId();
            interview.seteId(eid);
        }
        //获取cid并且设置到interview对象中添加到数据库
        for (String cRename : cRenames) {
            System.out.println(cRename);
            if(cRename != null && !cRename.equals("")){
                CustomerExample customerExample = new CustomerExample();
                customerExample.createCriteria().andCRenameEqualTo(cRename);
                Integer cid = customerMapper.selectByExample(customerExample).get(0).getcId();
                interview.setcId(cid);
                //循环添加
                System.out.println("======================================================");
                System.out.println("add cus..." + interview);
                System.out.println("======================================================");
                //调用接口将数据添加到数据库
                interviewMapper.insertSelective(interview);
            }
        }
    }

    /*删除*/
    public boolean itwDel(Integer eId){
        //删除业务
        int delResult = interviewMapper.deleteByPrimaryKey(eId);
        return delResult > 0 ? true : false;
    }

    /*修改*/
    public boolean itwUpdate(Interview interview){
        //调用目标接口实现信息修改

        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andRenameEqualTo(interview.geteRename());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        interview.seteId(employees.get(0).geteId());


        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCRenameEqualTo(interview.getcRename());
        List<Customer> customers = customerMapper.selectByExample(customerExample);
        interview.setcId(customers.get(0).getcId());

        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andPNameEqualTo(interview.getpName());
        List<Project> projects = projectMapper.selectByExample(projectExample);
        interview.setpId(projects.get(0).getpId());


        int updateResult = interviewMapper.updateByPrimaryKeySelective(interview);
        return updateResult > 0 ? true : false;
    }

}
