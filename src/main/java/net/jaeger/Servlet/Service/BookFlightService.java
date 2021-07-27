package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.ReservedFlightDAO;
import net.jaeger.Servlet.Modal.Flight;
import net.jaeger.Servlet.Modal.ReservedFlight;

public class BookFlightService {
    private ReservedFlightDAO reservedFlightDAO;

    public BookFlightService(){
        reservedFlightDAO = new ReservedFlightDAO();
    }

    public boolean saveBookingRecord(ReservedFlight reservedFlight){
        try {
            FlightService flightService = new FlightService();
            Flight flight = flightService.getFlightByID(reservedFlight.getFlightID());

            if(reservedFlight.getSeatType() == 'E'){
                flight.setEcoSeatsRes(flight.getEcoSeatsRes()+1);
            }
            else if(reservedFlight.getSeatType() == 'B'){
                flight.setBusiSeatsRes(flight.getBusiSeatsRes()+1);
            }
            else if(reservedFlight.getSeatType() == 'F'){
                flight.setFirstSeatsRes(flight.getFirstSeatsRes()+1);
            }

            if(flightService.updateFlight(flight)){
                if(reservedFlightDAO.saveBookingRecord(reservedFlight)){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
