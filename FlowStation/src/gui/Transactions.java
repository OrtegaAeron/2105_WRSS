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
import java.sql.*;
import java.util.concurrent.atomic.AtomicInteger;

import dbConnections.Connections;
import backend.Transactions_bcknd;
import backend.Sales;
import backend.Customers_bcknd;
import backend.Pricing_bcknd;
import backend.ContainerInventory;

public class Transactions extends JFrame {
	
	Transactions_bcknd objTrans = new Transactions_bcknd();
	Sales objSales = new Sales();
	Customers_bcknd objCstmr = new Customers_bcknd();
	Pricing_bcknd objPrice = new Pricing_bcknd();
	ContainerInventory objInvt = new ContainerInventory();
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JTextField textFieldAddress;
    private JTextField textFieldContactNumber;
    private JTextField textFieldTime;
    private JTextField textFieldContactNum;
    
    double  totalProfitVal = 0;
    int currentLargeValue = 0, currentMediumValue = 0, currentSmallValue = 0;

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
        setResizable(false);
        
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
        
//Customer Panel------------------------------------------------------------------------------
        JPanel pnlCustomer = new JPanel();
        lblBackground.add(pnlCustomer);
        pnlCustomer.setBounds(254, 133, 654, 200);
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
        lblName.setBounds(40, 58, 83, 33);
        pnlCustomer.add(lblName);
        
        
        JComboBox cmboBoxName = new JComboBox();
        cmboBoxName.setBounds(262, 45, 339, 40);
        pnlCustomer.add(cmboBoxName);
        
      //should drop down names from database------------------------------------------
        
        objCstmr.setName((String)cmboBoxName.getSelectedItem());
        
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddress.setForeground(Color.BLACK);
        lblAddress.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblAddress.setBounds(40, 105, 112, 30);
        pnlCustomer.add(lblAddress);
        
        
        textFieldAddress = new JTextField();
        textFieldAddress.setColumns(10);
        textFieldAddress.setBounds(262, 91, 320, 40);
        pnlCustomer.add(textFieldAddress);
        
        objCstmr.setCustomerAddress(textFieldAddress.getText());
        
        
        JLabel lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblContactNumber.setForeground(Color.BLACK);
        lblContactNumber.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblContactNumber.setBounds(40, 150, 211, 30);
        pnlCustomer.add(lblContactNumber);
        
        
        textFieldContactNum = new JTextField();
        textFieldContactNum.setColumns(10);
        textFieldContactNum.setBounds(262, 137, 320, 40);
        pnlCustomer.add(textFieldContactNum);
        
        objCstmr.setContactNumber(textFieldContactNum.getText());
        
        
        
//Schedule Panel------------------------------------------------------------------------------
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
        
        objTrans.setDate((String)cmboBox_Date.getSelectedItem());
        
        
        textFieldTime = new JTextField();
        textFieldTime.setColumns(10);
        textFieldTime.setBounds(117, 110, 295, 49);
        pnlSchedule.add(textFieldTime);
        
        objTrans.setTime(textFieldTime.getText());
        
        
        JCheckBox chckbxDateTime = new JCheckBox();
        chckbxDateTime.setBounds(40, 183, 20, 33);
        pnlSchedule.add(chckbxDateTime);
        
        chckbxDateTime.setSelected(true);
        objTrans.setUseRealDnT(chckbxDateTime.isSelected());
        
        
        JTextArea txtNote = new JTextArea();
        txtNote.setFont(new Font("Monospaced", Font.PLAIN, 11));
        txtNote.setText("Note: This would automatically fill up the above slots with \r\nthe current date and time as of the creation of the entry.");
        txtNote.setBackground(new Color(240, 240, 240));
        txtNote.setBounds(70, 191, 415, 47);
        pnlSchedule.add(txtNote);
        txtNote.setEditable(false);
        
