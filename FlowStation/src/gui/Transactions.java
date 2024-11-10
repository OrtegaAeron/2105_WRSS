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
        btnTransactions.setBounds(0, 212, 238, 50);
        pnlSide.add(btnTransactions);
        
        //Customer Button
        JButton btnCustomers = new JButton("Customers");
        btnCustomers.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnCustomers.setBounds(0, 269, 238, 50);
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
        btnInventory.setBounds(0, 326, 238, 50);
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
        btnPricing.setBounds(0, 383, 238, 50);
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
        btnDailySales.setBounds(0, 440, 238, 50);
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
        btnSalesCatalog.setBounds(0, 497, 238, 50);
        pnlSide.add(btnSalesCatalog);
        
        btnSalesCatalog.addActionListener(new ActionListener() {
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
        pnlSide.add(btnAdminSettings);
        
        btnAdminSettings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                AdminSettingsLogIn AdminSettingsLogInFrame = new AdminSettingsLogIn(); // Open the Customers frame
                AdminSettingsLogInFrame.setVisible(true); // Set the Customers frame visible
            }
        });
        
        //Exit Button
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnExit.setBounds(0, 645, 238, 50);
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
        
        JComboBox cmboBox_Date = new JComboBox();
        cmboBox_Date.setBounds(117, 52, 319, 49);
        pnlSchedule.add(cmboBox_Date);
        
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
        
        JPanel pnlOrder = new JPanel();
        pnlOrder.setLayout(null);
        pnlOrder.setBounds(254, 384, 564, 236);
        lblBackground.add(pnlOrder);
        
        JLabel lblOrder = new JLabel("ORDER:\r\n");
        lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrder.setForeground(Color.BLACK);
        lblOrder.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblOrder.setBounds(10, 15, 126, 41);
        pnlOrder.add(lblOrder);
        
        JCheckBox chckbxLargeContainer = new JCheckBox("");
        chckbxLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxLargeContainer.setBounds(20, 66, 28, 30);
        pnlOrder.add(chckbxLargeContainer);
        
        JLabel lblLargeContainer = new JLabel("5gl/Large\r\n");
        lblLargeContainer.setForeground(Color.BLACK);
        lblLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblLargeContainer.setBounds(47, 66, 137, 33);
        pnlOrder.add(lblLargeContainer);
        
        JCheckBox chckbxMediumContainer = new JCheckBox("");
        chckbxMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxMediumContainer.setBounds(22, 131, 28, 30);
        pnlOrder.add(chckbxMediumContainer);
        
        JLabel lblMediumContainer = new JLabel("3gl/Medium");
        lblMediumContainer.setForeground(Color.BLACK);
        lblMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblMediumContainer.setBounds(47, 131, 173, 33);
        pnlOrder.add(lblMediumContainer);
        
        JLabel lblSmallContainer = new JLabel("2.5gl/Small");
        lblSmallContainer.setForeground(Color.BLACK);
        lblSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblSmallContainer.setBounds(47, 193, 160, 33);
        pnlOrder.add(lblSmallContainer);
        
        JCheckBox chckbxSmallContainer = new JCheckBox("");
        chckbxSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxSmallContainer.setBounds(22, 193, 28, 30);
        pnlOrder.add(chckbxSmallContainer);
        
        JSpinner spnrMediumOrder = new JSpinner();
        spnrMediumOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrMediumOrder.setBounds(217, 116, 314, 48);
        pnlOrder.add(spnrMediumOrder);
        
        JSpinner spnrSmallOrder = new JSpinner();
        spnrSmallOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrSmallOrder.setBounds(217, 174, 314, 48);
        pnlOrder.add(spnrSmallOrder);
        
        JSpinner spnrLargeOrder = new JSpinner();
        spnrLargeOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrLargeOrder.setBounds(217, 57, 314, 48);
        pnlOrder.add(spnrLargeOrder);
        
        JPanel pnlDelivery = new JPanel();
        pnlDelivery.setLayout(null);
        pnlDelivery.setBounds(254, 630, 564, 98);
        lblBackground.add(pnlDelivery);
        
        JCheckBox chckbxDelivery = new JCheckBox("");
        chckbxDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxDelivery.setBounds(21, 34, 28, 30);
        pnlDelivery.add(chckbxDelivery);
        
        JLabel lblDelivery = new JLabel("Delivery");
        lblDelivery.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelivery.setForeground(Color.BLACK);
        lblDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblDelivery.setBounds(45, 33, 116, 44);
        pnlDelivery.add(lblDelivery);
        
        JTextArea txtrDeliveryNote = new JTextArea();
        txtrDeliveryNote.setText("Note: This would include a \r\ndelivery fee to the final price        ");
        txtrDeliveryNote.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtrDeliveryNote.setBackground(UIManager.getColor("Button.background"));
        txtrDeliveryNote.setBounds(190, 26, 288, 47);
        pnlDelivery.add(txtrDeliveryNote);
        
        JPanel pnlTotalFee = new JPanel();
        pnlTotalFee.setBounds(832, 384, 577, 344);
        lblBackground.add(pnlTotalFee);
        pnlTotalFee.setLayout(null);
        
        JLabel lblTotalFee = new JLabel("TOTAL FEE:");
        lblTotalFee.setBounds(10, 10, 181, 41);
        lblTotalFee.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalFee.setForeground(Color.BLACK);
        lblTotalFee.setFont(new Font("Myanmar Text", Font.BOLD, 33));
        pnlTotalFee.add(lblTotalFee);
        
        JPanel pnlRegularFees = new JPanel();
        pnlRegularFees.setBounds(10, 43, 560, 157);
        pnlRegularFees.setBackground(new Color(225, 225, 225));
        pnlTotalFee.add(pnlRegularFees);
        pnlRegularFees.setLayout(null);
        
        JLabel lblPricePerGl = new JLabel("Price per gallon");
        lblPricePerGl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPricePerGl.setBounds(26, 10, 118, 28);
        pnlRegularFees.add(lblPricePerGl);
        
        JLabel lblgllargeContainers = new JLabel("5gl/Large Containers:");
        lblgllargeContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers.setBounds(47, 35, 161, 28);
        pnlRegularFees.add(lblgllargeContainers);
        
        JLabel lblglmediumContainers = new JLabel("3gl/Medium Containers:");
        lblglmediumContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblglmediumContainers.setBounds(47, 61, 178, 28);
        pnlRegularFees.add(lblglmediumContainers);
        
        JLabel lblgllargeContainers_1_1 = new JLabel("2.5gl/Small Containers:");
        lblgllargeContainers_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1.setBounds(47, 86, 178, 28);
        pnlRegularFees.add(lblgllargeContainers_1_1);
        
        JLabel lblServiceFee = new JLabel("Service Fee per container:");
        lblServiceFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblServiceFee.setBounds(26, 119, 199, 28);
        pnlRegularFees.add(lblServiceFee);
        
        JLabel lblPricePerGl_Int = new JLabel("₱ 5.00");
        lblPricePerGl_Int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPricePerGl_Int.setBackground(new Color(225, 225, 225));
        lblPricePerGl_Int.setBounds(458, 11, 71, 27);
        pnlRegularFees.add(lblPricePerGl_Int);
        
        JLabel lblMediumContainerCount = new JLabel("0");
        lblMediumContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMediumContainerCount.setBackground(new Color(225, 225, 225));
        lblMediumContainerCount.setBounds(458, 62, 71, 27);
        pnlRegularFees.add(lblMediumContainerCount);
        
        JLabel lblSmallContainerCount = new JLabel("0");
        lblSmallContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblSmallContainerCount.setBackground(new Color(225, 225, 225));
        lblSmallContainerCount.setBounds(458, 87, 71, 27);
        pnlRegularFees.add(lblSmallContainerCount);
        
        JLabel lblServiceFee_Int = new JLabel("₱ 3.00");
        lblServiceFee_Int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblServiceFee_Int.setBackground(new Color(225, 225, 225));
        lblServiceFee_Int.setBounds(458, 120, 71, 27);
        pnlRegularFees.add(lblServiceFee_Int);
        
        JLabel lblLargeContainerCount = new JLabel("0");
        lblLargeContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblLargeContainerCount.setBackground(new Color(225, 225, 225));
        lblLargeContainerCount.setBounds(458, 35, 71, 27);
        pnlRegularFees.add(lblLargeContainerCount);
        
        JPanel pnlDeliveryFees = new JPanel();
        pnlDeliveryFees.setBackground(new Color(225, 225, 225));
        pnlDeliveryFees.setBounds(10, 210, 560, 46);
        pnlTotalFee.add(pnlDeliveryFees);
        pnlDeliveryFees.setLayout(null);
        
        JLabel lblDeliveryFee = new JLabel("Delivery fee:");
        lblDeliveryFee.setBounds(26, 12, 118, 21);
        lblDeliveryFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnlDeliveryFees.add(lblDeliveryFee);
        
        JLabel lblDeliveryFee_Int = new JLabel("₱ 10.00");
        lblDeliveryFee_Int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblDeliveryFee_Int.setBackground(new Color(225, 225, 225));
        lblDeliveryFee_Int.setBounds(458, 12, 71, 27);
        pnlDeliveryFees.add(lblDeliveryFee_Int);
        
        JPanel pnlTotal = new JPanel();
        pnlTotal.setLayout(null);
        pnlTotal.setBackground(new Color(225, 225, 225));
        pnlTotal.setBounds(167, 273, 403, 61);
        pnlTotalFee.add(pnlTotal);
        
        JLabel lblTotal_Int = new JLabel("₱ ");
        lblTotal_Int.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTotal_Int.setBackground(new Color(225, 225, 225));
        lblTotal_Int.setBounds(296, 16, 107, 31);
        pnlTotal.add(lblTotal_Int);
        
        JLabel lblTotal = new JLabel("TOTAL:");
        lblTotal.setBounds(10, 288, 181, 47);
        pnlTotalFee.add(lblTotal);
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setFont(new Font("Myanmar Text", Font.BOLD, 40));
        
        
    }
}
