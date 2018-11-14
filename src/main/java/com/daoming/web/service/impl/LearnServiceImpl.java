package com.daoming.web.service.impl;

import com.daoming.web.dao.LearnDao;
import com.daoming.web.domain.LearnResource;
import com.daoming.web.service.LearnService;
import com.daoming.web.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnDao learnDao;

    @Override
    public int add(LearnResource learnResouce) {
        return learnDao.add(learnResouce);
    }

    @Override
    public int update(LearnResource learnResouce) {
        return learnDao.update(learnResouce);
    }

    @Override
    public int deleteByIds(String ids) {
        return learnDao.deleteById(ids);
    }

    @Override
    public LearnResource queryLearnResouceById(Long id) {
        return learnDao.queryLearnResourceById(id);
    }

    @Override
    public Page queryLearnResouceList(Map<String, Object> params) {
        return learnDao.queryLearnResourceList(params);
    }
}
