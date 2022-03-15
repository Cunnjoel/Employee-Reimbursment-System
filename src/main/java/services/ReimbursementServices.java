package services;

import models.Reimbursement;
import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;

import java.util.List;

public class ReimbursementServices {
    private ReimbursementDAO reimbursementDAO;

    public ReimbursementServices(ReimbursementDAO reimbursementDAO) { this.reimbursementDAO = reimbursementDAO; }

    public ReimbursementServices() { this.reimbursementDAO = new ReimbursementDAOImpl(); }

    public List<Reimbursement> getAllGivenId(Integer reimbursementID){
        return this.reimbursementDAO.getAllReimbursementById(reimbursementID);
    }

    public void createReimbursement(Reimbursement reimbursement) { this.reimbursementDAO.createReimbursement(reimbursement); }
}
