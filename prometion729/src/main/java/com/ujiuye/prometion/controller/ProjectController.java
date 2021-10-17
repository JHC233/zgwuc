package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.pojo.Project;
import com.ujiuye.prometion.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @RequestMapping("/list")
    public PageInfo<Project> list(@RequestParam(value ="pageNum" ,defaultValue = "1")
                                       int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Project> list=projectService.list();
        PageInfo<Project> PageInfo=new PageInfo<Project>(list);
        return PageInfo;
    }

    @RequestMapping("/listAll")
    public List<Project> listAll(){
        List<Project> list=projectService.list();
        return list;
    }

    @RequestMapping("/save")
    public String save(Project project){
        try {
            projectService.save(project);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/update")
    public String update(Project project){
        try {
            projectService.update(project);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/remove")
    public String remove(int id){
        try {
            projectService.remove(id);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/getById")
    public Project getById(int id){
        return  projectService.getById(id);
    }

}
