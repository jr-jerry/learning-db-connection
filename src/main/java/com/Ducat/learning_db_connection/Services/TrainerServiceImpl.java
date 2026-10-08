package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.Entity.UserEntity;
import org.springframework.stereotype.Service;

import com.Ducat.learning_db_connection.Entity.TrainerEntity;
import com.Ducat.learning_db_connection.Repository.TrainerRepo;

import java.util.ArrayList;
import java.util.List;

@Service 
public class TrainerServiceImpl implements  TrainerService{
    private final TrainerRepo trainerRepo;

    public TrainerServiceImpl(TrainerRepo trainerRepo) {
        this.trainerRepo = trainerRepo;
    }

    @Override
    public TrainerEntity save(TrainerEntity trainerEntity) {
        List<UserEntity> users = trainerEntity.getUserEntityList();
         for(UserEntity user : users){
             user.setTrainer(trainerEntity);
         }
        return trainerRepo.save(trainerEntity);
    }

    @Override
    public TrainerEntity findByName(String name) {
        return trainerRepo.findByName(name).orElseThrow(()->new RuntimeException("No Trainer Exist with this name"));
    }
}
