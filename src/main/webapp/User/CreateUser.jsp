<%--
  Created by IntelliJ IDEA.
  User: Amar Shrestha
  Date: 7/20/2021
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New User</title>
    <script language="JavaScript">
        var passwordMatch = function () {
            if (document.userForm.password.value == document.userForm.confirmPassword.value) {
                document.getElementById('message').style.color = 'green';
                document.getElementById('message').innerHTML = '[Matching]';
            } else {
                document.getElementById('message').style.color = 'red';
                document.getElementById('message').innerHTML = '[Not matching]';
            }
        }
    </script>
</head>
<body>
<h1>Create New User</h1>
<form method="post" action="/create-user" name="userForm">
    Firstname :<input type="text" name="firstName" placeholder="FirstName">
    Middlename :<input type="text" name="middleName" placeholder="MiddleName">
    Lastname :<input type="text" name="lastName" placeholder="LastName"><br>
    Gender :<input type="radio" name="gender" value="F" checked>Female
    <input type="radio" name="gender" value="M">Male
    <input type="radio" name="gender" value="O">Other<br>
    Age :<input type="number" name="age" placeholder="Age"><br>
    Address Line :<input type="text" name="addressLine" placeholder="Address Line"><br>
    Unit # :<input type="text" name="addressUnit" placeholder="Unit/Apartment">
    City :<input type="text" name="city" placeholder="City">
    State :<input type="text" name="state" placeholder="State">
    Zipcode :<input type="number" name="zipCode" placeholder="12345"><br>
    Email :<input type="email" name="email" placeholder="jaeger@airlines.com">
    Phone :<input type="text" name="phone" placeholder="1234567890">
    <hr>
    Username :<input type="text" name="username" placeholder="Username"><br>
    Create Password :<input type="password" name="password" placeholder="Create Password" onkeyup="passwordMatch();"><br>
    Confirm Password <input type="password" name="confirmPassword" placeholder="Confirm Password" onkeyup="passwordMatch();">
    <span id="message"></span>
    <hr>
    <input type="submit" value="Submit">
</form>
</body>
</html>
