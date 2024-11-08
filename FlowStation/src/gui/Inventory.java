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
import java.awt.Toolkit;

public class Inventory extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Inventory frame = new Inventory();
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
    public Inventory() {
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Inventory.class.getResource("/resources/Logo_Small.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1440, 780);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(Inventory.class.getResource("/resources/Main.png")));
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
        JLabel lblNewLabel_3 = new JLabel("Inventory");
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
        
        lblNewLabel_1 = new JLabel(new ImageIcon(Inventory.class.getResource("/resources/Logo_Small.png")));
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
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBackground(new Color(16, 68, 160));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
        btnNewButton_2.setBounds(0, 342, 238, 50);
        panel_1.add(btnNewButton_2);
        
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
        panel_2.setBounds(290, 129, 1093, 310);
        panel_2.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(9, 11, 1075, 290);
        panel_2.add(scrollPane);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"  1", "   5gl / Large Container", "   ", "   ", "   "},
        		{"  2", "   3gl / Medium Container", "   ", "   ", "   "},
        		{"  3", "   2.5gl / Small Container", "   ", "   ", "  "},
        	},
        	new String[] {
        		"Inventory ID", "Container", "In-Storage Quantity", "Lent Quantity", "Total Quantity"
        	}
        ));
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.getColumnModel().getColumn(1).setMaxWidth(3000);
        table.getColumnModel().getColumn(2).setPreferredWidth(99);
        table.getColumnModel().getColumn(2).setMaxWidth(1500);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setMaxWidth(1500);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setMaxWidth(1500);
        
        int rowCount = table.getRowCount();
        int scrollPaneHeight = scrollPane.getHeight();
        if (rowCount > 0) {
            int rowHeight = scrollPaneHeight / rowCount;
            table.setRowHeight(rowHeight-6);
        }
        
        table.setBounds(0, 0, 1075, 290);
        table.setLayout(null);
        scrollPane.setViewportView(table);
        
        JPanel panel_3 = new JPanel();
        backgroundLabel.add(panel_3);
        panel_3.setLayout(null);
        panel_3.setBounds(290, 451, 537, 282);
        
        JLabel lblNewLabel = new JLabel("ADD NEW CONTAINERS:");
        lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 30));
        lblNewLabel.setBounds(18, 18, 382, 36);
        panel_3.add(lblNewLabel);
        
        JLabel lblgllarge = new JLabel("5gl/L Container:");
        lblgllarge.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblgllarge.setBounds(18, 71, 271, 36);
        panel_3.add(lblgllarge);
        
        JLabel lblglmContainer = new JLabel("3gl/M Container:");
        lblglmContainer.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblglmContainer.setBounds(18, 132, 287, 36);
        panel_3.add(lblglmContainer);
        
        JLabel lblgllarge_1_1 = new JLabel("2.5gl/S Container:");
        lblgllarge_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblgllarge_1_1.setBounds(20, 194, 306, 36);
        panel_3.add(lblgllarge_1_1);
        
        JSpinner spinner_1 = new JSpinner();
        spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1.setBounds(215, 64, 298, 48);
        panel_3.add(spinner_1);
        
        JSpinner spinner_1_1 = new JSpinner();
        spinner_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1_1.setBounds(215, 125, 298, 48);
        panel_3.add(spinner_1_1);
        
        JSpinner spinner_1_1_1 = new JSpinner();
        spinner_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1_1_1.setBounds(215, 186, 298, 48);
        panel_3.add(spinner_1_1_1);
        
        JButton btnNewButton_7 = new JButton("ADD");
        btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_7.setBounds(225, 244, 85, 28);
        panel_3.add(btnNewButton_7);
        
        JPanel panel_4 = new JPanel();
        backgroundLabel.add(panel_4);
        panel_4.setLayout(null);
        panel_4.setBounds(838, 451, 545, 282);
        
        JLabel lblRemoveOldContainers = new JLabel("REMOVE OLD CONTAINERS:");
        lblRemoveOldContainers.setFont(new Font("Myanmar Text", Font.BOLD, 30));
        lblRemoveOldContainers.setBounds(18, 18, 448, 36);
        panel_4.add(lblRemoveOldContainers);
        
        JLabel lblgllarge_1 = new JLabel("5gl/L Container:");
        lblgllarge_1.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblgllarge_1.setBounds(18, 71, 169, 35);
        panel_4.add(lblgllarge_1);
        
        JLabel lblglmContainer_1 = new JLabel("3gl/M Container:");
        lblglmContainer_1.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblglmContainer_1.setBounds(18, 132, 179, 35);
        panel_4.add(lblglmContainer_1);
        
        JLabel lblgllarge_1_1_1 = new JLabel("2.5gl/S Container:");
        lblgllarge_1_1_1.setFont(new Font("Myanmar Text", Font.BOLD, 22));
        lblgllarge_1_1_1.setBounds(20, 194, 190, 35);
        panel_4.add(lblgllarge_1_1_1);
        
        JSpinner spinner_1_2 = new JSpinner();
        spinner_1_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1_2.setBounds(215, 64, 298, 48);
        panel_4.add(spinner_1_2);
        
        JSpinner spinner_1_3 = new JSpinner();
        spinner_1_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1_3.setBounds(215, 125, 298, 48);
        panel_4.add(spinner_1_3);
        
        JSpinner spinner_1_4 = new JSpinner();
        spinner_1_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
        spinner_1_4.setBounds(215, 186, 298, 48);
        panel_4.add(spinner_1_4);
        
        JButton btnNewButton_7_1 = new JButton("REMOVE");
        btnNewButton_7_1.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_7_1.setBounds(215, 244, 103, 28);
        panel_4.add(btnNewButton_7_1);
        
        
    }
}
