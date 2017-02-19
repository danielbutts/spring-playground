package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by danielbutts on 2/19/17.
 */

@RestController
@RequestMapping("/jr")
public class JSONRequestController {

    @PostMapping("/example")
    public String postJSONString(@RequestBody SearchParams params) {
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(params);
        return jsonString;
    }

    @PostMapping("/gson-post")
    public String postJSONObjString(@RequestBody Person person) {
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(person);
        return jsonString;
    }

    @PostMapping("/gson-obj-post")
    public String postJSONCustObjString(@RequestBody Person person) {
//        System.out.println("Happiness: "+person.isHappy());
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(person);
        return jsonString;
    }

    @PostMapping("/json-file")
    public String postJSONObjString(@RequestBody SearchParams params) {
        Gson builder = new GsonBuilder().create();
        String jsonString = builder.toJson(params);
        return jsonString;
    }

    static class SearchParams {
        private String q;
        private String from;

        public SearchParams() {
        }

        public SearchParams(String q, String from) {
            this.q = q;
            this.from = from;
        }

        public String getQ() {
            return q;
        }

        public void setQ(String q) {
            this.q = q;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    static class Person {
        private String firstName;
        private String lastName;
        private ArrayList<Person> siblings;
        private ArrayList<Pet> pets;
        private int age;
        private Boolean isHappy;

        public Person() {
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public ArrayList<Person> getSiblings() {
            return siblings;
        }

        public void setSiblings(ArrayList<Person> siblings) {
            this.siblings = siblings;
        }

        public ArrayList<Pet> getPets() {
            return pets;
        }

        public void setPets(ArrayList<Pet> pets) {
            this.pets = pets;
        }

        public Boolean getHappy() {
            return isHappy;
        }

        public void setHappy(Boolean happy) {
            isHappy = happy;
        }
    }

    static class Pet {
        private String name;
        private String type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


}
