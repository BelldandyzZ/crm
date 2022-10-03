package com.xxz.controller;


import com.xxz.bean.*;
import com.xxz.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

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

//    @Autowired
//    private

    //条件查询
    @RequestMapping("/projects")
    public String queryAll(Model model, String pName, String pMoeny, String pProgress, String pOwner) throws UnsupportedEncodingException {
//        System.out.println(URLEncoder.encode(eJob,"utf-8"));
        System.out.println("queryAll-customers-confition:" + pName + "-" + pMoeny + "-" + pProgress + "-" + pOwner);
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
        System.out.println("条件查询结果：" + projectList);
        model.addAttribute("projectList", projectList);

        //============================================================================
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        List<Customer> customerList = customerMapper.selectByExample(null);
        List<Employee> employeeList = employeeMapper.selectByExample(null);
        //获取所有客户名称
        Set<String> cRenameSet = new HashSet<>();
        //获取所有我方员工姓名
        Set<String> eRenameSet = new TreeSet<>();
        //去重
        for (Customer customer : customerList) {
            cRenameSet.add(customer.getcRename());
        }
        for (Employee employee : employeeList) {
            eRenameSet.add(employee.getRename());
        }
        model.addAttribute("cRenameSet",cRenameSet );
        model.addAttribute("eRenameSet",eRenameSet );
        return "project/project";
    }

    //添加回款业务
    @RequestMapping("/add")
    public String addProject(HttpSession session, Project project, String[] cRenames){
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
        return "redirect:/project/projects";
    }

    //根据编号pid查询
    @RequestMapping("/queryById/{pId}")
    @ResponseBody
    public Map<String,Object> queryById(@PathVariable("pId") Integer pId){
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
        //============================================
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",project);
//        response.getWriter().println(employee);
        return stringObjectHashMap;
    }

    //修改项目
    @RequestMapping("/update")
    public String updateProject(Project project, String[] cRenames){
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
        projectMapper.updateByPrimaryKey(project);
        return "redirect:/project/projects";
    }
















//拜访模块===================================================================================
//拜访模块===================================================================================
//拜访模块===================================================================================
//    /project/interview_record
    @RequestMapping("/interview_record")
    public String interview_recor(Model model, String cIds){
        InterviewExample interviewExample = new InterviewExample();
        //获取目标cId信息
        String[] split = cIds.split(",");
        List<Integer> integers = new ArrayList<>();
        for (String s : split) {
            integers.add(Integer.valueOf(s));
        }
        System.out.println(integers+"================================================================");
        interviewExample.createCriteria().andCIdIn(integers);
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
                interview.setpName("农村购物致富商城系统项目");
            }
        }
        model.addAttribute("currentInterviewList", currentInterviewList);
        return "project/interview_record/interview_record";
    }





