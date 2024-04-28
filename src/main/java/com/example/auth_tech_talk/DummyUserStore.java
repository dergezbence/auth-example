package com.example.auth_tech_talk;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DummyUserStore {

    private final PasswordEncoder passwordEncoder;

    private Map<String, List<String>> userStore;


    @PostConstruct
    private void init() {
        // initialize some test users
        userStore = Map.of(
                "username", List.of("username", passwordEncoder.encode("password"), "ROLE_USER"),
                "admin", List.of("admin", passwordEncoder.encode("password"), "ADMIN")
        );
    }

    public List<String> getUserData(String username) {
        return userStore.get(username);
    }
}
