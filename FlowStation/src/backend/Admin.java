package backend;
import java.sql.*;

public class Admin {
    
    private String adminName;
    private String password;
    private String passkey = "supersecret";

	//getters----------------------------------------------
    public String getAdminName() {
        return adminName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getPasskey() {
		return passkey;
	}

    //setters----------------------------------------------
    public void setAdminName(String username) {
        this.adminName = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPasskey(String passkey) {
		this.passkey = passkey;
	}
    
    //methods---------------------------------------------
    void login(String username, String password){
        //check if log in credentials are in the admins table in  the database
    	//if they are 
    }
    
    
    void signup(String username, String password){
        //add new admin to the database table
    }
    
    void updateAdmin() {
    	//update existing admins
    }
    
}
