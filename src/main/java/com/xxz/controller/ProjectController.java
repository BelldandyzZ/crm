package com.xxz.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxz.annotations.Permission;
import com.xxz.bean.*;
import com.xxz.mapper.*;
import com.xxz.service.*;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmpService empService;

    @Autowired
    private  ProjectMapper projectMapper;

    @Autowired
    private DicValueService dicValueService;


    //条件查询
    @Permission("3010")
    @RequestMapping("/projects")
    public String queryAll(Model model, String pName, String pMoeny, String pProgress, String pOwner, HttpSession session,  @RequestParam(defaultValue = "1") Integer pageNum, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");



//=====================================================================================================



        PageHelper.startPage(pageNum,  10);
        //工具条件查询
        List<Project> projectList = projectService.queryAllProject(pName, pMoeny, pProgress, pOwner);
        PageInfo<Project> proPageInfo = new PageInfo<>(projectList, 5);
        model.addAttribute("proPageInfo", proPageInfo);
        //条件回显
        model.addAttribute("pName", pName);
        model.addAttribute("pMoeny", pMoeny);
        model.addAttribute("pProgress", pProgress);
        model.addAttribute("pOwner", pOwner);
        //============================================================================
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        //(2)客户名称下拉框、客户单位下拉框,我方员工姓名
        List<Customer> customerList = customerService.queryAllCus(null, null, null);
        List<Employee> employeeList = empService.queryAllEmp(null, null, null);
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
    @Permission("3020")
    public String addProject(HttpSession session, Project project, String[] cRenames){
        //(1)获取session域中的pbId
        //设置回款编号
        projectService.addProject(project, cRenames);
        return "redirect:/project/projects";
    }

    //添加回款业务
    @RequestMapping("/del/{pId}")
    @Permission("3040")
    public String delProject(@PathVariable("pId") Integer pId){
        //(1)获取session域中的pbId
        //设置回款编号
//        projectService.addProject(project, cRenames);
        projectMapper.deleteByPrimaryKey(pId);
        return "redirect:/project/projects";
    }

    //根据编号pid查询
    @RequestMapping("/queryById/{pId}")
    @ResponseBody
    @Permission("3010")
    public Map<String,Object> queryById(@PathVariable("pId") Integer pId){
        Project project = projectService.queryById(pId);
        //============================================
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",project);
//        response.getWriter().println(employee);
        return stringObjectHashMap;
    }

    //修改项目
    @RequestMapping("/update")
    @Permission("3040")
    public String updateProject(Project project, String[] cRenames){
        boolean result = projectService.updateProject(project, cRenames);

        return "redirect:/project/projects";
    }

//拜访模块===================================================================================
//拜访模块===================================================================================
//    /project/interview_record
    @RequestMapping("/interview_record")
    @Permission("2010")
    public String interview_recor(Model model, @RequestParam(required = false) String cIds, Integer pId,
                                  @RequestParam(defaultValue = "1") Integer pageNum){
        //查询当前项目对应的所有拜访记录
        List<Interview> currentInterviewList = projectService.interview_recor(cIds, pId);
        PageHelper.startPage(pageNum,  10);
        PageInfo<Interview> itwRecordPageInfo = new PageInfo<>(currentInterviewList, 5);
        model.addAttribute("itwRecordPageInfo", itwRecordPageInfo);
        //条件回显
        model.addAttribute("pId", pId);
        return "project/interview_record/interview_record";
    }


//合同模块===================================================================================
//合同模块===================================================================================
//    /project/contract/contract_record
    @RequestMapping("/contract_record")
    @Permission("305010")
    public String contract_record(Model model, Integer pId,
                                  @RequestParam(defaultValue = "1") Integer pageNum){
        PageHelper.startPage(pageNum,  10);
        //查询当前项目所有合同
        List<Contract> contracts = projectService.contract_record(pId);
        PageInfo<Contract> conPageInfo = new PageInfo<>(contracts, 5);
        //返回数据
        model.addAttribute("conPageInfo", conPageInfo);
        //回显条件
        model.addAttribute("pId", pId);
        return "project/contract/contract";
    }

    //合同文件下载
    @RequestMapping("/conownloadCon/{fileName}")
    public ResponseEntity<byte[]> conownloadCon(HttpSession session,@PathVariable("fileName") String fileName) throws IOException {
        //使用ResponseEntity实现文件下载功能
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径img/1.jpg-->(img + File.separator分隔符 + 1.jpg)
        //获取当前工程下photo目录的真实路径
        String realPath = servletContext.getRealPath("/contracts");
        File parentFile = new File(realPath).getParentFile().getParentFile().getParentFile();
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
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径img/1.jpg-->(img + File.separator分隔符 + 1.jpg)
        String realPath = servletContext.getRealPath("/tenders");
        File parentFile = new File(realPath).getParentFile().getParentFile().getParentFile();
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
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        if(ctContractDocmentFile.getOriginalFilename() != null && !ctContractDocmentFile.getOriginalFilename().equals("")){
            String ctfileName = UUID.randomUUID().toString().substring(15) + ctContractDocmentFile.getOriginalFilename();
            //锁定长度
            if(ctfileName.length() > 25){
                ctfileName = ctfileName.substring(ctfileName.length() - 25, ctfileName.length());
            }
            contract.setCtContractDocment(ctfileName);
            //获取当前工程下photo目录的真实路径
            String photoRealPath = servletContext.getRealPath("/contracts");
            File parentFile = new File(photoRealPath).getParentFile().getParentFile().getParentFile();

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
            //上传文件(根据目标文件上传路径)
            ctContractDocmentFile.transferTo(new File(targetFileUploadPath));
        }
        //====================================================================
        //====================================================================
        //====================================================================
        if(ctTenderDocmentFile.getOriginalFilename() != null && !ctTenderDocmentFile.getOriginalFilename().equals("")){
            //获取上传的文件的文件名
            String tdfileName = UUID.randomUUID().toString().substring(15) + ctTenderDocmentFile.getOriginalFilename();
            //锁定长度
            if(tdfileName.length() > 25){
                tdfileName = tdfileName.substring(tdfileName.length() - 25, tdfileName.length());
            }
            contract.setCtTenderDocment(tdfileName);
            //获取ServletContext对象
            //获取当前工程下photo目录的真实路径
            String photoRealPath2 = servletContext.getRealPath("/tenders");
            File parentFile2 = new File(photoRealPath2).getParentFile().getParentFile().getParentFile();
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
        }
        //=============================================
        //实现添加业务
        boolean result = projectService.contractAdd(contract);
        //获取
        return "redirect:/project/contract_record?pId=" + pId;
    }


    //    updateContract
    @RequestMapping("/updateContract")
    @Permission("305040")
    public String updateContract(Integer pId,MultipartFile ctContractDocmentFile, MultipartFile ctTenderDocmentFile, Contract contract, HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        if(ctContractDocmentFile.getOriginalFilename() != null && !ctContractDocmentFile.getOriginalFilename().equals("")) {
            //获取上传的文件的文件名
            String ctfileName = UUID.randomUUID().toString().substring(15) + ctContractDocmentFile.getOriginalFilename();
            //锁定长度
            if (ctfileName.length() > 25) {
                ctfileName = ctfileName.substring(ctfileName.length() - 25, ctfileName.length());
            }
            contract.setCtContractDocment(ctfileName);
            //获取当前工程下photo目录的真实路径
            String photoRealPath = servletContext.getRealPath("/contracts");
            File parentFile = new File(photoRealPath).getParentFile().getParentFile().getParentFile();

            //E:\idea-workspace\crm\src\main\webapp\contracts
            photoRealPath = parentFile.getPath() + "\\src\\main\\webapp\\contracts";
/*
我们项目中没有photo目录，但文件上传如果到tomcat服务器中,
则可以给服务器部署的工程war包所运行的项目创建photo目录,专门用于存储客户端上传的文件
*/
            //创建photoPath所对应的File对象
            File file = new File(photoRealPath);
            //判断file所对应目录是否存在(即部署的项目中，判断photo目录是否存在)
            if (!file.exists()) {
                //不存在则直接创建目录
                file.mkdir();
            }
            //拼接目标文件上传的路径
            String targetFileUploadPath = photoRealPath + File.separator + ctfileName;
            //上传文件(根据目标文件上传路径)
            ctContractDocmentFile.transferTo(new File(targetFileUploadPath));
        }
        //====================================================================
        //====================================================================
        //====================================================================
        if(ctTenderDocmentFile.getOriginalFilename() != null && !ctTenderDocmentFile.getOriginalFilename().equals("")) {
            //获取上传的文件的文件名
            String tdfileName = UUID.randomUUID().toString().substring(15) + ctTenderDocmentFile.getOriginalFilename();
            //锁定长度
            if (tdfileName.length() > 25) {
                tdfileName = tdfileName.substring(tdfileName.length() - 25, tdfileName.length());
            }
            contract.setCtTenderDocment(tdfileName);
            //获取ServletContext对象
            //获取当前工程下photo目录的真实路径
            String photoRealPath2 = servletContext.getRealPath("/tenders");
            File parentFile2 = new File(photoRealPath2).getParentFile().getParentFile().getParentFile();
            photoRealPath2 = parentFile2.getPath() + "\\src\\main\\webapp\\tenders";
            //创建photoPath所对应的File对象
            File file2 = new File(photoRealPath2);
            //判断file所对应目录是否存在(即部署的项目中，判断photo目录是否存在)
            if (!file2.exists()) {
                //不存在则直接创建目录
                file2.mkdir();
            }
            //拼接目标文件上传的路径
            String targetFileUploadPath2 = photoRealPath2 + File.separator + tdfileName;
            //上传文件(根据目标文件上传路径)
            ctTenderDocmentFile.transferTo(new File(targetFileUploadPath2));
        }
        //=============================================
        //实现添加业务
        boolean result = projectService.contractUpdate(contract);
        //获取
        return "redirect:/project/contract_record?pId=" + pId;
    }

    @RequestMapping("/queryConById/{ctId}")
    @ResponseBody
    @Permission("305010")
    public Map<String,Object> queryConById(@PathVariable("ctId") Integer ctId, HttpServletResponse response) throws IOException {
        Contract contract = projectService.queryConById(ctId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",contract);
        return stringObjectHashMap;
    }

    //回款模块===================================================================================
    //回款模块===================================================================================

    @RequestMapping("/payment_back")
    @Permission("306010")
    public String payment_back(Model model, HttpSession session, Integer pbId,
                               @RequestParam(required = false) Integer pId,
                               @RequestParam(defaultValue = "1") Integer pageNum){
        //处理查询业务
//        Integer startPbId = Integer.valueOf(pbId.toString().substring(0,2)) * 100;
        Integer startPbId = pbId;
        Integer endPbId = startPbId + 999;
        PageHelper.startPage(pageNum,  10);
        List<PaymentBack> paymentBackList = projectService.PbIdBetweenStartAndEnd(startPbId, endPbId);
        PageInfo<PaymentBack> payPageInfo = new PageInfo<>(paymentBackList, 5);
        //回显分页对象
        model.addAttribute("payPageInfo", payPageInfo);
        //======================================================
        TreeSet<Integer> pbIds = new TreeSet<>();
        for (PaymentBack paymentBack : paymentBackList) {
            pbIds.add(paymentBack.getPbId());
        }
        //有回款最大编号才返回----添加的时候到session里面获取+1即可
        if(pbIds.size() > 0){
            session.setAttribute("max_pbId", pbIds.last());
        }else{
            session.setAttribute("max_pbId", pbId);
        }
        session.setAttribute("now_pbId", pbId);
        //条件回显
        model.addAttribute("pbId", pbId);
        return "project/payment_back/payment_back";
    }

    //添加回款业务
    @Permission("306020")
    @RequestMapping("/addPayBack")
    public String addPayMent(HttpSession session, PaymentBack paymentBack){
        //session获取最大pbid
        Integer max_pbId = (Integer) session.getAttribute("max_pbId");
        //session获取当前pbid
        Integer now_pbId = (Integer) session.getAttribute("now_pbId");
        //设置最大id添加
        paymentBack.setPbId(max_pbId + 1);
        projectService.addPayMent(paymentBack);
        return "redirect:/project/payment_back?pbId=" + now_pbId;
    }

    //查询回款业务
    @Permission("306010")
    @RequestMapping("payBackQueryById/{pbId}")
    @ResponseBody
    public Map<String,Object> payBackQueryById(@PathVariable("pbId") Integer pbId){
        PaymentBack paymentBack = projectService.payBackQueryById(pbId);
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code","200");
        stringObjectHashMap.put("data",paymentBack);
//        response.getWriter().println(employee);
        return stringObjectHashMap;
    }

    //修改回款信息
    @Permission("306040")
    @RequestMapping("/payBackUpdate")
    private String payBackUpdate(PaymentBack paymentBack,HttpSession session){
        boolean result = projectService.payBackUpdate(paymentBack);
        //session获取当前pbid
        Integer now_pbId = (Integer) session.getAttribute("now_pbId");
        return "redirect:/project/payment_back?pbId=" + now_pbId;
    }


    //删除回款
    @Permission("306030")
    @RequestMapping("/remove/{paymentBackId}")
    public String erasePaymentbackById(HttpSession session,@PathVariable("paymentBackId") Integer id){
        projectService.removePaymentbackById(id);
        Integer now_pbId = (Integer) session.getAttribute("now_pbId");
        return "redirect:/project/payment_back?pbId=" + now_pbId;
    }

    //删除合同
    @Permission("305030")
    @RequestMapping("/eraseContractById/{currentpId}/{ctId}")
    public String eraseContractById(@PathVariable("currentpId") Integer currentpId,@PathVariable("ctId") Integer ctId){
        int res = projectService.removeContractById(ctId);
        return "redirect:/project/contract_record?pId=" + currentpId;
    }



}
