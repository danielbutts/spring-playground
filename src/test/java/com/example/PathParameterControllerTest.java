package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by danielbutts on 2/18/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(PathParameterController.class)
public class PathParameterControllerTest {


    @Autowired
    MockMvc mvc;

    @Test
    public void testGetPathParameter() throws Exception {
        int activity = 4;
        int duration = 19;

        this.mvc.perform(get(String.format("/activity/%s/duration/%s", activity, duration)))
                .andExpect(status().isOk())
                .andExpect(content().string("activity:4 duration:19"));
    }

    @Test
    public void testGetParametersMap() throws Exception {
        int activity = 4;
        int duration = 19;

        this.mvc.perform(get(String.format("/activity/%s/duration/map/%s", activity, duration)))
                .andExpect(status().isOk())
                .andExpect(content().string("{activity=4, duration=19}"));
    }

    @Test
    public void testGetParametersObject() throws Exception {
        int activity = 4;
        int duration = 19;

        this.mvc.perform(get(String.format("/activity/%s/duration/obj/%s", activity, duration)))
                .andExpect(status().isOk())
                .andExpect(content().string("activity:4 duration:19"));
    }
}
