package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by danielbutts on 2/19/17.
 */


@RestController()
public class FormDataPostController {

    @PostMapping("/comment")
    public String postFormData(@RequestParam String author, @RequestParam String comment) {
        return String.format("%s said %s!", author,comment);
    }

    @PostMapping("/string")
    public String postRequestBodyAsString(@RequestBody String body) {
        return body;
    }

    @PostMapping("/map")
    public String postRequestBodyAsString(@RequestParam Map<String, String> formData) {
        return formData.toString();
    }

    @PostMapping("/obj")
    public String postRequestBodyAsObject(Body body) {
        return String.format("%s said %s!", body.getAuthor(),body.getComment());
    }

    public static class Body {
        private String author;
        private String comment;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

}
