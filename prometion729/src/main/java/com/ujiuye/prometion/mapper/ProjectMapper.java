package com.ujiuye.prometion.mapper;
import com.ujiuye.prometion.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    List<Project> list();
    int save(Project project);
    int update(Project project);
    Project getById(int id);
    int remove(int id);
}