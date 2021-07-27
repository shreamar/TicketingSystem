package net.jaeger.Servlet;

import net.jaeger.Servlet.Modal.Flight;
import net.jaeger.Servlet.Service.FlightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/flights")
public class FlightsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FlightService flightService = new FlightService();

            List<Flight> flightList = Collections.emptyList();

            for (Flight flight : flightService.getAllFlights()) {
                if (flight.getOrigin().equals(request.getParameter("from"))
                        && flight.getDestination().equals(request.getParameter("to"))
                        && flight.getLeaveTime().equals(request.getParameter("depart"))
                        && flight.getArriveTime().equals(request.getParameter("arrive"))) {
                    flightList.add(flight);
                }
            }
            if (flightList.isEmpty()) {
                request.setAttribute("areFlights", false);
            } else {
                request.setAttribute("areFlights", true);
                request.setAttribute("flightList", flightService.getAllFlights());
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Flight/ListFlights.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            FlightService flightService = new FlightService();

            request.setAttribute("flightList", flightService.getAllFlights());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Flight/SearchFlights.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
