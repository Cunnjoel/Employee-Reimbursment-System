package controllers;


import io.javalin.http.Context;
import models.JsonResponse;
import models.User;
import services.UserServices;


public class UserController {
    private UserServices userServices;

    public UserController() { this.userServices = new UserServices(); }

    public UserController(UserServices userServices) { this.userServices = userServices; }

    public void login(Context context){
        JsonResponse jsonResponse;

        User credentials = context.bodyAsClass(User.class);

        User userFromDb = userServices.validateCredentials(credentials.getUsername(), credentials.getPassword());

        if(userFromDb == null){
            jsonResponse = new JsonResponse(false, "Invalid Username or Password", null);
        }else{
            jsonResponse = new JsonResponse(true, "Login Successful", userFromDb);
        }

        context.json(jsonResponse);
    }

}
