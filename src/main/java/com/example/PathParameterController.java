package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by danielbutts on 2/18/17.
 */

@RestController()
@RequestMapping("/activity/{activity}/duration")
public class PathParameterController {

    @GetMapping("/{duration}")
    public String getIndividualParams(@PathVariable String activity, @PathVariable String duration) {
        return String.format("activity:%s duration:%s", activity, duration);
    }

    @GetMapping("/map/{duration}")
    public String getParametersAsMap(@PathVariable Map pathVariables) {
        return pathVariables.toString(); // {task=?, comment=?}
    }

    @GetMapping("/obj/{duration}")
    public String getParametersAsObject(PathParams params) {
        return String.format("activity:%s duration:%s", params.getActivity(), params.getDuration());
    }

    public static class PathParams {
        private String activity;
        private String duration;

        public PathParams() {
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }
}

