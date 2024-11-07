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

public class Pricing extends JFrame {

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
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 47));
        lblNewLabel.setBounds(39, 25, 487, 55);
        panel_2.add(lblNewLabel);
        
        JLabel lblNewLabel_6 = new JLabel("₱ 5.00");
        lblNewLabel_6.setForeground(new Color(0, 0, 0));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel_6.setBounds(520, 24, 195, 57);
        panel_2.add(lblNewLabel_6);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(225, 225, 225));
        panel_7.setBounds(520, 24, 195, 57);
        panel_2.add(panel_7);
        
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
        
        JButton btnNewButton_7 = new JButton("UPDATE\r\n");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_7.setBounds(257, 53, 91, 34);
        panel_3.add(btnNewButton_7);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(500, 420, 665, 87);
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblNewLabel_5_1 = new JLabel("5gl/Large Containers Price:\r\n");
        lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1.setBounds(11, 26, 486, 34);
        panel_4.add(lblNewLabel_5_1);
        
        JLabel lblNewLabel_6_1 = new JLabel("₱ 25.00");
        lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_6_1.setBounds(490, 22, 163, 47);
        panel_4.add(lblNewLabel_6_1);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(225, 225, 225));
        panel_8.setBounds(490, 22, 163, 47);
        panel_4.add(panel_8);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(500, 519, 665, 87);
        backgroundLabel.add(panel_5);
        panel_5.setLayout(null);
        
        JLabel lblNewLabel_5_1_1 = new JLabel("3gl/Medium Containers Price:\r\n");
        lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1_1.setBounds(11, 26, 501, 34);
        panel_5.add(lblNewLabel_5_1_1);
        
        JLabel lblNewLabel_6_1_1 = new JLabel("₱ 15.00");
        lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6_1_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_6_1_1.setBounds(490, 22, 163, 47);
        panel_5.add(lblNewLabel_6_1_1);
        
        JPanel panel_8_1 = new JPanel();
        panel_8_1.setBackground(new Color(225, 225, 225));
        panel_8_1.setBounds(490, 22, 163, 47);
        panel_5.add(panel_8_1);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(500, 620, 665, 87);
        backgroundLabel.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_5_1_1_1 = new JLabel("2.5gl/Small Containers Price:\r\n");
        lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblNewLabel_5_1_1_1.setBounds(11, 26, 501, 34);
        panel_6.add(lblNewLabel_5_1_1_1);
        
        JLabel lblNewLabel_6_1_1_1 = new JLabel("₱ 10.50");
        lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6_1_1_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_6_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_6_1_1_1.setBounds(490, 22, 163, 47);
        panel_6.add(lblNewLabel_6_1_1_1);
        
        JPanel panel_8_1_1 = new JPanel();
        panel_8_1_1.setBackground(new Color(225, 225, 225));
        panel_8_1_1.setBounds(490, 22, 163, 47);
        panel_6.add(panel_8_1_1);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBounds(547, 345, 45, 13);
        contentPane.add(lblNewLabel_4);
        
        
    }
}
