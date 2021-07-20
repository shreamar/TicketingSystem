package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.User;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

public class UserDAO {

    public User getUser(String userName) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();

        Query query = entityManager.createQuery("select t from User t");
        List<User> users = (List<User>)query.getResultList();

        for (User user: users){
//            return user;
            if(user.getUsername().toLowerCase().equals(userName.toLowerCase())){
                return user;
            }
        }
        return null;
    }

    public boolean saveUser(User user){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}
