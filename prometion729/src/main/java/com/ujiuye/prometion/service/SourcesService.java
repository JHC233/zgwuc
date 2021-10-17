package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Sources;

import java.util.List;

public interface SourcesService {
    int remove(int id);
    int save(Sources sources);
    int update(Sources sources);
    Sources getById(int id);
    List<Sources> list();
}
