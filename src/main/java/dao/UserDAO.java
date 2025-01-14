package dao;

import classes.JDBC;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (connection == null) {
                logger.warn("Failed to establish database connection.");
                return userList;
            }

            logger.debug("Fetching all users...");
            logger.debug("Query executed: {}", query);

            while (resultSet.next()) {
                logger.debug("Processing row with ID: {}", resultSet.getInt("id"));
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("created_at")
                );
                userList.add(user);
                logger.debug("User added to list: {}", user);
            }

            logger.info("Total users retrieved: {}", userList.size());

        } catch (SQLException e) {
            logger.error("SQL Error: {}", e.getMessage());
            e.printStackTrace();
        }

        return userList;
    }



    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = null;

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (connection == null) {
                System.out.println("Failed to establish database connection.");
                return null;
            }

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Query executed: " + query);
            if (resultSet.next()) {
                System.out.println("Processing row with ID: " + resultSet.getInt("id"));
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getTimestamp("created_at")
                );
                System.out.println("User retrieved: " + user);
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (connection == null) {
                System.out.println("Failed to establish database connection.");
                return false;
            }

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());

            System.out.println("Executing query: " + query);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateUser(User user) {
        String query = "UPDATE users SET username = ?, password = ?, role = ? WHERE id = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (connection == null) {
                System.out.println("Failed to establish database connection.");
                return false;
            }

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setInt(4, user.getId());

            System.out.println("Executing query: " + query);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection connection = JDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (connection == null) {
                System.out.println("Failed to establish database connection.");
                return false;
            }

            preparedStatement.setInt(1, id);

            System.out.println("Executing query: " + query);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
