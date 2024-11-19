package backend;
import java.sql.*;

public class Sales extends Transactions_bcknd{
    
    private double profit, serviceFee = 3.00, customerPayment, change, deliveryFee = 10.00;

	//setters------------------------------------------
    public void setProfit(double profit) {
        this.profit = profit;
    }
    
    public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
    
    public void setCustomerPayment(double customerPayment) {
		this.customerPayment = customerPayment;
	}
    
    public void setChange(double change) {
		this.change = change;
	}
    
    public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

    //getters--------------------------------------------
    public double getProfit() {
        return profit;
    }
    
    public double getServiceFee() {
		return serviceFee;
	}
    
    public double getCustomerPayment() {
		return customerPayment;
	}
    
    public double getChange() {
		return change;
	}
    
    public double getDeliveryFee() {
		return deliveryFee;
	}
    
    //methods---------------------------------
    
    public double calculateFinalProfit() {
    	if (isYesLargeContainer() == true){
    		profit += (getWaterPriceLarge() * getOutBoundContainer_L()) + (serviceFee * getOutBoundContainer_L());
    	}
    	else if(isYesMediumContainer() == true) {
    		profit += (getWaterPriceMedium() * getOutBoundContainer_M()) + (serviceFee * getOutBoundContainer_M());
    	}
    	else if(isYesSmallContainer() == true) {
    		profit += (getWaterPriceSmall() * getOutBoundContainer_S()) + (serviceFee * getOutBoundContainer_S());
    	}
    	
    	if (isDelivery() == true) {
    		profit += deliveryFee;
    	}
    	
    	return profit;
    }
    
    public double calculateTransaction() {
    	change = customerPayment - profit;
    	return change;
    }
}
