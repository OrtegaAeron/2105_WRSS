package backend;

import java.sql.*;

public class Pricing_bcknd extends ContainerInventory {

    private double pricePerGalon = 25, waterPriceLarge, waterPriceMedium, waterPriceSmall;
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // Database connection setup
    public Pricing_bcknd() {
        try {
            // Change these values according to your database credentials
            String url = "jdbc:mysql://localhost:3306/flowstation_db";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Setters
    public void setPricePerGalon(double pricePerGalon) {
        this.pricePerGalon = pricePerGalon;
    }

    public void setWaterPriceLarge(double waterPriceLarge) {
        this.waterPriceLarge = waterPriceLarge;
    }

    public void setWaterPriceMedium(double waterPriceMedium) {
        this.waterPriceMedium = waterPriceMedium;
    }

    public void setWaterPriceSmall(double waterPriceSmall) {
        this.waterPriceSmall = waterPriceSmall;
    }

    // Getters
    public double getPricePerGalon() {
        return pricePerGalon;
    }

    public double getWaterPriceLarge() {
        return waterPriceLarge;
    }

    public double getWaterPriceMedium() {
        return waterPriceMedium;
    }

    public double getWaterPriceSmall() {
        return waterPriceSmall;
    }

    // Methods to calculate water prices
    public double calculateWaterPriceLarge() {
        waterPriceLarge = pricePerGalon * getContainerLarge();
        return waterPriceLarge;
    }

    public double calculateWaterPriceMedium() {
        waterPriceMedium = pricePerGalon * getContainerMedium();
        return waterPriceMedium;
    }

    public double calculateWaterPriceSmall() {
        waterPriceSmall = pricePerGalon * getContainerSmall();
        return waterPriceSmall;
    }

    // Method to load pricing data from the database
    public void loadPricingData() {
        try {
            String query = "SELECT * FROM pricing_table LIMIT 1";
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Assuming there's only one row in the table
                pricePerGalon = rs.getDouble("pricePerGalon");
                waterPriceLarge = rs.getDouble("fiveGalPrice");
                waterPriceMedium = rs.getDouble("threeGalPrice");
                waterPriceSmall = rs.getDouble("twoPointFiveGalPrice");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update pricing data in the database
    public void updatePricingData() {
        try {
            String updateQuery = "UPDATE pricing_table SET pricePerGalon = ?, fiveGalPrice = ?, threeGalPrice = ?, twoPointFiveGalPrice = ? WHERE id = 1";
            stmt = conn.prepareStatement(updateQuery);
            stmt.setDouble(1, pricePerGalon);
            stmt.setDouble(2, waterPriceLarge);
            stmt.setDouble(3, waterPriceMedium);
            stmt.setDouble(4, waterPriceSmall);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close database connection
    public void closeConnection() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Pricing_bcknd pricing = new Pricing_bcknd();
        pricing.loadPricingData(); // Load data from the database

        // Update prices
        pricing.setPricePerGalon(30);
        pricing.setWaterPriceLarge(pricing.calculateWaterPriceLarge());
        pricing.setWaterPriceMedium(pricing.calculateWaterPriceMedium());
        pricing.setWaterPriceSmall(pricing.calculateWaterPriceSmall());

        // Save the updated prices back to the database
        pricing.updatePricingData();

        // Close the connection
        pricing.closeConnection();
    }
}
