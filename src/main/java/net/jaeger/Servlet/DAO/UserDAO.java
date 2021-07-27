package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.User;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

public class UserDAO {

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public List<User> getAllUsers() {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createQuery("select t from User t");
            return query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return null;
        }finally{
//            entityManager.close();
//            entityManagerFactory.close();
        }
    }

    public boolean saveUser(User user){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction.begin();
            entityManager.persist(user);
            entityTransaction.commit();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        }finally{
//            entityManager.close();
//            entityManagerFactory.close();
        }
    }
}
