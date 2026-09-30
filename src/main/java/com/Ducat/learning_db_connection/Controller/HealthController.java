package com.Ducat.learning_db_connection.Controller;

import com.Ducat.learning_db_connection.Exception.DuplicateUserException;
import com.Ducat.learning_db_connection.Exception.InValidAgeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthController {
    @GetMapping
    public Map<String,String> endpoin() {
        throw new InValidAgeException("invalid age hai ");
//        return Map.of("message","project working");
    }
}
