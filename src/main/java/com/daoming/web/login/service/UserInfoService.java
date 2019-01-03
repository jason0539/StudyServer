package com.daoming.web.login.service;

import com.daoming.web.login.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
