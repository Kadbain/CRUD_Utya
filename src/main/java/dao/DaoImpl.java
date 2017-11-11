package dao;

import model.User;
import util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ps1X on 27.06.2017.
 */
public class DaoImpl implements Dao {
    private Connection connection;

    public DaoImpl() {
        this.connection = DButil.getConnection();
    }

    public void addUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO datausers(firstname, lastname, dob, email) VALUES " +
                    "(?, ?, ?, ?)");
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, new Date(user.getDob().getTime()));
            ps.setString(4, user.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM datausers WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE datausers SET firstname = ?, lastname = ?, dob = ?, email = ? WHERE id = ?");
            ps.setString(1,user.getFirstName());
            ps.setString(2,user.getLastName());
            ps.setDate(3,new Date(user.getDob().getTime()));
            ps.setString(4,user.getEmail());
            ps.setInt(5,user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM datausers");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserById(int id) {
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM datausers WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("fisrtname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
