package com.Ducat.learning_db_connection.Config.Beans;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeans {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
