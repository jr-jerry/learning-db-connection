package com.Ducat.learning_db_connection.Controller;

import com.Ducat.learning_db_connection.DTO.AadharReqDTO;
import com.Ducat.learning_db_connection.Entity.AadharEntity;
import com.Ducat.learning_db_connection.Services.AadharService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aadhar")
public class AadharController {
    public AadharController(AadharService aadharService) {
        this.aadharService = aadharService;
    }

    private final AadharService aadharService;
    @PostMapping("/create")
    public ResponseEntity<?> saveAadhar(@RequestBody AadharReqDTO aadharReqDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(aadharService.save(aadharReqDTO));
    }
}
