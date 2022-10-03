package com.xxz.controller;

import com.xxz.bean.Project;
import com.xxz.bean.ProjectExample;
import com.xxz.mapper.ProjectMapper;
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
        System.out.println("条件查询结果：" + projectList);
        model.addAttribute("projectList", projectList);
        return "project/project";
    }

}
