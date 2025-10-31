package dev.alefiengo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello from Spring Boot API!");
    }

    @GetMapping("/api/info")
    public ResponseEntity<Map<String, Object>> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("alumno", "JUAN CARLOS ALANOCA"); 
        info.put("version", "v2.1");
        info.put("curso", "Docker & Kubernetes - i-Quattro");
        info.put("timestamp", LocalDateTime.now().toString());
        info.put("hostname", System.getenv("HOSTNAME"));
        return ResponseEntity.ok(info);
    }
}
