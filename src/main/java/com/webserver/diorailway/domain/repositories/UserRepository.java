package com.webserver.diorailway.domain.repositories;
import com.webserver.diorailway.domain.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserModel, Long>{


    boolean existsByEmail(String email);

}
