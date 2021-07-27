<%@ page import="net.jaeger.Servlet.Modal.Flight" %>
<%@ page import="net.jaeger.Servlet.Service.FlightService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Amar Shrestha
  Date: 7/22/2021
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Flights</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form method="post" action="/TicketingSystem_war_exploded/flights" class="box">
                    <h2>Search Flights</h2>
                    <label>From:</label>
                    <select name="from" class="form-select">
                        <%
                            List<Flight> flights = (List<Flight>) request.getAttribute("flightList");
                            FlightService flightService = new FlightService();
                            for (Flight flight : flights) {
                        %>
                        <option value="<%flight.getOrigin();%>"><%=flight.getOrigin()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <label>To:</label>
                    <select name="to" class="form-select">
                        <%
                            for (Flight flight : flights) {
                        %>
                        <option value="<%flight.getDestination();%>"><%=flight.getDestination()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <label>Departure:</label>
                    <select class="form-select" name="depart">
                        <%
                            for (Flight flight : flights) {
                        %>
                        <option value="<%flight.getLeaveTime();%>"><%=flight.getLeaveTime()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <label>Arrival:</label>
                    <select class="form-select" name="arrive">
                        <%
                            for (Flight flight : flights) {
                        %>
                        <option value="<%flight.getArriveTime();%>"><%=flight.getArriveTime()%>
                        </option>
                        <%
                            }
                        %>
                    </select>
                    <input type="submit" value="Search Flights">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
