<%@ page import="net.jaeger.Servlet.Modal.Flight" %>
<%@ page import="net.jaeger.Servlet.Service.FlightService" %><%--
  Created by IntelliJ IDEA.
  User: Amar Shrestha
  Date: 7/22/2021
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Flight</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
        <%
                    Flight flight = (Flight)request.getAttribute("flight");
                    FlightService flightService = new FlightService();
                %>
        function priceCalculate(){
            var price = 0;
            if (document.getElementById('tripType').value == "O") {
                price = <%=flight.getOneWayPrice()%>
            }
            else {
                price =<%=flight.getTwoWayPrice()%>
            }

            if(document.getElementById('seatType').value == "B"){
                price = price*1.5 + 100;
            }
            else if(document.getElementById('seatType').value == "F"){
                price = price*2 + 200;
            }

            document.getElementById('price').style.color = 'green';
            document.getElementById('price').innerHTML = price;
            document.getElementById('ticketPrice').value = price;
        }
    </script>
</head>
<body onload="priceCalculate();">
<div class="container">
    <div class="row">
        <div class="col-md-9">
            <div class="card">
                <form class="box" method="post" action="/TicketingSystem_war_exploded/book" >
                    <h4>Flight number: </h4><h1><%=flightService.getFlightNumber(flight)%>
                    </h1>
                    <hr>
                    <h2>From: </h2><h1><%=flight.getOrigin()%></h1>
                    <h1><%=flight.getLeaveTime()%>
                    </h1><br>
                    <h2>To: </h2><h1><%=flight.getDestination()%></h1>
                    <h1><%=flight.getArriveTime()%>
                    </h1><hr><br>
                    <label>Seat Type: </label>
                    <select id="seatType" name = "seatType" onchange="priceCalculate();">
                        <option selected value="E">Economy</option>
                        <option value="B">Business Class</option>
                        <option value="F">First Class</option>
                    </select>
                    <label>Trip Type: </label>
                    <select id="tripType" name="tripType" onchange="priceCalculate();">
                        <option value="O" selected>One-way</option>
                        <option value="R">Round-trip</option>
                    </select>
                    <h3>Price : $<span id="price"></span></h3>
                    <hr>
                    <input hidden name="ticketPrice" id="ticketPrice">
                    <input hidden name="flightID" value="<%=flight.getFlightID()%>">
                    <input value="Submit" type="submit">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
