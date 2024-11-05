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

public class Customers extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 785);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Customers.class.getResource("/gui/Main.png")));
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Customers.class.getResource("/gui/Logo_Small.png")));
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
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(16, 68, 160));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_1.setBounds(0, 285, 238, 50);
        panel_1.add(btnNewButton_1);
        
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
        panel_2.setBounds(246, 125, 1169, 323);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 1147, 303);
        panel_2.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"", null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"Customer ID", "Customer Name", "Address", "Contact Number", "Lent Large Containers", "Lent Medium Containers", "Lent Small Containers"
        	}
        ));
        table.setBounds(10, 24, 1147, 276);
        scrollPane.add(table);
        
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBounds(286, 456, 1092, 94);
        backgroundLabel.add(panel_3);
        
        JLabel lblNewLabel = new JLabel("ADD CUSTOMER:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblNewLabel.setBounds(10, 10, 139, 20);
        panel_3.add(lblNewLabel);
        
        JLabel lblNewLabel_4 = new JLabel("Name:");
        lblNewLabel_4.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4.setBounds(20, 37, 45, 15);
        panel_3.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("Address:");
        lblNewLabel_4_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_1.setBounds(20, 62, 58, 15);
        panel_3.add(lblNewLabel_4_1);
        
        textField = new JTextField();
        textField.setBounds(81, 33, 414, 19);
        panel_3.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(81, 58, 413, 19);
        panel_3.add(textField_1);
        
        JLabel lblNewLabel_4_2 = new JLabel("Contact Number:");
        lblNewLabel_4_2.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_2.setBounds(560, 38, 117, 15);
        panel_3.add(lblNewLabel_4_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(679, 36, 292, 19);
        panel_3.add(textField_3);
        
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton_7.setBounds(985, 36, 85, 41);
        panel_3.add(btnNewButton_7);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBounds(286, 557, 1092, 119);
        backgroundLabel.add(panel_4);
        
        JLabel lblNewLabel_4_3 = new JLabel("Name:");
        lblNewLabel_4_3.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_3.setBounds(21, 43, 45, 15);
        panel_4.add(lblNewLabel_4_3);
        
        JLabel lblUpdateCustomerDeta = new JLabel("UPDATE CUSTOMER DETAILS:        ");
        lblUpdateCustomerDeta.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblUpdateCustomerDeta.setBounds(10, 13, 335, 20);
        panel_4.add(lblUpdateCustomerDeta);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(89, 38, 427, 21);
        panel_4.add(comboBox);
        
        JLabel lblNewLabel_4_3_1 = new JLabel("Address:");
        lblNewLabel_4_3_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_3_1.setBounds(21, 83, 58, 15);
        panel_4.add(lblNewLabel_4_3_1);
        
        textField_4 = new JTextField();
        textField_4.setBounds(89, 79, 403, 19);
        panel_4.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel lblNewLabel_4_2_1 = new JLabel("Contact Number:");
        lblNewLabel_4_2_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_2_1.setBounds(565, 43, 117, 15);
        panel_4.add(lblNewLabel_4_2_1);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(681, 39, 306, 19);
        panel_4.add(textField_5);
        
        JButton btnNewButton_7_1 = new JButton("UPDATE");
        btnNewButton_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_7_1.setBounds(997, 41, 85, 31);
        panel_4.add(btnNewButton_7_1);
        
        JLabel lblNewLabel_4_2_1_1 = new JLabel("Container L:");
        lblNewLabel_4_2_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_2_1_1.setBounds(596, 82, 86, 15);
        panel_4.add(lblNewLabel_4_2_1_1);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(689, 75, 20, 20);
        panel_4.add(lblNewLabel_5);
        
        JLabel lblNewLabel_4_2_1_1_1 = new JLabel("M:");
        lblNewLabel_4_2_1_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_2_1_1_1.setBounds(741, 83, 20, 15);
        panel_4.add(lblNewLabel_4_2_1_1_1);
        
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setBounds(771, 79, 20, 20);
        panel_4.add(lblNewLabel_5_1);
        
        JLabel lblNewLabel_4_2_1_1_1_1 = new JLabel("S:");
        lblNewLabel_4_2_1_1_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_2_1_1_1_1.setBounds(845, 82, 20, 15);
        panel_4.add(lblNewLabel_4_2_1_1_1_1);
        
        JLabel lblNewLabel_5_1_1 = new JLabel("");
        lblNewLabel_5_1_1.setBounds(869, 83, 20, 20);
        panel_4.add(lblNewLabel_5_1_1);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setLayout(null);
        panel_4_1.setBounds(286, 683, 1092, 52);
        backgroundLabel.add(panel_4_1);
        
        JLabel lblDeleteCustomer = new JLabel("DELETE CUSTOMER:");
        lblDeleteCustomer.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblDeleteCustomer.setBounds(8, 15, 150, 20);
        panel_4_1.add(lblDeleteCustomer);
        
        JLabel lblNewLabel_4_3_2 = new JLabel("Name/ID:");
        lblNewLabel_4_3_2.setFont(new Font("Myanmar Text", Font.BOLD, 14));
        lblNewLabel_4_3_2.setBounds(220, 19, 93, 17);
        panel_4_1.add(lblNewLabel_4_3_2);
        
        JButton btnNewButton_7_1_1 = new JButton("DELETE");
        btnNewButton_7_1_1.setBounds(984, 7, 85, 31);
        panel_4_1.add(btnNewButton_7_1_1);
        btnNewButton_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(299, 14, 515, 21);
        panel_4_1.add(comboBox_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(1112, 487, 236, 19);
        contentPane.add(textField_2);
        
        
    }
}
