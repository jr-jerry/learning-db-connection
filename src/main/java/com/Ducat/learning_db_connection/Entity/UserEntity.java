package com.Ducat.learning_db_connection.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @Entity annotation-->I want to represnt this class in table representation
 */
@Entity
@Getter 
@Setter 
public class UserEntity {
    /**
     * @Id primary key 
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column (
        unique = true,name = "user_name"
    )
    private String userName;
    private Long userAge;

    private Boolean isDeleted;
}
