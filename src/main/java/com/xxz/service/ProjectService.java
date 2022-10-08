package com.xxz.service;

import com.xxz.bean.*;
import com.xxz.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private CustomerMapper customerMapper;
    //
    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private PaymentBackMapper paymentBackMapper;

    @Autowired
    private CusProMapper cusProMapper;

    /*查询所有项目*/
    public List<Project> queryAllProject(String pName, String pMoeny, String pProgress, String pOwner){
        //样本
        ProjectExample projectExampleExample = new ProjectExample();
        //条件盒子
        ProjectExample.Criteria criteria = projectExampleExample.createCriteria();
        //追加条件
        if (pName != null){
            criteria.andPNameLike("%" + pName + "%");
        }
        if(pMoeny != null && !pMoeny.equals("")){
            criteria.andPMoenyEqualTo(pMoeny);
        }
        if(pProgress != null && !pProgress.equals("")){
            criteria.andPProgressEqualTo(pProgress);
        }
        if(pOwner != null && !pOwner.equals("")){
            criteria.andPOwnerLike("%" + pOwner + "%");
        }
        //查询
        List<Project> projectList = projectMapper.selectByExample(projectExampleExample);
        for (Project project : projectList) {
            CusProExample cusProExample = new CusProExample();
            System.out.println("===================================================================");
            System.out.println(project);
            cusProExample.createCriteria().andCpIdEqualTo(project.getCpId());
            List<CusPro> cusProList = cusProMapper.selectByExample(cusProExample);
            List<String> cRenames = new ArrayList<>();
            //给Project对象设置cIds拜访客户cId
            String cIds = new String();
            for (CusPro cusPro : cusProList) {
                cRenames.add(customerMapper.selectByPrimaryKey(cusPro.getcId()).getcRename());
                cIds += cusPro.getcId() + ",";
            }
            project.setcIds(cIds);
            project.setcRenames(cRenames);
        }
        return projectList;
    }

    /*添加项目*/
    public void addProject(Project project, String[] cRenames){
        //(1)获取session域中的pbId
        //设置回款编号
        System.out.println(project);
        projectMapper.insertSelective(project);
        Integer newIndex = project.getpId();
        project.setCpId(newIndex);
        project.setPbId(newIndex * 1000);
        projectMapper.updateByPrimaryKeySelective(project);
        for (String cRename : cRenames) {
            //追加关系表cus_pro
            CusPro cusPro = new CusPro();
            cusPro.setCpId(newIndex);
            cusPro.setpId(newIndex);
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andCRenameEqualTo(cRename);
            cusPro.setcId(customerMapper.selectByExample(customerExample).get(0).getcId());
            cusProMapper.insertSelective(cusPro);
        }
    }

    /*根据编号pid查询项目*/
    public Project queryById(Integer pId){
        Project project = projectMapper.selectByPrimaryKey(pId);
        //========================================================
        CusProExample cusProExample = new CusProExample();
        cusProExample.createCriteria().andCpIdEqualTo(project.getCpId());
        List<CusPro> cusProList = cusProMapper.selectByExample(cusProExample);
        List<String> cRenames = new ArrayList<>();
        //给Project对象设置cIds拜访客户cId
        for (CusPro cusPro : cusProList) {
            cRenames.add(customerMapper.selectByPrimaryKey(cusPro.getcId()).getcRename());
        }
        project.setcRenames(cRenames);
        return project;
    }

    /*修改项目*/
    public boolean updateProject(Project project, String[] cRenames){
        //清空客户与项目信息
        CusProExample cusProExample = new CusProExample();
        cusProExample.createCriteria().andCpIdEqualTo(project.getpId());
        cusProMapper.deleteByExample(cusProExample);
        //重新添加客户信息到cus_pro
        for (String cRename : cRenames) {
            //追加关系表cus_pro
            CusPro cusPro = new CusPro();
            cusPro.setCpId(project.getpId());
            cusPro.setpId(project.getpId());
            CustomerExample customerExample = new CustomerExample();
            customerExample.createCriteria().andCRenameEqualTo(cRename);
            cusPro.setcId(customerMapper.selectByExample(customerExample).get(0).getcId());
            cusProMapper.insertSelective(cusPro);
        }
        //重写字段值
        project.setCpId(project.getpId());
        project.setPbId(project.getpId() * 1000);
        int updateResult = projectMapper.updateByPrimaryKey(project);
        return updateResult > 0 ? true : false;
    }

    /*[拜访模块]=====================================================================================*/
    /*查询当前合同拜访记录*/
    public List<Interview> interview_recor(String cIds, Integer pId){
        InterviewExample interviewExample = new InterviewExample();
        //获取目标cId信息
        String[] split = cIds.split(",");
        List<Integer> integers = new ArrayList<>();
        for (String s : split) {
            integers.add(Integer.valueOf(s));
        }
        System.out.println(integers+"================================================================");
//        interviewExample.createCriteria().andCIdIn(integers);
        interviewExample.createCriteria().andPIdEqualTo(pId);
        //查询
        List<Interview> currentInterviewList = interviewMapper.selectByExample(interviewExample);
        for (Interview interview : currentInterviewList) {
            //设置客户姓名
            if(interview.getcId() != null && !interview.getcId().equals("")){
                interview.setcRename(customerMapper.selectByPrimaryKey(interview.getcId()).getcRename());
            }
            //我方员工姓名
            if(interview.geteId() != null && !interview.geteId().equals("")){
                interview.seteRename(employeeMapper.selectByPrimaryKey(interview.geteId()).getRename());
            }
            //设置拜访类型
            if(interview.getpName() == null || interview.getpName().equals("")){
                interview.setpName(projectMapper.selectByPrimaryKey(interview.getpId()).getpName());
//                interview.setpName("农村购物致富商城系统项目");
            }
        }
        return currentInterviewList;
    }

    /*[合同模块]===========================================================================*/
    /*查询所有合同*/
    public List<Contract> contract_record(Integer pId){
        ContractExample contractExample = new ContractExample();
        contractExample.createCriteria().andPIdEqualTo(pId);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        return contractList;
    }

    /*添加合同*/
    public boolean contractAdd(Contract contract){
        //实现添加业务
        System.out.println(contract);
        int result = contractMapper.insertSelective(contract);
        return result>0 ? true : false;
    }

    /*[回款模块]==================================================================================*/
    public List<PaymentBack> queryAllPayBack(Integer pbId){
        PaymentBackExample paymentBackExample1 = new PaymentBackExample();
        paymentBackExample1.createCriteria().andPbIdEqualTo(pbId);
        List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample1);
        return paymentBacks;
    }

    /*查询区间*/
    public List<PaymentBack> PbIdBetweenStartAndEnd(Integer startPbId, Integer endPbId){
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        paymentBackExample.createCriteria().andPbIdBetween(startPbId, endPbId);
        List<PaymentBack> paymentBackList = paymentBackMapper.selectByExample(paymentBackExample);
        return paymentBackList;
    }

    /*添加回款*/
    public void addPayMent(PaymentBack paymentBack){
        paymentBackMapper.insertSelective(paymentBack);
    }

    /*根据ID查询回款*/
    public PaymentBack payBackQueryById(Integer pbId){
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        paymentBackExample.createCriteria().andPbIdEqualTo(pbId);
        PaymentBack paymentBack = paymentBackMapper.selectByExample(paymentBackExample).get(0);
        return paymentBack;
    }

    /*修改回款*/
    public boolean payBackUpdate(PaymentBack paymentBack){
        int updateResult = paymentBackMapper.updatePayBack(paymentBack);
        return updateResult > 0 ? true : false;
    }
}
