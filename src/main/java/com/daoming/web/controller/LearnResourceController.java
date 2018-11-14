package com.daoming.web.controller;

import com.daoming.tvseries.controller.TvSeriesController;
import com.daoming.web.domain.LearnResource;
import com.daoming.web.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.TextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://github.com/tengj/SpringBootDemo/blob/master/chapter4/src/main/java/com/dudu/controller/LearnResourceController.java
 */
@Controller
@RequestMapping("/")
public class LearnResourceController {
    private static final Log log = LogFactory.getLog(LearnResourceController.class);

    ////http://localhost:8080/learn/
    @RequestMapping("learn")
    public ModelAndView allBlogs() {
        List<LearnResource> learnList = new ArrayList<LearnResource>();
        ModelAndView modelAndView = new ModelAndView("/indexPage");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    //http://localhost:8080/learn/react
    @RequestMapping("/learn/react")
    public ModelAndView officialBlog() {
        List<LearnResource> learnList = new ArrayList<LearnResource>();
        ModelAndView modelAndView = new ModelAndView("/indexPageByReact");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }
}
