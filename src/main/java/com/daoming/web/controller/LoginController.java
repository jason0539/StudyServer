package com.daoming.web.controller;

import com.daoming.web.bean.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);

    //http://localhost:8080/login
    @RequestMapping()
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }

    //处理登录请求
    //curl -H "Content-Type:application/json" -X POST http://127.0.0.1:8080/handleLogin?userName=name&password=password
    @RequestMapping(value = "/handleLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        //getParameter获取到参数是路径中携带的
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (log.isDebugEnabled()) {
            log.debug("userName:" + userName + ",password:" + password);
        }

        if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {
            User user = new User(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }
}
