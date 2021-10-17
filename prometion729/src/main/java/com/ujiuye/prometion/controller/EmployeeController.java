package com.ujiuye.prometion.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Dept;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.service.EmployeeService;
import com.ujiuye.prometion.utils.MyFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/listAll")
    public List<Employee> listAll() {
        List<Employee> list =employeeService.listAll();
        return list;
    }

    @RequestMapping("/list")
    public PageInfo<Employee> list(@RequestParam(value ="pageNum" ,defaultValue = "1")
                       int pageNum, String keyword,
          @RequestParam(value ="type" ,defaultValue = "0" )int type){
        PageHelper.startPage(pageNum,5);
        List<Employee> list=employeeService.list(type,keyword);
        PageInfo<Employee> page=new PageInfo<Employee>(list);
        return page;
    }

    @RequestMapping("/save")
    public String save(Employee employee,Integer[] roles){
        try {
            List<Integer> list= Arrays.asList(roles);
            employeeService.save(employee,list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/update")
    public String update(Employee employee,Integer[] roles){
        List<Integer> list =null;
        if (roles==null){
            return "true";
        }
        if (roles!=null){
           list=Arrays.asList(roles);
        }
        try {
            employeeService.update(employee,list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/remove")
    public String remove(int eid){
        try {
           int remove = employeeService.remove(eid);
           if (remove<0){
               return "error";
           }
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }

    @RequestMapping("/getByEid")
    public Employee getByEid(int eid){
        return  employeeService.getByEid(eid);
    }


    @RequestMapping("/updateLogo")
    public String updateLogo(Employee employee, HttpSession session){
        try {
            Employee sysUser=(Employee) session.getAttribute("LOGIN_USER");
            employee.setEid(sysUser.getEid());
            employeeService.updateLogo(employee);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "flase";
    }

    @Value("${upload.url}")
    private String url;

    @RequestMapping("/upload")
    public String upload(MultipartFile myfile){
       File file= MyFileUtils.uploadFile(myfile,url);
        if (file==null){
              return "false";
        }
        String picUrl="/upload/"+file.getName();

            return picUrl;
        }

    @RequestMapping("/getLoginUser")
    public Employee getLoginUser(HttpSession session){
        Employee employee=(Employee)session.getAttribute("LOGIN_USER");
            return  employeeService.getByEid(employee.getEid());
    }

    }


