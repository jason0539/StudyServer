package com.daoming.web.login.dao;

import com.daoming.web.login.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);

    @Modifying
    @Transactional
    Long deleteByUsername(String username);
}
