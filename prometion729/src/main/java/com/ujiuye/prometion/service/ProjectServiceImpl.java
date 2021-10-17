package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.ProjectMapper;
import com.ujiuye.prometion.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
@Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> list() { return projectMapper.list(); }

    @Override
    public int save(Project project) {
        return projectMapper.save(project);
    }

    @Override
    public int update(Project project) {
        return projectMapper.update(project);
    }

    @Override
    public Project getById(int id) {
        return projectMapper.getById(id);
    }

    @Override
    public int remove(int id) {
        return projectMapper.remove(id);
    }
}
