package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    int removeList(@Param("nos") List<Integer> nos);
    List<Dept> list();
    int save(Dept dept);
    int update(Dept dept);
    Dept getByNo(int no);
    int remove(int no);
}
