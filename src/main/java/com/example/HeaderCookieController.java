package com.example;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by danielbutts on 2/19/17.
 */

@RestController
public class HeaderCookieController {

    @GetMapping("/cookie")
    public String getCookieValue(@CookieValue(name = "foo") String cookie) {
        return cookie;
    }

    @GetMapping("/header")
    public String getHeaderValue(@RequestHeader String host) {
        return host;
    }

}
