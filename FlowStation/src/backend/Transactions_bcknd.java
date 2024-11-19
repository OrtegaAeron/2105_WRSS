package backend;
import java.sql.*;

public class Transactions_bcknd extends Pricing_bcknd{
	
    private String date;
    private String time;
	private boolean delivery, yesLargeContainer, yesMediumContainer, yesSmallContainer, useRealDnT;

	private int deliveryLargeContainer = getOutBoundContainer_L();
    private int deliveryMediumContainer = getOutBoundContainer_M();
    private int deliverySmallContainer = getOutBoundContainer_S();

    //setters------------------------------------------
    public void setDate(String date) {
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
    
    public void setYesLargeContainer(boolean yesLargeContainer) {
		this.yesLargeContainer = yesLargeContainer;
	}
    
    public void setYesMediumContainer(boolean yesMediumContainer) {
		this.yesMediumContainer = yesMediumContainer;
	}
    
    public void setYesSmallContainer(boolean yesSmallContainer) {
		this.yesSmallContainer = yesSmallContainer;
	}
    
    public void setUseRealDnT(boolean useRealDnT) {
		this.useRealDnT = useRealDnT;
	}

    //getters-------------------------------------------
    public String getDate() {
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
    
    public boolean isYesLargeContainer() {
		return yesLargeContainer;
	}

	public boolean isYesMediumContainer() {
		return yesMediumContainer;
	}

	public boolean isYesSmallContainer() {
		return yesSmallContainer;
	}
	
	public boolean isUseRealDnT() {
		return useRealDnT;
	}
    
}
