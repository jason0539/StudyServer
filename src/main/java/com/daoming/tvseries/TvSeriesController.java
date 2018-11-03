package com.daoming.tvseries;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        if (log.isDebugEnabled()) {
            log.debug("TvSeriesController.getAll被调用了");
        }
        List<TvSeriesDto> list = new ArrayList<>();
        list.add(createPoi());
        list.add(createWestWorld());
        return list;
    }

    @GetMapping("/{id}")
    public TvSeriesDto getOne(@PathVariable int id) {
        if (log.isDebugEnabled()) {
            log.debug("getOne " + id);
        }
        if (id == 101) {
            return createPoi();
        } else if (id == 102) {
            return createWestWorld();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    private TvSeriesDto createPoi() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        return new TvSeriesDto(101, "Person of interest", 1, calendar.getTime());
    }

    private TvSeriesDto createWestWorld() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.OCTOBER, 2, 0, 0);
        return new TvSeriesDto(102, "WestWorld", 1, calendar.getTime());
    }
}
