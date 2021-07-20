package net.jaeger.Servlet;

import net.jaeger.Servlet.Modal.User;
import net.jaeger.Servlet.Service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user  = new User();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setFirstName(request.getParameter("firstName"));
        user.setMiddleName(request.getParameter("middleName"));
        user.setLastName(request.getParameter("lastName"));
        user.setGender(request.getParameter("gender").charAt(0));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setAddressLine(request.getParameter("addressLine"));
        user.setAddressUnit(request.getParameter("addressUnit"));
        user.setCity(request.getParameter("city"));
        user.setState(request.getParameter("state"));
        user.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));

        UserService userService = new UserService();
        PrintWriter printWriter = response.getWriter();
        if(userService.saveUser(user)){
            printWriter.println("<html><body><h1>Save Successful.</h1></body></html>");
        }
        else {
            printWriter.println("<html><body><h1>Save Failed.</h1></body></html>");
        }
    }
}
