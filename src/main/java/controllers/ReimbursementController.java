package controllers;

import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import services.ReimbursementServices;

import java.util.List;

public class ReimbursementController {
    ReimbursementServices reimbursementServices;

    public  ReimbursementController() { this.reimbursementServices = new ReimbursementServices(); }

    public ReimbursementController(ReimbursementServices reimbursementServices) { this.reimbursementServices = reimbursementServices; }

    public void displayReimbursementForUser(Context context){
        Integer userId = Integer.parseInt(context.queryParam("userId"));

        List<Reimbursement> lists = reimbursementServices.getAllGivenId(userId);
        context.json(new JsonResponse(true, "Listing all Reimbursements for user " + userId, lists));
    }

    public void createReimbursement(Context context){
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        reimbursementServices.createReimbursement(reimbursement);

        context.json(new JsonResponse(true, "Reimburesment created ", null));
    }
}
