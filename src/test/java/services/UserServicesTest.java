package services;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repositories.UserDAO;

import static org.junit.jupiter.api.Assertions.*;

class UserServicesTest {

    private UserServices userServices;

    private UserDAO userDAO = Mockito.mock(UserDAO.class);

    public  UserServicesTest() { this.userServices = new UserServices(userDAO); }

    @Test
    void validateCredentialsInvalidPassword() {
        //arrange
        String expectedUsername = "correctusername";
        String expectedPassword = "pass1234";
        User expectedOutput = null;
        User userFromDb = new User("correctusername", "pass123", "firstname", "lastname", "email@emila.com", 1);
        Mockito.when(userDAO.getUserGivenUserName(expectedUsername)).thenReturn(userFromDb);

        //act
        User actualOutput = userServices.validateCredentials(expectedUsername,expectedPassword);

        //assert
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void validateCredentialsInvalidUsername() {

        String expectedUsername = "incorrectusername";
        String expectedPassword = "pass1234";
        User expectedOutput = null;
        Mockito.when(userDAO.getUserGivenUserName(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userServices.validateCredentials(expectedUsername, expectedPassword);

        Assertions.assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void validateCredentialsValidCredentials() {
        String expectedUsername = "correctusername";
        String expectedPassword = "correctpassword";
        User expectedOutput = new User(expectedUsername, expectedPassword, "user", "namme", "email", 2);
        Mockito.when(userDAO.getUserGivenUserName(expectedUsername)).thenReturn(expectedOutput);

        User actualOutput = userServices.validateCredentials(expectedUsername, expectedPassword);

        Assertions.assertEquals(expectedOutput,actualOutput);

    }

    @Test
    void createUser() {
        User userPass = new User("username", "password", "user", "namme", "email", 2);

        userServices.createUser(userPass);

        Mockito.verify(userDAO, Mockito.times(1)).createUser(userPass);
    }
}