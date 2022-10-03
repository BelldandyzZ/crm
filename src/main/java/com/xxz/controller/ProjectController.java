package com.xxz.controller;

import com.xxz.bean.*;
import com.xxz.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CusProMapper cusProMapper;

    @Autowired
    private InterviewMapper interviewMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private PaymentBackMapper paymentBackMapper;

//    @Autowired
//    private

    //条件查询
    @RequestMapping("/projects")
    public String queryAll(Model model, String cRename, String cName, String cJob) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll-customers-confition:" + cRename + "-" + cName + "-" + cJob);
        //样本
        ProjectExample projectExampleExample = new ProjectExample();
        //条件盒子
        ProjectExample.Criteria criteria = projectExampleExample.createCriteria();
        //追加条件
//        if (cRename != null){
//            criteria.andCRenameLike("%" + cRename + "%");
//        }
//        if(cJob != null && !cJob.equals("")){
//            criteria.andCJobEqualTo(cJob);
//        }
//        if(cName != null && !cName.equals("")){
//            criteria.andCNameEqualTo(cName);
//        }
        //查询
        List<Project> projectList = projectMapper.selectByExample(null);
        for (Project project : projectList) {
            CusPro cusPro = cusProMapper.selectByPrimaryKey(project.getCpId());
            project.setcId(cusPro.getcId());
            project.setcRename(customerMapper.selectByPrimaryKey(cusPro.getcId()).getcRename());
        }
        System.out.println("条件查询结果：" + projectList);
        model.addAttribute("projectList", projectList);
        return "project/project";
    }

//    /project/interview_record
    @RequestMapping("/interview_record")
    public String interview_recor(Model model, Integer cId){
        InterviewExample interviewExample = new InterviewExample();
        interviewExample.createCriteria().andCIdEqualTo(cId);
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
                interview.setpName("农村购物致富商城系统项目");
            }
        }
        model.addAttribute("currentInterviewList", currentInterviewList);
        return "project/interview_record/interview_record";
    }

//    /project/contract/contract_record
    @RequestMapping("/contract_record")
    public String contract_record(Model model, Integer pId){
        ContractExample contractExample = new ContractExample();
        contractExample.createCriteria().andPIdEqualTo(pId);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        model.addAttribute("contractList", contractList);
        return "project/contract/contract";
    }

//    /project/payment_back?
    @RequestMapping("/payment_back")
    public String payment_back(Model model, Integer pbId){
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        paymentBackExample.createCriteria().andPbIdEqualTo(pbId);
        List<PaymentBack> paymentBackList = paymentBackMapper.selectByExample(paymentBackExample);
        model.addAttribute("paymentBackList", paymentBackList);
        return "project/payment_back/payment_back";
    }

}
