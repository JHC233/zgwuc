package com.ujiuye.prometion.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ujiuye.prometion.pojo.Employee;
import com.ujiuye.prometion.pojo.Role;
import com.ujiuye.prometion.service.EmployeeService;
import com.ujiuye.prometion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@RequestMapping("/role")
@RestController
public class RoleController {
        @Autowired
        private RoleService roleService;

        @RequestMapping("/list")
        public PageInfo<Role> list(@RequestParam(value ="pageNum" ,defaultValue = "1") int pageNum){
            PageHelper.startPage(pageNum,5);
            List<Role> list=roleService.list();
            PageInfo<Role> PageInfo=new PageInfo<Role>(list);
            return PageInfo;
        }

         @RequestMapping("/listAll")
         public List<Role> listAll(){
             List<Role> list=roleService.list();
             return list;
         }

        @RequestMapping("/save")
        public String save(Role role){
            try {
                roleService.save(role);
                return "true";
            } catch (Exception e) {
                e.printStackTrace();
                return "flase";
            }
        }

        @RequestMapping("/update")
        public String update(Role role){
            try {
                roleService.update(role);
                return "true";
            } catch (Exception e) {
                e.printStackTrace();
                return "flase";
            }
        }

        @RequestMapping("/remove")
        public String remove(int id){
            try {
           roleService.remove(id);
                return "true";
            } catch (Exception e) {
                e.printStackTrace();
                return "flase";
            }
        }
    @RequestMapping("/removeList")
    public String removeList(Integer[] ids){
        try {
            List<Integer> list= Arrays.asList(ids);
            roleService.removeList( list);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "flase";
        }
    }
        @RequestMapping("/getById")
        public Role getById(int id){
            return  roleService.getById(id);
        }
    }


