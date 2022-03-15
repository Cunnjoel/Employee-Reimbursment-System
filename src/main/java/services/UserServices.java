package services;

import models.User;
import repositories.UserDAO;
import repositories.UserDaoImpl;

public class UserServices {
    private UserDAO userDAO;

    public UserServices(UserDAO userDAO) { this.userDAO = userDAO; }

    public UserServices() { this.userDAO = new UserDaoImpl(); }

    public User validateCredentials(String username, String password){
        User user = this.userDAO.getUserGivenUserName(username);

        if(user == null)
            return null;
        if(!password.equals(user.getPassword()))
            return null;
        return user;
    }
}
