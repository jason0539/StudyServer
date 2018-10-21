package com.daoming.tvseries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tvseries")
public class TvSeriesController {

    @GetMapping
    public Map<String, Object> sayHello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello,worldsss");
        return map;
    }
}
