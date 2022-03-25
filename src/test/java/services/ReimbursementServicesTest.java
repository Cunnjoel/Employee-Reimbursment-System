package services;

import models.Reimbursement;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import repositories.ReimbursementDAO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReimbursementServicesTest {
    ReimbursementServices reimbursementServices;

    ReimbursementDAO reimbursementDAO = Mockito.mock(ReimbursementDAO.class);

    public ReimbursementServicesTest() { reimbursementServices = new ReimbursementServices(reimbursementDAO); }

    @Test
    void getAllGivenId() {
        Integer userId = 2;
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement(330.2 ,1, 2022-03-17, 3));
        expectedOutput.add(new Reimbursement(500.2 ,2, 2022-03-17, 3));
        Mockito.when(reimbursementDAO.getAllReimbursementById(userId)).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput =reimbursementServices.getAllGivenId(userId);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getAll() {
        List<Reimbursement> expectedOutput = new ArrayList<>();
        expectedOutput.add(new Reimbursement(330.2 ,1, 2022-03-17, 3));
        expectedOutput.add(new Reimbursement(500.2 ,2, 2022-03-17, 3));
        Mockito.when(reimbursementDAO.getAllReimbursement()).thenReturn(expectedOutput);

        List<Reimbursement> actualOutput = reimbursementServices.getAll();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void createReimbursement() {
        Reimbursement newReimb = new Reimbursement(330.2 ,1, 2022-03-17, 3);

        reimbursementServices.createReimbursement(newReimb);

        Mockito.verify(reimbursementDAO, Mockito.times(1)).createReimbursement(newReimb);
    }

    @Test
    void updateStatusApproved() {
        Integer reimbursementId = 2;

        reimbursementServices.updateStatusApproved(reimbursementId);

        Mockito.verify(reimbursementDAO).updateStatusApproved(reimbursementId);
    }

    @Test
    void updateStatusDenied() {
        Integer reimbursementId = 2;

        reimbursementServices.updateStatusDenied(reimbursementId);

        Mockito.verify(reimbursementDAO).updateStatusDenied(reimbursementId);
    }
}