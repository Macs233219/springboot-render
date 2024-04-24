package com.login.ProyectoLogin.controller;

import com.login.ProyectoLogin.models.UserEntity;
import com.login.ProyectoLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showUserList(Model model, UserEntity userEntity) {
        userEntity = null;
        return "index";
    }

    @GetMapping("/registerForm")
    public String registerForm(UserEntity userEntity) {
        return "register";
    }

    @PostMapping("/registerSave")
    public String registerSave(UserEntity userEntity) {
        userService.save(userEntity);
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, UserEntity userEntity) {
        boolean authenticated = userService.authenticate(userEntity);

        model.addAttribute("authenticated",authenticated);

        if (authenticated == true) {
            return "adminPanel";
        } else {
            return "error";
        }

    }

}
