package com.Ducat.learning_db_connection.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter 
@Setter 
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column (
        unique = true,name = "user_name"
    )
    private String userName;
    private Long userAge;

    private String add;
    private Boolean isDeleted;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id",name = "aadhar_id")
    private AadharEntity aadharEntity;

}
// select * from table where userAge=? AND isDeleted=false;
// findById(id) ;
//findByUserName(name);
//findByUserAge(age);
//findByUserAgeAndUserName(age,name);
// isDeleted false , userAge>20
// findByUserAgeGreaterThanAndIsDeletedFalse(age);