package net.jaeger.Servlet;

import net.jaeger.Servlet.Modal.Flight;
import net.jaeger.Servlet.Modal.ReservedFlight;
import net.jaeger.Servlet.Service.BookFlightService;
import net.jaeger.Servlet.Service.FlightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/book")
public class BookFlightServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            ReservedFlight reservedFlight = new ReservedFlight();
            reservedFlight.setFlightID(Integer.parseInt(request.getParameter("flightID")));
            reservedFlight.setPrice(Double.parseDouble(request.getParameter("ticketPrice")));
            reservedFlight.setSeatType(request.getParameter("seatType").charAt(0));
            reservedFlight.setTripType(request.getParameter("tripType").charAt(0));
            reservedFlight.setUserID(1);

            BookFlightService bookFlightService = new BookFlightService();
            PrintWriter printWriter = response.getWriter();

//            printWriter.println("<html><body><h1>"+reservedFlight.getSeatType()+
//                    reservedFlight.getTripType()+reservedFlight.getPrice()+"---"+
//                    reservedFlight.getFlightID()+"</h1></body></html>");
            if(bookFlightService.saveBookingRecord(reservedFlight)){
                printWriter.println("<html><body><h1>Save Successful.</h1></body></html>");
            }
            else {
                printWriter.println("<html><body><h1>Save Failed.</h1></body></html>");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        try{
                FlightService flightService = new FlightService();

                Random random = new Random();
                Flight flight = flightService.getFlightByID(random.nextInt(100)+1);

                request.setAttribute("flight",flight);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Flight/BookFlight.jsp");
            requestDispatcher.forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
