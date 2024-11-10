package backend;

public class Expenses extends Sales{
    private int deliveryManDailySalary = 500, noOfDeliveryMan = 2, wages;
    private double totalExpense;
    private boolean delivery = true;

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
    
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
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
    
    public boolean isDelivery() {
        return delivery;
    }
    
    //methods-----------------------------------------------------
    int calculateWages(deliveryManDailySalary, noOfDeliveryMan){
        return wages;
    }
    
    double calculateTotalExpense(wages, travelExpense){
        return totalExpense;
    }
    
    void ifDelivery(totalExpense){
        return totalExpense;
    }
}
