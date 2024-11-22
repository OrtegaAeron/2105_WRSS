package dbConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Connections {
	
    static Connection con;
    
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flowstation_db","root","");
        } catch (Exception ex) {
        	System.out.println(""+ex);
        }
        return con;
    }
}
