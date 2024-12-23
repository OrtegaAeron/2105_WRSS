package backend;

import dbConnections.Connections;
import java.sql.*;

public class Admin {

    private String username;
    private String password;
    private String passkey = "supersecret"; // You can adjust or remove this depending on your requirements

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
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Connection failed.");
                return false; // Connection failed
            }

            String query = "SELECT * FROM admin WHERE Admin_Name = ? AND Admin_Password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true; // Login successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Login failed
    }

    // Method to register a new admin (sign up)
    public boolean signup(String username, String password) {
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Connection failed.");
                return false; // Connection failed
            }

            String query = "INSERT INTO admin (Admin_Name, Admin_Password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0; // Check if insertion was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Signup failed
    }

    // Method to update an existing admin's password
    public boolean updateAdmin(String username, String newPassword) {
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Connection failed.");
                return false; // Connection failed
            }

            String query = "UPDATE admin SET Admin_Password = ? WHERE Admin_Name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, newPassword);
            stmt.setString(2, username);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0; // Check if update was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Update failed
    }

    // Method to delete an admin by username
    public boolean deleteAdmin(String username) {
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Connection failed.");
                return false; // Connection failed
            }

            String query = "DELETE FROM admin WHERE Admin_Name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0; // Check if delete was successful
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Deletion failed
    }

    // Method to fetch all admins from the database (for populating the table)
    public ResultSet getAllAdmins() {
        ResultSet rs = null;
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Connection failed.");
                return null; // Connection failed
            }

            String query = "SELECT * FROM admin";
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
