package backend;

public class Customers {
    private String name;
    private String customerAddress;
    private String contactNumber;
    
    private int largeLentContainer = getDeliveryLargeContainer();
    private int mediumLentContainer = getDeliveryMediumContainer();
    private int smallLentContainer = getDeliverySmallContainer();

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
        
    }
    
    void newCustomer(){
        
    }
    
    void updateCustomer(){
        
    }
    
    void deleteCustomer(){
        
    }
    
}
