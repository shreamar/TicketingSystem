package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.Plane;

import javax.persistence.*;
import java.util.List;

public class PlaneDAO {

    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public List<Plane> getAllPlanes(){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createQuery("select p from Plane p");
            return query.getResultList();
        }
        catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return null;
        }finally{
            entityManager.close();
            entityManagerFactory.close();
        }
    }


}
