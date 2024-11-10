package backend;

public class Pricing extends ContainerInventory{

    private double pricePerGalon = 5.00, waterPrice;

    //setters----------------------------------------------
    public void setPricePerGalon(double pricePerGalon) {
        this.pricePerGalon = pricePerGalon;
    }
    
    public void setWaterPrice(double waterPrice) {
        this.waterPrice = waterPrice;
    }
    
    //getters----------------------------------------------
    public double getPricePerGalon() {
        return pricePerGalon;
    }
    
    public double getWaterPrice() {
        return waterPrice;
    }

    //methods-----------------------------------------------
    void showPrice(){
        
    }
    
    void updatePrice(){
        
    }
    
    void calculateWaterPrice(double pricePerGallon){
        waterPrice = pricePerGallon * getContainerLarge();
    }
    
    void calculateWaterPrice(double pricePerGallon){
        waterPrice = pricePerGallon * getContainerMedium();
    }
    
    void calculateWaterPrice(double pricePerGallon){
        waterPrice = pricePerGallon * getContainerSmall();
        return waterPrice;
    }
    
}
