package repositories;

import models.Reimbursement;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReimbursementDAOImpl implements ReimbursementDAO{

    @Override
    public List<Reimbursement> getAllReimbursementById(Integer reimbursementID) {
        List<Reimbursement> reimbursement =new ArrayList<>();

        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "select * from ers_reimbursement where ers_users_fk_auth = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbursementID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                reimbursement.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3),rs.getDate(4), rs.getString(5),rs.getBlob(6)));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return reimbursement;
    }

    @Override
    public Reimbursement getByStatus(Integer statusId) {
        return null;
    }

    @Override
    public void createReimbursement(Reimbursement reimbursement) {

    }
}