package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.DTO.AadharReqDTO;
import com.Ducat.learning_db_connection.Entity.AadharEntity;
import com.Ducat.learning_db_connection.Repository.AadharRepo;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AadharServiceImpl implements AadharService {


    public AadharServiceImpl(ModelMapper modelMapper, AadharRepo aadharRepo) {
        this.modelMapper = modelMapper;
        this.aadharRepo = aadharRepo;
    }

    private final ModelMapper  modelMapper;
    private final AadharRepo aadharRepo;

    @Override
    public AadharEntity save(AadharReqDTO aadharReqDTO) {
        AadharEntity aadharEntity=this.modelMapper.map(aadharReqDTO,AadharEntity.class);
        return aadharRepo.save(aadharEntity);
    }
}
