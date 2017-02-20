package com.example;

/**
 * Created by danielbutts on 2/19/17.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JSONResponseController {

    @GetMapping("/simple-object")
    public Person getPerson() {
        Person dwayne = new Person();
        dwayne.setFirstName("Dwayne");
        dwayne.setLastName("Johnson");
        return dwayne;
    }

    @GetMapping("/array")
    public Person[] getPeople() {
        Person dwayne = new Person();
        dwayne.setFirstName("Dwayne");
        dwayne.setLastName("Johnson");
        Person john = new Person();
        john.setFirstName("John");
        john.setLastName("Cena");
        Person[] people = new Person[] {
                dwayne,john
        };
        return people;
    }

    static class Person {
        private String firstName;
        private String lastName;

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
    }
}