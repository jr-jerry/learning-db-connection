package com.Ducat.learning_db_connection.Repository;

import com.Ducat.learning_db_connection.Entity.AadharEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AadharRepo extends JpaRepository<AadharEntity, UUID> {
}
