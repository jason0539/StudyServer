package com.daoming.tvseries;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

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

    //curl http://127.0.0.1:8080/tvseries/
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

    //curl http://127.0.0.1:8080/tvseries/101
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


    //curl -H "Content-Type:application/json" -X POST --data '{"name":"西部世界","seasonCount":1,"originalRelease":"2016-10-2"}' http://127.0.0.1:8080/tvseries
    @PostMapping
    public TvSeriesDto insertOne(@RequestBody TvSeriesDto tvSeriesDto) {
        if (log.isDebugEnabled()) {
            log.debug("insertOne " + tvSeriesDto + "，这里应该写插入到数据库的代码");
        }
        tvSeriesDto.setId(9999);
        return tvSeriesDto;
    }

    @PutMapping("/{id}")
    public TvSeriesDto updateOne(@PathVariable int id, @RequestBody TvSeriesDto tvSeriesDto) {
        if (log.isDebugEnabled()) {
            log.debug("updateOne " + id + ",这里应该写更新到数据库的代码");
        }
        if (id == 101 || id == 102) {
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
