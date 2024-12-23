package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Panel;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.Checkbox;
import java.awt.Toolkit;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

import dbConnections.Connections;
import backend.Transactions_bcknd;
import backend.Sales;
import backend.Customers_bcknd;
import backend.Pricing_bcknd;
import backend.ContainerInventory;
import backend.Expenses;

public class Transactions extends JFrame {
	
	Transactions_bcknd objTrans = new Transactions_bcknd();
	Sales objSales = new Sales();
	Customers_bcknd objCstmr = new Customers_bcknd();
	Pricing_bcknd objPrice = new Pricing_bcknd();
	ContainerInventory objInvt = new ContainerInventory();
	Expenses objExps = new Expenses();
	

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JTextField textFieldAddress;
    private JTextField textFieldContactNumber;
    private JTextField textFieldTime;
    private JTextField textFieldContactNum;
    private JTextField textFieldPayment;
    private JTextField textFieldDate;
    
    private int containerQuantityLarge, containerQuantityMedium, containerQuantitySmall;
    private String selectedCustomer_Name, selectedCustomer_ID, lastDate;
    private DateTimeFormatter dateFormatter1;
    private DateTimeFormatter timeFormatter1;
    private JTextField textFieldID;

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
        pnlCustomer.setBounds(254, 133, 654, 238);
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
        
        
        JComboBox<String> cmboBoxName = new JComboBox();
        cmboBoxName.setBounds(294, 45, 307, 40);
        pnlCustomer.add(cmboBoxName);
        
