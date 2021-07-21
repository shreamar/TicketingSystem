package net.jaeger.Servlet;

import net.jaeger.Servlet.Service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        UserService userService = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PrintWriter printWriter = response.getWriter();
//        printWriter.println("<html><body><h1>"+userService.getUser(username).getPassword().toUpperCase()+"</h1></body></html>");
        if(userService.loginAuthenticate(userService.getUserByUsername(username),username,password)){
            printWriter.println("<html><body><h1>Login Successful.</h1></body></html>");
        }
        else{
            printWriter.println("<html><body><h1>Login Failed!!!</h1></body></html>");
        }
    }
}
