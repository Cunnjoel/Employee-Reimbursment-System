import repositories.ReimbursementDAO;
import repositories.ReimbursementDAOImpl;
import repositories.UserDAO;
import repositories.UserDaoImpl;

public class MainDrive {
    public static void main(String[] args) {
        UserDAO user = new UserDaoImpl();
        ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

        //System.out.println(user.getUserGivenUserName("MeUser"));
        //System.out.println(reimbursementDAO.getAllReimbursementById(2));
    }
}
