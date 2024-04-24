package com.login.ProyectoLogin.service;

import com.login.ProyectoLogin.models.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    UserEntity find(UserEntity userEntity);

    void save(UserEntity userEntity);

    void delete(UserEntity userEntity);

    boolean authenticate(UserEntity userEntity);

}
