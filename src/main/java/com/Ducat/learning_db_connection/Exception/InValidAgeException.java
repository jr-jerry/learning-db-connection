package com.Ducat.learning_db_connection.Exception;

public class InValidAgeException extends RuntimeException{
    public InValidAgeException(String message){
        super(message);
    }
    public InValidAgeException(){
        super();
    }
}
