package com.example.auth_tech_talk;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ExampleController {
    @GetMapping("/public")
    public String publicSite() {
        return "public";
    }

    @PostMapping("/public")
    public String receiveFormData(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("Some data received");
        return "public";
    }

    @GetMapping("/protected")
    public String protectedSite() {
        return "protected";
    }
}
