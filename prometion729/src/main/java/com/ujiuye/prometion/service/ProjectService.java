package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> list();
    int save(Project project);
    int update(Project project);
    Project getById(int id);
    int remove(int id);
}
