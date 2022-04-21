package com.javaproject.project.dao;

import com.javaproject.project.models.Client;
import com.javaproject.project.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ClientDaoImp implements ClientDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional(readOnly=true)
    public List<Client> getClients() {

        String query="FROM Client ORDER BY id DESC";
        return entityManager.createQuery(query).getResultList();

    }

    @Override
    @Transactional
    public void deleteClient(Long id) {

        Client clientFound= entityManager.find(Client.class,id);

        entityManager.remove(clientFound);

    }



    @Override
    @Transactional
    public void createClient(Client client) {

        entityManager.merge(client);

    }

    @Override
    @Transactional
    public void updateClient(Client client) {

        entityManager.merge(client);

    }

    @Override
    @Transactional(readOnly=true)
    public Client getClient(Long id) {

        Client clientFound= entityManager.find(Client.class,id);

        return clientFound;
    }
}
