package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptService {
    int removeList(@Param("nos") List<Integer> nos);
    List<Dept> list();
    int save(Dept dept);
    int update(Dept dept);
    Dept getByNo(int no);
    int remove(int no);
}
