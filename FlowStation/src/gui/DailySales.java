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
import java.awt.ScrollPane;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class DailySales extends JFrame {

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
                	DailySales frame = new DailySales();
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
    public DailySales() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(DailySales.class.getResource("/resources/Logo_Small.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 780);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(DailySales.class.getResource("/resources/Main.png")));
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
        JLabel lblNewLabel_3 = new JLabel("Daily Sales");
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(DailySales.class.getResource("/resources/Logo_Small.png")));
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
        btnNewButton_4.setForeground(new Color(255, 255, 255));
        btnNewButton_4.setBackground(new Color(16, 68, 160));
        btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_4.setBounds(0, 440, 238, 50);
        panel_1.add(btnNewButton_4);
        
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
        panel_2.setBounds(288, 130, 1079, 425);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 1060, 406);
        panel_2.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Daily Sales ID", "Customer ID", "Date", "Time", "Sold Large Containers", "Sold Medium Containers", "Sold Small Containers", "Delivery", "Total Fee"
        	}
        ));
        scrollPane.setViewportView(table);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(288, 562, 1079, 168);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblTodaysProfit = new JLabel("TODAYS PROFIT:");
        lblTodaysProfit.setFont(new Font("Myanmar Text", Font.BOLD, 25));
        lblTodaysProfit.setBounds(8, 9, 228, 35);
        panel_3.add(lblTodaysProfit);
        
        JPanel panel_7 = new JPanel();
        panel_7.setLayout(null);
        panel_7.setBackground(new Color(225, 225, 225));
        panel_7.setBounds(11, 35, 708, 123);
        panel_3.add(panel_7);
        
        JLabel lblSumOfAll = new JLabel("Sum Of All Customer Fees:");
        lblSumOfAll.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblSumOfAll.setBounds(32, 10, 343, 28);
        panel_7.add(lblSumOfAll);
        
        JLabel lblExpenses = new JLabel("Expenses:");
        lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblExpenses.setBounds(32, 35, 157, 28);
        panel_7.add(lblExpenses);
        
        JLabel lblEmployeesSalary = new JLabel("Employee's Salary:");
        lblEmployeesSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEmployeesSalary.setBounds(44, 61, 145, 28);
        panel_7.add(lblEmployeesSalary);
        
        JLabel lblEmployeeNo = new JLabel("No. of Employees:");
        lblEmployeeNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEmployeeNo.setBounds(44, 86, 178, 28);
        panel_7.add(lblEmployeeNo);
        
        JLabel lblNewLabel_4 = new JLabel("2");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBackground(new Color(225, 225, 225));
        lblNewLabel_4.setBounds(458, 86, 71, 27);
        panel_7.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("5.00");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_5.setBackground(new Color(225, 225, 225));
        lblNewLabel_5.setBounds(458, 120, 71, 27);
        panel_7.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("₱ ");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_6.setBackground(new Color(225, 225, 225));
        lblNewLabel_6.setBounds(458, 10, 83, 27);
        panel_7.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("₱ 500.00");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_7.setBackground(new Color(225, 225, 225));
        lblNewLabel_7.setBounds(458, 61, 71, 27);
        panel_7.add(lblNewLabel_7);
        
        JPanel panel_8 = new JPanel();
        panel_8.setLayout(null);
        panel_8.setBackground(new Color(225, 225, 225));
        panel_8.setBounds(735, 35, 334, 123);
        panel_3.add(panel_8);
        
        JLabel lblTotalProfit = new JLabel("Total Profit:\r\n");
        lblTotalProfit.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblTotalProfit.setBounds(6, 9, 236, 28);
        panel_8.add(lblTotalProfit);
        
        JLabel lblTotalProfit_Int = new JLabel("₱ ");
        lblTotalProfit_Int.setFont(new Font("Tahoma", Font.BOLD, 31));
        lblTotalProfit_Int.setBounds(89, 55, 161, 42);
        panel_8.add(lblTotalProfit_Int);
        
        
    }
}
