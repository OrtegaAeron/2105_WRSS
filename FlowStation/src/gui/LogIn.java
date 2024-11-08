package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class LogIn extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JTextField txtFieldAdmin;
    private JLabel textAdmin;
    private JLabel textPassword;
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
    	setTitle("FlowStation");
    	setIconImage(Toolkit.getDefaultToolkit().getImage(LogIn.class.getResource("/resources/Logo_Big.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 720, 526);
        setLocationRelativeTo(null);
        
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
        
        //Admin text
        textAdmin = new JLabel("Admin:");
        textAdmin.setForeground(new Color(255, 255, 255));
        textAdmin.setHorizontalAlignment(SwingConstants.CENTER);
        textAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBackground.add(textAdmin);
        textAdmin.setBounds(197, 259, 56, 18);
        
        //Password text
        textPassword = new JLabel("Password:");
        textPassword.setForeground(new Color(255, 255, 255));
        textPassword.setHorizontalAlignment(SwingConstants.CENTER);
        textPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBackground.add(textPassword);
        textPassword.setBounds(172, 298, 82, 18);

        // Username field
        txtFieldAdmin = new JTextField();
        txtFieldAdmin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtFieldAdmin.setBounds(253, 251, 199, 35);
        lblBackground.add(txtFieldAdmin);
        txtFieldAdmin.setColumns(10);
        
        //Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(253, 291, 199, 35);
        lblBackground.add(passwordField);

        // FlowStation title label
        JLabel lblFlowstation = new JLabel("FLOWSTATION™");
        lblFlowstation.setForeground(new Color(255, 255, 255));
        lblFlowstation.setFont(new Font("Myanmar Text", Font.BOLD, 37));
        lblFlowstation.setBounds(206, 183, 293, 42);
        lblBackground.add(lblFlowstation);
        
        // Log-in Button
        JButton btnLogIn = new JButton("Log-In");
        btnLogIn.setBounds(291, 339, 123, 20);
        lblBackground.add(btnLogIn);
        
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Transactions transactionsFrame = new Transactions(); // Open the Customers frame
                transactionsFrame.setVisible(true); // Set the Customers frame visible
            }
        });

        // Exit Button
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(291, 364, 123, 20);
        lblBackground.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });

   
    }
}