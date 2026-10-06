package com.Ducat.learning_db_connection.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ducat.learning_db_connection.Entity.TrainerEntity;

public interface TrainerRepo extends JpaRepository<TrainerEntity,Long>{
    Optional<TrainerEntity> findByName(String trainerName);
}
