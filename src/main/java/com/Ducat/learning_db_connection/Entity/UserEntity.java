package com.Ducat.learning_db_connection.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = {"userId"},ignoreUnknown = true)
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @Column (
        unique = true,name = "user_name"
    )
    private String userName;
    private Long userAge;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id",referencedColumnName = "id")
    @JsonIgnore
    private TrainerEntity trainer;
    private String add;
    private Boolean isDeleted;
}