//合同模块===================================================================================
//合同模块===================================================================================
//合同模块===================================================================================
//    /project/contract/contract_record
    @RequestMapping("/contract_record")
    public String contract_record(Model model, Integer pId){
        ContractExample contractExample = new ContractExample();
        contractExample.createCriteria().andPIdEqualTo(pId);
        List<Contract> contractList = contractMapper.selectByExample(contractExample);
        model.addAttribute("contractList", contractList);
        model.addAttribute("pId", pId);
        return "project/contract/contract";
    }

    //合同文件下载
    @RequestMapping("/conownloadCon/{fileName}")
    public ResponseEntity<byte[]> conownloadCon(HttpSession session,@PathVariable("fileName") String fileName) throws IOException {
        //使用ResponseEntity实现文件下载功能
        System.out.println("[fileName]=============================================================");
        System.out.println("[fileName=]" + fileName);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径img/1.jpg-->(img + File.separator分隔符 + 1.jpg)
        //获取当前工程下photo目录的真实路径
        String realPath = servletContext.getRealPath("/contracts");
        System.out.println(realPath);
        File parentFile = new File(realPath).getParentFile().getParentFile().getParentFile();
        System.out.println(parentFile.getPath() + "\\src\\main\\webapp\\contracts");
        realPath = parentFile.getPath() + "\\src\\main\\webapp\\contracts\\" + fileName;//--/contracts/test1.doc
        //创建输入流（根据目标文件获取输入流）
        InputStream in = new FileInputStream(realPath);
        //创建字节数组(根据当前输入流可用字节数)
        byte[] bytes = new byte[in.available()];
        //将流数据读取到数组中
        in.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置下载方式以及下载文件的名字
        headers.add("Content-Disposition","attachment;filename=" + fileName);
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        in.close();
        //返回ResponseEntity对象、交给浏览器解析
        return responseEntity;
    }

    //招标合同下载(/tenders/)
    @RequestMapping("/conownloadTen/{fileName}")
    public ResponseEntity<byte[]> conownloadTen(HttpSession session,@PathVariable("fileName") String fileName) throws IOException {
        //使用ResponseEntity实现文件下载功能
        System.out.println("[fileName]=============================================================");
        System.out.println("[fileName=]" + fileName);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径img/1.jpg-->(img + File.separator分隔符 + 1.jpg)
        String realPath = servletContext.getRealPath("/tenders");
        System.out.println(realPath);
        File parentFile = new File(realPath).getParentFile().getParentFile().getParentFile();
        System.out.println(parentFile.getPath() + "\\src\\main\\webapp\\tenders");
        realPath = parentFile.getPath() + "\\src\\main\\webapp\\tenders\\" + fileName;//--/contracts/test1.doc
        //创建输入流（根据目标文件获取输入流）
        InputStream in = new FileInputStream(realPath);
        //创建字节数组(根据当前输入流可用字节数)
        byte[] bytes = new byte[in.available()];
        //将流数据读取到数组中
        in.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置下载方式以及下载文件的名字
        headers.add("Content-Disposition","attachment;filename=" + fileName);
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        in.close();
        //返回ResponseEntity对象、交给浏览器解析
        return responseEntity;
    }

    //合同文件上传
    @RequestMapping("/contractAdd")
    public String contractAdd(Integer pId,MultipartFile ctContractDocmentFile, MultipartFile ctTenderDocmentFile, Contract contract, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String ctfileName = UUID.randomUUID().toString().substring(15) + ctContractDocmentFile.getOriginalFilename();
        System.out.println(ctfileName);
        contract.setCtContractDocment(ctfileName);
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取当前工程下photo目录的真实路径
        String photoRealPath = servletContext.getRealPath("/contracts");
        System.out.println(photoRealPath);
        File parentFile = new File(photoRealPath).getParentFile().getParentFile().getParentFile();
        System.out.println(parentFile.getPath() + "\\src\\main\\webapp\\contracts");

        //E:\idea-workspace\crm\src\main\webapp\contracts
        photoRealPath = parentFile.getPath() + "\\src\\main\\webapp\\contracts";
/*
我们项目中没有photo目录，但文件上传如果到tomcat服务器中,
则可以给服务器部署的工程war包所运行的项目创建photo目录,专门用于存储客户端上传的文件
*/
        //创建photoPath所对应的File对象
        File file = new File(photoRealPath);
        //判断file所对应目录是否存在(即部署的项目中，判断photo目录是否存在)
        if(!file.exists()){
            //不存在则直接创建目录
            file.mkdir();
        }
        //拼接目标文件上传的路径
        String targetFileUploadPath = photoRealPath + File.separator + ctfileName;
        System.out.println(targetFileUploadPath);
        //上传文件(根据目标文件上传路径)
        ctContractDocmentFile.transferTo(new File(targetFileUploadPath));
        //====================================================================
        //====================================================================
        //====================================================================
        //获取上传的文件的文件名
        String tdfileName = UUID.randomUUID().toString().substring(15) + ctTenderDocmentFile.getOriginalFilename();
        System.out.println(tdfileName);
        contract.setCtTenderDocment(tdfileName);
        //获取ServletContext对象
        //获取当前工程下photo目录的真实路径
        String photoRealPath2 = servletContext.getRealPath("/tenders");
        File parentFile2 = new File(photoRealPath2).getParentFile().getParentFile().getParentFile();
        System.out.println(parentFile2.getPath() + "\\src\\main\\webapp\\tenders");
        photoRealPath2 = parentFile2.getPath() + "\\src\\main\\webapp\\tenders";
        //创建photoPath所对应的File对象
        File file2 = new File(photoRealPath2);
        //判断file所对应目录是否存在(即部署的项目中，判断photo目录是否存在)
        if(!file2.exists()){
            //不存在则直接创建目录
            file2.mkdir();
        }
        //拼接目标文件上传的路径
        String targetFileUploadPath2 = photoRealPath2 + File.separator + tdfileName;
        //上传文件(根据目标文件上传路径)
        ctTenderDocmentFile.transferTo(new File(targetFileUploadPath2));
        //=============================================
        //实现添加业务
        System.out.println(contract);
        contractMapper.insertSelective(contract);
        //获取
        return "redirect:/project/contract_record?pId=" + pId;
    }

    //招标合同上传(/tenders/)





