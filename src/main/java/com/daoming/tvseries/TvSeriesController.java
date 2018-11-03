package com.daoming.tvseries;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {
    private static final Log log = LogFactory.getLog(TvSeriesController.class);

//    @GetMapping
//    public Map<String, Object> sayHello() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("message", "hello,world");
//        return map;
//    }

    @GetMapping
    public List<TvSeriesDto> getAll() {
        List<TvSeriesDto> list = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        list.add(new TvSeriesDto(1, "WestWorld", 1, calendar.getTime()));
        calendar.set(2011, Calendar.SEPTEMBER, 22, 0, 0);
        list.add(new TvSeriesDto(2, "WestWorld", 1, calendar.getTime()));
        if (log.isDebugEnabled()) {
            log.debug("TvSeriesController.getAll被调用了");
        }
        return list;
    }
}
