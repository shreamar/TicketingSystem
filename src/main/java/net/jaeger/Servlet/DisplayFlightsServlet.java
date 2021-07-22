package net.jaeger.Servlet;

import net.jaeger.Servlet.Service.FlightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/display-flights")
public class DisplayFlightsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            FlightService flightService = new FlightService();

            request.setAttribute("flightList", flightService.getAllFlights());

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Flight/ListFlights.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
