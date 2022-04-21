package com.javaproject.project.controllers;

import com.javaproject.project.dao.UserDao;
import com.javaproject.project.models.User;
import com.javaproject.project.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userdao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/login",method= RequestMethod.POST)
    public String login(@RequestBody User user){

        User loggedUser = userdao.checkUserPassword(user);

        if(loggedUser!=null){

            String tokenJWT = jwtUtil.create(String.valueOf(loggedUser.getId()),loggedUser.getEmail());

            return tokenJWT;
        }

        return "FAIL";
    }
}
