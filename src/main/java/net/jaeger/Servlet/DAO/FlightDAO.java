package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.Flight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FlightDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Flight> getAllFlights(){
        Query query = entityManager.createQuery("select f from Flight f");
        return (List<Flight>)query.getResultList();
    }
}
