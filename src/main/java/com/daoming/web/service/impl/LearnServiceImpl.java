package com.daoming.web.service.impl;

import com.daoming.utils.LogUtils;
import com.daoming.web.dao.LearnDao;
import com.daoming.web.dao.LearnMapper;
import com.daoming.web.domain.LearnResource;
import com.daoming.web.service.LearnService;
import com.daoming.web.tools.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LearnServiceImpl implements LearnService {

    @Autowired
    LearnDao learnDao;

    @Autowired
    LearnMapper learnMapper;

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

    @Override
    public List<LearnResource> queryLearnResouceListByMybatis(Map<String, Object> params) {
        LogUtils.d("mapper");
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.learnMapper.queryLearnResourceList(params);
    }
}
