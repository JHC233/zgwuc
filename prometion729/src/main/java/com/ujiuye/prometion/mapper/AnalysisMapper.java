package com.ujiuye.prometion.mapper;
import com.ujiuye.prometion.pojo.Analysis;

import java.util.List;

public interface AnalysisMapper {
    List<Analysis> list();
    int save(Analysis analysis);
    int update(Analysis analysis);
    Analysis getById(int id);
    int remove(int id);
}