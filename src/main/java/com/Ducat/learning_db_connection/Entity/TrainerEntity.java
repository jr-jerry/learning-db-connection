package com.Ducat.learning_db_connection.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity 
@Table (name="trainer_tb")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor
@JsonIgnoreProperties(value = {"id"},ignoreUnknown = true)
public class TrainerEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnoreProperties
    private Long id;
    private String name;
    private String technology;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "trainer")
    private List<UserEntity> userEntityList;
}
