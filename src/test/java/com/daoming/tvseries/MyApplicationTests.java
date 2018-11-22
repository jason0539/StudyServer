package com.daoming.tvseries;

import com.daoming.tvseries.controller.TvSeriesController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTests {
    private MockMvc tvSeriesControllerMvc;

    @Before
    public void setup() {
        tvSeriesControllerMvc = MockMvcBuilders.standaloneSetup(new TvSeriesController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        tvSeriesControllerMvc.perform(MockMvcRequestBuilders.get("/tvseries").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
