package repositories;

import models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    List<Reimbursement> getAllReimbursementById(Integer userID);
    Reimbursement getByStatus(Integer statusId);
    void createReimbursement(Reimbursement reimbursement);

}
