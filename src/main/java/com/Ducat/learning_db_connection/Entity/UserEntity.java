package com.Ducat.learning_db_connection.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

/**
 * @Entity annotation-->I want to represnt this class in table representation
 */
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "trainer_id",referencedColumnName = "id")
    private TrainerEntity trainerEntity;

}
// select * from table where userAge=? AND isDeleted=false;
// findById(id) ;
//findByUserName(name);
//findByUserAge(age);
//findByUserAgeAndUserName(age,name);
// isDeleted false , userAge>20
// findByUserAgeGreaterThanAndIsDeletedFalse(age);