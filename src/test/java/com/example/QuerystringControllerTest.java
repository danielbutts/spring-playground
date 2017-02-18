package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by danielbutts on 2/17/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(QuerystringController.class)
public class QuerystringControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testGetSingleParameter() throws Exception {
        this.mvc.perform(get("/tasks?filter=completed"))
                .andExpect(status().isOk())
                .andExpect(content().string("Filter is: completed"));
    }

    @Test
    public void testGetMapOfParameters() throws Exception {
        this.mvc.perform(get("/tasks_to_map?filter=completed&owner=Chloe"))
                .andExpect(status().isOk())
                .andExpect(content().string("{filter=completed, owner=Chloe}"));
    }

    @Test
    public void testGetParameterObject() throws Exception {
        this.mvc.perform(get("/tasks_to_map?sortBy=date&owner=Chloe"))
                .andExpect(status().isOk())
                .andExpect(content().string("{sortBy=date, owner=Chloe}"));
    }
}

