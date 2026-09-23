package com.Ducat.learning_db_connection.Services;

import java.util.List;

import com.Ducat.learning_db_connection.DTO.UserReqDTO;
import com.Ducat.learning_db_connection.DTO.UserResDTO;
import com.Ducat.learning_db_connection.Entity.UserEntity;

public interface UserService {

    UserResDTO saveUserEntity(UserReqDTO userReqDTO);

    List<UserEntity> getAllUser();

    UserEntity updateUser(UserReqDTO userReqDTO);

}
