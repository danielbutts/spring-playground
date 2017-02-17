package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by danielbutts on 2/17/17.
 */

@RestController
@RequestMapping("/app")
public class EndpointsController {

    @GetMapping("/date")
    public String todaysDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    }

    @PostMapping("/posted")
    public String thingPosted() {
        return "You just posted something";
    }
}
