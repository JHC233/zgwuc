package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    List<Employee> list(@Param("name") String name,
                        @Param("tel") String tel,
                        @Param("hiredate") String hiredate);
    int save(Employee employee);
    int update(Employee employee);
    Employee getByEid(int eid);
    int remove(int eid);
    Employee getByUserName(String username);
     List<Employee> listAll();
}
