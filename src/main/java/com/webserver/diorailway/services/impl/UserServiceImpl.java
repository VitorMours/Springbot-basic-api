package com.webserver.diorailway.services.impl;


import com.webserver.diorailway.domain.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webserver.diorailway.domain.repositories.UserRepository;
import com.webserver.diorailway.services.UserService;
import com.webserver.diorailway.domain.models.UserModel;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl  implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public UserModel create(UserModel newUser) {
        if(userRepository.existsByEmail(newUser.getEmail())){
            throw new IllegalArgumentException("This user already exists");
        }

        return this.userRepository.save(newUser);
    }
}
