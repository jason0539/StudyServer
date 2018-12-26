package com.daoming.web.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.daoming.web.learn.domain.LearnResource;
import com.daoming.web.learn.service.LearnService;
import com.daoming.web.tools.Page;
import com.daoming.web.tools.ServletUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://github.com/tengj/SpringBootDemo/blob/master/chapter4/src/main/java/com/dudu/controller/LearnResourceController.java
 */
@Controller
@RequestMapping("/learn")
public class LearnController {
    private static final Log log = LogFactory.getLog(LearnController.class);

    @Autowired
    LearnService learnService;

    ////http://localhost:8080/learn/
    @RequestMapping()
    public ModelAndView allBlogs() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("rows", 100);
        Page pageObj = learnService.queryLearnResouceList(params);
        List<Map<String, Object>> learnList = pageObj.getResultList();
        ModelAndView modelAndView = new ModelAndView("/indexPage");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    //http://localhost:8080/learn/react
    @RequestMapping("/react")
    public ModelAndView officialBlog() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", 1);
        params.put("rows", 100);
        List<LearnResource> learnList = learnService.queryLearnResouceListByMybatis(params);
        ModelAndView modelAndView = new ModelAndView("/indexPageByReact");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    //    curl -H "Content-Type:application/json" -X POST http://127.0.0.1:8080/learn/queryLeanList?page=1&rows=5
    @RequestMapping(value = "/queryLeanList", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void queryLearnList(HttpServletRequest request, HttpServletResponse response) {
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("author", author);
        params.put("title", title);
        Page pageObj = learnService.queryLearnResouceList(params);
        List<Map<String, Object>> learnList = pageObj.getResultList();
        JSONObject jo = new JSONObject();
        jo.put("rows", learnList);
        jo.put("total", pageObj.getTotalPages());
        jo.put("records", pageObj.getTotalRows());
        ServletUtil.createSuccessResponse(200, jo, response);
    }
}
