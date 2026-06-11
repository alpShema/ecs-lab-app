package com.ecslab;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LabController {

    // Serves the main HTML page at /
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    // Simple JSON health endpoint (ALB also uses /actuator/health)
    @GetMapping("/health")
    @ResponseBody
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of(
            "status", "UP",
            "service", "ecs-lab-app"
        ));
    }
}
