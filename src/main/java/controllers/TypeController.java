package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Type;
import services.TypeServices;

public class TypeController {
    TypeServices typeServices;

    public TypeController() { this.typeServices = new TypeServices(); }

    public TypeController(TypeServices typeServices) { this.typeServices = typeServices; }

    public void getTypeById(Context context){
        Integer typeId = Integer.parseInt(context.queryParam("typeId"));

        Type type = typeServices.getTypeById(typeId);

        context.json(new JsonResponse(true, "Show type by " + typeId, type));
    }

}
