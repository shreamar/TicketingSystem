package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.Flight;

import javax.persistence.*;
import java.util.List;

public class FlightDAO {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public List<Flight> getAllFlights(){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();

            Query query = entityManager.createQuery("select f from Flight f");
            List<Flight> flights = (List<Flight>) query.getResultList();
            entityManager.close();
            return flights;
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return null;
        }finally{
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public boolean updateFlight(Flight flight){
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            Flight flight1 = entityManager.find(Flight.class,flight.getFlightID());
            flight1.setEcoSeatsRes(99999);
            entityTransaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            entityTransaction.rollback();
            return false;
        }finally{
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
