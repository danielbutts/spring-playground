package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static com.example.JSONRequestController.Person;
import static com.example.JSONRequestController.Pet;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by danielbutts on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(JSONRequestController.class)
public class JSONRequestControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void testObjectParams() throws Exception {

        MockHttpServletRequestBuilder request = post("/jr/example")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"q\": \"something\", \"from\": \"2008\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"q\":\"something\",\"from\":\"2008\"}"));

    }


    @Test
    public void testCreateJSONObject() throws Exception {
        JsonObject person = new JsonObject();
        person.addProperty("firstName", "Daniel");
        person.addProperty("lastName", "Butts");
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(person);

        MockHttpServletRequestBuilder request = post("/jr/gson-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"firstName\":\"Daniel\",\"lastName\":\"Butts\",\"age\":0}"));

    }

    @Test
    public void testSerializedJSONObject() throws Exception {
        Person person = new Person();
        person.setAge(38);
        person.setFirstName("Daniel");
        person.setLastName("Butts");
        person.setHappy(true);
        Person brother = new Person();
        brother.setAge(40);
        brother.setFirstName("David");
        brother.setLastName("Butts");
        brother.setHappy(true);
        ArrayList<Person> siblings = new ArrayList<>();
        siblings.add(brother);
        person.setSiblings(siblings);
        ArrayList<Pet> pets = new ArrayList<>();
        Pet cherry = new Pet();
        cherry.setName("Cherry");
        cherry.setType("French Bulldog");
        Pet tank = new Pet();
        tank.setName("Tank");
        tank.setType("French Bulldog");
        pets.add(cherry);
        pets.add(tank);
        person.setPets(pets);


        Gson gson = new GsonBuilder().create();
        String jsonString = gson.toJson(person);

        MockHttpServletRequestBuilder request = post("/jr/gson-obj-post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"firstName\":\"Daniel\",\"lastName\":\"Butts\",\"siblings\"" +
                        ":[{\"firstName\":\"David\",\"lastName\":\"Butts\",\"age\":40}],\"pets\":[{\"name\":\"Cherry\"," +
                        "\"type\":\"French Bulldog\"},{\"name\":\"Tank\",\"type\":\"French Bulldog\"}],\"age\":38}"));
    }

    @Test
    public void testRawBody() throws Exception {
        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/jr/json-file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"q\":\"something\",\"from\":\"2008\"}"));

    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }


}
