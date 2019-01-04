package com.daoming.web.login.service;

import com.daoming.web.login.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> getUserList();

    UserInfo findByUsername(String username);

    void save(UserInfo userInfo);

    void edit(UserInfo userInfo);

    void deleteByUsername(String username);
}
