package net.jaeger.Servlet.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @Column(name = "flightID")
    private int flightID;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "oneWayPrice")
    private double oneWayPrice;

    @Column(name = "twoWayPrice")
    private double twoWayPrice;

    @Column(name = "leaveTime")
    private Timestamp leaveTime;

    @Column(name = "arriveTime")
    private Timestamp arriveTime;

    @Column(name = "planeID")
    private int planeID;

    @Column(name = "returnTime")
    private Timestamp returnTime;

    @Column(name = "returnArriveTime")
    private Timestamp returnArriveTime;

    @Column(name = "ecoSeatsRes")
    private int ecoSeatsRes; //economy class seats reserved

    @Column(name = "busiSeatsRes")
    private int busiSeatsRes;  //business class seats reserved

    @Column(name = "firstSeatsRes")
    private int firstSeatsRes;  //first class seats reserved

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getOneWayPrice() {
        return oneWayPrice;
    }

    public void setOneWayPrice(double oneWayPrice) {
        this.oneWayPrice = oneWayPrice;
    }

    public double getTwoWayPrice() {
        return twoWayPrice;
    }

    public void setTwoWayPrice(double twoWayPrice) {
        this.twoWayPrice = twoWayPrice;
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Timestamp getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Timestamp arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public Timestamp getReturnArriveTime() {
        return returnArriveTime;
    }

    public void setReturnArriveTime(Timestamp returnArriveTime) {
        this.returnArriveTime = returnArriveTime;
    }

    public int getEcoSeatsRes() {
        return ecoSeatsRes;
    }

    public void setEcoSeatsRes(int ecoSeatsRes) {
        this.ecoSeatsRes = ecoSeatsRes;
    }

    public int getBusiSeatsRes() {
        return busiSeatsRes;
    }

    public void setBusiSeatsRes(int busiSeatsRes) {
        this.busiSeatsRes = busiSeatsRes;
    }

    public int getFirstSeatsRes() {
        return firstSeatsRes;
    }

    public void setFirstSeatsRes(int firstSeatsRes) {
        this.firstSeatsRes = firstSeatsRes;
    }
}
