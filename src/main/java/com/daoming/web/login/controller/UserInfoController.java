package com.daoming.web.login.controller;

import com.daoming.utils.LogUtils;
import com.daoming.web.login.entity.UserInfo;
import com.daoming.web.login.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    /**
     * 用户列表页面
     */
    @RequestMapping("/userlist")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfoList(Model model) {
        LogUtils.d("/userList");
        List<UserInfo> userInfos = userInfoService.getUserList();
        model.addAttribute("users", userInfos);
        return "user/list";
    }

    /**
     * 用户添加页面
     */
    @RequestMapping("/userToAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd() {
        LogUtils.d("/userToAdd");
        return "user/userAdd";
    }

    /**
     * 用户添加动作
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String add(UserInfo user) {
        LogUtils.d("/userAdd");
        userInfoService.save(user);
        return "redirect:/userlist";
    }

    /**
     * 用户编辑页面
     */
    @RequestMapping("/userToEdit")
    @RequiresPermissions("userInfo:add")
    public String toEdit(Model model, String username) {
        LogUtils.d("/userToEdit");
        UserInfo userInfo = userInfoService.findByUsername(username);
        model.addAttribute("user", userInfo);
        return "user/userEdit";
    }

    /**
     * 用户编辑动作
     */
    @RequestMapping("/userEdit")
    @RequiresPermissions("userInfo:add")
    public String edit(UserInfo user) {
        LogUtils.d("/userEdit");
        userInfoService.edit(user);
        return "redirect:/userlist";
    }

    /**
     * 用户删除动作
     */

    @RequestMapping("/userDelete")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String delete(String username) {
        LogUtils.d("/userDelete:username is " + username);
        userInfoService.deleteByUsername(username);
        return "redirect:/userlist";
    }

}
