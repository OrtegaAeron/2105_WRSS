package backend;

public class Expenses extends Sales{
    private int deliveryManDailySalary = 500, noOfDeliveryMan = 2, wages;
    private double totalExpense;

    //setters--------------------------------------------------------------
    public void setDeliveryManDailySalary(int deliveryManDailySalary) {
        this.deliveryManDailySalary = deliveryManDailySalary;
    }

    public void setNoOfDeliveryMan(int noOfDeliveryMan) {
        this.noOfDeliveryMan = noOfDeliveryMan;
    }

    public void setWages(int wages) {
        this.wages = wages;
    }
    
    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    //getters------------------------------------
    public int getDeliveryManDailySalary() {
        return deliveryManDailySalary;
    }

    public int getNoOfDeliveryMan() {
        return noOfDeliveryMan;
    }
    
    public int getWages() {
        return wages;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    
    //methods-----------------------------------------------------
    void calculateWages(){
    	wages = deliveryManDailySalary * noOfDeliveryMan;
    }
    
    void calculateTotalExpense(){
    	if (isDelivery() == true){
    		totalExpense = wages + getDeliveryFee();
    	}
    	else{
    		totalExpense = wages;
    	}
    }
}
