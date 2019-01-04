package com.daoming.web.login.controller;

import com.daoming.utils.LogUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    //http://localhost:8080/login
    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        LogUtils.d("LoginController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        LogUtils.d("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                LogUtils.d("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                LogUtils.d("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                LogUtils.d("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                LogUtils.d("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "user/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        LogUtils.d("------没有权限-------");
        return "403";
    }

//    //处理登录请求
//    //curl -H "Content-Type:application/json" -X POST http://127.0.0.1:8080/handleLogin?userName=name&password=password
//    @RequestMapping(value = "/handleLogin", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
//        Map<String, Object> map = new HashMap<>();
//        //getParameter获取到参数是路径中携带的
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//
//        if (log.isDebugEnabled()) {
//            log.debug("userName:" + userName + ",password:" + password);
//        }
//
//        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
//            UserInfo user = new UserInfo(userName, password);
//            request.getSession().setAttribute("user", user);
//            map.put("result", "1");
//        } else {
//            map.put("result", "0");
//        }
//        return map;
//    }
}
