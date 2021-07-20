package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.UserDAO;
import net.jaeger.Servlet.Modal.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User getUser(String username) {
        User user = userDAO.getUser(username);
        return user;
    }

    public boolean loginAuthenticate(User user, String username, String password) {
        if (user != null) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
