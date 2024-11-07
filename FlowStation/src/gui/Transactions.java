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
import java.awt.Checkbox;
import java.awt.Toolkit;

public class Transactions extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JTextField textFieldAddress;
    private JTextField textFieldContactNumber;
    private JTextField textFieldTime;

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
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Transactions.class.getResource("/resources/Logo_Small.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 780);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel lblBackground = new JLabel(new ImageIcon(Transactions.class.getResource("/resources/Main.png")));
        lblBackground.setBounds(0, 0, 1426, 743);
        contentPane.add(lblBackground);
        lblBackground.setLayout(null);
        
        //side panel
        JPanel pnlHeader = new JPanel();
        pnlHeader.setBackground(new Color(16, 68, 160));
        pnlHeader.setBounds(238, 0, 1188, 120);
        lblBackground.add(pnlHeader);
        pnlHeader.setLayout(null);
        
        //head label
        JLabel lblTransactions = new JLabel("Transactions");
        lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
        lblTransactions.setForeground(Color.WHITE);
        lblTransactions.setFont(new Font("Myanmar Text", Font.BOLD, 41));
        lblTransactions.setBounds(438, 27, 296, 66);
        pnlHeader.add(lblTransactions);
        
        //head panel
        JPanel pnlSide = new JPanel();
        pnlSide.setForeground(new Color(255, 255, 255));
        pnlSide.setBackground(new Color(65, 134, 255));
        pnlSide.setBounds(0, 0, 238, 743);
        lblBackground.add(pnlSide);
        pnlSide.setLayout(null);
        
        lblLogo = new JLabel(new ImageIcon(Transactions.class.getResource("/resources/Logo_Small.png")));
        lblLogo.setBounds(57, 19, 125, 125);
        pnlSide.add(lblLogo);
        
        // FlowStation title label
        JLabel lblFlowStation = new JLabel("FLOWSTATION™");
        lblFlowStation.setBounds(19, 156, 195, 48);
        lblFlowStation.setForeground(new Color(255, 255, 255));
        pnlSide.add(lblFlowStation);
        lblFlowStation.setFont(new Font("Myanmar Text", Font.BOLD, 25));
        
        //Transaction Button
        JButton btnTransactions = new JButton("Transactions");
        btnTransactions.setForeground(new Color(255, 255, 255));
        btnTransactions.setBackground(new Color(16, 68, 160));
        btnTransactions.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnTransactions.setBounds(0, 228, 238, 50);
        pnlSide.add(btnTransactions);
        
        //Customer Button
        JButton btnCustomers = new JButton("Customers");
        btnCustomers.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnCustomers.setBounds(0, 285, 238, 50);
        pnlSide.add(btnCustomers);
        
        btnCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Customers customersFrame = new Customers(); // Open the Customers frame
                customersFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Inventory Button
        JButton btnInventory = new JButton("Inventory");
        btnInventory.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnInventory.setBounds(0, 342, 238, 50);
        pnlSide.add(btnInventory);
        
        btnInventory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Inventory inventoryFrame = new Inventory(); // Open the Customers frame
                inventoryFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Pricing Button
        JButton btnPricing = new JButton("Pricing");
        btnPricing.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnPricing.setBounds(0, 399, 238, 50);
        pnlSide.add(btnPricing);
        
        btnPricing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Pricing pricingFrame = new Pricing(); // Open the Customers frame
                pricingFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Daily Sales Button
        JButton btnDailySales = new JButton("Daily Sales");
        btnDailySales.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnDailySales.setBounds(0, 456, 238, 50);
        pnlSide.add(btnDailySales);
        
        btnDailySales.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                DailySales dailySalesFrame = new DailySales(); // Open the Customers frame
                dailySalesFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Sales Catalog Button
        JButton btnSalesCatalog = new JButton("Sales Catalog");
        btnSalesCatalog.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnSalesCatalog.setBounds(0, 513, 238, 50);
        pnlSide.add(btnSalesCatalog);
        
        btnSalesCatalog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                SalesCatalog salesCatalogFrame = new SalesCatalog(); // Open the Customers frame
                salesCatalogFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Exit Button
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnExit.setBounds(0, 606, 238, 50);
        pnlSide.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                LogIn logInFrame = new LogIn(); // Open the Customers frame
                logInFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        JPanel pnlCustomer = new JPanel();
        lblBackground.add(pnlCustomer);
        pnlCustomer.setBounds(254, 133, 654, 240);
        pnlCustomer.setLayout(null);
        
        JLabel lblCustomer = new JLabel("CUSTOMER:");
        lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
        lblCustomer.setForeground(new Color(0, 0, 0));
        lblCustomer.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblCustomer.setBounds(10, 15, 199, 41);
        pnlCustomer.add(lblCustomer);
        
        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblName.setBounds(40, 72, 83, 29);
        pnlCustomer.add(lblName);
        
        JLabel lblContactNumber = new JLabel("ContactNumber");
        lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblContactNumber.setForeground(Color.BLACK);
        lblContactNumber.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblContactNumber.setBounds(40, 186, 208, 30);
        pnlCustomer.add(lblContactNumber);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddress.setForeground(Color.BLACK);
        lblAddress.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblAddress.setBounds(40, 129, 112, 30);
        pnlCustomer.add(lblAddress);
        
        textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(262, 110, 320, 49);
        pnlCustomer.add(textFieldAddress);
        
        textFieldContactNumber = new JTextField();
        textFieldContactNumber.setColumns(10);
        textFieldContactNumber.setBounds(262, 168, 320, 49);
        pnlCustomer.add(textFieldContactNumber);
        
        JComboBox cmboBoxName = new JComboBox();
        cmboBoxName.setBounds(262, 52, 339, 49);
        pnlCustomer.add(cmboBoxName);
        
        JPanel pnlSchedule = new JPanel();
        pnlSchedule.setLayout(null);
        pnlSchedule.setBounds(924, 133, 485, 238);
        lblBackground.add(pnlSchedule);
        
        JLabel lblSchedule = new JLabel("SCHEDULE:");
        lblSchedule.setHorizontalAlignment(SwingConstants.CENTER);
        lblSchedule.setForeground(Color.BLACK);
        lblSchedule.setFont(new Font("Myanmar Text", Font.BOLD, 33));
        lblSchedule.setBounds(10, 15, 181, 41);
        pnlSchedule.add(lblSchedule);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setForeground(Color.BLACK);
        lblDate.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblDate.setBounds(40, 72, 83, 33);
        pnlSchedule.add(lblDate);
        
        JLabel lblTime = new JLabel("Time");
        lblTime.setForeground(Color.BLACK);
        lblTime.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblTime.setBounds(40, 129, 83, 33);
        pnlSchedule.add(lblTime);
        
        textFieldTime = new JTextField();
        textFieldTime.setColumns(10);
        textFieldTime.setBounds(117, 110, 295, 49);
        pnlSchedule.add(textFieldTime);
        
        JCheckBox chckbxDateTime = new JCheckBox("");
        chckbxDateTime.setBounds(40, 183, 20, 33);
        pnlSchedule.add(chckbxDateTime);
        
        JTextArea txtNote = new JTextArea();
        txtNote.setFont(new Font("Monospaced", Font.PLAIN, 11));
        txtNote.setText("Note: This would automatically fill up the above slots with \r\nthe current date and time as of the creation of the entry.");
        txtNote.setBackground(new Color(240, 240, 240));
        txtNote.setBounds(70, 191, 415, 47);
        pnlSchedule.add(txtNote);
        
        JTextArea txtrUseRealDate = new JTextArea();
        txtrUseRealDate.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtrUseRealDate.setText("Use real date and time.");
        txtrUseRealDate.setBackground(UIManager.getColor("Button.background"));
        txtrUseRealDate.setBounds(70, 172, 319, 22);
        pnlSchedule.add(txtrUseRealDate);
        
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setBounds(117, 52, 319, 49);
        pnlSchedule.add(comboBox_1);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBounds(254, 384, 564, 236);
        lblBackground.add(panel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel("ORDER:\r\n");
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4_1.setForeground(Color.BLACK);
        lblNewLabel_4_1.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblNewLabel_4_1.setBounds(10, 15, 126, 41);
        panel_4.add(lblNewLabel_4_1);
        
        JCheckBox chckbxgllarge = new JCheckBox("");
        chckbxgllarge.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxgllarge.setBounds(20, 66, 28, 30);
        panel_4.add(chckbxgllarge);
        
        JLabel lblNewLabel_10_1 = new JLabel("5gl/Large\r\n");
        lblNewLabel_10_1.setForeground(Color.BLACK);
        lblNewLabel_10_1.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_10_1.setBounds(47, 66, 137, 33);
        panel_4.add(lblNewLabel_10_1);
        
        JCheckBox chckbxglMedium = new JCheckBox("");
        chckbxglMedium.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxglMedium.setBounds(22, 131, 28, 30);
        panel_4.add(chckbxglMedium);
        
        JLabel lblNewLabel_10_1_1 = new JLabel("3gl/Medium");
        lblNewLabel_10_1_1.setForeground(Color.BLACK);
        lblNewLabel_10_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_10_1_1.setBounds(47, 131, 173, 33);
        panel_4.add(lblNewLabel_10_1_1);
        
        JLabel lblNewLabel_10_1_1_1 = new JLabel("2.5gl/Small");
        lblNewLabel_10_1_1_1.setForeground(Color.BLACK);
        lblNewLabel_10_1_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_10_1_1_1.setBounds(47, 193, 160, 33);
        panel_4.add(lblNewLabel_10_1_1_1);
        
        JCheckBox chckbxglSmall = new JCheckBox("");
        chckbxglSmall.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxglSmall.setBounds(22, 193, 28, 30);
        panel_4.add(chckbxglSmall);
        
        JSpinner spnrMediumOrder = new JSpinner();
        spnrMediumOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrMediumOrder.setBounds(217, 116, 314, 48);
        panel_4.add(spnrMediumOrder);
        
        JSpinner spnrSmallOrder = new JSpinner();
        spnrSmallOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrSmallOrder.setBounds(217, 174, 314, 48);
        panel_4.add(spnrSmallOrder);
        
        JSpinner spnrLargeOrder = new JSpinner();
        spnrLargeOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrLargeOrder.setBounds(217, 57, 314, 48);
        panel_4.add(spnrLargeOrder);
        
        JPanel panel_5 = new JPanel();
        panel_5.setLayout(null);
        panel_5.setBounds(254, 630, 564, 98);
        lblBackground.add(panel_5);
        
        JCheckBox chckbxDelivery = new JCheckBox("");
        chckbxDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxDelivery.setBounds(21, 34, 28, 30);
        panel_5.add(chckbxDelivery);
        
        JLabel lblNewLabel_5_1 = new JLabel("Delivery");
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5_1.setForeground(Color.BLACK);
        lblNewLabel_5_1.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblNewLabel_5_1.setBounds(45, 33, 116, 44);
        panel_5.add(lblNewLabel_5_1);
        
        JTextArea txtrNote = new JTextArea();
        txtrNote.setText("Note: This would include a \r\ndelivery fee to the final price        ");
        txtrNote.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtrNote.setBackground(UIManager.getColor("Button.background"));
        txtrNote.setBounds(190, 26, 288, 47);
        panel_5.add(txtrNote);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBounds(832, 384, 577, 344);
        lblBackground.add(panel_6);
        panel_6.setLayout(null);
        
        JLabel lblNewLabel_8_1 = new JLabel("TOTAL FEE:");
        lblNewLabel_8_1.setBounds(10, 10, 181, 41);
        lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8_1.setForeground(Color.BLACK);
        lblNewLabel_8_1.setFont(new Font("Myanmar Text", Font.BOLD, 33));
        panel_6.add(lblNewLabel_8_1);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBounds(10, 43, 560, 157);
        panel_7.setBackground(new Color(225, 225, 225));
        panel_6.add(panel_7);
        panel_7.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Price per gallon");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(26, 10, 118, 28);
        panel_7.add(lblNewLabel);
        
        JLabel lblgllargeContainers = new JLabel("5gl/Large Containers:");
        lblgllargeContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers.setBounds(47, 35, 161, 28);
        panel_7.add(lblgllargeContainers);
        
        JLabel lblglmediumContainers = new JLabel("3gl/Medium Containers:");
        lblglmediumContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblglmediumContainers.setBounds(47, 61, 178, 28);
        panel_7.add(lblglmediumContainers);
        
        JLabel lblgllargeContainers_1_1 = new JLabel("2.5gl/Small Containers:");
        lblgllargeContainers_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1.setBounds(47, 86, 178, 28);
        panel_7.add(lblgllargeContainers_1_1);
        
        JLabel lblgllargeContainers_1_1_1 = new JLabel("Service Fee per container:");
        lblgllargeContainers_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1_1.setBounds(26, 119, 199, 28);
        panel_7.add(lblgllargeContainers_1_1_1);
        
        JLabel lblNewLabel_11 = new JLabel("₱ 5.00");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11.setBackground(new Color(225, 225, 225));
        lblNewLabel_11.setBounds(458, 11, 71, 27);
        panel_7.add(lblNewLabel_11);
        
        JLabel lblFeeMContainer = new JLabel("0");
        lblFeeMContainer.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFeeMContainer.setBackground(new Color(225, 225, 225));
        lblFeeMContainer.setBounds(458, 62, 71, 27);
        panel_7.add(lblFeeMContainer);
        
        JLabel lblFeeSContainer = new JLabel("0");
        lblFeeSContainer.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFeeSContainer.setBackground(new Color(225, 225, 225));
        lblFeeSContainer.setBounds(458, 87, 71, 27);
        panel_7.add(lblFeeSContainer);
        
        JLabel lblNewLabel_11_3 = new JLabel("₱ 3.00");
        lblNewLabel_11_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_3.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_3.setBounds(458, 120, 71, 27);
        panel_7.add(lblNewLabel_11_3);
        
        JLabel lblFeeLContainer = new JLabel("0");
        lblFeeLContainer.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblFeeLContainer.setBackground(new Color(225, 225, 225));
        lblFeeLContainer.setBounds(458, 35, 71, 27);
        panel_7.add(lblFeeLContainer);
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(225, 225, 225));
        panel_8.setBounds(10, 210, 560, 46);
        panel_6.add(panel_8);
        panel_8.setLayout(null);
        
        JLabel lblDeliveryFee = new JLabel("Delivery fee:");
        lblDeliveryFee.setBounds(26, 12, 118, 21);
        lblDeliveryFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        panel_8.add(lblDeliveryFee);
        
        JLabel lblNewLabel_11_4 = new JLabel("₱ 10.00");
        lblNewLabel_11_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_11_4.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_4.setBounds(458, 12, 71, 27);
        panel_8.add(lblNewLabel_11_4);
        
        JPanel panel_8_1 = new JPanel();
        panel_8_1.setLayout(null);
        panel_8_1.setBackground(new Color(225, 225, 225));
        panel_8_1.setBounds(167, 273, 403, 61);
        panel_6.add(panel_8_1);
        
        JLabel lblNewLabel_11_4_1 = new JLabel("₱ ");
        lblNewLabel_11_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblNewLabel_11_4_1.setBackground(new Color(225, 225, 225));
        lblNewLabel_11_4_1.setBounds(296, 16, 107, 31);
        panel_8_1.add(lblNewLabel_11_4_1);
        
        JLabel lblNewLabel_8_1_1 = new JLabel("TOTAL:");
        lblNewLabel_8_1_1.setBounds(10, 288, 181, 47);
        panel_6.add(lblNewLabel_8_1_1);
        lblNewLabel_8_1_1.setForeground(Color.BLACK);
        lblNewLabel_8_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 40));
        
        
    }
}
