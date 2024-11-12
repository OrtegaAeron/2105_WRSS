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
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Toolkit;

public class AdminSettings extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;
    private JTextField textField;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;

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
        	},
        	new String[] {
        		"Admin ID", "Admin User Name", "Password"
        	}
        ));
        table.setBounds(0, 0, 1147, 303);
        scrollPane.setViewportView(table);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(488, 455, 682, 93);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("ADD ADMIN:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 10, 98, 30);
        panel_3.add(lblNewLabel);
        
        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName.setBounds(35, 35, 49, 30);
        panel_3.add(lblName);
        
        textField = new JTextField();
        textField.setBounds(116, 39, 438, 19);
        panel_3.add(textField);
        textField.setColumns(10);
        
        JLabel lblPassworf = new JLabel("Password:");
        lblPassworf.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblPassworf.setBounds(35, 63, 68, 30);
        panel_3.add(lblPassworf);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(117, 67, 438, 19);
        panel_3.add(passwordField);
        
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        btnNewButton_7.setBounds(574, 35, 85, 30);
        panel_3.add(btnNewButton_7);
        
        JPanel panel_3_2 = new JPanel();
        panel_3_2.setBounds(488, 658, 683, 76);
        backgroundLabel.add(panel_3_2);
        panel_3_2.setLayout(null);
        
        JLabel lblDeleteAdmin = new JLabel("DELETE ADMIN:");
        lblDeleteAdmin.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblDeleteAdmin.setBounds(10, 10, 122, 30);
        panel_3_2.add(lblDeleteAdmin);
        
        JLabel lblName_1_1 = new JLabel("Name:");
        lblName_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName_1_1.setBounds(34, 34, 49, 30);
        panel_3_2.add(lblName_1_1);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(347, 35, 0, 21);
        panel_3_2.add(comboBox);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(121, 39, 437, 21);
        panel_3_2.add(comboBox_1);
        
        JButton btnNewButton_7_1_1 = new JButton("DELETE");
        btnNewButton_7_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        btnNewButton_7_1_1.setBounds(575, 33, 97, 30);
        panel_3_2.add(btnNewButton_7_1_1);
        
        JPanel panel_3_1 = new JPanel();
        backgroundLabel.add(panel_3_1);
        panel_3_1.setBounds(489, 556, 682, 93);
        panel_3_1.setLayout(null);
        
        JLabel lblUpdateAdminDetails = new JLabel("UPDATE ADMIN DETAILS:");
        lblUpdateAdminDetails.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblUpdateAdminDetails.setBounds(10, 10, 192, 30);
        panel_3_1.add(lblUpdateAdminDetails);
        
        JLabel lblName_1 = new JLabel("Name:");
        lblName_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblName_1.setBounds(31, 32, 49, 30);
        panel_3_1.add(lblName_1);
        
        JLabel lblPassworf_1 = new JLabel("Password:");
        lblPassworf_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblPassworf_1.setBounds(31, 60, 68, 30);
        panel_3_1.add(lblPassworf_1);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(117, 64, 420, 19);
        panel_3_1.add(passwordField_1);
        
        JButton btnNewButton_7_1 = new JButton("UPDATE");
        btnNewButton_7_1.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        btnNewButton_7_1.setBounds(575, 32, 97, 30);
        panel_3_1.add(btnNewButton_7_1);
        
        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setBounds(116, 35, 440, 21);
        panel_3_1.add(comboBox_1_1);
        
        
    }
}
