package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.FlightDAO;
import net.jaeger.Servlet.Modal.Flight;

import java.util.List;

public class FlightService {
    private FlightDAO flightDAO;

    public FlightService(){
        flightDAO = new FlightDAO();
    }

    public List<Flight> getAllFlights(){
        return flightDAO.getAllFlights();
    }
}
