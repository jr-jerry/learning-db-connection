package com.Ducat.learning_db_connection.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "aadhar_tb")
@Setter
@Getter
public class AadharEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty
    private String completeName;
    @NotNull
    private Integer aadharId;

    public static AadharEntity getAadharEntity(String completeName,Integer aadharId){
         AadharEntity aadharEntity=new AadharEntity();
         aadharEntity.setAadharId(aadharId);
         aadharEntity.setCompleteName(completeName);
         return aadharEntity;
    }
}
