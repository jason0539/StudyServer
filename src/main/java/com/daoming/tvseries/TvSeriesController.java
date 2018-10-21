package com.daoming.tvseries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

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
        return list;
    }
}
