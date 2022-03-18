package controllers;


import io.javalin.http.Context;
import models.JsonResponse;
import models.Role;
import services.RoleServices;

public class RoleController {
    RoleServices roleServices;

    public RoleController() { this.roleServices = new RoleServices(); }

    RoleController(RoleServices roleServices) { this.roleServices = roleServices; }

    public void getRoleById(Context context){
        Integer roleId = Integer.parseInt(context.queryParam("roleId"));

        Role role = roleServices.getAllRoleGivenId(roleId);

        context.json(new JsonResponse(true, "Role for " + roleId, role));
    }
}
