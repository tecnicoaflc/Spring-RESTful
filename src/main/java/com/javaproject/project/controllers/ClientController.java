package com.javaproject.project.controllers;

import com.javaproject.project.dao.ClientDao;
import com.javaproject.project.models.Client;
import com.javaproject.project.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientDao clientdao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="api/clientes",method= RequestMethod.GET)
    public List<Client> showClients() {

        return clientdao.getClients();
    }

    private boolean checkToken(String token){

        String userId = jwtUtil.getKey(token);

        if(userId==null){

            return false;
        }

        return true;
    }

    @RequestMapping(value="api/clientes/{id}",method=RequestMethod.DELETE)
    public void deleteClient(@RequestHeader(value="Authorization") String token,@PathVariable Long id){

        if(checkToken(token)){

            clientdao.deleteClient(id);

        }

    }

    @RequestMapping(value="api/clientes/{id}",method=RequestMethod.GET)
    public Client getClient(@PathVariable Long id){

        return clientdao.getClient(id);
    }


    @RequestMapping(value="api/altaCliente",method=RequestMethod.POST)
    public void postClient(@RequestHeader(value="Authorization") String token,@RequestBody Client client){

        if(checkToken(token)) {
            clientdao.createClient(client);

        }

    }


    @RequestMapping(value="api/clientes/{id}",method=RequestMethod.PUT)
    public void putClient(@RequestHeader(value="Authorization") String token,@RequestBody Client client){

        if(checkToken(token)) {

            clientdao.updateClient(client);
        }
    }


}
