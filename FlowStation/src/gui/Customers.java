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
      //sql command to get values and insert to table
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
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Customer ID", "Customer Name", "Address", "Contact Number", "Lent Large Containers", "Lent Medium Containers", "Lent Small Containers"
        	}
        ));
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
        	textField.postActionEvent();
        	textField_1.postActionEvent();
        	textField_3.postActionEvent();
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
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(89, 37, 423, 26);
        panel_4.add(comboBox);
        
      //should drop down names from database------------------------------------------
        
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
        
        textField_4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
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
        
        textField_5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
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
        	//comboBox.postActionEvent();
        	textField_4.postActionEvent();
        	textField_5.postActionEvent();
        	textField_2.postActionEvent();
        	textField_6.postActionEvent();
        	textField_7.postActionEvent();
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
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(422, 13, 428, 26);
        panel_5.add(comboBox_1);
        
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
        	//comboBox_1.postActionEvent();
        });
        
        
        
        backgroundLabel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{table, panel, lblNewLabel_3, panel_1, lblNewLabel_1, lblNewLabel_2, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_7, btnNewButton_3, btnNewButton_4, btnNewButton_5, btnNewButton_6, panel_2, scrollPane, panel_3, lblNewLabel, lblNewLabel_4, lblNewLabel_5, textField, textField_1, lblNewLabel_6, textField_3, panel_4, lblNewLabel_7, lblUpdateCustomerDeta, comboBox, lblNewLabel_9, textField_4, lblNewLabel_10, textField_5, btnNewButton_8, lblNewLabel_11, lblNewLabel_12, lblNewLabel_13, textField_2, textField_6, textField_7, panel_5, lblDeleteCustomer, lblNewLabel_14, btnNewButton_9, comboBox_1}));
        
        
    }
}
