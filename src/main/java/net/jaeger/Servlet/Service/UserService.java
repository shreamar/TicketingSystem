package net.jaeger.Servlet.Service;

import net.jaeger.Servlet.DAO.UserDAO;
import net.jaeger.Servlet.Modal.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User getUserByUsername(String userName) {
        List<User> users = userDAO.getAllUsers();
        for (User user: users){
//            return user;
            if(user.getUsername().equalsIgnoreCase(userName.toLowerCase())){
                return user;
            }
        }
        return null;
    }

    public boolean loginAuthenticate(User user, String username, String password) {
        if (user != null) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean saveUser(User user){
        return userDAO.saveUser(user);
    }
}
