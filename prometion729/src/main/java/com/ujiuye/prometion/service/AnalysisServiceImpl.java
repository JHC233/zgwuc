package com.ujiuye.prometion.service;

import com.ujiuye.prometion.mapper.AnalysisMapper;
import com.ujiuye.prometion.pojo.Analysis;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnalysisServiceImpl implements AnalysisService {

    private AnalysisMapper analysisMapper;

    @Override
    public List<Analysis> list() {
        return analysisMapper.list();
    }

    @Override
    public int save(Analysis analysis) {
        return analysisMapper.save(analysis);
    }

    @Override
    public int update(Analysis analysis) {
        return analysisMapper.update(analysis);
    }

    @Override
    public Analysis getById(int id) {
        return analysisMapper.getById(id);
    }

    @Override
    public int remove(int id) {
        return analysisMapper.remove(id);
    }
}
