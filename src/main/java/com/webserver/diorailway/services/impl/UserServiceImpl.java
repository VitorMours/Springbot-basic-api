package com.webserver.diorailway.services.impl;

import com.webserver.diorailway.domain.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.webserver.diorailway.domain.repositories.UserRepository;
import com.webserver.diorailway.services.UserService;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
    }

    @Override
    public UserModel create(UserModel newUser) {
        if(userRepository.existsByEmail(newUser.getEmail())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with this email already exists");
        }
        return userRepository.save(newUser);
    }

    @Override
    public UserModel update(Long id, UserModel newUser) {
        try {
            return userRepository.findById(id).map(user -> {
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                user.setPhone(newUser.getPhone());
                user.setPassword(newUser.getPassword());

                return userRepository.save(user);  // O Hibernate lida com o controle de versão
            }).orElseThrow(() -> new NoSuchElementException("User not found"));
        } catch (org.hibernate.StaleObjectStateException ex) {
            throw new ConcurrencyFailureException("A conflict occurred while updating the user. Please try again.");
        }
    }

    @Override
    public void delete(Long id){
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
