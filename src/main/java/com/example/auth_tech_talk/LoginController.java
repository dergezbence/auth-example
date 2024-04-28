package com.example.auth_tech_talk;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/api/login")
    public String createResource(@RequestBody LoginRequest loginRequest) {

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());


        authentication = authenticationManager.authenticate(authentication);

        User user = (User) authentication.getPrincipal();

        return jwtService.generateJwt(user);
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }

}
