package backend;

public class ContainerInventory extends ReturningContainers{
    private int containerLarge = 5;
    private int containerMedium = 5;
    private int containerSmall = 5;

    private int containerQuantityLarge;
    private int containerQuantityMedium;
    private int containerQuantitySmall;
    
    private int outboundContainer_L;
    private int outboundContainer_M;
    private int outboundContainer_S;

    

    //setters------------------------------------------------------------------
    public void setContainerLarge(int containerLarge) {
        this.containerLarge = containerLarge;
    }

    public void setContainerMedium(int containerMedium) {
        this.containerMedium = containerMedium;
    }

    public void setContainerSmall(int containerSmall) {
        this.containerSmall = containerSmall;
    }

    public void setContainerQuantityLarge(int ContainerQuantityLarge) {
        this.containerQuantityLarge = ContainerQuantityLarge;
    }

    public void setContainerQuantityMedium(int ContainerQuantityMedium) {
        this.containerQuantityMedium = ContainerQuantityMedium;
    }

    public void setContainerQuantitySmall(int ContainerQuantitySmall) {
        this.containerQuantitySmall = ContainerQuantitySmall;
    }
    
    public void setOutboundContainer_L(int outboundContainer_L) {
        this.outboundContainer_L = outboundContainer_L;
    }

    public void setOutboundContainer_M(int outboundContainer_M) {
        this.outboundContainer_M = outboundContainer_M;
    }

    public void setOutboundContainer_S(int outboundContainer_S) {
        this.outboundContainer_S = outboundContainer_S;
    }

    //getters------------------------------------------------------------------
    public int getContainerLarge() {
        return containerLarge;
    }

    public int getContainerMedium() {
        return containerMedium;
    }

    public int getContainerSmall() {
        return containerSmall;
    }

    public int getContainerQuantityLarge() {
        return containerQuantityLarge;
    }

    public int getContainerQuantityMedium() {
        return containerQuantityMedium;
    }

    public int getContainerQuantitySmall() {
        return containerQuantitySmall;
    }
    
    public int getOutboundContainer_L() {
        return outboundContainer_L;
    }

    public int getOutboundContainer_M() {
        return outboundContainer_M;
    }

    public int getOutboundContainer_S() {
        return outboundContainer_S;
    }
    
    //methods----------------------------------------------------------------
    void showContainerInventory(){
        
    }
    
    void addNewContainer(){
        
    }
    
    void removeOldContainer(){
        
    }
    
    int increaseContainerQuantity(int containerQuantityLarge){
        containerQuantityLarge += getInboundContainer_L();
        return 0;
    }
    
    int increaseContainerQuantity(int containerQuantityMedium){
        containerQuantityMedium += getInboundContainer_M();
        return 0;
    }
    
    int increaseContainerQuantity(int containerQuantitySmall){
        containerQuantitySmall += getInboundContainer_S();
        return 0;
    }
    
    int decreaseContainerQuantity(int containerQuantityLarge){
        
        return setOutboundContainer_L()
    }
    
    int decreaseContainerQuantity(int containerQuantityMedium){
        return setOutboundContainer_M()
    }
    
    int decreaseContainerQuantity(int containerQuantitySmall){
        return setOutboundContainer_S;
    }
    
}
