package net.jaeger.Servlet.Modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane {
    @Id
    @Column(name = "planeID")
    private int planeID;

    @Column(name = "planeCode")
    private String planeCode;

    @Column(name = "ecoSeatsCap")
    private int ecoSeatsCap; //economy seat capacity

    @Column(name = "busiSeatsCap")
    private int busiSeatsCap;  //business class seat capacity

    @Column(name = "firstSeatsCap")
    private int firstSeatsCap;  //first class seat capacity

    public int getPlaneID() {
        return planeID;
    }

    public void setPlaneID(int planeID) {
        this.planeID = planeID;
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    public int getEcoSeatsCap() {
        return ecoSeatsCap;
    }

    public void setEcoSeatsCap(int ecoSeatsCap) {
        this.ecoSeatsCap = ecoSeatsCap;
    }

    public int getBusiSeatsCap() {
        return busiSeatsCap;
    }

    public void setBusiSeatsCap(int busiSeatsCap) {
        this.busiSeatsCap = busiSeatsCap;
    }

    public int getFirstSeatsCap() {
        return firstSeatsCap;
    }

    public void setFirstSeatsCap(int firstSeatsCap) {
        this.firstSeatsCap = firstSeatsCap;
    }
}
