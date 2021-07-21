package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.PlaneDAO;
import net.jaeger.Servlet.Modal.Plane;

import javax.persistence.EntityManager;

public class PlaneService {
    private PlaneDAO planeDAO;

    public PlaneService(){
        planeDAO = new PlaneDAO();
    }

    public Plane getPlaneByID(int planeID){
        for(Plane plane: planeDAO.getAllPlanes()){
            if(plane.getPlaneID() == planeID){
                return plane;
            }
        }
        return null;
    }
}
