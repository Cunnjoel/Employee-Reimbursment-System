package repositories;

import models.User;

public interface UserDAO {
    User getUserGivenUserName(String username);
    void createUser(User user);
}
