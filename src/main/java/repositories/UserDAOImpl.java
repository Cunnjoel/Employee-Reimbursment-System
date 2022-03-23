package repositories;

import models.User;
import util.ConnectionUtil;

import java.sql.*;

public class UserDAOImpl implements UserDAO{

    @Override
    public User getUserGivenUserName(String username) {
        User user = null;
        try{
                    Connection conn = ConnectionUtil.getConnection();

            String sql ="select * from ers_users where ers_username = ?;";

            PreparedStatement ps =conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();

        }
        return user;
    }

    @Override
    public void createUser(User user) {
        try{
            Connection conn = ConnectionUtil.getConnection();

            String sql ="insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, ers_user_role_fk)\n" +
                    "values (?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRoleId());

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
