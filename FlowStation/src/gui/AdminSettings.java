package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.*;

import dbConnections.Connections;
import backend.Admin;

public class AdminSettings extends JFrame {
	
	Admin obj = new Admin();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;
    private JTextField textField;
    private JTextField passwordField_1;
    private JTextField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	AdminSettings frame = new AdminSettings();
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
    public AdminSettings() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Customers.class.getResource("/resources/Logo_Small.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 780);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Customers.class.getResource("/resources/Main.png")));
        backgroundLabel.setBounds(0, 6, 1426, 743);
        contentPane.add(backgroundLabel);
        backgroundLabel.setLayout(null);
        
        //side panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(16, 68, 160));
        panel.setBounds(238, 0, 1188, 120);
        backgroundLabel.add(panel);
        panel.setLayout(null);
        
        //head label
        JLabel lblNewLabel_3 = new JLabel("Admin Settings");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 41));
        lblNewLabel_3.setBounds(433, 27, 325, 66);
        panel.add(lblNewLabel_3);
        
        //head panel
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(65, 134, 255));
        panel_1.setBounds(0, 0, 238, 743);
        backgroundLabel.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Customers.class.getResource("/resources/Logo_Small.png")));
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
        btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_3.setBounds(0, 383, 238, 50);
        panel_1.add(btnNewButton_3);
        
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Pricing pricingFrame = new Pricing(); // Open the Customers frame
                pricingFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
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
        btnAdminSettings.setForeground(new Color(255, 255, 255));
        btnAdminSettings.setBackground(new Color(16, 68, 160));
        btnNewButton_5.setForeground(UIManager.getColor("Button.foreground"));
        btnNewButton_5.setBackground(UIManager.getColor("Button.background"));
        btnAdminSettings.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnAdminSettings.setBounds(0, 554, 238, 50);
        panel_1.add(btnAdminSettings);
        
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
        panel_2.setBounds(246, 125, 1169, 323);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 1147, 303);
        panel_2.add(scrollPane);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        //sql command to get values and insert to table
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        		{null, null, null},
        	},
        	new String[] {
        		"Admin ID", "Admin User Name", "Password"
        	}
        ));
        
        table.setBounds(0, 0, 1147, 303);
        scrollPane.setViewportView(table);
        table.setRowHeight(45);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            // SQL query to fetch admin details
            String query = "SELECT AdminID, Admin_Name, Admin_Password FROM admin";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Get the table's model
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Clear any existing rows
            model.setRowCount(0);

            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                int adminId = rs.getInt("AdminID");
                String adminName = rs.getString("Admin_Name");
                String adminPassword = rs.getString("Admin_Password");

                // Add a new row to the table
                model.addRow(new Object[]{adminId, adminName, adminPassword});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching admin data: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        //add admin panel------------------------------------------------
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(488, 455, 682, 93);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ADD ADMIN:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblNewLabel.setBounds(5, 6, 98, 30);
        panel_3.add(lblNewLabel);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName.setBounds(42, 36, 49, 19);
        panel_3.add(lblName);
        
        
        textField = new JTextField();
        textField.setBounds(116, 34, 438, 21);
        panel_3.add(textField);
        textField.setColumns(10);
        
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        textField.addActionListener(e -> {
        	
        	obj.setAdminName(String.valueOf(textField.getText()));
        });
        
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblPassword.setBounds(42, 63, 68, 23);
        panel_3.add(lblPassword);
        
        
        passwordField = new JTextField();
        passwordField.setBounds(117, 61, 420, 21);
        panel_3.add(passwordField);
        
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
  
        obj.setPassword(new String(passwordField.getText()));

        
        //update admin panel----------------------------------------------------------
        JPanel panel_3_1 = new JPanel();
        backgroundLabel.add(panel_3_1);
        panel_3_1.setBounds(489, 556, 682, 93);
        panel_3_1.setLayout(null);
        
        JLabel lblUpdateAdminDetails = new JLabel("UPDATE ADMIN DETAILS:");
        lblUpdateAdminDetails.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblUpdateAdminDetails.setBounds(5, 6, 192, 30);
        panel_3_1.add(lblUpdateAdminDetails);
        
        JLabel lblName_1 = new JLabel("Name:");
        lblName_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName_1.setBounds(31, 38, 49, 18);
        panel_3_1.add(lblName_1);
        
        JComboBox<String> comboBox_1_1 = new JComboBox();
        comboBox_1_1.setBounds(116, 34, 440, 21);
        panel_3_1.add(comboBox_1_1);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            String query = "SELECT Admin_Name FROM admin";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add a default empty option
            comboBox_1_1.addItem("");

            while (rs.next()) {
                String adminName = rs.getString("Admin_Name");
                comboBox_1_1.addItem(adminName); // Add each admin name to the combo box
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching data for the combo box: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        		
        comboBox_1_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        JLabel lblPassworf_1 = new JLabel("Password:");
        lblPassworf_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblPassworf_1.setBounds(31, 66, 68, 17);
        panel_3_1.add(lblPassworf_1);
        
        passwordField_1 = new JTextField();
        passwordField_1.setBounds(117, 61, 420, 21);
        panel_3_1.add(passwordField_1);
        
        comboBox_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAdminName = (String) comboBox_1_1.getSelectedItem();

                if (selectedAdminName == null || selectedAdminName.isEmpty()) {
                    passwordField_1.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Admin_Password FROM admin WHERE Admin_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedAdminName);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String adminPassword = rs.getString("Admin_Password");
                        passwordField_1.setText(adminPassword); // Set the password in the text field
                    } else {
                        passwordField_1.setText(""); // Clear the password field if no password is found
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                            "Error fetching password: " + ex.getMessage(), 
                            "Database Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        passwordField_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });

        obj.setPassword(new String(passwordField.getText())); 
        
        
        
        
        
      //delete admin panel-------------------------------------------------------------------------
        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBounds(488, 658, 683, 76);
        backgroundLabel.add(panel_3_2);
        panel_3_2.setLayout(null);
        
        JLabel lblDeleteAdmin = new JLabel("DELETE ADMIN:");
        lblDeleteAdmin.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblDeleteAdmin.setBounds(5, 6, 122, 30);
        panel_3_2.add(lblDeleteAdmin);
        
        JLabel lblName_1_1 = new JLabel("Name:");
        lblName_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName_1_1.setBounds(31, 40, 49, 21);
        panel_3_2.add(lblName_1_1);
        
        JComboBox<String> comboBox_1 = new JComboBox();
        comboBox_1.setBounds(117, 39, 437, 21);
        panel_3_2.add(comboBox_1);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            String query = "SELECT Admin_Name FROM admin";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add a default empty option
            comboBox_1.addItem("");

            while (rs.next()) {
                String adminName = rs.getString("Admin_Name");
                comboBox_1.addItem(adminName); // Add each admin name to the combo box
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching data for the combo box: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        comboBox_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        comboBox_1.addActionListener(e -> {
        	
        	obj.setAdminName(String.valueOf(comboBox_1.getSelectedItem()));
        });
        
        
        
        
        // add button---------------------------------------------------------------------------
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_7.setBounds(574, 33, 85, 27);
        panel_3.add(btnNewButton_7);
        
        btnNewButton_7.addActionListener(e -> {
        	//comboBox_1_1.postActionEvent();
        	passwordField_1.postActionEvent();
        });
        
        btnNewButton_7.addActionListener(e -> {
            // Retrieve values from the text fields
            String adminName = textField.getText();
            String adminPassword = passwordField.getText(); // Use getText() for simplicity

            // Validate the input fields
            if (adminName.isEmpty() || adminPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                return;
            }

            // Show a confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to add this admin?",
                "Confirm Add Admin",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) {
                return; // Exit if the user selects "No"
            }

            // Database interaction
            try (Connection conn = Connections.getConnection()) {
                if (conn == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String sql = "INSERT INTO admin (Admin_Name, Admin_Password) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, adminName);
                    stmt.setString(2, adminPassword);

                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Admin added successfully!");
                        textField.setText(""); // Clear the admin name field
                        passwordField.setText(""); // Clear the password field

                        // Get the generated Admin ID
                        ResultSet rs = stmt.getGeneratedKeys();
                        int adminId = -1;
                        if (rs.next()) {
                            adminId = rs.getInt(1); // Retrieve the new Admin ID
                        }

                        // Update the JTable
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.addRow(new Object[]{adminId, adminName, adminPassword});

                        // Update both comboBox_1 and comboBox_1_1
                        comboBox_1.removeAllItems();
                        comboBox_1_1.removeAllItems();
                        comboBox_1.addItem("");
                        comboBox_1_1.addItem("");

                        // Fetch all admin names from the database
                        String fetchAdminQuery = "SELECT Admin_Name FROM admin";
                        try (PreparedStatement fetchStmt = conn.prepareStatement(fetchAdminQuery);
                             ResultSet adminRs = fetchStmt.executeQuery()) {
                            while (adminRs.next()) {
                                String fetchedAdminName = adminRs.getString("Admin_Name");
                                comboBox_1.addItem(fetchedAdminName);
                                comboBox_1_1.addItem(fetchedAdminName);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add admin.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });


        
        
      //update button--------------------------------------------------------
        JButton btnNewButton_7_1 = new JButton("UPDATE");
        btnNewButton_7_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_7_1.setBounds(575, 32, 97, 30);
        panel_3_1.add(btnNewButton_7_1);
        
        btnNewButton_7_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Step 1: Get the selected admin name from the JComboBox
                String selectedAdminName = (String) comboBox_1_1.getSelectedItem();

                // Step 2: Check if a valid admin is selected
                if (selectedAdminName == null || selectedAdminName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select an admin to update.");
                    return;
                }

                // Step 3: Get the new password from the password field and convert it to String
                String newPassword = new String(passwordField_1.getText()).trim(); // Convert char[] to String and trim spaces

                // Step 4: Validate the new password (check if it's empty or just whitespace)
                if (newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password cannot be empty.");
                    return;
                }

                // Show a confirmation dialog
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to update the password for admin: " + selectedAdminName + "?",
                    "Confirm Update",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm != JOptionPane.YES_OPTION) {
                    return; // Exit if the user selects "No"
                }

                // Step 5: Query to get the AdminID for the selected Admin Name
                String getAdminIdQuery = "SELECT AdminID FROM admin WHERE Admin_Name = ?";

                try (Connection conn = Connections.getConnection()) {
                    if (conn == null) {
                        JOptionPane.showMessageDialog(null, "Database connection failed.");
                        return;
                    }

                    int adminId = -1;
                    try (PreparedStatement stmt = conn.prepareStatement(getAdminIdQuery)) {
                        stmt.setString(1, selectedAdminName);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            adminId = rs.getInt("AdminID"); // Get the AdminID
                        }
                    }

                    if (adminId == -1) {
                        JOptionPane.showMessageDialog(null, "Admin not found.");
                        return;
                    }

                    // Step 6: SQL query to update the admin password in the database
                    String updateQuery = "UPDATE admin SET Admin_Password = ? WHERE AdminID = ?";

                    try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, newPassword); // Set the new password
                        updateStmt.setInt(2, adminId);

                        int rowsAffected = updateStmt.executeUpdate();

                        // Step 7: Provide feedback to the user
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Password updated successfully!");

                            // Step 8: Update the JTable
                            DefaultTableModel model = (DefaultTableModel) table.getModel();

                            // Loop through rows of the JTable to find the updated admin
                            for (int row = 0; row < model.getRowCount(); row++) {
                                if (model.getValueAt(row, 1).equals(selectedAdminName)) { // Assuming column 1 is Admin Name
                                    model.setValueAt(newPassword, row, 2); // Assuming column 2 is for password
                                    break;
                                }
                            }

                            model.fireTableDataChanged(); // Force the table to repaint itself

                            // Clear the password field after update
                            passwordField_1.setText("");

                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update password.");
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        
        
        //delete button--------------------------------------------------------------------------
        JButton btnNewButton_7_1_1 = new JButton("DELETE");
        btnNewButton_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_7_1_1.setBounds(575, 33, 97, 30);
        panel_3_2.add(btnNewButton_7_1_1);

        btnNewButton_7_1_1.addActionListener(e -> {
            String selectedAdminName = (String) comboBox_1.getSelectedItem();

            if (selectedAdminName == null || selectedAdminName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please select an admin to delete.");
                return;
            }

            // Show a confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(
                null, 
                "Are you sure you want to delete the admin: " + selectedAdminName + "?", 
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION
            );

            if (confirm != JOptionPane.YES_OPTION) {
                return; // Exit if the user selects "No"
            }

            try (Connection conn = Connections.getConnection()) {
                if (conn == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed.");
                    return;
                }

                String getAdminIdQuery = "SELECT AdminID FROM admin WHERE Admin_Name = ?";
                int adminId = -1;

                try (PreparedStatement stmt = conn.prepareStatement(getAdminIdQuery)) {
                    stmt.setString(1, selectedAdminName);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        adminId = rs.getInt("AdminID");
                    }
                }

                if (adminId == -1) {
                    JOptionPane.showMessageDialog(null, "Admin not found.");
                    return;
                }

                String deleteQuery = "DELETE FROM admin WHERE AdminID = ?";
                try (PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery)) {
                    deleteStmt.setInt(1, adminId);
                    int rowsAffected = deleteStmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Admin deleted successfully!");

                        // Update comboBox_1 and comboBox_1_1
                        comboBox_1.removeAllItems();
                        comboBox_1_1.removeAllItems();
                        comboBox_1.addItem("");
                        comboBox_1_1.addItem("");

                        String updateComboBoxQuery = "SELECT Admin_Name FROM admin";

                        try (PreparedStatement stmt = conn.prepareStatement(updateComboBoxQuery);
                             ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                String adminName = rs.getString("Admin_Name");
                                comboBox_1.addItem(adminName);
                                comboBox_1_1.addItem(adminName);
                            }
                        }

                        // Update JTable
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.setRowCount(0);
                        String selectQuery = "SELECT * FROM admin";

                        try (PreparedStatement stmt = conn.prepareStatement(selectQuery);
                             ResultSet rs = stmt.executeQuery()) {
                            while (rs.next()) {
                                int adminIdFromDb = rs.getInt("AdminID");
                                String adminName = rs.getString("Admin_Name");
                                String adminPassword = rs.getString("Admin_Password");

                                model.addRow(new Object[]{adminIdFromDb, adminName, adminPassword});
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete admin.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });




    }
}

