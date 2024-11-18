package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class AdminSettingsLogIn extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblLogo;
    private JLabel textPassword;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	AdminSettingsLogIn frame = new AdminSettingsLogIn();
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
    public AdminSettingsLogIn() {
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
        
        //Password text
        textPassword = new JLabel("Pass Key:");
        textPassword.setForeground(new Color(255, 255, 255));
        textPassword.setHorizontalAlignment(SwingConstants.CENTER);
        textPassword.setFont(new Font("Myanmar Text", Font.BOLD, 15));
        lblBackground.add(textPassword);
        textPassword.setBounds(176, 265, 82, 18);
        
        //Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(253, 256, 199, 35);
        lblBackground.add(passwordField);

        // FlowStation title label
        JLabel lblFlowstation = new JLabel("FLOWSTATION™");
        lblFlowstation.setForeground(new Color(255, 255, 255));
        lblFlowstation.setFont(new Font("Myanmar Text", Font.BOLD, 37));
        lblFlowstation.setBounds(206, 183, 293, 42);
        lblBackground.add(lblFlowstation);
        
        JLabel lblNewLabel = new JLabel("-Admin Settings-");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Myanmar Text", Font.PLAIN, 25));
        lblNewLabel.setBounds(260, 217, 200, 30);
        lblBackground.add(lblNewLabel);
        
        // Log-in Button
        JButton btnLogIn = new JButton("Enter");
        btnLogIn.setBounds(291, 302, 123, 20);
        lblBackground.add(btnLogIn);
        
        btnLogIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                AdminSettings  adminSettingsFrame = new AdminSettings (); // Open the Customers frame
                adminSettingsFrame.setVisible(true); // Set the Customers frame visible
            }
        });

        // Exit Button
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(291, 328, 123, 20);
        lblBackground.add(btnExit);
        
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Transactions frame
                Transactions transactionsFrame = new Transactions(); // Open the Customers frame
                transactionsFrame.setVisible(true); // Set the Customers frame visible
            }
        });

   
    }
}