package com.webserver.diorailway.services;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import com.webserver.diorailway.domain.models.UserModel;

@Service
public interface UserService {

    UserModel findById(Long id);
    UserModel create(UserModel newUser);
}

