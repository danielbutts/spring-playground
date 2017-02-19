package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Created by danielbutts on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataPostController.class)
public class FormDataPostControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPostingFormData() throws Exception {
        String comment = "This is some test content.";
        String author = "Daniel Butts";

        MockHttpServletRequestBuilder postRequest = post("/comment")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", comment)
                .param("author", author);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("%s said %s!", author,comment)));
    }

    @Test
    public void testPostingFormDataMap() throws Exception {
        String comment = "This is some test content.";
        String author = "Daniel Butts";

        MockHttpServletRequestBuilder postRequest = post("/map")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", comment)
                .param("author", author);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{comment=%s, author=%s}",comment , author)));
    }

    @Test
    public void testPostingFormDataObj() throws Exception {
        String comment = "This is some test content.";
        String author = "Daniel Butts";

        MockHttpServletRequestBuilder postRequest = post("/obj")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", comment)
                .param("author", author);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("%s said %s!", author,comment)));
    }

    @Test
    public void testPostingFormDataString() throws Exception {
        String comment = "This is some test content.";
        String author = "Daniel Butts";

        MockHttpServletRequestBuilder postRequest = post("/string")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("comment", comment)
                .param("author", author);

        this.mvc.perform(postRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("comment=This+is+some+test+content.&author=Daniel+Butts"));
    }

}
