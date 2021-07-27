package net.jaeger.Servlet.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservedFlights")
public class ReservedFlight {

    @Id
    @Column(name = "reservedFlightID")
    private int reservedFlightID;

    @Column(name = "flightID")
    private int flightID;

    @Column(name = "seatType")
    private char seatType;

    @Column(name = "tripType")
    private char tripType;

    @Column(name = "price")
    private double price;

    @Column(name = "userID")
    private int userID;

    public int getReservedFlightID() {
        return reservedFlightID;
    }

    public void setReservedFlightID(int reservedFlightID) {
        this.reservedFlightID = reservedFlightID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public char getSeatType() {
        return seatType;
    }

    public void setSeatType(char seatType) {
        this.seatType = seatType;
    }

    public char getTripType() {
        return tripType;
    }

    public void setTripType(char tripType) {
        this.tripType = tripType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