//回款模块===================================================================================
//回款模块===================================================================================
//回款模块===================================================================================
//    /project/payment_back?
    @RequestMapping("/payment_back")
    public String payment_back(Model model, HttpSession session, Integer pbId, Integer pId){
        //(1)给定当前操作的项目pbId到Session域中---添加时需要
//        session.setAttribute("pbId", pbId);
        //(2)回显最大pbId
        PaymentBackExample paymentBackExample1 = new PaymentBackExample();
        paymentBackExample1.createCriteria().andPbIdEqualTo(pbId);
        List<PaymentBack> paymentBacks = paymentBackMapper.selectByExample(paymentBackExample1);
        TreeSet<Integer> pbIds = new TreeSet<>();
        for (PaymentBack paymentBack : paymentBacks) {
            pbIds.add(paymentBack.getPbId());
        }
        System.out.println("[pbIds=======================]" + pbIds);
        if(pbIds.size() != 0){ //有回款最大编号才返回
            model.addAttribute("pbId", pbIds.last());
        }else{
            model.addAttribute("pbId", pId * 1000);
        }
        //处理查询业务
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        Integer startPbId = Integer.valueOf(pbId.toString().substring(0,2)) * 100;
        Integer endPbId = startPbId + 999;
        System.out.println("--------------start=" + startPbId + "------end=" + endPbId);
        paymentBackExample.createCriteria().andPbIdBetween(startPbId, endPbId);
        List<PaymentBack> paymentBackList = paymentBackMapper.selectByExample(paymentBackExample);
        model.addAttribute("paymentBackList", paymentBackList);
        return "project/payment_back/payment_back";
    }

    //添加回款业务
    @RequestMapping("/addPayBack")
    public String addProject(HttpSession session, PaymentBack paymentBack){
        //(1)获取session域中的pbId
//        Integer pbId = (Integer) session.getAttribute("pbId");
        //(2)回去回显pbId(last)
        paymentBack.setPbId(paymentBack.getPbId() + 1);
        paymentBackMapper.insert(paymentBack);
        return "redirect:/project/payment_back?pbId=" + paymentBack.getPbId();
    }
    //查询回款业务
//    url: "/crm/project/payBackQueryById/" + pbId,
    @RequestMapping("payBackQueryById/{pbId}")
    @ResponseBody
    public Map<String,Object> payBackQueryById(@PathVariable("pbId") Integer pbId){
        PaymentBackExample paymentBackExample = new PaymentBackExample();
        paymentBackExample.createCriteria().andPbIdEqualTo(pbId);
        PaymentBack paymentBack = paymentBackMapper.selectByExample(paymentBackExample).get(0);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",paymentBack);
//        response.getWriter().println(employee);
        return stringObjectHashMap;
    }

    //修改回款信息
    @RequestMapping("/payBackUpdate")
    private String payBackUpdate(PaymentBack paymentBack){
        paymentBackMapper.updatePayBack(paymentBack);
        return "redirect:/project/payment_back?pbId=" + paymentBack.getPbId();
    }
}