        try (Connection conn = Connections.getConnection()) { // Use your Connections class
            if (conn == null) {
                System.out.println("Database connection failed.");
                return;
            }

            String query = "SELECT Customer_Name FROM customer ORDER BY Customer_Name ASC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Add a default empty option
            cmboBoxName.addItem("");

            while (rs.next()) {
                String adminName = rs.getString("Customer_Name");
                cmboBoxName.addItem(adminName); // Add each admin name to the combo box
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Error fetching data for the combo box: " + e.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        cmboBoxName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    e.consume(); // Prevent the default "Enter" action
                }
            }
        });
        
      //should drop down names from database------------------------------------------
        
        objCstmr.setName((String)cmboBoxName.getSelectedItem());
        
        
        textFieldID = new JTextField();
        textFieldID.setFont(new Font("Tahoma", Font.BOLD, 12));
        textFieldID.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldID.setBackground(UIManager.getColor("ComboBox.background"));
        textFieldID.setBounds(262, 45, 33, 41);
        pnlCustomer.add(textFieldID);
        textFieldID.setColumns(10);
        
        cmboBoxName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCustomer_Name = (String) cmboBoxName.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textFieldID.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT CustomerID FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        selectedCustomer_ID = rs.getString("CustomerID");
                        textFieldID.setText(selectedCustomer_ID); // Set the password in the text field
                    } else {
                    	textFieldID.setText(""); // Clear the password field if no password is found
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                            "Error fetching password: " + ex.getMessage(), 
                            "Database Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
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
        
        cmboBoxName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCustomer_Name = (String) cmboBoxName.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textFieldAddress.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Address FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Address = rs.getString("Address");
                        textFieldAddress.setText(Address); // Set the password in the text field
                    } else {
                    	textFieldAddress.setText(""); // Clear the password field if no password is found
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                            "Error fetching password: " + ex.getMessage(), 
                            "Database Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        
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
        
        cmboBoxName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCustomer_Name = (String) cmboBoxName.getSelectedItem();

                if (selectedCustomer_Name == null || selectedCustomer_Name.isEmpty()) {
                	textFieldContactNum.setText(""); // Clear the password field if no admin is selected
                    return;
                }

                try (Connection conn = Connections.getConnection()) { // Use your Connections class
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    String query = "SELECT Contact_Number FROM customer WHERE Customer_Name = ?";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, selectedCustomer_Name);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String Contact_Number = rs.getString("Contact_Number");
                        textFieldContactNum.setText(Contact_Number); // Set the password in the text field
                    } else {
                    	textFieldContactNum.setText(""); // Clear the password field if no password is found
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, 
                            "Error fetching password: " + ex.getMessage(), 
                            "Database Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        objCstmr.setContactNumber(textFieldContactNum.getText());
        
        
        JLabel lblPayment = new JLabel("Payment");
        lblPayment.setForeground(Color.BLACK);
        lblPayment.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblPayment.setBounds(40, 194, 211, 30);
        pnlCustomer.add(lblPayment);
        
        JLabel lblPayment_Peso = new JLabel("₱ ");
        lblPayment_Peso.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblPayment_Peso.setBackground(new Color(225, 225, 225));
        lblPayment_Peso.setBounds(269, 182, 33, 41);
        pnlCustomer.add(lblPayment_Peso);
        
        textFieldPayment = new JTextField();
        textFieldPayment.setColumns(10);
        textFieldPayment.setBounds(300, 183, 282, 40);
        pnlCustomer.add(textFieldPayment);
        
        textFieldPayment.addActionListener(e -> {
        if (!textFieldPayment.getText().trim().isEmpty()) {
        	
        	try {
            	objSales.setCustomerPayment(Double.parseDouble(textFieldPayment.getText()));
            }
        	catch(NumberFormatException ex) {
        		objSales.setCustomerPayment(0);
        		// Handle invalid input
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", 
                        "Input Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        });
        
        
        
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
        lblDate.setFont(new Font("Myanmar Text", Font.BOLD, 24));
        lblDate.setBounds(40, 61, 83, 33);
        pnlSchedule.add(lblDate);
        
        
        textFieldDate = new JTextField();
        textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textFieldDate.setColumns(10);
        textFieldDate.setBounds(114, 56, 298, 41);
        pnlSchedule.add(textFieldDate);
        
        
        JLabel lblTime = new JLabel("Time");
        lblTime.setForeground(Color.BLACK);
        lblTime.setFont(new Font("Myanmar Text", Font.BOLD, 24));
        lblTime.setBounds(40, 121, 83, 33);
        pnlSchedule.add(lblTime);
        
        
        textFieldTime = new JTextField();
        textFieldTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textFieldTime.setColumns(10);
        textFieldTime.setBounds(114, 113, 298, 41);
        pnlSchedule.add(textFieldTime);
        
        objTrans.setTime(textFieldTime.getText());
        
        
        JCheckBox chckbxDateTime = new JCheckBox();
        chckbxDateTime.setBounds(14, 181, 20, 33);
        pnlSchedule.add(chckbxDateTime);
        
        chckbxDateTime.setSelected(true);
        objTrans.setUseRealDnT(chckbxDateTime.isSelected());
        
        
        LocalDate currentDate1 = LocalDate.now();
        LocalTime currentTime1 = LocalTime.now();

        // Format date and time as needed
        dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        timeFormatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Set formatted date and time into the text fields`
        textFieldDate.setText(currentDate1.format(dateFormatter1));
        textFieldTime.setText(currentTime1.format(timeFormatter1));
        
        chckbxDateTime.addItemListener(e -> {
        	
            if (chckbxDateTime.isSelected()) {
                // Fetch the current date and time using java.time
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();

                // Format date and time as needed
                DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter timeFormatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");

                // Set formatted date and time into the text fields
                textFieldDate.setText(currentDate.format(dateFormatter1));
                textFieldTime.setText(currentTime.format(timeFormatter1));
            } else {
                // Clear the text fields when checkbox is unchecked
                textFieldDate.setText("");
                textFieldTime.setText("");
            }

            // Update the object's state
            objTrans.setUseRealDnT(chckbxDateTime.isSelected());
        });
        
        
        JTextArea txtNote = new JTextArea();
        txtNote.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtNote.setText("Note: This would automatically fill up the above slots with \r\nthe current date and time as of the creation of the entry.");
        txtNote.setBackground(new Color(240, 240, 240));
        txtNote.setBounds(40, 181, 437, 33);
        pnlSchedule.add(txtNote);
        txtNote.setEditable(false);
        
        JTextArea txtrUseRealDate = new JTextArea();
        txtrUseRealDate.setFont(new Font("Monospaced", Font.BOLD, 12));
        txtrUseRealDate.setText("Use real date and time.");
        txtrUseRealDate.setBackground(UIManager.getColor("Button.background"));
        txtrUseRealDate.setBounds(40, 164, 319, 22);
        pnlSchedule.add(txtrUseRealDate);
        txtrUseRealDate.setEditable(false);
        
        
//Order Panel------------------------------------------------------------------------------
        JPanel pnlOrder = new JPanel();
        pnlOrder.setLayout(null);
        pnlOrder.setBounds(254, 380, 570, 236);
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
        	//objTrans.setDeliveryMediumContainer((Integer)spnrMediumOrder.getValue());
        	
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
        	//objTrans.setDeliveryLargeContainer((Integer)spnrSmallOrder.getValue());
        	
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
        	//objTrans.setDeliveryLargeContainer((Integer)spnrLargeOrder.getValue());
        	
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
        pnlDelivery.setBounds(255, 625, 570, 50);
        lblBackground.add(pnlDelivery);
        
        
        JCheckBox chckbxDelivery = new JCheckBox("");
        chckbxDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 28));
        chckbxDelivery.setBounds(28, 8, 28, 30);
        pnlDelivery.add(chckbxDelivery);
        
        chckbxDelivery.setSelected(true);
        if(chckbxDelivery.isSelected()) {
        	objTrans.setDelivery(true);
        }
        else if(!chckbxDelivery.isSelected()) {
        	objTrans.setDelivery(false);
        }
        
        
        JLabel lblDelivery = new JLabel("Delivery");
        lblDelivery.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelivery.setForeground(Color.BLACK);
        lblDelivery.setFont(new Font("Myanmar Text", Font.BOLD, 26));
        lblDelivery.setBounds(55, 6, 116, 44);
        pnlDelivery.add(lblDelivery);
        
        JTextArea txtrDeliveryNote = new JTextArea();
        txtrDeliveryNote.setText("Note: This would include a \r\ndelivery fee to the final price");
        txtrDeliveryNote.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtrDeliveryNote.setBackground(UIManager.getColor("Button.background"));
        txtrDeliveryNote.setBounds(190, 6, 288, 47);
        pnlDelivery.add(txtrDeliveryNote);
        txtrDeliveryNote.setEditable(false);
        
        
//Total Fee Panel------------------------------------------------------------------------------
        JPanel pnlTotalFee = new JPanel();
        pnlTotalFee.setBounds(840, 380, 570, 355);
        lblBackground.add(pnlTotalFee);
        pnlTotalFee.setLayout(null);
        
        JLabel lblTotalFee = new JLabel("TOTAL FEE:");
        lblTotalFee.setBounds(10, 9, 181, 41);
        lblTotalFee.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotalFee.setForeground(Color.BLACK);
        lblTotalFee.setFont(new Font("Myanmar Text", Font.BOLD, 33));
        pnlTotalFee.add(lblTotalFee);
        
        JPanel pnlRegularFees = new JPanel();
        pnlRegularFees.setBounds(10, 38, 550, 148);
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
        
     // Database connection setup
        Connection conn1 = null;
        try {
            // Establish the database connection
            conn1 = dbConnections.Connections.getConnection();

            // Query to retrieve the first row's Price_perGallon value from the pricing table
            String selectQuery = "SELECT Price_perGallon FROM pricing LIMIT 1"; // Fetching the first row
            PreparedStatement ps = conn1.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();

            // Check if the query returns any results
            if (rs.next()) {
                // Retrieve the Price_perGallon value from the first row
                double pricePerGallon = rs.getDouble("Price_perGallon");

                // Set the value of lblNewLabel_14 to the retrieved value (formatted as a string)
                lblPricePerGl_int.setText(String.format("%.2f", pricePerGallon)); // Display with 2 decimal places
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to retrieve price. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);

        } finally {
            // Ensure the connection is closed after the operation
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
        
        
        JLabel lblMediumContainerCount = new JLabel("0");
        lblMediumContainerCount.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMediumContainerCount.setBackground(new Color(225, 225, 225));
        lblMediumContainerCount.setBounds(458, 51, 71, 27);
        pnlRegularFees.add(lblMediumContainerCount);
        
        lblMediumContainerCount.setEnabled(false);
        
        spnrMediumOrder.addChangeListener(e -> {
        	
        	/*if("medium spinner increments") {
        	objInvt.setContainerQuantityMedium(objInvt.decreaseContainerQuantityMedium());
        	}else if ("medium spinner decrements") {
        	objInvt.setContainerQuantityMedium(objInvt.increaseContainerQuantityMedium());
        	}*/
        	
        	containerQuantityMedium = (Integer)spnrMediumOrder.getValue();
        	
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
        	
        	//objInvt.setContainerQuantitySmall(objInvt.decreaseContainerQuantitySmall());
        	containerQuantitySmall = (Integer)spnrSmallOrder.getValue();
        	
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
        	
        	//objInvt.setContainerQuantityLarge(objInvt.decreaseContainerQuantityLarge());
        	containerQuantityLarge = (Integer)spnrLargeOrder.getValue();

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
        pnlDeliveryFees.setBounds(10, 191, 550, 35);
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
        lblTotal.setBounds(10, 233, 166, 52);
        pnlTotalFee.add(lblTotal);
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setFont(new Font("Myanmar Text", Font.BOLD, 40));
        
        JPanel pnlTotal = new JPanel();
        pnlTotal.setLayout(null);
        pnlTotal.setBackground(new Color(225, 225, 225));
        pnlTotal.setBounds(167, 230, 393, 41);
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
        lblTotal_Peso.setEnabled(false);
        

//Payment Panel------------------------------------------------------------------------------
        JPanel pnlCstmrPayment = new JPanel();
        pnlCstmrPayment.setLayout(null);
        pnlCstmrPayment.setBackground(new Color(225, 225, 225));
        pnlCstmrPayment.setBounds(281, 275, 279, 35);
        pnlTotalFee.add(pnlCstmrPayment);
        
        JLabel lblCstmrPayment = new JLabel("Customer Payment:");
        lblCstmrPayment.setForeground(Color.BLACK);
        lblCstmrPayment.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblCstmrPayment.setBounds(10, 278, 289, 41);
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
        
        lblCstmrPayment_int.setText(textFieldPayment.getText());
        lblCstmrPayment_Peso.setEnabled(false);
        
        /*textFieldPayment.addActionListener(e -> {
        	if (textFieldPayment.getText().isEmpty()) {
        		lblCstmrPayment_int.setText(textFieldPayment.getText());
        		lblCstmrPayment_Peso.setEnabled(false);
        	}
        	else {
        		lblCstmrPayment_int.setText(textFieldPayment.getText()+".0");
        		lblCstmrPayment_Peso.setEnabled(true);
        	}
        });*/
        
        
        
//Change Panel------------------------------------------------------------------------------
        JPanel pnlChange = new JPanel();
        pnlChange.setLayout(null);
        pnlChange.setBackground(new Color(225, 225, 225));
        pnlChange.setBounds(133, 313, 427, 35);
        pnlTotalFee.add(pnlChange);
        
        JLabel lblChange = new JLabel("Change:");
        lblChange.setForeground(Color.BLACK);
        lblChange.setFont(new Font("Myanmar Text", Font.BOLD, 27));
        lblChange.setBounds(10, 313, 113, 41);
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
        lblChange_Peso.setEnabled(false);
        lblChange_int.setEnabled(false);
        
        
        
// Calculate button----------------------------------------------------------
        JButton btnCalculateTotal = new JButton("CALCULATE");
        btnCalculateTotal.setVerticalAlignment(SwingConstants.TOP);
        btnCalculateTotal.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        btnCalculateTotal.setBounds(365, 688, 160, 38);
        lblBackground.add(btnCalculateTotal);

        objSales.setProfit(0);

        btnCalculateTotal.addActionListener(e -> {

            // Set the delivery flag based on the checkbox state
            objTrans.setDelivery(chckbxDelivery.isSelected());

            // Check if customer payment is empty
            if (textFieldPayment.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                    "Transaction not recorded: No payment entered.", 
                    "Payment Error", 
                    JOptionPane.WARNING_MESSAGE);
                return;  // Exit the method without proceeding further
            }

            // Check if all container values are zero
            if (containerQuantityLarge == 0 && containerQuantityMedium == 0 && containerQuantitySmall == 0) {
                JOptionPane.showMessageDialog(null, 
                    "Transaction not recorded: No containers selected.", 
                    "Container Error", 
                    JOptionPane.WARNING_MESSAGE);
                return;  // Exit the method without proceeding further
            }

            double totalProfitVal = 0, profitVal = 0, pChange = 0;

            // Retrieve container prices from the inventory table
            try (Connection conn = Connections.getConnection()) {
                if (conn == null) {
                    System.out.println("Database connection failed.");
                    return;
                }

             // Corrected query to match the pricing table structure
                String priceQuery = "SELECT Container_Size, Container_Price FROM pricing WHERE Container_Size IN (5, 3, 2.5)";

                try (PreparedStatement priceStmt = conn.prepareStatement(priceQuery);
                     ResultSet priceRs = priceStmt.executeQuery()) {

                    // Fetch the prices for each container size
                    while (priceRs.next()) {
                        double containerSize = priceRs.getDouble("Container_Size");
                        double containerPrice = priceRs.getDouble("Container_Price");

                        // Set the appropriate price based on container size
                        if (containerSize == 5) {
                            objPrice.setWaterPriceLarge(containerPrice);
                        } else if (containerSize == 3) {
                            objPrice.setWaterPriceMedium(containerPrice);
                        } else if (containerSize == 2.5) {
                            objPrice.setWaterPriceSmall(containerPrice);
                        }
                    }

                } catch (SQLException ex) {
                    System.err.println("Error fetching prices from pricing table: " + ex.getMessage());
                }


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error connecting to the database: " + ex.getMessage(), 
                    "Connection Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculate profits
            profitVal += (objPrice.getWaterPriceLarge() * containerQuantityLarge) + (objSales.getServiceFee() * containerQuantityLarge);
            profitVal += (objPrice.getWaterPriceMedium() * containerQuantityMedium) + (objSales.getServiceFee() * containerQuantityMedium);
            profitVal += (objPrice.getWaterPriceSmall() * containerQuantitySmall) + (objSales.getServiceFee() * containerQuantitySmall);

            if (!textFieldPayment.getText().trim().isEmpty()) {
                lblCstmrPayment_int.setText(textFieldPayment.getText() + ".0");
                lblCstmrPayment_Peso.setEnabled(true);

                try {
                    objSales.setCustomerPayment(Double.parseDouble(textFieldPayment.getText()));
                } catch (NumberFormatException ex) {
                    objSales.setCustomerPayment(0);
                    // Handle invalid input
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                lblCstmrPayment_int.setText(textFieldPayment.getText());
                lblCstmrPayment_Peso.setEnabled(false);
            }

            if (objTrans.isDelivery()) {
                profitVal += objSales.getDeliveryFee();
            }

            totalProfitVal = profitVal;
            objSales.setProfit(totalProfitVal);

            pChange = objSales.calculateTransaction();
            lblChange_int.setText(String.valueOf(objSales.getChange()));
            lblChange_Peso.setEnabled(true);

            if (totalProfitVal > 0) {
                lblTotal_int.setText(String.valueOf(objSales.getProfit()));
                lblTotal_int.setEnabled(true);
                lblTotal_Peso.setEnabled(true);
                lblChange_int.setText(String.valueOf(objSales.getChange()));
                lblChange_int.setEnabled(true);
                lblChange_Peso.setEnabled(true);
            } else {
                objSales.setProfit(0);
                totalProfitVal = 0;
                lblTotal_int.setEnabled(false);
                lblTotal_int.setText("0.0");
                lblTotal_Peso.setEnabled(false);
                lblChange_int.setText("0.0");
                lblChange_Peso.setEnabled(false);
            }

        });

        
        JButton btnRecordEntry = new JButton("RECORD");
        btnRecordEntry.setVerticalAlignment(SwingConstants.TOP);
        btnRecordEntry.setFont(new Font("Myanmar Text", Font.BOLD, 19));
        btnRecordEntry.setBounds(546, 688, 160,38);
        lblBackground.add(btnRecordEntry);

        btnRecordEntry.addActionListener(e -> {
            // Check if the customer fields are empty (adjust the field names based on your UI)
            if (selectedCustomer_ID == null || selectedCustomer_ID.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                    "Please select a customer. The customer ID cannot be empty.", 
                    "Missing Customer", 
                    JOptionPane.WARNING_MESSAGE);
                return;  // Stop further processing if the customer ID is empty
            }

            // Check if the payment field is empty or containers are not selected
            if (textFieldPayment.getText().trim().isEmpty() && (containerQuantityLarge == 0 && containerQuantityMedium == 0 && containerQuantitySmall == 0)) {
                JOptionPane.showMessageDialog(null, 
                    "Warning: Customer selected but no payment entered and no containers selected.", 
                    "Missing Data", 
                    JOptionPane.WARNING_MESSAGE);
                return;  // Stop further processing
            }

            // Check if Date and Time are empty (ensure they are properly set)
            String currentDate = dateFormatter1.format(java.time.LocalDate.now());
            String currentTime = timeFormatter1.format(java.time.LocalTime.now());

            if (currentDate == null || currentDate.trim().isEmpty() || currentTime == null || currentTime.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                    "Error: Date and Time cannot be empty.", 
                    "Missing Date/Time", 
                    JOptionPane.WARNING_MESSAGE);
                return;  // Stop further processing if Date/Time is empty
            }

            // Ask if the user is sure about finalizing the transaction
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to finalize this transaction?", 
                    "Confirm Transaction", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);

            // If the user clicks 'Yes', proceed with the calculation
            if (confirmation == JOptionPane.YES_OPTION) {

                Boolean delivery = chckbxDelivery.isSelected();
                Double total = Double.parseDouble(lblTotal_int.getText());
                Double payment = Double.parseDouble(textFieldPayment.getText());
                double change = Double.parseDouble(lblChange_int.getText());

                boolean salesInserted = false;
                boolean catalogInsertedOrUpdated = false;

                try (Connection conn = Connections.getConnection()) {
                    if (conn == null) {
                        System.out.println("Database connection failed.");
                        return;
                    }

                    
                    // Determine the Date_ID
                    int dateID = 1;
                    String checkDateQuery = "SELECT MAX(DateID) AS LastDateID, MAX(Date) AS LastDate FROM sales";
                    try (PreparedStatement stmt = conn.prepareStatement(checkDateQuery)) {
                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            lastDate = rs.getString("LastDate");
                            int lastDateID = rs.getInt("LastDateID");

                            if (currentDate.equals(lastDate)) {
                                dateID = lastDateID;
                            } else {
                                dateID = lastDateID + 1;
                            }
                        }
                    }
                    
                 // Check if a record for the current DateID exists in the SalesCatalog table
                    String checkCatalogQuery = "SELECT COUNT(*) FROM salescatalog WHERE DateID = ?";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkCatalogQuery)) {
                        checkStmt.setInt(1, dateID);
                        ResultSet rs = checkStmt.executeQuery();
                        
                        if (rs.next() && rs.getInt(1) == 0) {
                            // No record exists for this DateID, insert a new one
                            String insertSalesCatalogQuery = "INSERT INTO salescatalog (DateID, TotalSales, Expenses, TotalProfit) " +
                                                             "VALUES (?, ?, ?, ?)"; // Assume Expenses is initially 0
                            
                            try (PreparedStatement insertStmt = conn.prepareStatement(insertSalesCatalogQuery)) {
                            	int expenses = objExps.calculateWages();
                            	
                                insertStmt.setInt(1, dateID);   // Set DateID
                                insertStmt.setDouble(2, 0); // Initial TotalSales
                                insertStmt.setDouble(3, expenses); // Initial TotalProfit (TotalSales - Expenses)
                                insertStmt.setDouble(4, 0);
                                
                                int rowsInserted = insertStmt.executeUpdate();
                                if (rowsInserted > 0) {
                                    System.out.println("New entry added to SalesCatalog for DateID: " + dateID);
                                }
                            }
                        }

                        // Update TotalSales and TotalProfit for the existing record (or newly inserted record)
                        String updateSalesCatalogQuery = "UPDATE salescatalog " +
                                                          "SET TotalSales = TotalSales + ?, " +
                                                          "    TotalProfit = TotalSales - Expenses " +
                                                          "WHERE DateID = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSalesCatalogQuery)) {
                            updateStmt.setDouble(1, total); // Add the current transaction's total to TotalSales // Recalculate TotalProfit
                            updateStmt.setInt(2, dateID);   // Use the current DateID as reference

                            int rowsAffected = updateStmt.executeUpdate();
                            if (rowsAffected > 0) {
                                System.out.println("SalesCatalog updated successfully.");
                            } else {
                                System.out.println("Failed to update SalesCatalog.");
                            }
                        }
                    }
                    
                    if (lastDate != null && !currentDate.equals(lastDate)) {
                        // Reset customer lent container values to 0
                        String resetCustomerQuery = "UPDATE customer SET Lent_Large_Container = 0, Lent_Medium_Container = 0, Lent_Small_Container = 0";
                        try (PreparedStatement stmt = conn.prepareStatement(resetCustomerQuery)) {
                            stmt.executeUpdate();
                        }

                        // Reset inventory: Set Lent_Quantity to 0 and In_Storage_Quantity to Total_Quantity
                        String resetInventoryQuery = "UPDATE inventory SET Lent_Quantity = 0, In_Storage_Quantity = Total_Quantity";
                        try (PreparedStatement stmt = conn.prepareStatement(resetInventoryQuery)) {
                            stmt.executeUpdate();
                        }
                    }

                    // Check if there are enough containers in inventory
                    String checkInventoryQuery = "SELECT In_Storage_Quantity FROM inventory WHERE Container_Type = ?";
                    boolean insufficientContainers = false;

                    // Check large containers
                    try (PreparedStatement checkLargeStmt = conn.prepareStatement(checkInventoryQuery)) {
                        checkLargeStmt.setString(1, "Large");
                        ResultSet rsLarge = checkLargeStmt.executeQuery();
                        if (rsLarge.next()) {
                            int inStorageLarge = rsLarge.getInt("In_Storage_Quantity");
                            if (inStorageLarge < containerQuantityLarge) {
                                JOptionPane.showMessageDialog(null, 
                                    "Insufficient Large Containers in stock. Transaction cannot be completed.", 
                                    "Insufficient Inventory", 
                                    JOptionPane.WARNING_MESSAGE);
                                insufficientContainers = true;
                            }
                        }
                    }

                    // Check medium containers
                    try (PreparedStatement checkMediumStmt = conn.prepareStatement(checkInventoryQuery)) {
                        checkMediumStmt.setString(1, "Medium");
                        ResultSet rsMedium = checkMediumStmt.executeQuery();
                        if (rsMedium.next()) {
                            int inStorageMedium = rsMedium.getInt("In_Storage_Quantity");
                            if (inStorageMedium < containerQuantityMedium) {
                                JOptionPane.showMessageDialog(null, 
                                    "Insufficient Medium Containers in stock. Transaction cannot be completed.", 
                                    "Insufficient Inventory", 
                                    JOptionPane.WARNING_MESSAGE);
                                insufficientContainers = true;
                            }
                        }
                    }

                    // Check small containers
                    try (PreparedStatement checkSmallStmt = conn.prepareStatement(checkInventoryQuery)) {
                        checkSmallStmt.setString(1, "Small");
                        ResultSet rsSmall = checkSmallStmt.executeQuery();
                        if (rsSmall.next()) {
                            int inStorageSmall = rsSmall.getInt("In_Storage_Quantity");
                            if (inStorageSmall < containerQuantitySmall) {
                                JOptionPane.showMessageDialog(null, 
                                    "Insufficient Small Containers in stock. Transaction cannot be completed.", 
                                    "Insufficient Inventory", 
                                    JOptionPane.WARNING_MESSAGE);
                                insufficientContainers = true;
                            }
                        }
                    }

                    // If there are insufficient containers, stop the transaction
                    if (insufficientContainers) {
                        return;
                    }

                    // Insert into sales table
                    String query = "INSERT INTO sales (DateID, CustomerID, Date, Time, Sold_Large_Container, " +
                            "Sold_Medium_Container, Sold_Small_Container, Delivery, Total_Fees, " +
                            "Customer_Payment, Customer_Change) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement stmt = conn.prepareStatement(query)) {
                        stmt.setInt(1, dateID); // DateID
                        stmt.setInt(2, Integer.valueOf(selectedCustomer_ID)); // CustomerID
                        stmt.setString(3, currentDate); // Date
                        stmt.setString(4, currentTime); // Time
                        stmt.setInt(5, containerQuantityLarge); // Sold_Large_Container
                        stmt.setInt(6, containerQuantityMedium); // Sold_Medium_Container
                        stmt.setInt(7, containerQuantitySmall); // Sold_Small_Container
                        stmt.setBoolean(8, delivery); // Delivery
                        stmt.setDouble(9, total); // Total_Fees
                        stmt.setDouble(10, payment); // Customer_Payment
                        stmt.setDouble(11, change); // Customer_Change

                        int rowsAffected = stmt.executeUpdate();
                        if (rowsAffected > 0) {
                            salesInserted = true;
                        }
                    }

                    // Update the customer table to reflect the lent containers
                    String updateCustomerQuery = "UPDATE customer SET " +
                            "Lent_Large_Container = Lent_Large_Container + ?, " +
                            "Lent_Medium_Container = Lent_Medium_Container + ?, " +
                            "Lent_Small_Container = Lent_Small_Container + ? " +
                            "WHERE CustomerID = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateCustomerQuery)) {
                        updateStmt.setInt(1, containerQuantityLarge); // Lent_Large_Container
                        updateStmt.setInt(2, containerQuantityMedium); // Lent_Medium_Container
                        updateStmt.setInt(3, containerQuantitySmall); // Lent_Small_Container
                        updateStmt.setInt(4, Integer.parseInt(selectedCustomer_ID)); // CustomerID

                        updateStmt.executeUpdate();
                    }

                 // Update the inventory table to adjust In_Storage_Quantity and Lent_Quantity
                    String updateInventoryQuery = "UPDATE inventory SET " +
                            "In_Storage_Quantity = In_Storage_Quantity - ?, " +
                            "Lent_Quantity = Lent_Quantity + ? " +
                            "WHERE Container_Type = ?";

                    try {
                        // Update for large containers
                        if (containerQuantityLarge > 0) {
                            try (PreparedStatement updateInvStmt = conn.prepareStatement(updateInventoryQuery)) {
                                updateInvStmt.setInt(1, containerQuantityLarge); // Decrease In_Storage_Quantity
                                updateInvStmt.setInt(2, containerQuantityLarge); // Increase Lent_Quantity
                                updateInvStmt.setString(3, "5/gl Large"); // Container_Type for large

                                int rowsAffected = updateInvStmt.executeUpdate();
                                if (rowsAffected == 0) {
                                    System.out.println("No rows updated for Large containers.");
                                }
                            }
                        }

                        // Update for medium containers
                        if (containerQuantityMedium > 0) {
                            try (PreparedStatement updateInvStmt = conn.prepareStatement(updateInventoryQuery)) {
                                updateInvStmt.setInt(1, containerQuantityMedium); // Decrease In_Storage_Quantity
                                updateInvStmt.setInt(2, containerQuantityMedium); // Increase Lent_Quantity
                                updateInvStmt.setString(3, "3/gl Medium"); // Container_Type for medium

                                int rowsAffected = updateInvStmt.executeUpdate();
                                if (rowsAffected == 0) {
                                    System.out.println("No rows updated for Medium containers.");
                                }
                            }
                        }

                        // Update for small containers
                        if (containerQuantitySmall > 0) {
                            try (PreparedStatement updateInvStmt = conn.prepareStatement(updateInventoryQuery)) {
                                updateInvStmt.setInt(1, containerQuantitySmall); // Decrease In_Storage_Quantity
                                updateInvStmt.setInt(2, containerQuantitySmall); // Increase Lent_Quantity
                                updateInvStmt.setString(3, "2.5/gl Small"); // Container_Type for small

                                int rowsAffected = updateInvStmt.executeUpdate();
                                if (rowsAffected == 0) {
                                    System.out.println("No rows updated for Small containers.");
                                }
                            }
                        }

                    } catch (SQLException ex) {
                        // Handle exceptions here for all inventory updates
                        System.err.println("Error executing inventory update: " + ex.getMessage());
                    }

                    // Handle results and show appropriate messages
                    if (salesInserted) {
                        JOptionPane.showMessageDialog(null, 
                            "Transaction successfully recorded.", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, 
                            "Error: Transaction was not recorded.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Error inserting data into the database: " + ex.getMessage(),
                            "Database Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });




    }
}
