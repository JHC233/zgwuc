package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int removeList(@Param("ids") List<Integer> ids);
    List<Role> list();
    int save(Role role);
    int update(Role role);
    Role getById(int id);
    int remove(int id);
}