        JTextArea txtrUseRealDate = new JTextArea();
        txtrUseRealDate.setFont(new Font("Monospaced", Font.BOLD, 13));
        txtrUseRealDate.setText("Use real date and time.");
        txtrUseRealDate.setBackground(UIManager.getColor("Button.background"));
        txtrUseRealDate.setBounds(70, 172, 319, 22);
        pnlSchedule.add(txtrUseRealDate);
        txtrUseRealDate.setEditable(false);
        
        
//Order Panel------------------------------------------------------------------------------
        JPanel pnlOrder = new JPanel();
        pnlOrder.setLayout(null);
        pnlOrder.setBounds(254, 340, 564, 236);
        lblBackground.add(pnlOrder);
        
        JLabel lblOrder = new JLabel("ORDER:\r\n");
        lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
        lblOrder.setForeground(Color.BLACK);
        lblOrder.setFont(new Font("Myanmar Text", Font.BOLD, 35));
        lblOrder.setBounds(10, 15, 126, 41);
        pnlOrder.add(lblOrder);
        
        
        JLabel lblLargeContainer = new JLabel("5gl/Large\r\n");
        lblLargeContainer.setForeground(Color.BLACK);
        lblLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblLargeContainer.setBounds(47, 66, 137, 33);
        pnlOrder.add(lblLargeContainer);
        
        
        JCheckBox chckbxLargeContainer = new JCheckBox();
        chckbxLargeContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxLargeContainer.setBounds(20, 66, 28, 30);
        pnlOrder.add(chckbxLargeContainer);
        
        chckbxLargeContainer.addItemListener(e -> {
            // Set yesLargeContainer to true if selected, false otherwise
            objTrans.setYesLargeContainer(chckbxLargeContainer.isSelected());
        });
        
        
        JLabel lblMediumContainer = new JLabel("3gl/Medium");
        lblMediumContainer.setForeground(Color.BLACK);
        lblMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblMediumContainer.setBounds(47, 131, 173, 33);
        pnlOrder.add(lblMediumContainer);
        
        
        JCheckBox chckbxMediumContainer = new JCheckBox();
        chckbxMediumContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxMediumContainer.setBounds(22, 131, 28, 30);
        pnlOrder.add(chckbxMediumContainer);
        
        chckbxMediumContainer.addItemListener(e -> {
            // Set yesLargeContainer to true if selected, false otherwise
            objTrans.setYesMediumContainer(chckbxMediumContainer.isSelected());
        });
        

        JLabel lblSmallContainer = new JLabel("2.5gl/Small");
        lblSmallContainer.setForeground(Color.BLACK);
        lblSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblSmallContainer.setBounds(47, 193, 160, 33);
        pnlOrder.add(lblSmallContainer);
        
        
        JCheckBox chckbxSmallContainer = new JCheckBox();
        chckbxSmallContainer.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxSmallContainer.setBounds(22, 193, 28, 30);
        pnlOrder.add(chckbxSmallContainer);
        
        chckbxSmallContainer.addItemListener(e -> {
            // Set yesLargeContainer to true if selected, false otherwise
            objTrans.setYesSmallContainer(chckbxSmallContainer.isSelected());
        });
        
        
        JSpinner spnrMediumOrder = new JSpinner();
        spnrMediumOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrMediumOrder.setBounds(217, 116, 314, 48);
        pnlOrder.add(spnrMediumOrder);
        
        
        spnrMediumOrder.setEnabled(false);
        chckbxMediumContainer.addActionListener(e -> {
        	objTrans.setDeliveryMediumContainer((Integer)spnrMediumOrder.getValue());
        	
            if (chckbxMediumContainer.isSelected()) {
                spnrMediumOrder.setEnabled(true);
            }
            else {
                spnrMediumOrder.setEnabled(false);
                spnrMediumOrder.setValue(0);
            }});
        
        
        JSpinner spnrSmallOrder = new JSpinner();
        spnrSmallOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrSmallOrder.setBounds(217, 174, 314, 48);
        pnlOrder.add(spnrSmallOrder);
        
