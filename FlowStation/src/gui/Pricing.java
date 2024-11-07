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

public class Pricing extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 785);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Pricing.class.getResource("/gui/Main.png")));
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Pricing.class.getResource("/gui/Logo_Small.png")));
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
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(16, 68, 160));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_3.setBounds(0, 399, 238, 50);
        panel_1.add(btnNewButton_3);
        
        //Daily Sales Button
        JButton btnNewButton_4 = new JButton("Daily Sales");
        btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_4.setBounds(0, 456, 238, 50);
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
        panel_2.setBounds(455, 160, 753, 108);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Price per Gallon:\r\n");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel.setBounds(60, 35, 360, 49);
        panel_2.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setText("₱");
        textField.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField.setBounds(430, 43, 258, 41);
        panel_2.add(textField);
        textField.setColumns(10);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(630, 290, 404, 108);
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("Change Price per Gallon:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 27));
        lblNewLabel_5.setBounds(25, 10, 349, 34);
        panel_3.add(lblNewLabel_5);
        
        textField_1 = new JTextField();
        textField_1.setBounds(52, 54, 221, 34);
        panel_3.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btnNewButton_7 = new JButton("UPDATE\r\n");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_7.setBounds(277, 54, 82, 34);
        panel_3.add(btnNewButton_7);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(500, 420, 665, 87);
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_5_1 = new JLabel("5gl/Large Containers Price:\r\n");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1.setBounds(27, 27, 394, 34);
        panel_4.add(lblNewLabel_5_1);
        
        textField_2 = new JTextField();
        textField_2.setText("₱");
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_2.setColumns(10);
        textField_2.setBounds(467, 27, 176, 41);
        panel_4.add(textField_2);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(500, 519, 665, 87);
        backgroundLabel.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_5_1_1 = new JLabel("3gl/Medium Containers Price:\r\n");
        lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1_1.setBounds(29, 28, 426, 34);
        panel_5.add(lblNewLabel_5_1_1);
        
        textField_3 = new JTextField();
        textField_3.setText("₱");
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_3.setColumns(10);
        textField_3.setBounds(465, 28, 176, 41);
        panel_5.add(textField_3);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(500, 620, 665, 87);
        backgroundLabel.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_5_1_1_1 = new JLabel("2.5gl/Small Containers Price:\r\n");
        lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1_1_1.setBounds(31, 23, 426, 34);
        panel_6.add(lblNewLabel_5_1_1_1);
        
        textField_4 = new JTextField();
        textField_4.setText("₱");
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 22));
        textField_4.setColumns(10);
        textField_4.setBounds(467, 23, 176, 41);
        panel_6.add(textField_4);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBounds(547, 345, 45, 13);
        contentPane.add(lblNewLabel_4);
        
        
    }
}
