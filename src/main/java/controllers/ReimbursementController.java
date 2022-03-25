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

    public void displayAllReimbursement(Context context){
        List<Reimbursement> lists = reimbursementServices.getAll();
        context.json(new JsonResponse(true, "Listing all Reimbursemtns in database", lists));
    }

    public void createReimbursement(Context context){
        Reimbursement reimbursement = context.bodyAsClass(Reimbursement.class);

        reimbursementServices.createReimbursement(reimbursement);

        context.json(new JsonResponse(true, "Reimbursement created ", null));
    }

    public void updateStatusApproved(Context context){
        Integer reimbursementId = Integer.parseInt(context.pathParam("reimbursementId"));

        reimbursementServices.updateStatusApproved(reimbursementId);

        context.json(new JsonResponse(true, "Status updated to Approved", null));
    }

    public void updateStatusDenied(Context context){
        Integer reimbursementId = Integer.parseInt(context.pathParam("reimbursementId"));

        reimbursementServices.updateStatusDenied(reimbursementId);
        context.json(new JsonResponse(true, "Status updated to Denied", null));
    }
}
