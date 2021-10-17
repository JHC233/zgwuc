package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/list")
    public PageInfo<Dept> list(@RequestParam(value ="pageNum" ,defaultValue = "1")
                                       int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Dept> list=deptService.list();
        PageInfo<Dept> PageInfo=new PageInfo<Dept>(list);
        return PageInfo;
    }

    @RequestMapping("/listAll")
    public List<Dept> listAll(){
        List<Dept> list=deptService.list();
        return list;
    }

    @RequestMapping("/save")
    public String save(Dept dept){
        try {
            deptService.save(dept);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/update")
    public String update(Dept dept){
        try {
            deptService.update(dept);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/remove")
    public String remove(int no){
        try {
            deptService.remove(no);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }
    @RequestMapping("/getByNo")
    public Dept getByNo(int no){
        return  deptService.getByNo(no);
    }

    @RequestMapping("/removeList")
    public String removeList(Integer[] nos){
        try {
//            把数据转成集合
            List<Integer> list= Arrays.asList(nos);
            deptService.removeList(list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }
}

