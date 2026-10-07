package com.Ducat.learning_db_connection.DTO;

import com.Ducat.learning_db_connection.Entity.TrainerEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder 
public class UserResDTO {
    private String userName;
    private Long userAge;
    private TrainerEntity trainerEntity;
}
