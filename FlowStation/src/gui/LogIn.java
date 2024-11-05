package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel_1;
    private JTextField textField;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_3;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogIn frame = new LogIn();
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
    public LogIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 526);
        setLocationRelativeTo(null);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel backgroundLabel = new JLabel(new ImageIcon(LogIn.class.getResource("/gui/Login.png")));
        backgroundLabel.setBounds(0, 0, 706, 489);
        contentPane.add(backgroundLabel);
        backgroundLabel.setLayout(null);
        
     // Logo label
        lblNewLabel_1 = new JLabel(new ImageIcon(LogIn.class.getResource("/gui/Logo_Big.png")));
        backgroundLabel.add(lblNewLabel_1);
        lblNewLabel_1.setBounds(301, 71, 103, 103);
        
        //Admin text
        lblNewLabel = new JLabel("Admin:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(lblNewLabel);
        lblNewLabel.setBounds(198, 259, 56, 18);
        
        //Password text
        lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        backgroundLabel.add(lblNewLabel_3);
        lblNewLabel_3.setBounds(176, 298, 82, 18);

        // Username field
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField.setBounds(253, 251, 199, 35);
        backgroundLabel.add(textField);
        textField.setColumns(10);
        
        //Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(253, 291, 199, 35);
        backgroundLabel.add(passwordField);

        // FlowStation title label
        JLabel lblNewLabel_2 = new JLabel("FLOWSTATION™");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Myanmar Text", Font.BOLD, 37));
        lblNewLabel_2.setBounds(206, 183, 293, 42);
        backgroundLabel.add(lblNewLabel_2);
        
        // Log-in Button
        JButton btnExit = new JButton("Log-In");
        btnExit.setBounds(291, 339, 123, 20);
        backgroundLabel.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Transactions transactionsFrame = new Transactions(); // Open the Customers frame
                transactionsFrame.setVisible(true); // Set the Customers frame visible
            }
        });

        // Exit Button
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.setBounds(291, 364, 123, 20);
        backgroundLabel.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });

   
    }
}