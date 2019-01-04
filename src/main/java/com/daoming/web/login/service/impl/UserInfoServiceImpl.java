package com.daoming.web.login.service.impl;

import com.daoming.web.login.dao.UserInfoDao;
import com.daoming.web.login.entity.UserInfo;
import com.daoming.web.login.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    public List<UserInfo> getUserList() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }

    @Override
    public void deleteByUsername(String username) {
        userInfoDao.deleteByUsername(username);
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }

    @Override
    public void edit(UserInfo userInfo) {
        userInfoDao.save(userInfo);
    }
}
