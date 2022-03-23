package repositories;

import models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {
    List<Reimbursement> getAllReimbursementById(Integer userID);
    void createReimbursement(Reimbursement reimbursement);
    void updateStatusApproved(Integer reimbursementId);
    void updateStatusDenied(Integer reimbursementId);

}
