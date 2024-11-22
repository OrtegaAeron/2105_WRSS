package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

import backend.Admin;

public class LogIn extends JFrame{

	Admin obj = new Admin();

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JTextField txtFieldAdmin;
    private JLabel textAdmin;
    private JLabel textPassword;
    private JPasswordField passwordField;
    private JLabel textAdmin_1;

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
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/resources/Logo_Big.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 526);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Setting up content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Adding background image label
        JLabel lblBackground = new JLabel(new ImageIcon(LogIn.class.getResource("/resources/Login.png")));
        lblBackground.setBounds(0, 0, 706, 489);
        contentPane.add(lblBackground);
        lblBackground.setLayout(null);
        
     // Logo label
        lblLogo = new JLabel(new ImageIcon(LogIn.class.getResource("/resources/Logo_Big.png")));
        lblBackground.add(lblLogo);
        lblLogo.setBounds(301, 71, 103, 103);
        
     // FlowStation title label
        JLabel lblFlowstation = new JLabel("FLOWSTATION™");
        lblFlowstation.setForeground(new Color(255, 255, 255));
        lblFlowstation.setFont(new Font("Myanmar Text", Font.BOLD, 37));
        lblFlowstation.setBounds(206, 183, 293, 42);
        lblBackground.add(lblFlowstation);
        
        //Admin text
        textAdmin = new JLabel("Admin:");
        textAdmin.setForeground(new Color(255, 255, 255));
        textAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        textAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBackground.add(textAdmin);
        textAdmin.setBounds(197, 259, 56, 18);

        // Username field
        txtFieldAdmin = new JTextField();
        txtFieldAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtFieldAdmin.setBounds(253, 251, 199, 35);
        lblBackground.add(txtFieldAdmin);
        txtFieldAdmin.setColumns(10);
        
        obj.setAdminName(txtFieldAdmin.getText());
        
       //Password text
        textPassword = new JLabel("Password:");
        textPassword.setForeground(new Color(255, 255, 255));
        textPassword.setHorizontalAlignment(SwingConstants.CENTER);
        textPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBackground.add(textPassword);
        textPassword.setBounds(172, 298, 82, 18);
        
        //Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(253, 291, 199, 35);
        lblBackground.add(passwordField);
        
        char[] passwordChars = passwordField.getPassword();
        obj.setPassword(new String(passwordChars)); // Convert char[] to String if obj.setPassword requires a String
        
        //show password label
        JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password:");
        chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
        chckbxNewCheckBox.setBackground(new Color(65, 134, 255));
        chckbxNewCheckBox.setBounds(230, 336, 120, 20);
        lblBackground.add(chckbxNewCheckBox);
        
        
        textAdmin_1 = new JLabel();
        textAdmin_1.setForeground(Color.WHITE);
        textAdmin_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        textAdmin_1.setBounds(350, 336, 120, 20);
        lblBackground.add(textAdmin_1);

        textAdmin_1.setText(" ");
    	KeyAdapter keyAdapter = new KeyAdapter() {
    	    @Override
    	    public void keyReleased(KeyEvent e) {
    	        textAdmin_1.setText(new String(passwordField.getPassword()));
    	    }
    	};

    	chckbxNewCheckBox.addActionListener(e -> {
    	    if (chckbxNewCheckBox.isSelected()) {
    	        passwordField.addKeyListener(keyAdapter);
    	        textAdmin_1.setText(new String(passwordField.getPassword()));
    	    } else {
    	        passwordField.removeKeyListener(keyAdapter);
    	        textAdmin_1.setText(" ");
    	    }
    	});
        
        
        // Log-in Button
        JButton btnLogIn = new JButton("Log-In");
        btnLogIn.setBounds(291, 360, 123, 20);
        lblBackground.add(btnLogIn);
        
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the entered username and password
                String enteredUsername = txtFieldAdmin.getText();
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                // Use the Admin class's login method
                boolean isAuthenticated = obj.login(enteredUsername, enteredPassword);

                if (isAuthenticated) {
                    JOptionPane.showMessageDialog(null, 
                            "Login successful!", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the current Transactions frame
                    Transactions transactionsFrame = new Transactions(); // Open the Customers frame
                    transactionsFrame.setVisible(true); ; // Set the AdminSettings frame visible
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Incorrect username or password. Please try again.", 
                            "Login Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Exit Button
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(291, 385, 123, 20);
        lblBackground.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });

   
    }
}