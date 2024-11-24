package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.Toolkit;
import java.sql.*;

import dbConnections.Connections;
import backend.SalesCatalog_bcknd;

public class SalesCatalog extends JFrame {
	
	SalesCatalog_bcknd objSalesCat = new SalesCatalog_bcknd();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	SalesCatalog frame = new SalesCatalog();
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
    public SalesCatalog() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(SalesCatalog.class.getResource("/resources/Logo_Small.png")));
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
        JLabel backgroundLabel = new JLabel(new ImageIcon(SalesCatalog.class.getResource("/resources/Main.png")));
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
        JLabel lblNewLabel_3 = new JLabel("Sales Catalog");
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(SalesCatalog.class.getResource("/resources/Logo_Small.png")));
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
        btnNewButton_5.setForeground(new Color(255, 255, 255));
        btnNewButton_5.setBackground(new Color(16, 68, 160));
        btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_5.setBounds(0, 497, 238, 50);
        panel_1.add(btnNewButton_5);
        
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
        panel_2.setBounds(375, 132, 912, 77);
        panel_2.setLayout(null);
        
        
        textField = new JTextField();
        textField.setBounds(126, 17, 567, 50);
        panel_2.add(textField);
        textField.setColumns(10);
        
        //sql command to search for the date in this txt field
        
        
        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon(SalesCatalog.class.getResource("/resources/search.png")));
        lblNewLabel_6.setBounds(83, 20, 37, 42);
        panel_2.add(lblNewLabel_6);
        
        
        JButton btnNewButton_7 = new JButton();
        btnNewButton_7.setIcon(new ImageIcon(SalesCatalog.class.getResource("/resources/down.png")));
        btnNewButton_7.setBounds(703, 21, 40, 40);
        panel_2.add(btnNewButton_7);
        
        //drop down for calendar
        
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(247, 214, 970, 523);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 950, 503);
        panel_3.add(scrollPane);

        table = new JTable();
        // SQL command to get values and insert to table
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Daily Sales ID", "Customer ID", "Date", "Time", "Sold Large Containers", "Sold Medium Containers", "Sold Small Containers", "Delivery", "Total Fee", "Customer Payment", "Change"
        	}
        ));

     // Adjust the column widths based on the header text
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            int maxWidth = 0;

            // Get the header text width
            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComponent = headerRenderer.getTableCellRendererComponent(
                table, table.getColumnName(columnIndex), false, false, -1, columnIndex
            );
            maxWidth = Math.max(maxWidth, headerComponent.getPreferredSize().width);

            // Check each row in the table to determine the widest cell in that column
            for (int rowIndex = 0; rowIndex < table.getRowCount(); rowIndex++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(rowIndex, columnIndex);
                Component cellComponent = cellRenderer.getTableCellRendererComponent(
                    table, table.getValueAt(rowIndex, columnIndex), false, false, rowIndex, columnIndex
                );
                maxWidth = Math.max(maxWidth, cellComponent.getPreferredSize().width);
            }

            // Add some padding to the column width
            table.getColumnModel().getColumn(columnIndex).setPreferredWidth(maxWidth + 80);  // Increase padding to make the columns wider
        }

        // Customize header font, height, and alignment
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));  // Larger header font size
        table.getTableHeader().setPreferredSize(new Dimension(0, 60));  // Adjust header height

        // Override header rendering for centered text
        table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel("<html><div style='text-align: center;'>" + value.toString() + "</div></html>");
                label.setFont(new Font("SansSerif", Font.BOLD, 15));  // Header font
                label.setHorizontalAlignment(SwingConstants.CENTER);  // Center align text within JLabel
                label.setVerticalAlignment(SwingConstants.CENTER);  // Center align vertically
                label.setBorder(BorderFactory.createLineBorder(Color.GRAY));  // Optional: Add border
                label.setOpaque(true);  // Make background visible
                return label;
            }
        });

        // Set row height for better readability
        table.setRowHeight(50);

        // Add table to scroll pane
        scrollPane.setViewportView(table);



        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(1225, 214, 192, 523);
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("That Day's Profit:");
        lblNewLabel_4.setBounds(3, 18, 179, 34);
        panel_4.add(lblNewLabel_4);
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Myanmar Text", Font.BOLD, 21));
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(225, 225, 225));
        panel_5.setBounds(7, 49, 178, 327);
        panel_4.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Sum of all customer Fees:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(5, 10, 173, 16);
        panel_5.add(lblNewLabel);
        
        JLabel lblNewLabel_5 = new JLabel("₱ ");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_5.setBounds(12, 31, 19, 23);
        panel_5.add(lblNewLabel_5);
        
        JLabel lblExpenses = new JLabel("Expenses:");
        lblExpenses.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblExpenses.setBounds(5, 71, 136, 16);
        panel_5.add(lblExpenses);
        
        JLabel lblEmployeesSalary = new JLabel("Employee's Salary:");
        lblEmployeesSalary.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblEmployeesSalary.setBounds(19, 90, 180, 16);
        panel_5.add(lblEmployeesSalary);
        
        JLabel lblEmployeesSalary_Int = new JLabel("₱");
        lblEmployeesSalary_Int.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblEmployeesSalary_Int.setBounds(19, 106, 19, 23);
        panel_5.add(lblEmployeesSalary_Int);
        
        JLabel lblNoOfEmployees = new JLabel("No. of Employees:");
        lblNoOfEmployees.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNoOfEmployees.setBounds(19, 145, 180, 16);
        panel_5.add(lblNoOfEmployees);
        
        JLabel lblNoOfEmployees_Int = new JLabel("2");
        lblNoOfEmployees_Int.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNoOfEmployees_Int.setBounds(19, 166, 28, 23);
        panel_5.add(lblNoOfEmployees_Int);
        
        
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_5_1.setBounds(29, 31, 101, 23);
        panel_5.add(lblNewLabel_5_1);
        //value from database
        
        
        JLabel lblEmployeesSalary_Int_1 = new JLabel("500.00");
        lblEmployeesSalary_Int_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblEmployeesSalary_Int_1.setBounds(38, 106, 101, 23);
        panel_5.add(lblEmployeesSalary_Int_1);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(225, 225, 225));
        panel_6.setBounds(7, 386, 178, 123);
        panel_4.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblTotalProfit = new JLabel("Total Profit:");
        lblTotalProfit.setBounds(10, 10, 115, 23);
        lblTotalProfit.setFont(new Font("Tahoma", Font.BOLD, 19));
        panel_6.add(lblTotalProfit);
        
        JLabel lblTotalProfit_Int = new JLabel("₱ ");
        lblTotalProfit_Int.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblTotalProfit_Int.setBounds(8, 50, 34, 42);
        panel_6.add(lblTotalProfit_Int);
        
        JLabel lblTotalProfit_Int_1 = new JLabel("");
        lblTotalProfit_Int_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblTotalProfit_Int_1.setBounds(36, 50, 142, 42);
        panel_6.add(lblTotalProfit_Int_1);
        //value also from databse
        
        
    }
}
