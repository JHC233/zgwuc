package com.ujiuye.prometion.service;

import com.ujiuye.prometion.pojo.Analysis;

import java.util.List;

public interface AnalysisService {
    List<Analysis> list();
    int save(Analysis analysis);
    int update(Analysis analysis);
    Analysis getById(int id);
    int remove(int id);
}
