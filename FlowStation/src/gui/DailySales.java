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

public class DailySales extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTextField textField;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 785);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(DailySales.class.getResource("/gui/Main.png")));
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(DailySales.class.getResource("/gui/Logo_Small.png")));
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
        btnNewButton.setBounds(0, 228, 238, 50);
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
        btnNewButton_1.setBounds(0, 285, 238, 50);
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
        btnNewButton_2.setBounds(0, 342, 238, 50);
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
        btnNewButton_3.setBounds(0, 399, 238, 50);
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
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_4.setBounds(0, 456, 238, 50);
        panel_1.add(btnNewButton_4);
        
        //Sales Catalog Button
        JButton btnNewButton_5 = new JButton("Sales Catalog");
        btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_5.setBounds(0, 513, 238, 50);
        panel_1.add(btnNewButton_5);
        
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                SalesCatalog salesCatalogFrame = new SalesCatalog(); // Open the Customers frame
                salesCatalogFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Exit Button
        JButton btnNewButton_6 = new JButton("Exit");
        btnNewButton_6.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_6.setBounds(0, 606, 238, 50);
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
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(288, 562, 1079, 168);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblTodaysProfit = new JLabel("TODAYS PROFIT:");
        lblTodaysProfit.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblTodaysProfit.setBounds(10, 10, 185, 35);
        panel_3.add(lblTodaysProfit);
        
        JPanel panel_7 = new JPanel();
        panel_7.setLayout(null);
        panel_7.setBackground(new Color(225, 225, 225));
        panel_7.setBounds(20, 32, 643, 126);
        panel_3.add(panel_7);
        
        JLabel lblSumOfAll = new JLabel("Sum Of All Customer Fees:");
        lblSumOfAll.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblSumOfAll.setBounds(26, 10, 236, 28);
        panel_7.add(lblSumOfAll);
        
        JLabel lblExpenses = new JLabel("Expenses:");
        lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblExpenses.setBounds(47, 35, 102, 28);
        panel_7.add(lblExpenses);
        
        JLabel lblEmployeesSalary = new JLabel("Employee's Salary:");
        lblEmployeesSalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEmployeesSalary.setBounds(69, 61, 145, 28);
        panel_7.add(lblEmployeesSalary);
        
        JLabel lblgllargeContainers_1_1 = new JLabel("No. of Employees:");
        lblgllargeContainers_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1.setBounds(69, 86, 178, 28);
        panel_7.add(lblgllargeContainers_1_1);
        
        JLabel lblgllargeContainers_1_1_1 = new JLabel("Service Fee per container:");
        lblgllargeContainers_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1_1.setBounds(26, 119, 199, 28);
        panel_7.add(lblgllargeContainers_1_1_1);
        
        JLabel lblNewLabel_11_2 = new JLabel("2");
        lblNewLabel_11_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_2.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_2.setBounds(458, 87, 71, 27);
        panel_7.add(lblNewLabel_11_2);
        
        JLabel lblNewLabel_11_3 = new JLabel("5.00");
        lblNewLabel_11_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_3.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_3.setBounds(458, 120, 71, 27);
        panel_7.add(lblNewLabel_11_3);
        
        JLabel lblNewLabel_11_4 = new JLabel("₱ 1000.00");
        lblNewLabel_11_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_4.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_4.setBounds(458, 10, 83, 27);
        panel_7.add(lblNewLabel_11_4);
        
        JLabel lblNewLabel_11_4_1 = new JLabel("₱ 500.00");
        lblNewLabel_11_4_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_4_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_4_1.setBounds(458, 62, 71, 27);
        panel_7.add(lblNewLabel_11_4_1);
        
        JPanel panel_7_1 = new JPanel();
        panel_7_1.setLayout(null);
        panel_7_1.setBackground(new Color(225, 225, 225));
        panel_7_1.setBounds(673, 32, 396, 126);
        panel_3.add(panel_7_1);
        
        JLabel lblSumOfAll_1 = new JLabel("Total Profit:\r\n");
        lblSumOfAll_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblSumOfAll_1.setBounds(26, 10, 236, 28);
        panel_7_1.add(lblSumOfAll_1);
        
        JLabel lblgllargeContainers_1_1_1_1 = new JLabel("Service Fee per container:");
        lblgllargeContainers_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1_1_1.setBounds(26, 119, 199, 28);
        panel_7_1.add(lblgllargeContainers_1_1_1_1);
        
        JLabel lblNewLabel_11_3_1 = new JLabel("5.00");
        lblNewLabel_11_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_3_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_3_1.setBounds(458, 120, 71, 27);
        panel_7_1.add(lblNewLabel_11_3_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
        textField.setText("₱");
        textField.setBounds(87, 48, 252, 61);
        panel_7_1.add(textField);
        textField.setColumns(10);
        
        
    }
}