        spnrSmallOrder.setEnabled(false);
        chckbxSmallContainer.addActionListener(e -> {
        	objTrans.setDeliveryLargeContainer((Integer)spnrSmallOrder.getValue());
        	
            if (chckbxSmallContainer.isSelected()) {
                spnrSmallOrder.setEnabled(true);
            }
            else {
                spnrSmallOrder.setEnabled(false);
                spnrSmallOrder.setValue(0);
            }});
        
        
        JSpinner spnrLargeOrder = new JSpinner();
        spnrLargeOrder.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spnrLargeOrder.setBounds(217, 57, 314, 48);
        pnlOrder.add(spnrLargeOrder);
        
        
        spnrLargeOrder.setEnabled(false);
        chckbxLargeContainer.addActionListener(e -> {
        	objTrans.setDeliveryLargeContainer((Integer)spnrLargeOrder.getValue());
        	
            if (chckbxLargeContainer.isSelected()) {
                spnrLargeOrder.setEnabled(true);
            }
            else {
                spnrLargeOrder.setEnabled(false);
                spnrLargeOrder.setValue(0);
            }});
        
        
//Delivery Panel------------------------------------------------------------------------------
        JPanel pnlDelivery = new JPanel();
        pnlDelivery.setLayout(null);
        pnlDelivery.setBounds(254, 580, 564, 80);
        lblBackground.add(pnlDelivery);
        
        
        JCheckBox chckbxDelivery = new JCheckBox("");
        chckbxDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxDelivery.setBounds(21, 20, 28, 30);
        pnlDelivery.add(chckbxDelivery);
        
        chckbxDelivery.setSelected(true);
        if(chckbxDelivery.isSelected()) {
        	objTrans.setDelivery(true);
        }
        
        
        JLabel lblDelivery = new JLabel("Delivery");
        lblDelivery.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelivery.setForeground(Color.BLACK);
        lblDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        lblDelivery.setBounds(55, 20, 116, 44);
        pnlDelivery.add(lblDelivery);
        
        JTextArea txtrDeliveryNote = new JTextArea();
        txtrDeliveryNote.setText("Note: This would include a \r\ndelivery fee to the final price");
        txtrDeliveryNote.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtrDeliveryNote.setBackground(UIManager.getColor("Button.background"));
        txtrDeliveryNote.setBounds(190, 20, 288, 47);
        pnlDelivery.add(txtrDeliveryNote);
        txtrDeliveryNote.setEditable(false);
        
        
//Total Fee Panel------------------------------------------------------------------------------
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
        pnlRegularFees.setBounds(10, 42, 560, 131);
        pnlRegularFees.setBackground(new Color(225, 225, 225));
        pnlTotalFee.add(pnlRegularFees);
        pnlRegularFees.setLayout(null);
        
//Regular Fees Panel------------------------------------------------------------------------------
        JLabel lblPricePerGl = new JLabel("Price per gallon");
        lblPricePerGl.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPricePerGl.setBounds(26, -1, 118, 28);
        pnlRegularFees.add(lblPricePerGl);
        
        JLabel lblgllargeContainers = new JLabel("5gl/Large Containers:");
        lblgllargeContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers.setBounds(47, 24, 161, 28);
        pnlRegularFees.add(lblgllargeContainers);
        
        JLabel lblglmediumContainers = new JLabel("3gl/Medium Containers:");
        lblglmediumContainers.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblglmediumContainers.setBounds(47, 50, 178, 28);
        pnlRegularFees.add(lblglmediumContainers);
        
        JLabel lblgllargeContainers_1_1 = new JLabel("2.5gl/Small Containers:");
        lblgllargeContainers_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblgllargeContainers_1_1.setBounds(47, 75, 178, 28);
        pnlRegularFees.add(lblgllargeContainers_1_1);
        
        JLabel lblServiceFee = new JLabel("Service Fee per container:");
        lblServiceFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblServiceFee.setBounds(26, 100, 199, 28);
        pnlRegularFees.add(lblServiceFee);
        
