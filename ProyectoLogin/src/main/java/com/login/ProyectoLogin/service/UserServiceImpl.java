package com.login.ProyectoLogin.service;

import com.login.ProyectoLogin.models.UserEntity;
import com.login.ProyectoLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity find(UserEntity userEntity) {
        return userRepository.findById(userEntity.getId()).orElse(null);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }

    @Override
    public boolean authenticate(UserEntity userEntity) {
        for (UserEntity user: this.findAll()) {
            if (user.getUsername().equals(userEntity.getUsername())) {
                if (user.getPassword().equals(userEntity.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }
}
