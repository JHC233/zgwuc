package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    int removeList(@Param("ids") List<Integer> ids);
    List<Role> list();
    int save(Role role);
    int update(Role role);
    Role getById(int id);
    int remove(int id);
}
