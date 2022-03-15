package repositories;

import models.Type;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeDAOImpl implements TypeDAO{
    @Override
    public Type getTypebById(Integer typeId) {
        Type type = null;

        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql = "select * from ers_reimbursement_type ert where reimb_type_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, typeId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                type = new Type(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return type;
    }
}
