package com.xxz.service;

import com.github.pagehelper.PageHelper;
import com.xxz.bean.*;
import com.xxz.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    private ProjectService projectService;

    /*查询所有项目*/
    public List<Project> queryAllProject(String pName, String pMoeny, String pProgress, String pOwner) throws UnsupportedEncodingException {
        System.out.println(pName + "-" + pMoeny + "-" + pProgress + "-" + pOwner);
        //样本
        ProjectExample projectExampleExample = new ProjectExample();
        //条件盒子
        ProjectExample.Criteria criteria = projectExampleExample.createCriteria();
        //追加条件
        //请求参数乱码解决
        if (pName != null){
            pName = URLDecoder.decode(pName, "UTF-8");
            criteria.andPNameLike("%" + pName + "%");
        }

        if(pMoeny != null && !pMoeny.equals("")){
            pMoeny = URLDecoder.decode(pMoeny, "UTF-8");
            criteria.andPMoenyGreaterThanOrEqualTo(pMoeny);
        }
        if(pProgress != null && !pProgress.equals("")){
            pProgress = URLDecoder.decode(pProgress, "UTF-8");
            criteria.andPProgressEqualTo(pProgress);
        }
        if(pOwner != null && !pOwner.equals("")){
            pOwner = URLDecoder.decode(pOwner, "UTF-8");
            criteria.andPOwnerEqualTo(pOwner);
        }
        //查询所有项目
        List<Project> projectList = projectMapper.selectByExample(projectExampleExample);
        for (Project project : projectList) {
            //判断该员工是否存在
            String eName = project.getpOwner();
            EmployeeExample employeeExample = new EmployeeExample();
            employeeExample.createCriteria().andENameEqualTo(eName);
            List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
            if(employeeList.size() == 0){
                project.setpOwner("待定");
            }
            //项目-客户表
            CusProExample cusProExample = new CusProExample();
            //根据当前项目id查询对应的所有客户
            cusProExample.createCriteria().andCpIdEqualTo(project.getCpId());
            List<CusPro> cusProList = cusProMapper.selectByExample(cusProExample);
            //获取当前项目对应的所有客户名称
            List<String> cRenames = new ArrayList<>();
            //给Project对象设置cIds拜访客户cId
            String cIds = new String();
            for (CusPro cusPro : cusProList) {
                //前端展示客户参与人员
                Customer customer = customerMapper.selectByPrimaryKey(cusPro.getcId());
                if(customer != null){
                    cRenames.add(customer.getcRename());
                    cIds += customer.getcId() + ",";
                }
            }
            //获取回款总金额
            Integer startPbId = project.getPbId();
            Integer endPbId = startPbId + 999;
            System.out.println("--------------start=" + startPbId + "------end=" + endPbId);
            List<PaymentBack> paymentBacks = projectService.PbIdBetweenStartAndEnd(startPbId, endPbId);
            Integer total = 0;
            for (PaymentBack paymentBack : paymentBacks) {
                total += paymentBack.getPbMoney();
            }
            project.setTotal(total);
            project.setcIds(cIds);
            project.setcRenames(cRenames);
        }
        //倒叙
//        Collections.reverse(projectList);
        return projectList;
    }

    /*获取所有项目名称*/
    public List<String> getAllProjectName(){
        ArrayList<String> strings = new ArrayList<>();
        List<Project> projects = projectMapper.selectByExample(null);
        for (Project project : projects) {
            strings.add(project.getpName());
        }
        return strings;
    }

    /*添加项目*/
    public void addProject(Project project, String[] cRenames){
        //(1)获取session域中的pbId
        //设置回款编号
        System.out.println(project);
        projectMapper.insertSelective(project);
        //返回生成的编号
        Integer newIndex = project.getpId();
        project.setCpId(newIndex);
        project.setPbId(newIndex * 1000);
        //修改重要字段值
        projectMapper.updateByPrimaryKeySelective(project);
        //根据客户名单遍历添加数据库
        if(cRenames.length > 0 && cRenames != null){
            for (String cRename : cRenames) {
                //追加关系表cus_pro
                CusPro cusPro = new CusPro();
                cusPro.setCpId(newIndex);
                cusPro.setpId(newIndex);
                CustomerExample customerExample = new CustomerExample();
                customerExample.createCriteria().andCRenameEqualTo(cRename);
                Customer customer = customerMapper.selectByExample(customerExample).get(0);
                if(customer != null){
                    cusPro.setcId(customer.getcId());
                    cusProMapper.insertSelective(cusPro);
                }
            }
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
        if(cusProList.size() > 0){
            for (CusPro cusPro : cusProList) {
                Customer customer = customerMapper.selectByPrimaryKey(cusPro.getcId());
                if(customer != null){
                    cRenames.add(customer.getcRename());
                }
            }
        }
        if(cRenames.size() > 0){
            project.setcRenames(cRenames);
        }
        return project;
    }

    /*修改项目*/
    public boolean updateProject(Project project, String[] cRenames){
        //清空客户与项目信息
        CusProExample cusProExample = new CusProExample();
        cusProExample.createCriteria().andCpIdEqualTo(project.getpId());
        cusProMapper.deleteByExample(cusProExample);
        //重新添加客户信息到cus_pro
        if(cRenames != null && cRenames.length > 0){
            for (String cRename : cRenames) {
                //追加关系表cus_pro
                CusPro cusPro = new CusPro();
                cusPro.setCpId(project.getpId());
                cusPro.setpId(project.getpId());
                CustomerExample customerExample = new CustomerExample();
                customerExample.createCriteria().andCRenameEqualTo(cRename);
                Customer customer = customerMapper.selectByExample(customerExample).get(0);
                if (customer != null){
                    cusPro.setcId(customer.getcId());
                    cusProMapper.insertSelective(cusPro);
                }
            }
        }
        //重写字段值
        project.setCpId(project.getpId());
        project.setPbId(project.getpId() * 1000);
        int updateResult = projectMapper.updateByPrimaryKeySelective(project);
        return updateResult > 0 ? true : false;
    }

    /*[拜访模块]=====================================================================================*/
    /*查询当前合同拜访记录*/
    public List<Interview> interview_recor(String cIds, Integer pId){
        //获取目标cIds信息，即当前项目所有的客户[目前没什么用]
//        if(cIds != null){
//            String[] split = cIds.split(",");
//            List<Integer> cIdList = new ArrayList<>();
//            for (String s : split) {
//                cIdList.add(Integer.parseInt(s));
//            }
//        }
        //创建样本对象
        InterviewExample interviewExample = new InterviewExample();
        //追加条件，根据传过来的项目id查询
        interviewExample.createCriteria().andPIdEqualTo(pId);
        //查询当前项目id对应的所有拜访记录
        List<Interview> currentInterviewList = interviewMapper.selectByExample(interviewExample);
        //不展示部分
        List<Interview> delItws = new ArrayList<>();
        //遍历
        for (Interview interview : currentInterviewList) {
            //设置客户姓名
            if(interview.getcId() != null && !interview.getcId().equals("")){
                Customer customer = customerMapper.selectByPrimaryKey(interview.getcId());
                //客户不为空时---为空则不展示
                if(customer != null){
                    interview.setcRename(customer.getcRename());
                }else{
                    delItws.add(interview);
                    continue;
                }
            }
            //我方员工姓名
            if(interview.geteId() != null && !interview.geteId().equals("")){
                Employee employee = employeeMapper.selectByPrimaryKey(interview.geteId());
                //客户不为空时---为空则不展示
                if(employee != null){
                    interview.seteRename(employee.getRename());
                }else{
                    delItws.add(interview);
                    continue;
                }
            }
            //设置拜访类型
            if(interview.getpName() == null || interview.getpName().equals("")){
                Project project = projectMapper.selectByPrimaryKey(interview.getpId());
                //客户不为空时---为空则不展示
                if(project != null){
                    interview.setpName(project.getpName());
                }else{
                    delItws.add(interview);
                    continue;
                }
            }
        }
        //批量过滤不存在的
        currentInterviewList.removeAll(delItws);

        //输出查看过情况
        System.out.println("===============================");
        System.out.println(currentInterviewList);

        //返回现有的
        //倒叙
        Collections.reverse(currentInterviewList);
        return currentInterviewList;
    }

    /*[合同模块]===========================================================================*/
    /*查询所有合同*/
    public List<Contract> contract_record(Integer pId){
        ContractExample contractExample = new ContractExample();
        contractExample.createCriteria().andPIdEqualTo(pId);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        //倒叙
        Collections.reverse(contractList);
        return contractList;
    }

    /*添加合同*/
    public boolean contractAdd(Contract contract){
        //实现添加业务
        System.out.println(contract);
        int result = contractMapper.insertSelective(contract);
        return result>0 ? true : false;
    }

    /*根据ctId查询合同*/
    public Contract queryConById(Integer ctId) {
        Contract contract = contractMapper.selectByPrimaryKey(ctId);
        return contract;
    }

    /*根据ctId修改合同*/
    public boolean contractUpdate(Contract contract){
        //去空格
        if(null != contract.getCtContractAmount()){
            String ctContractAmount = contract.getCtContractAmount();
            String conStr = "";
            String[] s = ctContractAmount.split(" ");
            for (String s1 : s) {
                conStr += s1;
            }
            contract.setCtContractAmount(conStr);
        }
        if(null != contract.getCtTenderAmount()){
            String ctTenderAmount = contract.getCtTenderAmount();
            String tenStr = "";
            String[] s1 = ctTenderAmount.split(" ");
            for (String s2 : s1) {
                tenStr += s2;
            }
            contract.setCtTenderAmount(tenStr);
        }
        //实现添加业务
        System.out.println(contract);
        int result = contractMapper.updateByPrimaryKeySelective(contract);
        return result > 0 ? true : false;
    }

    /*[回款模块]==================================================================================*/
    public List<PaymentBack> queryAllPayBack(Integer pbId){
        PaymentBackExample paymentBackExample1 = new PaymentBackExample();
        paymentBackExample1.createCriteria().andPbIdEqualTo(pbId);
        List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample1);
        //倒叙
        Collections.reverse(paymentBacks);
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
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        paymentBackExample.createCriteria().andPbIdEqualTo(paymentBack.getPbId());
        List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample);
        PaymentBack payment = paymentBacks.get(0);
        payment.setPbMoney(paymentBack.getPbMoney());
        int updateResult = paymentBackMapper.updatePayBack(payment);
        return updateResult > 0 ? true : false;
    }
}
