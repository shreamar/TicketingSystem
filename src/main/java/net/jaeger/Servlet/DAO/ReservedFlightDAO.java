package net.jaeger.Servlet.DAO;

import net.jaeger.Servlet.Modal.ReservedFlight;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ReservedFlightDAO {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

    public boolean saveBookingRecord(ReservedFlight reservedFlight) {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("ticketing");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction.begin();
            entityManager.persist(reservedFlight);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
