package repositories;

import models.User;
import util.ConnectionUtil;

import java.sql.*;

public class UserDaoImpl implements UserDAO{

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
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();

        }
        return user;
    }
}
