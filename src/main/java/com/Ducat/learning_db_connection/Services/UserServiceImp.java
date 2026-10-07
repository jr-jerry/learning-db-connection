package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.DTO.UserReqDTO;
import com.Ducat.learning_db_connection.DTO.UserResDTO;
import com.Ducat.learning_db_connection.Entity.TrainerEntity;
import com.Ducat.learning_db_connection.Entity.UserEntity;
import com.Ducat.learning_db_connection.Exception.InValidAgeException;
import com.Ducat.learning_db_connection.Repository.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements  UserService {
    public UserServiceImp(UserRepo userRepo, TrainerService trainerService) {
        this.userRepo = userRepo;
        this.trainerService = trainerService;
    }

    private final UserRepo userRepo;
    private final TrainerService trainerService;


    @Override 
    public void deleteUser(Long userId){
        Optional<UserEntity> boxOptional=userRepo.findById(userId);
        if(boxOptional.isEmpty()){

        }
        UserEntity oldEntity=boxOptional.get();
        oldEntity.setIsDeleted(true);
 
        userRepo.save(oldEntity); 
    }
    @Override
    public UserResDTO saveUserEntity(UserReqDTO userReqDTO) {

        UserEntity userEntity=new UserEntity();
        if(userReqDTO.getUserAge()<0){
            throw new InValidAgeException("invalid age hai ");
        }
        userEntity.setUserAge( userReqDTO.getUserAge());
        userEntity.setUserName(userReqDTO.getUserName());
        userEntity.setIsDeleted(false);
        TrainerEntity trainerEntity;
        try{
             trainerEntity=trainerService.findByName(userReqDTO.getTrainerEntity().getName());
        }catch(RuntimeException e){
            trainerEntity=new TrainerEntity();
            trainerEntity.setName(userReqDTO.getTrainerEntity().getName());
            trainerEntity.setTechnology(userReqDTO.getTrainerEntity().getTechnology());
        }



        userEntity.setTrainerEntity(trainerEntity);
     

       UserEntity savedUserEntity= userRepo.save(userEntity);

      return  UserResDTO.builder()
                .userAge(savedUserEntity.getUserAge())
                .userName(savedUserEntity.getUserName())
              .trainerEntity(savedUserEntity.getTrainerEntity())
                .build();
    }

    @Override
    public UserEntity updateUser(UserReqDTO userReqDTO) {
        String oldUsername=userReqDTO.getUserName();
        Long newAge= userReqDTO.getUserAge();

        Optional<UserEntity> boxOptional=userRepo.findByUserName(oldUsername);

        if(boxOptional.isEmpty()){
            return null;
        }
        UserEntity oldEntity=boxOptional.get();

        oldEntity.setUserAge(newAge);
        oldEntity.setUserName(oldUsername);
        
        UserEntity updatedEntity=userRepo.save(oldEntity);
        return updatedEntity;       
    }

    public List<UserResDTO> getAllUser(){
        List<UserResDTO> emptyDtoList=new ArrayList<>();
        List<UserEntity> savedUserList=userRepo.findAll();

        for(UserEntity user:savedUserList){
            if(user.getIsDeleted()==false){
                 UserResDTO userResDTO=UserResDTO.builder()
                                            .userName(user.getUserName())
                                            .userAge(user.getUserAge())
                         .trainerEntity(user.getTrainerEntity())
                                            .build();
                emptyDtoList.add(userResDTO);
            }
        }
        return emptyDtoList;
    }
}
