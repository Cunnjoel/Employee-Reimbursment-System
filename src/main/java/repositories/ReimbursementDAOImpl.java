package repositories;

import models.Reimbursement;
import util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReimbursementDAOImpl implements ReimbursementDAO{

    @Override
    public List<Reimbursement> getAllReimbursementById(Integer userId) {
        List<Reimbursement> reimbursement =new ArrayList<>();

        try {
            Connection conn = ConnectionUtil.getConnection();
            String sql = "select * from ers_reimbursement where ers_users_fk_auth = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                reimbursement.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3),rs.getDate(4), rs.getString(5),rs.getBlob(6),rs.getInt(7),rs.getInt(9),rs.getInt(10)));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return reimbursement;
    }

    @Override
    public void createReimbursement(Reimbursement reimbursement) {

        try{
            Connection conn = ConnectionUtil.getConnection();
            String sql = "insert into ers_reimbursement (reimb_amount, ers_users_fk_auth, reimb_description, ers_reimbursement_status_fk, ers_reimbursement_type_fk)\n" +
                    "values (?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimbursement.getAmount());
            ps.setInt(2, reimbursement.getUserId());
            ps.setString(3, reimbursement.getDescription());
            ps.setInt(4,reimbursement.getStatusId());
            ps.setInt(5, reimbursement.getTypeId());

            ps.executeUpdate();

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void updateStatusApproved(Integer reimbursementId) {
        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql = "update ers_reimbursement set ers_reimbursement_status_fk = 2 where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimbursementId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void updateStatusDenied(Integer reimbursementId) {
        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql = "update ers_reimbursement set ers_reimbursement_status_fk = 3 where reimb_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, reimbursementId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}