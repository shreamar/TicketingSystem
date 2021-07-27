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

    <title>User Login</title>
    <link rel="stylesheet" href="../Login.css">
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
                <form method="post" action="/TicketingSystem_war_exploded/user" name="userForm" class="box">
                    <h1>Create New User</h1>
                    <input type="text" name="firstName" placeholder="FirstName">
                    <input type="text" name="middleName" placeholder="MiddleName">
                    <input type="text" name="lastName" placeholder="LastName"><br>
                    <label>Gender :</label><input type="radio" name="gender" value="F" checked><label>Female</label>
                    <input type="radio" name="gender" value="M"><label>Male</label>
                    <input type="radio" name="gender" value="O"><label>Other</label><br>
                    <label>Age :</label><input type="number" name="age" placeholder="Age"><br>
                    <input type="text" name="addressLine" placeholder="Address Line"><br>
                    <input type="text" name="addressUnit" placeholder="Unit/Apartment">
                    <input type="text" name="city" placeholder="City">
                    <input type="text" name="state" placeholder="State">
                    <input type="number" name="zipCode" placeholder="12345"><br>
                    <label>Email :</label><input type="email" name="email" placeholder="jaeger@airlines.com">
                    <label>Phone :</label><input type="text" name="phone" placeholder="1234567890">
                    <hr>
                    <input type="text" name="username" placeholder="Username"><br>
                    <input type="password" name="password" placeholder="Create Password"
                                            onkeyup="passwordMatch();"><br>
                    <input type="password" name="confirmPassword" placeholder="Confirm Password"
                                            onkeyup="passwordMatch();">
                    <span id="message"></span>
                    <hr>
                    <input type="submit" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
