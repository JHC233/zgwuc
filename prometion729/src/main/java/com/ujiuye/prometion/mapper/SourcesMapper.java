package com.ujiuye.prometion.mapper;

import com.ujiuye.prometion.pojo.Sources;

import java.util.List;

public interface SourcesMapper {
    int remove(int id);
    int save(Sources sources);
    int update(Sources sources);
    Sources getById(int id);
    List<Sources> list();
}
