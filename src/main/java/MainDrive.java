import models.Reimbursement;
import repositories.*;

public class MainDrive {
    public static void main(String[] args) {
        UserDAO user = new UserDaoImpl();
        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
        ReimbursementDAOImpl reimb = new ReimbursementDAOImpl();
        RoleDAO role = new RoleDAOImlp();
        StatusDAO status = new StatusDAOImlp();
        TypeDAO type = new TypeDAOImpl();

        //System.out.println(user.getUserGivenUserName("MeUser"));
        //System.out.println(reimbursementDAO.getAllReimbursementById(2));
        //System.out.println(reimb.createReimbursement(new Reimbursement(200.50, 2,1,1)));
        //System.out.println(role.getRoleById(1));
        //System.out.println(status.getStatusById(1));
        System.out.println(type.getTypebById(1));
    }
}
