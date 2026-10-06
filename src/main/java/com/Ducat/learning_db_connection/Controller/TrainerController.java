package com.Ducat.learning_db_connection.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ducat.learning_db_connection.Entity.TrainerEntity;
import com.Ducat.learning_db_connection.Services.TrainerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/trainer")
public class TrainerController {
    
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    @PostMapping("/create")
    public TrainerEntity postMethodName(@RequestBody TrainerEntity trainerEntity) {
        return trainerService.save(trainerEntity);
    }
}
