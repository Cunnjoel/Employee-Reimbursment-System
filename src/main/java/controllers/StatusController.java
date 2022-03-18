package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Status;
import services.StatusServices;

public class StatusController {
    StatusServices statusServices;

    public StatusController() { this.statusServices = new StatusServices(); }

    public StatusController(StatusServices statusServices) { this.statusServices = statusServices; }

    public void getStatusById(Context context){
        Integer statusId = Integer.parseInt(context.queryParam("statusId"));

        Status status = statusServices.getStatusById(statusId);

        context.json(new JsonResponse(true, "Status for " + statusId, status));
    }

    public void changeStatusById(Context context){
        Integer statusId = Integer.parseInt(context.queryParam("statusId"));

        statusServices.changeStatusById(statusId);

        context.json(new JsonResponse(true, "Status changed if exists", null));

    }


}
