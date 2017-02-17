package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by danielbutts on 2/17/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(EndpointsController.class)
public class EndpointsControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testEndpoints() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/app/date");

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

    @Test
    public void testPostEndpoint() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/app/posted");

        this.mvc.perform(request)
                .andExpect(status().isOk());
    }

}
