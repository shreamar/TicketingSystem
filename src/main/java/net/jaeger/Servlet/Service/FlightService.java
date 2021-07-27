package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.FlightDAO;
import net.jaeger.Servlet.Modal.Flight;
import net.jaeger.Servlet.Modal.Plane;

import java.util.List;

public class FlightService {
    private FlightDAO flightDAO;

    public FlightService(){
        flightDAO = new FlightDAO();
    }

    public List<Flight> getAllFlights(){
        return flightDAO.getAllFlights();
    }

    public int getSeatAvailable(Flight flight){
        PlaneService planeService = new PlaneService();
        Plane plane = planeService.getPlaneByID(flight.getPlaneID());

        int seatCount = 0;
        if(plane.getEcoSeatsCap()-flight.getEcoSeatsRes()>0){
            seatCount += (plane.getEcoSeatsCap()-flight.getEcoSeatsRes());
        }
        if(plane.getBusiSeatsCap()-flight.getBusiSeatsRes()>0){
            seatCount += (plane.getBusiSeatsCap()-flight.getBusiSeatsRes());
        }
        if(plane.getFirstSeatsCap()-flight.getFirstSeatsRes()>0){
            seatCount += (plane.getFirstSeatsCap()-flight.getFirstSeatsRes());
        }
        return  seatCount;
    }

    public String getFlightNumber(Flight flight){
        PlaneService planeService = new PlaneService();
        return planeService.getPlaneByID(flight.getPlaneID()).getPlaneCode();
    }

    public Flight getFlightByID(int id){
        for(Flight flight: flightDAO.getAllFlights()){
            if(flight.getFlightID() == id){
                return flight;
            }
        }
        return null;
    }

    public boolean updateFlight(Flight flight){
        if(flightDAO.updateFlight(flight)){
            return true;
        }
        else {
            return false;
        }
    }
}
