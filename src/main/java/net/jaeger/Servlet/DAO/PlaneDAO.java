package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.Plane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PlaneDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Plane> getAllPlanes(){
        Query query = entityManager.createQuery("select p from Plane p");
        return query.getResultList();
    }


}
