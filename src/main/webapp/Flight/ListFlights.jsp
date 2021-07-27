<%@ page import="net.jaeger.Servlet.Modal.Flight" %>
<%@ page import="java.util.List" %>
<%@ page import="net.jaeger.Servlet.Service.FlightService" %>
<%@ page import="net.jaeger.Servlet.Service.PlaneService" %>
<%@ page import="net.jaeger.Servlet.Modal.Plane" %><%--
  Created by IntelliJ IDEA.
  User: Amar Shrestha
  Date: 7/20/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Flights</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <%
        if (request.getParameter("areFlights").equals("false")) {
    %>
    <h3>No Flights found</h3>
    <%
        }
        else {
    %>
    <table class="table table-sm table-dark box">
        <thead>
        <tr>
            <th scope="col">Flight</th>
            <th scope="col">Departure</th>
            <th scope="col">Depart Date/Time</th>
            <th scope="col">Arrival</th>
            <th scope="col">Arrival Date/Time</th>
            <th scope="col">Remaining Seats</th>
            <th scope="col">Base Price</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Flight> flights = (List<Flight>) request.getAttribute("flightList");
            FlightService flightService = new FlightService();
            for (Flight flight : flights) {
        %>
        <tr>
            <th scope="row"><%=flightService.getFlightNumber(flight)%>
            </th>
            <td><%=flight.getOrigin()%>
            </td>
            <td><%=flight.getLeaveTime()%>
            </td>
            <td><%=flight.getDestination()%>
            </td>
            <td><%=flight.getArriveTime()%>
            </td>
            <td><%=flightService.getSeatAvailable(flight)%>
            </td>
            <td>$<%=flight.getOneWayPrice()%>
            </td>
            <td>
                <a href="#" class="btn btn-success">Reserve Flight</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>
</div>
</body>
</html>
