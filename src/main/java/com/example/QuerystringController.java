package com.example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by danielbutts on 2/17/17.
 */


@RestController
public class QuerystringController {

    @GetMapping("/tasks")
    public String getIndividualParams(@RequestParam(value = "filter", required = false) String filter) {
        return String.format("Filter is: %s", filter);
    }

    @GetMapping("/tasks_to_map")
    public String getMapOfParams(@RequestParam Map querystring) {
        return querystring.toString();
    }

    @GetMapping("/tasks_to_obj")
    public String getObjectFromParams(Tasks tasks) {
        return String.format("sort-by is %s; owner is %s", tasks.getSortBy(), tasks.getOwner());
    }

    public static class Tasks {
        private String owner;
        private String sortBy;

        public Tasks () {
        }

        public Tasks (String owner, String sortBy) {
            this.owner = owner;
            this.sortBy = sortBy;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getSortBy() {
            return sortBy;
        }

        public void setSortBy(String sortBy) {
            this.sortBy = sortBy;
        }
    }
}