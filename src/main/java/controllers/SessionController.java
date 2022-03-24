package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.User;
import services.UserServices;

public class SessionController {
    private UserServices userServices;

    public SessionController() { this.userServices = new UserServices(); }

    public void login(Context context){
        JsonResponse jsonResponse;

        User credentials = context.bodyAsClass(User.class);

        User userFromDb = userServices.validateCredentials(credentials.getUsername(), credentials.getPassword());

        if(userFromDb == null){
            jsonResponse = new JsonResponse(false, "Invalid username or password", null);
        }else {
            context.sessionAttribute("user", userFromDb);
            jsonResponse = new JsonResponse(true, "Login Successful", userFromDb);
        }
        context.json(jsonResponse);
    }

    public void checkSession(Context context){
        User user = context.sessionAttribute("user");

        if(user == null){
            context.json(new JsonResponse(false, "Not Logged-IN", null));
        }else{
            context.json(new JsonResponse(true, "Login Found", user));
        }
    }

    public void logout(Context context){
        context.sessionAttribute("user", null);

        context.json(new JsonResponse(true, "User has logged-out", null));
    }
}
