package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.sql.*;

import dbConnections.Connections;
import backend.ContainerInventory;

public class Inventory extends JFrame {
	
	ContainerInventory obj = new ContainerInventory();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
    public void run() {
                try {
                	Inventory frame = new Inventory();
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
    public Inventory() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inventory.class.getResource("/resources/Logo_Small.png")));
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
        JLabel backgroundLabel = new JLabel(new ImageIcon(Inventory.class.getResource("/resources/Main.png")));
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
        JLabel lblNewLabel_3 = new JLabel("Inventory");
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Inventory.class.getResource("/resources/Logo_Small.png")));
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
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBackground(new Color(16, 68, 160));
        btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_2.setBounds(0, 326, 238, 50);
        panel_1.add(btnNewButton_2);
        
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
        panel_2.setBounds(290, 129, 1093, 310);
        panel_2.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(9, 11, 1075, 290);
        panel_2.add(scrollPane);

        table = new JTable();
        // SQL command to get values and insert to table
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {"  1", "   5gl / Large Container", "   ", "   ", "   "},
                {"  2", "   3gl / Medium Container", "   ", "   ", "   "},
                {"  3", "   2.5gl / Small Container", "   ", "   ", "  "},
            },
            new String[] {
                "Inventory ID", "Container", "In-Storage Quantity", "Lent Quantity", "Total Quantity"
            }
        ));
        
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            // SQL query to fetch admin details
            String query = "SELECT InventoryID, Container_Type, In_Storage_Quantity, Lent_Quantity, Total_Quantity FROM inventory";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Get the table's model
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Clear any existing rows
            model.setRowCount(0);

            // Populate the table model with data from the ResultSet
            while (rs.next()) {
                int inventoryID = rs.getInt("InventoryID");
                String container = rs.getString("Container_Type");
                int inStorageQuantity = rs.getInt("In_Storage_Quantity");
                int lentQuantity = rs.getInt("Lent_Quantity");
                int totalQuantity = rs.getInt ("Total_Quantity");
                

                // Add a new row to the table
                model.addRow(new Object[]{inventoryID, container, inStorageQuantity,lentQuantity, totalQuantity});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching admin data: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }

        // Set column widths to allow header text to fit
        table.getColumnModel().getColumn(0).setPreferredWidth(200); // Adjust width for Inventory ID column
        table.getColumnModel().getColumn(1).setPreferredWidth(400); // Adjust width for Container column
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Adjust width for In-Storage Quantity column
        table.getColumnModel().getColumn(3).setPreferredWidth(150); // Adjust width for Lent Quantity column
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // Adjust width for Total Quantity column

        // Set header font size and height
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 18));  // Increase the font size of the header
        table.getTableHeader().setPreferredSize(new Dimension(0, 60));  // Increase the header height

        // Adjust row height based on available space
        int rowCount = table.getRowCount();
        int scrollPaneHeight = scrollPane.getHeight();
        if (rowCount > 0) {
            int rowHeight = scrollPaneHeight / rowCount;
            table.setRowHeight(rowHeight - 20);  // Adjust the row height
        }

        // Add the table to the scroll pane
        scrollPane.setViewportView(table);


        //add new containers panel
        JPanel panel_3 = new JPanel();
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        panel_3.setBounds(290, 451, 537, 282);
        
        JLabel lblNewLabel = new JLabel("ADD NEW CONTAINERS:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 30));
        lblNewLabel.setBounds(18, 18, 382, 36);
        panel_3.add(lblNewLabel);
        
        
        JLabel lblAddLargeContainer = new JLabel("5gl/L Container:");
        lblAddLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblAddLargeContainer.setBounds(18, 71, 271, 36);
        panel_3.add(lblAddLargeContainer);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1.setBounds(215, 64, 298, 48);
        panel_3.add(spinner_1);
        
        spinner_1.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_1.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_1.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_1.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_1.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblAddMediumContainer = new JLabel("3gl/M Container:");
        lblAddMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblAddMediumContainer.setBounds(18, 132, 287, 36);
        panel_3.add(lblAddMediumContainer);
        
        JSpinner spinner_2 = new JSpinner();
        spinner_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_2.setBounds(215, 125, 298, 48);
        panel_3.add(spinner_2);
        
        spinner_2.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_2.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_2.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_2.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_2.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblAddSmallContainer = new JLabel("2.5gl/S Container:");
        lblAddSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblAddSmallContainer.setBounds(20, 194, 306, 36);
        panel_3.add(lblAddSmallContainer);
        
        JSpinner spinner_3 = new JSpinner();
        spinner_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_3.setBounds(215, 186, 298, 48);
        panel_3.add(spinner_3);
        
        spinner_3.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_3.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_3.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_3.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_3.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_7.setBounds(315, 240, 85, 28);
        panel_3.add(btnNewButton_7);
        
        btnNewButton_7.addActionListener(e -> {
        	//function add to value
        	obj.setContainerQuantityLarge((Integer)spinner_1.getValue());
        	obj.setContainerQuantityMedium((Integer)spinner_2.getValue());
        	obj.setContainerQuantitySmall((Integer)spinner_3.getValue());
        });
        

        //remove old containers panel
        JPanel panel_4 = new JPanel();
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        panel_4.setBounds(838, 451, 545, 282);
        
        JLabel lblRemoveOldContainers = new JLabel("REMOVE OLD CONTAINERS:");
        lblRemoveOldContainers.setFont(new Font("Myanmar Text", Font.BOLD, 30));
        lblRemoveOldContainers.setBounds(18, 18, 448, 36);
        panel_4.add(lblRemoveOldContainers);
        
        
        JLabel lblRmvLargeContainer = new JLabel("5gl/L Container:");
        lblRmvLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblRmvLargeContainer.setBounds(18, 71, 169, 35);
        panel_4.add(lblRmvLargeContainer);
        
        JSpinner spinner_4 = new JSpinner();
        spinner_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_4.setBounds(215, 64, 298, 48);
        panel_4.add(spinner_4);
        
        spinner_4.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_4.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_4.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_4.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_4.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblRmvMediumContainer = new JLabel("3gl/M Container:");
        lblRmvMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblRmvMediumContainer.setBounds(18, 132, 179, 35);
        panel_4.add(lblRmvMediumContainer);

        JSpinner spinner_5 = new JSpinner();
        spinner_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_5.setBounds(215, 125, 298, 48);
        panel_4.add(spinner_5);
        
        spinner_5.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_5.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_5.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_5.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_5.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblRmvSmallContainer = new JLabel("2.5gl/S Container:");
        lblRmvSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblRmvSmallContainer.setBounds(20, 194, 190, 35);
        panel_4.add(lblRmvSmallContainer);
        
        JSpinner spinner_6 = new JSpinner();
        spinner_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_6.setBounds(215, 186, 298, 48);
        panel_4.add(spinner_6);
        
        spinner_6.addChangeListener(e -> {
            try {
                // Get the spinner value
                int value = (Integer) spinner_6.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spinner_6.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spinner_6.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spinner_6.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JButton btnNewButton_8 = new JButton("REMOVE");
        btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_8.setBounds(315, 244, 103, 28);
        panel_4.add(btnNewButton_8);
        
        btnNewButton_8.addActionListener(e -> {
             //function decrease value
        	obj.getContainerQuantityLarge();
        	obj.getContainerQuantityMedium();
        	obj.getContainerQuantitySmall();
        });
    }
}
