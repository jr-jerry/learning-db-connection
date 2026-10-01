package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.DTO.AadharReqDTO;
import com.Ducat.learning_db_connection.Entity.AadharEntity;
import com.Ducat.learning_db_connection.Repository.AadharRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AadharServiceImpl implements AadharService {


    public AadharServiceImpl(ModelMapper modelMapper, AadharRepo aadharRepo) {
        this.modelMapper = modelMapper;
        this.aadharRepo = aadharRepo;
    }

    private final ModelMapper  modelMapper;
    private final AadharRepo aadharRepo;

    @Override
    public AadharEntity save(AadharReqDTO aadharReqDTO) {
        log.info("Code run upto this line : save method of aadharServiceImpl :26");
        AadharEntity aadharEntity=new AadharEntity();
        aadharEntity.setCompleteName(aadharReqDTO.getCompleteName());
        aadharEntity.setAadharId(aadharReqDTO.getAadharId());
        return aadharRepo.save(aadharEntity);
    }
}
