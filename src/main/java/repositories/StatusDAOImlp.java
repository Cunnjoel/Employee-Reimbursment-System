package repositories;

import models.Status;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDAOImlp implements StatusDAO{
    @Override
    public Status getStatusById(Integer statusId) {
        Status status = null;

        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql = "select * from ers_reimbursement_status ers where reimb_status_id  = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                status = new Status(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return status;
    }

    @Override
    public void changeStatus(Integer statusId) {
        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql = "update ers_reimbursement_status set reimb_status = 'Approved' where reimb_status_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }
}
