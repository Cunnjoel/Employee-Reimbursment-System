package repositories;

import models.Role;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImlp implements RoleDAO{
    @Override
    public Role getRoleById(Integer roleId) {
        Role role = null;
        try (Connection conn = ConnectionUtil.getConnection();){

            String sql = "select * from ers_user_role where ers_user_role_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, roleId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                 role = new Role(rs.getInt(1), rs.getString(2));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return role;
    }

    @Override
    public void changeRole(Integer roleId) {
        try (Connection conn = ConnectionUtil.getConnection();){

            String sql = "update ers_user_role set user_role = 'Manager' where ers_user_role_id = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, roleId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
