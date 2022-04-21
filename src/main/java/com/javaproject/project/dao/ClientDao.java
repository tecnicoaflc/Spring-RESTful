package com.javaproject.project.dao;

import com.javaproject.project.models.Client;

import java.util.List;

public interface ClientDao {

     List<Client> getClients();
     void deleteClient(Long id);
     void createClient(Client client);
     void updateClient(Client client);
     Client getClient(Long id);

}
