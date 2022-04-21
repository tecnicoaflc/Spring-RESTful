package com.javaproject.project.controllers;

import com.javaproject.project.dao.UserDao;
import com.javaproject.project.dao.UserDaoImp;
import com.javaproject.project.models.User;
import com.javaproject.project.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userdao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}")
    public User getUser(@PathVariable Long id){
        User user= new User();
        user.setId(id);
        user.setName("Pepe");
        user.setLastname("Test");
        user.setEmail("test@test.com");
        user.setPhone(123456789);
        //user.setToDoList(List.of("cleaning","playing","working"));




        return user;
    }

    @RequestMapping(value="api/usuarios",method= RequestMethod.GET)
    public List <User> showUsers(@RequestHeader(value="Authorization") String token){

        /* Spring security  y control de errores*/
        if(!checkToken(token)){return null;}

        return userdao.getUsers();

    }

    private boolean checkToken(String token){

        String userId = jwtUtil.getKey(token);

        return userId != null;
    }

    @RequestMapping(value="api/usuarios/{id}",method= RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value="Authorization") String token,
                           @PathVariable Long id){

        if(!checkToken(token)){return;}
         userdao.deleteUser(id);
    }


    @RequestMapping(value="api/registro",method=RequestMethod.POST)
    public void createUser(@RequestBody User user){

        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash=argon2.hash(1,1024,1,user.getPassword());

        user.setPassword(hash);
        userdao.registerUser(user);

    }

}
