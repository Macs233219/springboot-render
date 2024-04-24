package com.login.ProyectoLogin.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUser {

    private Long id;
    private String username;
    private String password;
    private String secondPassword;

}
