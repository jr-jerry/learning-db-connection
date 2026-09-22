package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.DTO.UserReqDTO;
import com.Ducat.learning_db_connection.DTO.UserResDTO;
import com.Ducat.learning_db_connection.Entity.UserEntity;
import com.Ducat.learning_db_connection.Repository.UserRepo;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements  UserService {
    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public UserResDTO saveUserEntity(UserReqDTO userReqDTO) {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserAge(userReqDTO.getUserAge());
        userEntity.setUserName(userReqDTO.getUserName());
     //business logic implement
        // UserEntity userEntity=UserEntity.builder()
        //         .userAge(userReqDTO.getUserAge())
        //         .userName(userReqDTO.getUserName())
        //         .build();

       UserEntity savedUserEntity= userRepo.save(userEntity);

      return  UserResDTO.builder()
                .userAge(savedUserEntity.getUserAge())
                .userName(savedUserEntity.getUserName())
                .build();
    }

    public List<UserEntity> getAllUser(){
       return userRepo.findAll();
    }
}
