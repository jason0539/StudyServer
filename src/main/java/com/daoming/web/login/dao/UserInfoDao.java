package com.daoming.web.login.dao;

import com.daoming.web.login.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
