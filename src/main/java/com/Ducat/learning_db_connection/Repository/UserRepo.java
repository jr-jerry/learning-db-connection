package com.Ducat.learning_db_connection.Repository;

import com.Ducat.learning_db_connection.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
    