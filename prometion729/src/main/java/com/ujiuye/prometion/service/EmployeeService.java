package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Employee;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

public interface EmployeeService {
    List<Employee> list(int type,String keyword);
    int save(Employee employee,List<Integer> list);
    int update(Employee employee,List<Integer> list);
    int updateLogo(Employee employee);
    Employee getByEid(int eid);
    int remove(int eid);
    List<Employee> listAll();

    Employee login(String username,String password);
    Employee getByUserName(String username);
    //返回一个Excel文件，用于下载
    File getExcel(int pageNum);

}
