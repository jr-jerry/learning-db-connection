package com.Ducat.learning_db_connection.Controller;

import com.Ducat.learning_db_connection.DTO.UserReqDTO;
import com.Ducat.learning_db_connection.DTO.UserResDTO;
import com.Ducat.learning_db_connection.Entity.UserEntity;
import com.Ducat.learning_db_connection.Services.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
        
    @PutMapping("/update")
    public ResponseEntity<?> updateEndpoint(@RequestBody UserReqDTO userReqDTO){
       UserEntity updatedUserEntity= userService.updateUser(userReqDTO);

       return ResponseEntity.accepted().body(updatedUserEntity);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpEndpoint(@RequestBody UserReqDTO userReqDTO){
        System.out.println("Data Receive in controller layer "+userReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUserEntity(userReqDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResDTO>> getMethodName() {
        List<UserEntity> savedUserList= userService.getAllUser();
        List<UserResDTO> emptyDtoList=new ArrayList<>();

        for(UserEntity user:savedUserList){
            UserResDTO userResDTO=UserResDTO.builder()
                                            .userName(user.getUserName())
                                            .userAge(user.getUserAge())
                                            .isSoftDeleted(false)
                                            .build();
            emptyDtoList.add(userResDTO);
        }
        return ResponseEntity.ok(emptyDtoList);
    }
}
