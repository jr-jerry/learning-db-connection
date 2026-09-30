package com.Ducat.learning_db_connection.Controller;

import com.Ducat.learning_db_connection.DTO.UserReqDTO;
import com.Ducat.learning_db_connection.DTO.UserResDTO;
import com.Ducat.learning_db_connection.Entity.UserEntity;
import com.Ducat.learning_db_connection.Exception.InValidAgeException;
import com.Ducat.learning_db_connection.Services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler(value=InValidAgeException.class)
    public ResponseEntity<?> handleInvalidAgeException(InValidAgeException e){
        ResponseEntity<Map<String,String>> response=new ResponseEntity<>(Map.of("message","invalid age"),HttpStatus.BAD_REQUEST);
        return response;
    }
    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteEndpoint(@RequestParam  Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateEndpoint(@Valid @RequestBody UserReqDTO userReqDTO){
       UserEntity updatedUserEntity= userService.updateUser(userReqDTO);

       return ResponseEntity.accepted().body(updatedUserEntity);
    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpEndpoint(@Valid  @RequestBody  UserReqDTO userReqDTO){
        System.out.println("Data Receive in controller layer "+userReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUserEntity(userReqDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResDTO>> getMethodName() {
        List<UserResDTO> emptyDtoList= userService.getAllUser();
        
        return ResponseEntity.ok(emptyDtoList);
    }
}
