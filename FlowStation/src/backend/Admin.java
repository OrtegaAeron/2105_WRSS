package backend;

import java.sql.*;

public class Admin {
    
    private String username;
    private String password;
    private String passkey = "supersecret"; // You can adjust or remove this depending on your requirements

    // Database connection details
    private final String DB_URL = "jdbc:mysql://localhost:3306/flowstation_db"; // Replace with your database name
    private final String DB_USER = "root"; // Replace with your database username
    private final String DB_PASSWORD = ""; // Replace with your database password

    // Getters and Setters
    public String getAdminName() {
        return username;
    }

    public void setAdminName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasskey() {
        return passkey;
    }

    // Method to validate admin login
    public boolean login(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM admin WHERE Admin_Name = ? AND Admin_Password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to register a new admin (sign up)
    public boolean signup(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO admin (Admin_Name, Admin_Password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to update an existing admin's password
    public boolean updateAdmin(String username, String newPassword) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE admin SET Admin_Password = ? WHERE Admin_Name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to delete an admin by username
    public boolean deleteAdmin(String username) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM admin WHERE Admin_Name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to fetch all admins from the database (for populating the table)
    public ResultSet getAllAdmins() {
        ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM admin";
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
