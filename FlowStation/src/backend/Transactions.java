package backend;

public class Transactions extends Pricing{
    private int date; //DATE-----------
    private String time;
    private boolean delivery = true;
    
    private int deliveryLargeContainer = getOutboundContainer_L();
    private int deliveryMediumContainer = getOutboundContainer_M();
    private int deliverySmallContainer = getOutboundContainer_S();

    //setters------------------------------------------
    public void setDate(int date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }
    
    public void setDeliveryLargeContainer(int deliveryLargeContainer) {
        this.deliveryLargeContainer = deliveryLargeContainer;
    }

    public void setDeliveryMediumContainer(int deliveryMediumContainer) {
        this.deliveryMediumContainer = deliveryMediumContainer;
    }

    public void setDeliverySmallContainer(int deliverySmallContainer) {
        this.deliverySmallContainer = deliverySmallContainer;
    }

    //getters-------------------------------------------
    public int getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
    
    public boolean isDelivery() {
        return delivery;
    }
    
    public int getDeliveryLargeContainer() {
        return deliveryLargeContainer;
    }

    public int getDeliveryMediumContainer() {
        return deliveryMediumContainer;
    }

    public int getDeliverySmallContainer() {
        return deliverySmallContainer;
    }
    
    
}
