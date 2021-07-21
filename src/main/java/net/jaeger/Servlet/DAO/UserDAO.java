package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.User;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

public class UserDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<User> getAllUsers() {

//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();

        Query query = entityManager.createQuery("select t from User t");
        return query.getResultList();
    }

    public boolean saveUser(User user){
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
