package com.Ducat.learning_db_connection.Services;

import com.Ducat.learning_db_connection.DTO.AadharReqDTO;
import com.Ducat.learning_db_connection.Entity.AadharEntity;

public interface AadharService {
    AadharEntity save(AadharReqDTO aadharReqDTO);
    AadharEntity findByName(String aadharCompleteName);
}
