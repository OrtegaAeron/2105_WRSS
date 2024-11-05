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
import java.awt.List;

public class Transactions extends JFrame {

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
                	Transactions frame = new Transactions();
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
    public Transactions() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 785);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Transactions.class.getResource("/gui/Main.png")));
        backgroundLabel.setBackground(new Color(215, 215, 215));
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
        JLabel lblNewLabel_3 = new JLabel("Transactions");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 41));
        lblNewLabel_3.setBounds(438, 27, 296, 66);
        panel.add(lblNewLabel_3);
        
        //head panel
        JPanel panel_1 = new JPanel();
        panel_1.setForeground(new Color(255, 255, 255));
        panel_1.setBackground(new Color(65, 134, 255));
        panel_1.setBounds(0, 0, 238, 743);
        backgroundLabel.add(panel_1);
        panel_1.setLayout(null);
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Transactions.class.getResource("/gui/Logo_Small.png")));
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
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(16, 68, 160));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton.setBounds(0, 228, 238, 50);
        panel_1.add(btnNewButton);
        
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
        panel_2.setBounds(254, 133, 654, 240);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("CUSTOMER:");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(new Color(0, 0, 0));
        lblNewLabel_4.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblNewLabel_4.setBounds(10, 15, 199, 41);
        panel_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Name");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setForeground(Color.BLACK);
        lblNewLabel_5.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_5.setBounds(40, 72, 83, 29);
        panel_2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_7 = new JLabel("ContactNumber");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setForeground(Color.BLACK);
        lblNewLabel_7.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblNewLabel_7.setBounds(40, 186, 208, 30);
        panel_2.add(lblNewLabel_7);
        
        JLabel lblNewLabel_6 = new JLabel("Address");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setForeground(Color.BLACK);
        lblNewLabel_6.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_6.setBounds(40, 129, 112, 30);
        panel_2.add(lblNewLabel_6);
        
        textField = new JTextField();
        textField.setBounds(262, 52, 320, 49);
        panel_2.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(262, 110, 320, 49);
        panel_2.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(262, 168, 320, 49);
        panel_2.add(textField_2);
        
        JButton btnNewButton_7 = new JButton("*");
        btnNewButton_7.setToolTipText("");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_7.setBounds(592, 53, 45, 45);
        panel_2.add(btnNewButton_7);
        
        JPanel panel_3 = new JPanel();
        panel_3.setLayout(null);
        panel_3.setBounds(924, 133, 485, 238);
        backgroundLabel.add(panel_3);
        
        JLabel lblNewLabel_8 = new JLabel("SCHEDULE:");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setForeground(Color.BLACK);
        lblNewLabel_8.setFont(new Font("Myanmar Text", Font.BOLD, 33));
        lblNewLabel_8.setBounds(10, 15, 181, 41);
        panel_3.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("Date");
        lblNewLabel_9.setForeground(Color.BLACK);
        lblNewLabel_9.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_9.setBounds(40, 72, 83, 33);
        panel_3.add(lblNewLabel_9);
        
        JLabel lblNewLabel_10 = new JLabel("Time");
        lblNewLabel_10.setForeground(Color.BLACK);
        lblNewLabel_10.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_10.setBounds(40, 129, 83, 33);
        panel_3.add(lblNewLabel_10);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(117, 55, 295, 49);
        panel_3.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(117, 112, 295, 49);
        panel_3.add(textField_4);
        
        JButton btnNewButton_8 = new JButton("*");
        btnNewButton_8.setToolTipText("");
        btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_8.setBounds(422, 55, 45, 45);
        panel_3.add(btnNewButton_8);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(40, 183, 20, 33);
        panel_3.add(chckbxNewCheckBox);
        
        JTextArea txtrNote = new JTextArea();
        txtrNote.setFont(new Font("Monospaced", Font.PLAIN, 11));
        txtrNote.setText("Note: This would automatically fill up the above slots with \r\nthe current date and time as of the creation of the entry.");
        txtrNote.setBackground(new Color(240, 240, 240));
        txtrNote.setBounds(60, 189, 415, 47);
        panel_3.add(txtrNote);
        
        JTextArea txtrUseRealDate = new JTextArea();
        txtrUseRealDate.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtrUseRealDate.setText("Use real date and time.");
        txtrUseRealDate.setBackground(UIManager.getColor("Button.background"));
        txtrUseRealDate.setBounds(60, 170, 319, 22);
        panel_3.add(txtrUseRealDate);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBounds(254, 384, 564, 236);
        backgroundLabel.add(panel_4);
        
        JLabel lblNewLabel_11 = new JLabel("ORDER:");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_11.setForeground(Color.BLACK);
        lblNewLabel_11.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblNewLabel_11.setBounds(10, 15, 126, 41);
        panel_4.add(lblNewLabel_11);
        
        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
        chckbxNewCheckBox_1.setBounds(49, 62, 251, 33);
        panel_4.add(chckbxNewCheckBox_1);
        
        JPanel panel_5 = new JPanel();
        panel_5.setLayout(null);
        panel_5.setBounds(254, 630, 564, 98);
        backgroundLabel.add(panel_5);
        
        JPanel panel_6 = new JPanel();
        panel_6.setLayout(null);
        panel_6.setBounds(832, 384, 577, 344);
        backgroundLabel.add(panel_6);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(225, 225, 225));
        panel_7.setBounds(161, 43, 203, 116);
        panel_6.add(panel_7);
        
        
    }
}