        JLabel lblPricePerGl_Peso = new JLabel("₱ ");
        lblPricePerGl_Peso.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPricePerGl_Peso.setBackground(new Color(225, 225, 225));
        lblPricePerGl_Peso.setBounds(458, 0, 15, 27);
        pnlRegularFees.add(lblPricePerGl_Peso);
        
        
        JLabel lblPricePerGl_int = new JLabel();
        lblPricePerGl_int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblPricePerGl_int.setBackground(new Color(225, 225, 225));
        lblPricePerGl_int.setBounds(475, 0, 75, 27);
        pnlRegularFees.add(lblPricePerGl_int);
        
        lblPricePerGl_int.setText(String.valueOf(objPrice.getPricePerGalon()));
        
        
        JLabel lblMediumContainerCount = new JLabel("0");
        lblMediumContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMediumContainerCount.setBackground(new Color(225, 225, 225));
        lblMediumContainerCount.setBounds(458, 51, 71, 27);
        pnlRegularFees.add(lblMediumContainerCount);
        
        lblMediumContainerCount.setEnabled(false);
        
        spnrMediumOrder.addChangeListener(e -> {
        	
            try {
                // Get the spinner value
                int value = (Integer) spnrMediumOrder.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spnrMediumOrder.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
                // Update label text with spinner value
                lblMediumContainerCount.setText(String.valueOf(value));
                
                // Enable or disable the label based on the spinner value
                if (value > 0) {
                    lblMediumContainerCount.setEnabled(true);
                } else {
                    lblMediumContainerCount.setEnabled(false);
                    lblMediumContainerCount.setText("0");
                }
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spnrMediumOrder.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spnrMediumOrder.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblSmallContainerCount = new JLabel("0");
        lblSmallContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblSmallContainerCount.setBackground(new Color(225, 225, 225));
        lblSmallContainerCount.setBounds(458, 76, 71, 27);
        pnlRegularFees.add(lblSmallContainerCount);
        
        lblSmallContainerCount.setEnabled(false);

        spnrSmallOrder.addChangeListener(e -> {
        	
            try {
                // Get the spinner value
                int value = (Integer) spnrSmallOrder.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spnrSmallOrder.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
                // Update label text with spinner value
                lblSmallContainerCount.setText(String.valueOf(value));
                
                // Enable or disable the label based on the spinner value
                if (value > 0) {
                    lblSmallContainerCount.setEnabled(true);
                } else {
                    lblSmallContainerCount.setEnabled(false);
                    lblSmallContainerCount.setText("0");
                }
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spnrSmallOrder.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spnrSmallOrder.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        JLabel lblLargeContainerCount = new JLabel("0");
        lblLargeContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblLargeContainerCount.setBackground(new Color(225, 225, 225));
        lblLargeContainerCount.setBounds(458, 24, 71, 27);
        pnlRegularFees.add(lblLargeContainerCount);
        
        lblLargeContainerCount.setEnabled(false);
        
        spnrLargeOrder.addChangeListener(e -> {

            try {
                // Get the spinner value
                int value = (Integer) spnrLargeOrder.getValue();
                
                // Prevent negative values
                if (value < 0) {
                    JOptionPane.showMessageDialog(null, "Value cannot be negative. Resetting to 0.");
                    spnrLargeOrder.setValue(0); // Reset spinner value to 0
                    value = 0;
                }
                
                // Update label text with spinner value
                lblLargeContainerCount.setText(String.valueOf(value));
                
                // Enable or disable the label based on the spinner value
                if (value > 0) {
                    lblLargeContainerCount.setEnabled(true);
                } else {
                    lblLargeContainerCount.setEnabled(false);
                    lblLargeContainerCount.setText("0");
                }
            } catch (ClassCastException ex) {
                JOptionPane.showMessageDialog(null, "Invalid spinner value. Please enter a valid number.");
                spnrLargeOrder.setValue(0); // Reset spinner value to 0 in case of error
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + ex.getMessage());
                spnrLargeOrder.setValue(0); // Reset spinner value to 0 in case of error
            }
        });
        
        
        
        JLabel lblServiceFee_Peso = new JLabel("₱");
        lblServiceFee_Peso.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblServiceFee_Peso.setBackground(new Color(225, 225, 225));
        lblServiceFee_Peso.setBounds(458, 100, 15, 27);
        pnlRegularFees.add(lblServiceFee_Peso);
        
        
        JLabel lblServiceFee_Int = new JLabel();
        lblServiceFee_Int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblServiceFee_Int.setBackground(new Color(225, 225, 225));
        lblServiceFee_Int.setBounds(475, 100, 75, 27);
        pnlRegularFees.add(lblServiceFee_Int);
        
        lblServiceFee_Int.setText(String.valueOf(objSales.getServiceFee()));
        
        
//Delivery Fees Panel------------------------------------------------------------------------------
        JPanel pnlDeliveryFees = new JPanel();
        pnlDeliveryFees.setBackground(new Color(225, 225, 225));
        pnlDeliveryFees.setBounds(10, 177, 560, 35);
        pnlTotalFee.add(pnlDeliveryFees);
        pnlDeliveryFees.setLayout(null);
        
        JLabel lblDeliveryFee = new JLabel("Delivery fee:");
        lblDeliveryFee.setBounds(26, 6, 118, 21);
        lblDeliveryFee.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnlDeliveryFees.add(lblDeliveryFee);
        
        JLabel lblDeliveryFee_Int = new JLabel("₱ ");
        lblDeliveryFee_Int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblDeliveryFee_Int.setBackground(new Color(225, 225, 225));
        lblDeliveryFee_Int.setBounds(458, 6, 15, 27);
        pnlDeliveryFees.add(lblDeliveryFee_Int);
        
        
        JLabel lblDeliveryFee_Int_1 = new JLabel();
        lblDeliveryFee_Int_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblDeliveryFee_Int_1.setBackground(new Color(225, 225, 225));
        lblDeliveryFee_Int_1.setBounds(475, 6, 75, 27);
        pnlDeliveryFees.add(lblDeliveryFee_Int_1);
        
        lblDeliveryFee_Int_1.setText(String.valueOf(objSales.getDeliveryFee()));
        
        chckbxDelivery.addActionListener(e -> {
            if (chckbxDelivery.isSelected()) {
            	lblDeliveryFee_Int_1.setText(String.valueOf(objSales.getDeliveryFee()));
            	lblDeliveryFee_Int_1.setEnabled(true);
            	lblDeliveryFee_Int.setEnabled(true);
            	lblDeliveryFee.setEnabled(true);
            	
            }
            else {
            	lblDeliveryFee_Int_1.setText("0.0");
            	lblDeliveryFee_Int_1.setEnabled(false);
            	lblDeliveryFee_Int.setEnabled(false);
            	lblDeliveryFee.setEnabled(false);
            }});
        
//Total Panel------------------------------------------------------------------------------
        JLabel lblTotal = new JLabel("TOTAL:");
        lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
        lblTotal.setBounds(10, 217, 166, 52);
        pnlTotalFee.add(lblTotal);
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setFont(new Font("Myanmar Text", Font.BOLD, 40));
        
        JPanel pnlTotal = new JPanel();
        pnlTotal.setLayout(null);
        pnlTotal.setBackground(new Color(225, 225, 225));
        pnlTotal.setBounds(167, 217, 403, 40);
        pnlTotalFee.add(pnlTotal);
        
        
        JLabel lblTotal_Peso = new JLabel("₱ ");
        lblTotal_Peso.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTotal_Peso.setBackground(new Color(225, 225, 225));
        lblTotal_Peso.setBounds(293, 8, 22, 31);
        pnlTotal.add(lblTotal_Peso);
        
        
        JLabel lblTotal_int = new JLabel();
        lblTotal_int.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTotal_int.setBackground(new Color(225, 225, 225));
        lblTotal_int.setBounds(315, 8, 78, 31);
        pnlTotal.add(lblTotal_int);
        
        lblTotal_int.setText(String.valueOf(objSales.getProfit()));
        lblTotal_int.setEnabled(false);
        
        
        
        AtomicInteger prevLargeValue = new AtomicInteger((Integer) spnrLargeOrder.getValue());
        spnrLargeOrder.addChangeListener(e -> {
            int currentLargeValue = (Integer) spnrLargeOrder.getValue();
            double profitVal = 0;
            objInvt.setContainerQuantityLarge(objInvt.decreaseContainerQuantityLarge());
            
            if (currentLargeValue > 0) {
            	profitVal = 0;
            }

            if (currentLargeValue > prevLargeValue.get()) {
                if (objTrans.isYesLargeContainer()) {
                    profitVal = (objPrice.getWaterPriceLarge() * objInvt.getOutBoundContainer_L()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_L());
                }

                if (objTrans.isDelivery()) {
                    profitVal += objSales.getDeliveryFee();
                }

                totalProfitVal += profitVal;
            } else if (currentLargeValue < prevLargeValue.get()) {
                if (objTrans.isYesLargeContainer()) {
                    profitVal = (objPrice.getWaterPriceLarge() * objInvt.getOutBoundContainer_L()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_L());
                }

                if (objTrans.isDelivery()) {
                    profitVal -= objSales.getDeliveryFee();
                }

                totalProfitVal -= profitVal;
            }
            prevLargeValue.set(currentLargeValue);

            if (currentLargeValue > 0) {
                lblTotal_int.setText(String.valueOf(totalProfitVal));
                lblTotal_int.setEnabled(true);
                lblTotal_Peso.setEnabled(true);
            } else {
            	
                lblTotal_int.setEnabled(false);
                lblTotal_int.setText(" ");
                lblTotal_Peso.setEnabled(false);
            }
            objSales.setProfit(totalProfitVal);
        });

        AtomicInteger prevMediumValue = new AtomicInteger((Integer) spnrMediumOrder.getValue());
        spnrMediumOrder.addChangeListener(e -> {
            int currentMediumValue = (Integer) spnrMediumOrder.getValue();
            double profitVal = 0;
            objInvt.setContainerQuantityMedium(objInvt.decreaseContainerQuantityMedium());
            
            if (currentMediumValue > 0) {
            	profitVal = 0;
            }

            if (currentMediumValue > prevMediumValue.get()) {
                if (objTrans.isYesMediumContainer()) {
                    profitVal = (objPrice.getWaterPriceMedium() * objInvt.getOutBoundContainer_M()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_M());
                }

                if (objTrans.isDelivery()) {
                    profitVal += objSales.getDeliveryFee();
                }

                totalProfitVal += profitVal;
            } else if (currentMediumValue < prevMediumValue.get()) {
                if (objTrans.isYesMediumContainer()) {
                    profitVal = (objPrice.getWaterPriceMedium() * objInvt.getOutBoundContainer_M()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_M());
                }

                if (objTrans.isDelivery()) {
                    profitVal -= objSales.getDeliveryFee();
                }

                totalProfitVal -= profitVal;
            }
            prevMediumValue.set(currentMediumValue);

            if (currentMediumValue > 0) {
                lblTotal_int.setText(String.valueOf(totalProfitVal));
                lblTotal_int.setEnabled(true);
                lblTotal_Peso.setEnabled(true);
            } else {
            	profitVal = 0;
                lblTotal_int.setEnabled(false);
                lblTotal_int.setText(" ");
                lblTotal_Peso.setEnabled(false);
            }
            objSales.setProfit(totalProfitVal);
        });
        
        AtomicInteger prevSmallValue = new AtomicInteger((Integer) spnrSmallOrder.getValue());
        spnrSmallOrder.addChangeListener(e -> {
            int currentSmallValue = (Integer) spnrSmallOrder.getValue();
            double profitVal = 0;
            objInvt.setContainerQuantitySmall(objInvt.decreaseContainerQuantitySmall());
            
            if (currentSmallValue > 0) {
            	profitVal = 0;
            }

            if (currentSmallValue > prevSmallValue.get()) {
                if (objTrans.isYesSmallContainer()) {
                    profitVal = (objPrice.getWaterPriceSmall() * objInvt.getOutBoundContainer_S()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_S());
                }

                if (objTrans.isDelivery()) {
                    profitVal += objSales.getDeliveryFee();
                }

                totalProfitVal += profitVal;
            } else if (currentSmallValue < prevSmallValue.get()) {
                if (objTrans.isYesSmallContainer()) {
                    profitVal = (objPrice.getWaterPriceSmall() * objInvt.getOutBoundContainer_S()) +
                                (objSales.getServiceFee() * objInvt.getOutBoundContainer_S());
                }

                if (objTrans.isDelivery()) {
                    profitVal -= objSales.getDeliveryFee();
                }

                totalProfitVal -= profitVal;
            }
            prevSmallValue.set(currentSmallValue);

            if (currentSmallValue > 0) {
                lblTotal_int.setText(String.valueOf(totalProfitVal));
                lblTotal_int.setEnabled(true);
                lblTotal_Peso.setEnabled(true);
            } else {
            	profitVal = 0;
                lblTotal_int.setEnabled(false);
                lblTotal_int.setText(" ");
                lblTotal_Peso.setEnabled(false);
            }
            objSales.setProfit(totalProfitVal);
        });


        

//Payment Panel------------------------------------------------------------------------------
        JPanel pnlCstmrPayment = new JPanel();
        pnlCstmrPayment.setLayout(null);
        pnlCstmrPayment.setBackground(new Color(225, 225, 225));
        pnlCstmrPayment.setBounds(281, 262, 289, 35);
        pnlTotalFee.add(pnlCstmrPayment);
        
        JLabel lblCstmrPayment = new JLabel("Customer Payment:");
        lblCstmrPayment.setForeground(Color.BLACK);
        lblCstmrPayment.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblCstmrPayment.setBounds(10, 262, 289, 41);
        pnlTotalFee.add(lblCstmrPayment);
        
        JLabel lblCstmrPayment_Peso = new JLabel("₱ ");
        lblCstmrPayment_Peso.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblCstmrPayment_Peso.setEnabled(true);
        lblCstmrPayment_Peso.setBackground(new Color(225, 225, 225));
        lblCstmrPayment_Peso.setBounds(186, 6, 15, 27);
        pnlCstmrPayment.add(lblCstmrPayment_Peso);
        
        
        JLabel lblCstmrPayment_int = new JLabel();
        lblCstmrPayment_int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblCstmrPayment_int.setEnabled(true);
        lblCstmrPayment_int.setBackground(new Color(225, 225, 225));
        lblCstmrPayment_int.setBounds(201, 6, 75, 27);
        pnlCstmrPayment.add(lblCstmrPayment_int);
        lblCstmrPayment_Peso.setEnabled(false);
        
        
        
//Change Panel------------------------------------------------------------------------------
        JPanel pnlChange = new JPanel();
        pnlChange.setLayout(null);
        pnlChange.setBackground(new Color(225, 225, 225));
        pnlChange.setBounds(133, 301, 437, 35);
        pnlTotalFee.add(pnlChange);
        
        JLabel lblChange = new JLabel("Change:");
        lblChange.setForeground(Color.BLACK);
        lblChange.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblChange.setBounds(10, 300, 289, 41);
        pnlTotalFee.add(lblChange);
        
        JLabel lblChange_Peso = new JLabel("₱ ");
        lblChange_Peso.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblChange_Peso.setEnabled(true);
        lblChange_Peso.setBackground(new Color(225, 225, 225));
        lblChange_Peso.setBounds(334, 6, 15, 27);
        pnlChange.add(lblChange_Peso);
        
        
        JLabel lblChange_int = new JLabel();
        lblChange_int.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblChange_int.setEnabled(true);
        lblChange_int.setBackground(new Color(225, 225, 225));
        lblChange_int.setBounds(349, 6, 75, 27);
        pnlChange.add(lblChange_int);
        
  
        lblChange_int.setText(String.valueOf(objSales.getChange()));
        lblCstmrPayment_Peso.setEnabled(false);
        
        JButton btnNewButton = new JButton("Calculate Total");
        btnNewButton.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        btnNewButton.setBounds(420, 680, 180, 43);
        lblBackground.add(btnNewButton);
        
    }
}
