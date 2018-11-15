package com.daoming.web.service;

import com.daoming.web.domain.LearnResource;
import com.daoming.web.tools.Page;

import java.util.List;
import java.util.Map;

public interface LearnService {
    int add(LearnResource learnResouce);

    int update(LearnResource learnResouce);

    int deleteByIds(String ids);

    LearnResource queryLearnResouceById(Long learnResouce);

    Page queryLearnResouceList(Map<String, Object> params);

    List<LearnResource> queryLearnResouceListByMybatis(Map<String, Object> params);
}
