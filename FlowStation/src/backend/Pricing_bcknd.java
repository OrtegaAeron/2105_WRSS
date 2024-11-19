package backend;
import java.sql.*;

public class Pricing_bcknd extends ContainerInventory{

    private double pricePerGalon = 5.00, waterPriceLarge, waterPriceMedium, waterPriceSmall;

    //setters----------------------------------------------
    public void setPricePerGalon(double pricePerGalon) {
        this.pricePerGalon = pricePerGalon;
    }
    
    public void setWaterPriceLarge(double waterPriceLarge) {
        this.waterPriceLarge = waterPriceLarge;
    }
    
    public void setWaterPriceMedium(double waterPriceMedium) {
        this.waterPriceMedium = waterPriceMedium;
    }
    
    public void setWaterPriceSmall(double waterPriceSmall) {
        this.waterPriceSmall = waterPriceSmall;
    }
    
    //getters----------------------------------------------
    public double getPricePerGalon() {
        return pricePerGalon;
    }
    
    public double getWaterPriceLarge() {
        return waterPriceLarge;
    }
    
    public double getWaterPriceMedium() {
        return waterPriceMedium;
    }
    
    public double getWaterPriceSmall() {
        return waterPriceSmall;
    }

    //methods-----------------------------------------------  
    public double calculateWaterPriceLarge(){
        waterPriceLarge = pricePerGalon * getContainerLarge();
        return waterPriceLarge;
    }
    
    public double calculateWaterPriceMedium(){
        waterPriceMedium = pricePerGalon * getContainerMedium();
        return waterPriceMedium;
    }
    
    public double calculateWaterPriceSmall(){
        waterPriceSmall = pricePerGalon * getContainerSmall();
        return waterPriceSmall;
    }
    
}
