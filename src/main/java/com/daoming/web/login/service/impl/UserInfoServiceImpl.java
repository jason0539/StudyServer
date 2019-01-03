package com.daoming.web.login.service.impl;

import com.daoming.web.login.dao.UserInfoDao;
import com.daoming.web.login.entity.UserInfo;
import com.daoming.web.login.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
