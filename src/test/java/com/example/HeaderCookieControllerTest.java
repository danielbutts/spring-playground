package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by danielbutts on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(HeaderCookieController.class)
public class HeaderCookieControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCookieValue() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/cookie");

        this.mvc.perform(get("/cookie").cookie(new Cookie("foo", "bar")))
                .andExpect(status().isOk())
                .andExpect(content().string("bar"));
    }

    @Test
    public void testHeaderValue() throws Exception {
        this.mvc.perform(get("/header")
                .header("Host", "example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("example.com"));
    }
}
