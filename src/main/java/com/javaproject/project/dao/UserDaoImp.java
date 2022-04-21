package com.javaproject.project.dao;

import com.javaproject.project.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly=true)
    public List<User> getUsers() {

        String query="FROM User";

        return entityManager.createQuery(query).getResultList();

    }

    @Override
    @Transactional(readOnly=true)
    public User getUser(String id) {

       /* String query="FROM User where id="+id;

        return entityManager.createQuery(query).getSingleResult();*/

        return null;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        User user=entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional(readOnly=true)
    public User checkUserPassword(User user) {
        String query= "FROM User WHERE email =:email";

        List<User> dataUsers= entityManager.createQuery(query)
                .setParameter("email",user.getEmail())
                .getResultList();

        if(dataUsers.isEmpty()){
            return null;
        }
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String passwordHashed= dataUsers.get(0).getPassword();

        if(argon2.verify(passwordHashed,user.getPassword())){

            return dataUsers.get(0);

        }

        return null;

    }

}
