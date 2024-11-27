package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import dbConnections.Connections;
import backend.Pricing_bcknd;

public class Pricing extends JFrame {
	
	Pricing_bcknd obj = new Pricing_bcknd();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTextField txtHello;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Pricing frame = new Pricing();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Pricing() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Pricing.class.getResource("/resources/Logo_Small.png")));
    	setTitle("FlowStation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 785);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Pricing.class.getResource("/resources/Main.png")));
        backgroundLabel.setBounds(0, 0, 1426, 743);
        contentPane.add(backgroundLabel);
        backgroundLabel.setLayout(null);
        
        //side panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(16, 68, 160));
        panel.setBounds(238, 0, 1188, 120);
        backgroundLabel.add(panel);
        panel.setLayout(null);
        
        //head label
        JLabel lblNewLabel_3 = new JLabel("Pricing");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 41));
        lblNewLabel_3.setBounds(438, 27, 296, 66);
        panel.add(lblNewLabel_3);
        
        //head panel
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(65, 134, 255));
        panel_1.setBounds(0, 0, 238, 743);
        backgroundLabel.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Pricing.class.getResource("/resources/Logo_Small.png")));
        lblNewLabel_1.setBounds(57, 19, 125, 125);
        panel_1.add(lblNewLabel_1);
        
        // FlowStation title label
        JLabel lblNewLabel_2 = new JLabel("FLOWSTATION™");
        lblNewLabel_2.setBounds(19, 156, 195, 48);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Myanmar Text", Font.BOLD, 25));
        
      //Transaction Button
        JButton btnNewButton = new JButton("Transactions");
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton.setBounds(0, 212, 238, 50);
        panel_1.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Transactions transactionsFrame = new Transactions(); // Open the Customers frame
                transactionsFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Customer Button
        JButton btnNewButton_1 = new JButton("Customers");
        btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_1.setBounds(0, 269, 238, 50);
        panel_1.add(btnNewButton_1);
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Customers customersFrame = new Customers(); // Open the Customers frame
                customersFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Inventory Button
        JButton btnNewButton_2 = new JButton("Inventory");
        btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_2.setBounds(0, 326, 238, 50);
        panel_1.add(btnNewButton_2);
        
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Inventory inventoryFrame = new Inventory(); // Open the Customers frame
                inventoryFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Pricing Button
        JButton btnNewButton_3 = new JButton("Pricing");
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(16, 68, 160));
        btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
        btnNewButton.setBackground(UIManager.getColor("Button.background"));
        btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_3.setBounds(0, 383, 238, 50);
        panel_1.add(btnNewButton_3);
        
        //Daily Sales Button
        JButton btnNewButton_4 = new JButton("Daily Sales");
        btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_4.setBounds(0, 440, 238, 50);
        panel_1.add(btnNewButton_4);
        
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                DailySales dailySalesFrame = new DailySales(); // Open the Customers frame
                dailySalesFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Sales Catalog Button
        JButton btnNewButton_5 = new JButton("Sales Catalog");
        btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_5.setBounds(0, 497, 238, 50);
        panel_1.add(btnNewButton_5);
        
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                SalesCatalog salesCatalogFrame = new SalesCatalog(); // Open the Customers frame
                salesCatalogFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
      //Admin Settings Button
        JButton btnAdminSettings = new JButton("Admin Settings");
        btnAdminSettings.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnAdminSettings.setBounds(0, 554, 238, 50);
        panel_1.add(btnAdminSettings);
        
        btnAdminSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                AdminSettingsLogIn AdminSettingsLogInFrame = new AdminSettingsLogIn(); // Open the Customers frame
                AdminSettingsLogInFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Exit Button
        JButton btnNewButton_6 = new JButton("Exit");
        btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_6.setBounds(0, 645, 238, 50);
        panel_1.add(btnNewButton_6);
        
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                LogIn logInFrame = new LogIn(); // Open the Customers frame
                logInFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        JPanel panel_2 = new JPanel();
        backgroundLabel.add(panel_2);
        panel_2.setBounds(455, 160, 753, 108);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Price per Gallon:\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 47));
        lblNewLabel.setBounds(39, 25, 487, 55);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_6 = new JLabel(" ₱       ");
        lblNewLabel_6.setForeground(new Color(0, 0, 0));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel_6.setBounds(520, 24, 195, 57);
        panel_2.add(lblNewLabel_6);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(225, 225, 225));
        panel_7.setBounds(520, 24, 195, 57);
        panel_2.add(panel_7);
        panel_7.setLayout(null);
        
        JLabel lblNewLabel_14 = new JLabel();
        lblNewLabel_14.setBounds(48, 5, 147, 49);
        lblNewLabel_14.setForeground(Color.BLACK);
        lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 40));
        panel_7.add(lblNewLabel_14);
        
     // Database connection setup
        Connection conn1 = null;
        try {
            // Establish the database connection
            conn1 = dbConnections.Connections.getConnection();

            // Query to retrieve the first row's Price_perGallon value from the pricing table
            String selectQuery = "SELECT Price_perGallon FROM pricing LIMIT 1"; // Fetching the first row
            PreparedStatement ps = conn1.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            // Check if the query returns any results
            if (rs.next()) {
                // Retrieve the Price_perGallon value from the first row
                double pricePerGallon = rs.getDouble("Price_perGallon");

                // Set the value of lblNewLabel_14 to the retrieved value (formatted as a string)
                lblNewLabel_14.setText(String.format("%.2f", pricePerGallon)); // Display with 2 decimal places
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Ensure the connection is closed after the operation
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(630, 290, 404, 108);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("Change Price per Gallon:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblNewLabel_5.setBounds(31, 11, 360, 32);
        panel_3.add(lblNewLabel_5);
        
        
        txtHello = new JTextField();
        txtHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtHello.setBounds(55, 50, 195, 41);
        panel_3.add(txtHello);
        txtHello.setColumns(10);
        
        lblNewLabel_6.setEnabled(true);
        
        txtHello.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        // Parse the input to ensure it is a valid integer
                        int value = Integer.parseInt(txtHello.getText());
                        if (value < 0) {
                            throw new NumberFormatException("Negative value not allowed.");
                        }
                        // If valid, perform desired actions here
                        System.out.println("Valid input: " + value);
                    } catch (NumberFormatException ex) {
                        // Handle invalid input
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", 
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        txtHello.setText(""); // Clear the text field
                    }
                    e.consume(); // Prevent default "Enter" key behavior
                }
            }
        });
        
        txtHello.addActionListener(e -> {
        	if (txtHello.getText().isEmpty()) {
        		obj.setPricePerGalon(0);
        		lblNewLabel_14.setText(String.valueOf(obj.getPricePerGalon()));
        		lblNewLabel_14.setEnabled(false);
        		lblNewLabel_6.setEnabled(false);
        	}
        	else {
        		obj.setPricePerGalon(Double.valueOf(txtHello.getText()));
        		lblNewLabel_14.setText(String.valueOf(obj.getPricePerGalon())+"0");
        		lblNewLabel_14.setEnabled(true);
        		lblNewLabel_6.setEnabled(true);
        	}
        });

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(500, 420, 665, 87);
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_8 = new JLabel("5gl/Large Containers Price:\r\n");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_8.setBounds(11, 26, 486, 34);
        panel_4.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("₱         ");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setBackground(new Color(225, 225, 225));
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_9.setBounds(490, 22, 163, 47);
        panel_4.add(lblNewLabel_9);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(225, 225, 225));
        panel_8.setBounds(490, 22, 163, 47);
        panel_4.add(panel_8);
        panel_8.setLayout(null);
        
        
        JLabel lblNewLabel_15 = new JLabel();
        lblNewLabel_15.setBounds(58, 6, 105, 34);
        lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 28));
        panel_8.add(lblNewLabel_15);
        
        lblNewLabel_15.setEnabled(true);
        lblNewLabel_9.setEnabled(true);

        txtHello.addActionListener(e -> {
            String input = txtHello.getText();
            if (input.isEmpty()) {
                lblNewLabel_15.setEnabled(false);
                lblNewLabel_9.setEnabled(false);
                
            } else {
                    lblNewLabel_15.setEnabled(true);
                    lblNewLabel_9.setEnabled(true);
            }});
        
     // Database connection setup
        Connection connection = null;
        try {
            // Establish the database connection
            connection = dbConnections.Connections.getConnection();

            // Query to retrieve the first row's Container_Price value from the pricing table
            String selectQuery = "SELECT Container_Price FROM pricing LIMIT 1"; // Fetching the first row
            PreparedStatement ps = connection.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            // Check if the query returns any results
            if (rs.next()) {
                // Retrieve the Container_Price value from the first row
                double containerPrice = rs.getDouble("Container_Price");

                // Set the value of lblNewLabel_15 to the retrieved value (formatted as a string)
                lblNewLabel_15.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Ensure the connection is closed after the operation
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }



        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(500, 519, 665, 87);
        backgroundLabel.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_10 = new JLabel("3gl/Medium Containers Price:\r\n");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_10.setBounds(11, 26, 501, 34);
        panel_5.add(lblNewLabel_10);
        
        JLabel lblNewLabel_11 = new JLabel("₱         ");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setBackground(new Color(225, 225, 225));
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_11.setBounds(490, 22, 163, 47);
        panel_5.add(lblNewLabel_11);
        
        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(225, 225, 225));
        panel_9.setBounds(490, 22, 163, 47);
        panel_5.add(panel_9);
        panel_9.setLayout(null);
        
        
        JLabel lblNewLabel_16 = new JLabel();
        lblNewLabel_16.setBounds(58, 5, 105, 34);
        lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 28));
        panel_9.add(lblNewLabel_16);

        lblNewLabel_16.setEnabled(true);
        lblNewLabel_11.setEnabled(true);

        txtHello.addActionListener(e -> {
            String input = txtHello.getText();
            if (input.isEmpty()) {
                lblNewLabel_16.setEnabled(false);
                lblNewLabel_11.setEnabled(false);
                
            } else {
                    lblNewLabel_16.setEnabled(true);
                    lblNewLabel_11.setEnabled(true);
            }});
        
     // Database connection setup
        Connection connection1 = null;
        try {
            // Establish the database connection
            connection1 = dbConnections.Connections.getConnection();

            // Query to retrieve the second row's Container_Price value from the pricing table
            String selectQuery = "SELECT Container_Price FROM pricing LIMIT 1, 1"; // Fetching the second row
            PreparedStatement ps = connection1.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            // Check if the query returns any results
            if (rs.next()) {
                // Retrieve the Container_Price value from the second row
                double containerPrice = rs.getDouble("Container_Price");

                // Set the value of lblNewLabel_16 to the retrieved value (formatted as a string)
                lblNewLabel_16.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Ensure the connection is closed after the operation
            try {
                if (connection1 != null && !connection1.isClosed()) {
                    connection1.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }

        
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(500, 620, 665, 87);
        backgroundLabel.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_12 = new JLabel("2.5gl/Small Containers Price:\r\n");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_12.setBounds(11, 26, 501, 34);
        panel_6.add(lblNewLabel_12);
        
        JLabel lblNewLabel_13 = new JLabel("₱         ");
        lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_13.setBackground(new Color(225, 225, 225));
        lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_13.setBounds(490, 22, 163, 47);
        panel_6.add(lblNewLabel_13);
        
        JPanel panel_10 = new JPanel();
        panel_10.setBackground(new Color(225, 225, 225));
        panel_10.setBounds(490, 22, 163, 47);
        panel_6.add(panel_10);
        panel_10.setLayout(null);
        
        
        JLabel lblNewLabel_17 = new JLabel();
        lblNewLabel_17.setBounds(58, 5, 105, 34);
        lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 28));
        panel_10.add(lblNewLabel_17);
        
        lblNewLabel_17.setEnabled(true);
        lblNewLabel_13.setEnabled(true);

        txtHello.addActionListener(e -> {
            String input = txtHello.getText();
            if (input.isEmpty()) {
                lblNewLabel_17.setEnabled(false);
                lblNewLabel_13.setEnabled(false);
                
            } else {
                    lblNewLabel_17.setEnabled(true);
                    lblNewLabel_13.setEnabled(true);
            }});
        
     // Database connection setup
        Connection connection2 = null;
        try {
            // Establish the database connection
            connection2 = dbConnections.Connections.getConnection();

            // Query to retrieve the third row's Container_Price value from the pricing table
            String selectQuery = "SELECT Container_Price FROM pricing LIMIT 2, 1"; // Fetching the third row (skipping the first 2 rows)
            PreparedStatement ps = connection2.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            // Check if the query returns any results
            if (rs.next()) {
                // Retrieve the Container_Price value from the third row
                double containerPrice = rs.getDouble("Container_Price");

                // Set the value of lblNewLabel_17 to the retrieved value (formatted as a string)
                lblNewLabel_17.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Ensure the connection is closed after the operation
            try {
                if (connection2 != null && !connection2.isClosed()) {
                    connection2.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }

        JButton btnNewButton_7 = new JButton("UPDATE\r\n");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_7.setBounds(257, 53, 91, 34);
        panel_3.add(btnNewButton_7);
        
        btnNewButton_7.addActionListener(e -> {
            // Get the new price per gallon from the text field
            String input = txtHello.getText();
            double newPricePerGallon;

            try {
                // Validate the input (ensure it's a positive number)
                newPricePerGallon = Double.parseDouble(input);
                if (newPricePerGallon <= 0) {
                    throw new NumberFormatException("Price per gallon must be positive.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid positive number for price per gallon.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
         // Show confirmation dialog asking if the user wants to update prices for all containers
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Do you want to update the price for all containers?", 
                "Confirm Update", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {

            // Database connection for updating pricing
            Connection connect = null;
            try {
                // Establish the database connection
                connect = dbConnections.Connections.getConnection();

                // Update query to set the price per gallon and container price
                String updateQuery = "UPDATE pricing SET Price_perGallon = ?, Container_Price = Container_Size * ?";
                PreparedStatement ps = connect.prepareStatement(updateQuery);

                // Set the parameters for the update
                ps.setDouble(1, newPricePerGallon);
                ps.setDouble(2, newPricePerGallon);

                // Execute the update
                ps.executeUpdate();

                // Notify the user of successful update
                JOptionPane.showMessageDialog(null, "Prices updated successfully!", "Update Successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to update prices. Please try again.", "Update Error", JOptionPane.ERROR_MESSAGE);

            } 
            
            //for pricepergallon update
            try {

                // Query to retrieve the first row's Price_perGallon value from the pricing table
                String selectQuery = "SELECT Price_perGallon FROM pricing LIMIT 1"; // Fetching the first row
                PreparedStatement ps = connect.prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery();

                // Check if the query returns any results
                if (rs.next()) {
                    // Retrieve the Price_perGallon value from the first row
                    double pricePerGallon = rs.getDouble("Price_perGallon");

                    // Set the value of lblNewLabel_14 to the retrieved value (formatted as a string)
                    lblNewLabel_14.setText(String.format("%.2f", pricePerGallon)); // Display with 2 decimal places
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to retrieve price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

            }
            
            //for large price
            try {
            	
                // Query to retrieve the first row's Container_Price value from the pricing table
                String selectQuery = "SELECT Container_Price FROM pricing LIMIT 1"; // Fetching the first row
                PreparedStatement ps = connect.prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery();

                // Check if the query returns any results
                if (rs.next()) {
                    // Retrieve the Container_Price value from the first row
                    double containerPrice = rs.getDouble("Container_Price");

                    // Set the value of lblNewLabel_15 to the retrieved value (formatted as a string)
                    lblNewLabel_15.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

            }
            
            //for medium container
            try {

                // Query to retrieve the second row's Container_Price value from the pricing table
                String selectQuery = "SELECT Container_Price FROM pricing LIMIT 1, 1"; // Fetching the second row
                PreparedStatement ps = connect.prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery();

                // Check if the query returns any results
                if (rs.next()) {
                    // Retrieve the Container_Price value from the second row
                    double containerPrice = rs.getDouble("Container_Price");

                    // Set the value of lblNewLabel_16 to the retrieved value (formatted as a string)
                    lblNewLabel_16.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

            }
            try {


                // Query to retrieve the third row's Container_Price value from the pricing table
                String selectQuery = "SELECT Container_Price FROM pricing LIMIT 2, 1"; // Fetching the third row (skipping the first 2 rows)
                PreparedStatement ps = connect.prepareStatement(selectQuery);
                ResultSet rs = ps.executeQuery();

                // Check if the query returns any results
                if (rs.next()) {
                    // Retrieve the Container_Price value from the third row
                    double containerPrice = rs.getDouble("Container_Price");

                    // Set the value of lblNewLabel_17 to the retrieved value (formatted as a string)
                    lblNewLabel_17.setText(String.format("%.2f", containerPrice)); // Display with 2 decimal places
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to retrieve container price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

            }finally {
                // Ensure the connection is closed after the operation
                try {
                    if (connect != null && !connect.isClosed()) {
                        connect.close();
                    }
                } catch (SQLException closeEx) {
                    closeEx.printStackTrace();
                }
            }}
        });
        
        
    }
}
