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
import javax.swing.table.TableCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;

import dbConnections.Connections;
import backend.Customers_bcknd;


public class Customers extends JFrame {
	
	Customers_bcknd obj = new Customers_bcknd();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_2;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Customers frame = new Customers();
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
    public Customers() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Customers.class.getResource("/resources/Logo_Small.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 780);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Customers.class.getResource("/resources/Main.png")));
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
        JLabel lblNewLabel_3 = new JLabel("Customers");
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
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(16, 68, 160));
        btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_1.setBounds(0,269, 238, 50);
        panel_1.add(btnNewButton_1);
        
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
        panel_2.setBounds(246, 125, 1169, 323);
        panel_2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 1147, 303);
        panel_2.add(scrollPane);

        table = new JTable();
        // SQL command to get values and insert to table
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"", null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
            },
            new String[] {
                "Customer ID", "Customer Name", "Address", "Contact Number", 
                "Lent Large Container", "Lent Medium Container", "Lent Small Container"
            }
        ));
        
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            // SQL query to fetch admin details
            String query = "SELECT CustomerID, Customer_Name, Address, Contact_Number, Lent_Large_Container, Lent_Medium_Container, Lent_Small_Container  FROM customer";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Get the table's model
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Clear any existing rows
            model.setRowCount(0);

            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                int customerId = rs.getInt("CustomerID");
                String customerName = rs.getString("Customer_Name");
                String address = rs.getString("Address");
                String contactNumber = rs.getString("Contact_Number");
                int lentLargeContainer = rs.getInt("Lent_Large_Container");
                int lentMediumContainer = rs.getInt("Lent_Medium_Container");
                int lentSmallContainer = rs.getInt("Lent_Small_Container");

                // Add a new row to the table
                model.addRow(new Object[]{customerId, customerName, address, contactNumber, lentLargeContainer, lentMediumContainer, lentSmallContainer });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching admin data: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }

     // Set larger font for the table header
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 20));

        // Set header height (optional)
        table.getTableHeader().setPreferredSize(new Dimension(0, 90));  // Increase header height (e.g., 70px)

        // Enable word wrapping and center the text in the header
        table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            private TableCellRenderer defaultRenderer = table.getTableHeader().getDefaultRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (component instanceof JLabel) {
                    JLabel label = (JLabel) component;
                    label.setText("<html><div style='text-align: center;'>" + value.toString() + "</div></html>"); // Center text using HTML
                    label.setHorizontalAlignment(SwingConstants.CENTER); // Align text horizontally
                }
                return component;
            }
        });

        // Set row height
        table.setRowHeight(50); // Adjust the value to your desired row height

        // Set table bounds and add to scrollPane
        table.setBounds(0, 0, 1147, 303);
        scrollPane.setViewportView(table);

        //Add customer panel
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBounds(286, 456, 1092, 94);
        backgroundLabel.add(panel_3);
        
        JLabel lblNewLabel = new JLabel("ADD CUSTOMER:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 21));
        lblNewLabel.setBounds(5, 6, 185, 24);
        panel_3.add(lblNewLabel);
        
        JLabel lblNewLabel_4 = new JLabel("Name:");
        lblNewLabel_4.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_4.setBounds(39, 36, 70, 22);
        panel_3.add(lblNewLabel_4);
        
        
        textField = new JTextField();
        textField.setBounds(109, 31, 423, 26);
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
        	
        	obj.setName(textField.getText());
        });
        
        
        JLabel lblNewLabel_5 = new JLabel("Address:");
        lblNewLabel_5.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_5.setBounds(39, 66, 90, 22);
        panel_3.add(lblNewLabel_5);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(127, 61, 437, 26);
        panel_3.add(textField_1);
        
        
        
        textField_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        textField_1.addActionListener(e -> {
        	
        	obj.setCustomerAddress(textField_1.getText());
        });
        
        
        JLabel lblNewLabel_6 = new JLabel("Contact Number:");
        lblNewLabel_6.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_6.setBounds(547, 36, 176, 22);
        panel_3.add(lblNewLabel_6);
        
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(721, 31, 232, 26);
        panel_3.add(textField_3);
        
        textField_3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        textField_3.addActionListener(e -> {
        	
        	obj.setContactNumber(textField_3.getText());
        });
        
        
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_7.setBounds(999, 27, 75, 38);
        panel_3.add(btnNewButton_7);
        
        btnNewButton_7.addActionListener(e -> {
            // Step 1: Retrieve values from text fields
            String customerName = textField.getText();
            String address = textField_1.getText();
            String contactNumber = textField_3.getText();

            // Step 2: Database connection details
            String url = "jdbc:mysql://localhost:3306/flowstation_db"; // Correct DB URL
            String username = "root"; // Ensure this is the correct MySQL username
            String password = ""; // Correct MySQL password

            // Step 3: SQL query to insert a new customer record
            String sql = "INSERT INTO customer (Customer_Name, Address, Contact_Number) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                // Step 4: Set the parameters for the SQL query (correct order)
                stmt.setString(1, customerName);
                stmt.setString(2, address);  // Set Address correctly
                stmt.setString(3, contactNumber);  // Set Contact Number correctly

                // Step 5: Execute the insert query
                int rowsAffected = stmt.executeUpdate();

                // Step 6: Provide feedback to the user
                if (rowsAffected > 0) {
                    // Successfully inserted the customer
                    JOptionPane.showMessageDialog(null, "Customer added successfully!");

                    // Clear the text fields after the operation
                    textField.setText("");
                    textField_1.setText("");
                    textField_3.setText("");

                    // Step 7: Refresh the JTable with new data, ordered by CustomerID
                    String selectSql = "SELECT * FROM customer ORDER BY CustomerID"; // Query to get all customers, ordered by CustomerID
                    try (Statement selectStmt = conn.createStatement();
                         ResultSet rs = selectStmt.executeQuery(selectSql)) {

                        // Get the model of the JTable
                        DefaultTableModel model = (DefaultTableModel) table.getModel();

                        // Clear existing rows in the JTable
                        model.setRowCount(0);

                        // Add new rows from the ResultSet
                        while (rs.next()) {
                            int customerId = rs.getInt("CustomerID");
                            String customerNameFromDb = rs.getString("Customer_Name");
                            String addressFromDb = rs.getString("Address");
                            String contactNumberFromDb = rs.getString("Contact_Number");

                            // Add the row to the table model
                            model.addRow(new Object[]{customerId, customerNameFromDb, addressFromDb, contactNumberFromDb});
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage());
                    }
                } else {
                    // Failed to insert the customer
                    JOptionPane.showMessageDialog(null, "Failed to add customer.");
                }
            } catch (SQLException ex) {
                // Handle database-related errors
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });

        //update customer panel
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBounds(286, 557, 1092, 119);
        backgroundLabel.add(panel_4);
        
        JLabel lblUpdateCustomerDeta = new JLabel("UPDATE CUSTOMER DETAILS:        ");
        lblUpdateCustomerDeta.setFont(new Font("Myanmar Text", Font.BOLD, 21));
        lblUpdateCustomerDeta.setBounds(6, 13, 337, 24);
        panel_4.add(lblUpdateCustomerDeta);
        
        
        JLabel lblNewLabel_7 = new JLabel("Name:");
        lblNewLabel_7.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_7.setBounds(21, 42, 70, 22);
        panel_4.add(lblNewLabel_7);
        
        JComboBox<String> comboBox = new JComboBox();
        comboBox.setBounds(89, 37, 423, 26);
        panel_4.add(comboBox);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            String query = "SELECT Customer_Name FROM customer";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add a default empty option
            comboBox.addItem("");

            while (rs.next()) {
                String adminName = rs.getString("Customer_Name");
                comboBox.addItem(adminName); // Add each admin name to the combo box
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching data for the combo box: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        comboBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        comboBox.addActionListener(e -> {
        	
        	obj.setName((String)comboBox.getSelectedItem());
        });
        
        
        JLabel lblNewLabel_9 = new JLabel("Address:");
        lblNewLabel_9.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_9.setBounds(21, 73, 90, 22);
        panel_4.add(lblNewLabel_9);
        
        
        textField_4 = new JTextField();
        textField_4.setBounds(111, 68, 442, 26);
        panel_4.add(textField_4);
        textField_4.setColumns(10);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer_Name = (String) comboBox.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textField_4.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Address FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Address = rs.getString("Address");
                        textField_4.setText(Address); // Set the password in the text field
                    } else {
                    	textField_4.setText(""); // Clear the password field if no password is found
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
        
        textField_4.addActionListener(e -> {
        	
        	obj.setCustomerAddress(textField_4.getText());
        });
        
        
        JLabel lblNewLabel_10 = new JLabel("Contact Number:");
        lblNewLabel_10.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_10.setBounds(577, 42, 176, 22);
        panel_4.add(lblNewLabel_10);
        
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(747, 37, 232, 26);
        panel_4.add(textField_5);
        

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer_Name = (String) comboBox.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textField_5.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Contact_Number FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Contact_Number = rs.getString("Contact_Number");
                        textField_5.setText(Contact_Number); // Set the password in the text field
                    } else {
                    	textField_5.setText(""); // Clear the password field if no password is found
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
        
        textField_5.addActionListener(e -> {
        	
        	obj.setContactNumber(textField_5.getText());
        });
        

        JLabel lblNewLabel_11 = new JLabel("Container L:");
        lblNewLabel_11.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        lblNewLabel_11.setBounds(609, 73, 125, 22);
        panel_4.add(lblNewLabel_11);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(724, 68, 40, 26);
        panel_4.add(textField_2);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer_Name = (String) comboBox.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textField_2.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Lent_Large_Container FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Lent_Large_Container = String.valueOf(rs.getInt("Lent_Large_Container"));
                        textField_2.setText(Lent_Large_Container); // Set the password in the text field
                    } else {
                    	textField_2.setText(""); // Clear the password field if no password is found
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
        
        textField_2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                    
                    
                }
            }
        });
        
        textField_2.addActionListener(e -> {
        	
        	obj.setLargeLentContainer(Integer.valueOf(textField_2.getText()));
        });
        
        JLabel lblNewLabel_12 = new JLabel("M:");
        lblNewLabel_12.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        lblNewLabel_12.setBounds(793, 73, 25, 22);
        panel_4.add(lblNewLabel_12);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(822, 68, 40, 26);
        panel_4.add(textField_6);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer_Name = (String) comboBox.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textField_6.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Lent_Medium_Container FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Lent_Medium_Container = String.valueOf(rs.getInt("Lent_Medium_Container"));
                        textField_6.setText(Lent_Medium_Container); // Set the password in the text field
                    } else {
                    	textField_6.setText(""); // Clear the password field if no password is found
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
        textField_6.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        textField_6.addActionListener(e -> {
        	
        	obj.setMediumLentContainer(Integer.valueOf(textField_2.getText()));
        });
        
        
        
        JLabel lblNewLabel_13 = new JLabel("S:");
        lblNewLabel_13.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        lblNewLabel_13.setBounds(882, 73, 25, 22);
        panel_4.add(lblNewLabel_13);
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(904, 68, 40, 26);
        panel_4.add(textField_7);
        
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCustomer_Name = (String) comboBox.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textField_7.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Lent_Small_Container FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Lent_Small_Container = String.valueOf(rs.getInt("Lent_Small_Container"));
                        textField_7.setText(Lent_Small_Container); // Set the password in the text field
                    } else {
                    	textField_7.setText(""); // Clear the password field if no password is found
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
        textField_7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        textField_7.addActionListener(e -> {
        	
        	obj.setSmallLentContainer(Integer.valueOf(textField_7.getText()));
        });
        
        
        JButton btnNewButton_8 = new JButton("UPDATE");
        btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_8.setBounds(990, 42, 93, 35);
        panel_4.add(btnNewButton_8);
        
        btnNewButton_8.addActionListener(e -> {
            // Step 1: Get the selected customer name from the JComboBox
            String selectedCustomer = (String) comboBox.getSelectedItem();

            // Ensure a customer is selected
            if (selectedCustomer != null && !selectedCustomer.isEmpty()) {
                // Step 2: Use the custom Connections class to establish a database connection
                try (Connection conn = Connections.getConnection()) {  // Use your Connections class to get the connection
                    // Step 3: Retrieve the customer ID and other details based on the selected customer name
                    String getCustomerIdQuery = "SELECT CustomerID, Address, Contact_Number, Lent_Large_Container, Lent_Medium_Container, Lent_Small_Container FROM customer WHERE Customer_Name = ?";
                    int customerId = -1;
                    String address = "";
                    String contactNumber = "";
	                    int lentLargeContainer = 0;
	                    int lentMediumContainer = 0;
                    int lentSmallContainer = 0;

                    // Step 4: Get the current details of the selected customer
                    try (PreparedStatement stmt = conn.prepareStatement(getCustomerIdQuery)) {
                        stmt.setString(1, selectedCustomer);
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            customerId = rs.getInt("CustomerID");
                            address = rs.getString("Address");
                            contactNumber = rs.getString("Contact_Number");
                            lentLargeContainer = rs.getInt("Lent_Large_Container");
                            lentMediumContainer = rs.getInt("Lent_Medium_Container");
                            lentSmallContainer = rs.getInt("Lent_Small_Container");

                            // Update text fields with the existing data
                            textField_1.setText(address);  // Address field
                            textField_2.setText(contactNumber);  // Contact number field
                            textField_3.setText(String.valueOf(lentLargeContainer));  // Lent large container
                            textField_4.setText(String.valueOf(lentMediumContainer));  // Lent medium container
                            textField_5.setText(String.valueOf(lentSmallContainer));  // Lent small container
                        }
                    }

                    // Step 5: Retrieve updated values from text fields
                    String updatedAddress = textField_1.getText();
                    String updatedContactNumber = textField_2.getText();

                    // Parse integers for containers, ensure proper conversion
                    int updatedLentLargeContainer = 0;
                    int updatedLentMediumContainer = 0;
                    int updatedLentSmallContainer = 0;

                    try {
                        updatedLentLargeContainer = Integer.parseInt(textField_3.getText());
                    } catch (NumberFormatException ex) {
                        // Handle invalid input, e.g., show a warning or set default value
                        JOptionPane.showMessageDialog(null, "Invalid value for Lent Large Container. Setting to 0.");
                        updatedLentLargeContainer = 0;
                    }

                    try {
                        updatedLentMediumContainer = Integer.parseInt(textField_4.getText());
                    } catch (NumberFormatException ex) {
                        // Handle invalid input, e.g., show a warning or set default value
                        JOptionPane.showMessageDialog(null, "Invalid value for Lent Medium Container. Setting to 0.");
                        updatedLentMediumContainer = 0;
                    }

                    try {
                        updatedLentSmallContainer = Integer.parseInt(textField_5.getText());
                    } catch (NumberFormatException ex) {
                        // Handle invalid input, e.g., show a warning or set default value
                        JOptionPane.showMessageDialog(null, "Invalid value for Lent Small Container. Setting to 0.");
                        updatedLentSmallContainer = 0;
                    }

                    // Step 6: Update the database with the new customer details
                    String updateCustomerQuery = "UPDATE customer SET Address = ?, Contact_Number = ?, Lent_Large_Container = ?, Lent_Medium_Container = ?, Lent_Small_Container = ? WHERE CustomerID = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateCustomerQuery)) {
                        updateStmt.setString(1, updatedAddress);
                        updateStmt.setString(2, updatedContactNumber);  // Set the correct contact number
                        updateStmt.setInt(3, updatedLentLargeContainer);
                        updateStmt.setInt(4, updatedLentMediumContainer);
                        updateStmt.setInt(5, updatedLentSmallContainer);
                        updateStmt.setInt(6, customerId);  // Use the customer ID to update the record

                        int rowsUpdated = updateStmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            JOptionPane.showMessageDialog(null, "Customer updated successfully!");

                            // Step 7: Update the JTable directly without refreshing it fully
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            for (int i = 0; i < model.getRowCount(); i++) {
                                // Check if the row corresponds to the updated customer
                                String customerNameInTable = (String) model.getValueAt(i, 1);  // Assuming customer name is in the second column
                                if (customerNameInTable.equals(selectedCustomer)) {
                                    // Update the row data in the correct columns:
                                    model.setValueAt(updatedAddress, i, 3);  // Update address (assuming it's in the 4th column)
                                    model.setValueAt(updatedContactNumber, i, 4);  // Update contact number (column 5)
                                    model.setValueAt(updatedLentLargeContainer, i, 5);  // Update large container (column 6)
                                    model.setValueAt(updatedLentMediumContainer, i, 6);  // Update medium container (column 7)
                                    model.setValueAt(updatedLentSmallContainer, i, 7);  // Update small container (column 8)
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update customer.");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a customer to update.");
            }
        });






        //delete customer panel
        JPanel panel_5 = new JPanel();
        panel_5.setLayout(null);
        panel_5.setBounds(286, 683, 1092, 52);
        backgroundLabel.add(panel_5);
        
        JLabel lblDeleteCustomer = new JLabel("DELETE CUSTOMER:");
        lblDeleteCustomer.setFont(new Font("Myanmar Text", Font.BOLD, 21));
        lblDeleteCustomer.setBounds(6, 17, 212, 24);
        panel_5.add(lblDeleteCustomer);
        
        JLabel lblNewLabel_14 = new JLabel("Name/ID:");
        lblNewLabel_14.setFont(new Font("Myanmar Text", Font.BOLD, 20));
        lblNewLabel_14.setBounds(316, 19, 108, 22);
        panel_5.add(lblNewLabel_14);
        
        JComboBox<String> comboBox_1 = new JComboBox();
        comboBox_1.setBounds(414, 15, 428, 26);
        panel_5.add(comboBox_1);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            String query = "SELECT Customer_Name FROM customer";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add a default empty option
            comboBox_1.addItem("");

            while (rs.next()) {
                String adminName = rs.getString("Customer_Name");
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
        //should drop down names from database------------------------------------------
        
        comboBox_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
        comboBox_1.addActionListener(e -> {
        	
        	obj.setName(String.valueOf(comboBox_1.getSelectedItem()));
        });
        
        
        JButton btnNewButton_9 = new JButton("DELETE");
        btnNewButton_9.setBounds(1000, 6, 82, 41);
        panel_5.add(btnNewButton_9);
        btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_9.addActionListener(e -> {
            // Step 1: Get the selected customer name from the JComboBox
            String selectedCustomer = (String) comboBox_1.getSelectedItem();

            // Ensure a customer is selected before proceeding
            if (selectedCustomer != null && !selectedCustomer.isEmpty()) {
                // Step 2: Database connection details
                String url = "jdbc:mysql://localhost:3306/flowstation_db"; // Correct DB URL
                String username = "root"; // Correct MySQL username
                String password = ""; // Correct MySQL password

                try (Connection conn = DriverManager.getConnection(url, username, password)) {
                    // Step 3: Fetch the customer ID based on customer name
                    String getCustomerIdQuery = "SELECT CustomerID FROM customer WHERE Customer_Name = ?";
                    int customerId = -1;
                    try (PreparedStatement stmt = conn.prepareStatement(getCustomerIdQuery)) {
                        stmt.setString(1, selectedCustomer);
                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                            customerId = rs.getInt("CustomerID"); // Get CustomerID
                        }
                    }

                    // If customer ID is found, proceed with deletion
                    if (customerId != -1) {
                        // Step 4: Delete related sales records first (Cascade delete or handling foreign key)
                        String deleteSalesQuery = "DELETE FROM sales WHERE CustomerID = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(deleteSalesQuery)) {
                            stmt.setInt(1, customerId);
                            stmt.executeUpdate();
                        }

                        // Step 5: Delete the customer record from the database
                        String deleteCustomerQuery = "DELETE FROM customer WHERE CustomerID = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(deleteCustomerQuery)) {
                            stmt.setInt(1, customerId);
                            int rowsAffected = stmt.executeUpdate();

                            if (rowsAffected > 0) {
                                // Step 6: Provide feedback that the customer has been deleted
                                JOptionPane.showMessageDialog(null, "Customer deleted successfully!");

                                // Step 7: Remove the deleted customer from the JComboBox
                                comboBox_1.removeItem(selectedCustomer);
                                comboBox_1.setSelectedItem(null); // Reset the selection

                                // Step 8: Remove the row from the JTable without needing to refresh
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                for (int i = 0; i < model.getRowCount(); i++) {
                                    // Assuming customer name is in the first column (index 0)
                                    String customerNameInTable = (String) model.getValueAt(i, 0);
                                    if (customerNameInTable.equals(selectedCustomer)) {
                                        model.removeRow(i); // Remove the row
                                        break; // Exit the loop once the row is removed
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete customer.");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a customer to delete.");
            }
        });

        backgroundLabel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table, panel, lblNewLabel_3, panel_1, lblNewLabel_1, lblNewLabel_2, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_7, btnNewButton_3, btnNewButton_4, btnNewButton_5, btnNewButton_6, panel_2, scrollPane, panel_3, lblNewLabel, lblNewLabel_4, lblNewLabel_5, textField, textField_1, lblNewLabel_6, textField_3, panel_4, lblNewLabel_7, lblUpdateCustomerDeta, comboBox, lblNewLabel_9, textField_4, lblNewLabel_10, textField_5, btnNewButton_8, lblNewLabel_11, lblNewLabel_12, lblNewLabel_13, textField_2, textField_6, textField_7, panel_5, lblDeleteCustomer, lblNewLabel_14, btnNewButton_9, comboBox_1}));
        
        
    }
}
