package backend;
import backend.Transactions_bcknd;

public class Customers_bcknd{

	//Transactions_bcknd obj = new Transactions_bcknd();
	
    private String name;
    private String customerAddress;
    private String contactNumber;
    
    private int largeLentContainer; //= obj.getDeliveryLargeContainer();
    private int mediumLentContainer; //= obj.getDeliveryMediumContainer();
    private int smallLentContainer; //= obj.getDeliverySmallContainer();

    //setters-----------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setLargeLentContainer(int largeLentContainer) {
        this.largeLentContainer = largeLentContainer;
    }

    public void setMediumLentContainer(int mediumLentContainer) {
        this.mediumLentContainer = mediumLentContainer;
    }

    public void setSmallLentContainer(int smallLentContainer) {
        this.smallLentContainer = smallLentContainer;
    }

    //getters------------------------------------------
    public String getName() {
        return name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public int getLargeLentContainer() {
        return largeLentContainer;
    }

    public int getMediumLentContainer() {
        return mediumLentContainer;
    }

    public int getSmallLentContainer() {
        return smallLentContainer;
    }
    
    //methods----------------------------------------------
    void viewCustomer(){
        //sql command to show database data from Customers table to gui customers table
    }
    
    void newCustomer(){
        //sql command to add new customers
    }
    
    void updateCustomer(){
        //sql command to uodate old customers
    }
    
    void deleteCustomer(){
        //sql command to delete a customer from the database based on 
    }
}
