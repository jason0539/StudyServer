package com.daoming.web.login.controller;

import com.daoming.utils.LogUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    /**
     * 用户查询.
     *
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo() {
        LogUtils.d("userInfo");
        return "userInfo";
    }

    /**
     * 用户添加;
     *
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd() {
        LogUtils.d("userInfoAdd");
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     *
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel() {
        LogUtils.d("userDel");
        return "userInfoDel";
    }

}
