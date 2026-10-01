package com.Ducat.learning_db_connection.DTO;

 import com.Ducat.learning_db_connection.Entity.AadharEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@Builder 
@NoArgsConstructor
@AllArgsConstructor  
public class UserReqDTO {
    @NotEmpty(message = "name cann't be null or empty")
    @Size(min = 4,max = 10,message = "Name should be atleast 4 character and atmost 10 character")
    private String userName;

    @NotNull(message = "age cann't be empty")
    @Min(value = 10,message = "age should be above 10 ")
    private Long userAge;

    private String add;
    private AadharEntity aadharEntity;
}
