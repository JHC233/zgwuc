package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Analysis;
import com.ujiuye.prometion.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Analysis")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    @RequestMapping("/list")
    public PageInfo<Analysis> list(@RequestParam(value ="pageNum" ,defaultValue = "1")
                                       int pageNum){
        PageHelper.startPage(pageNum,5);
        List<Analysis> list=analysisService.list();
        PageInfo<Analysis> PageInfo=new PageInfo<Analysis>(list);
        return PageInfo;
    }

    @RequestMapping("/listAll")
    public List<Analysis> listAll(){
        List<Analysis> list=analysisService.list();
        return list;
    }

    @RequestMapping("/save")
    public String save(Analysis analysis){
        try {
            analysisService.save(analysis);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/update")
    public String update(Analysis analysis){
        try {
            analysisService.update(analysis);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/remove")
    public String remove(int id){
        try {
            analysisService.remove(id);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }
    @RequestMapping("/getById")
    public Analysis getById(int id){
        return  analysisService.getById(id);
    }


}
