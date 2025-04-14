package ru.kolotov.springMvc.Dao;

import org.springframework.stereotype.Component;
import ru.kolotov.springMvc.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ru.kolotov.springMvc.config.AppConfig.getConnection;


@Component
public class UserDao implements UserDaoInterface {


    @Override
    public List<User> index() {
        List<User> users = new ArrayList<>();
        Statement stmt;
        try (Connection conn = getConnection()) {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM users.user";
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()){
                User user = new User();
                user.setId(res.getInt("id"));
                user.setAge(res.getInt("age"));
                user.setName(res.getString("name"));
                user.setLastName(res.getString("lastName"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM User WHERE id=?");
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            if (res.next()){
                user = new User();
                user.setId(res.getInt("id"));
                user.setAge(res.getInt("age"));
                user.setName(res.getString("name"));
                user.setLastName(res.getString("lastName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO User (name, lastName, age) VALUES (?, ?, ?)");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setInt(3, user.getAge());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, User updateUser) {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE User SET name=?, age=?, lastName=? WHERE id=?");
            stmt.setString(1, updateUser.getName());
            stmt.setString(3, updateUser.getLastName());
            stmt.setInt(2, updateUser.getAge());
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        PreparedStatement stmt;
        try (Connection conn = getConnection()) {
            stmt = conn.prepareStatement("DELETE FROM User WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
