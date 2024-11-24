package backend;

import dbConnections.Connections;
import java.sql.*;

public class ContainerInventory extends ReturningContainers{
    private int containerLarge = 5;
    private int containerMedium = 3;
    private double containerSmall = 2.5;

    private int containerQuantityLarge = 100;
    private int containerQuantityMedium = 100;
    private int containerQuantitySmall = 100;
    
    private int outBoundContainer_L;
    private int outBoundContainer_M;
    private int outBoundContainer_S;

    

    //setters------------------------------------------------------------------
    public void setContainerLarge(int containerLarge) {
        this.containerLarge = containerLarge;
    }

    public void setContainerMedium(int containerMedium) {
        this.containerMedium = containerMedium;
    }

    public void setContainerSmall(double containerSmall) {
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
        this.outBoundContainer_L = outboundContainer_L;
    }

    public void setOutboundContainer_M(int outboundContainer_M) {
        this.outBoundContainer_M = outboundContainer_M;
    }

    public void setOutboundContainer_S(int outboundContainer_S) {
        this.outBoundContainer_S = outboundContainer_S;
    }

    //getters------------------------------------------------------------------
    public int getContainerLarge() {
        return containerLarge;
    }

    public int getContainerMedium() {
        return containerMedium;
    }

    public double getContainerSmall() {
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
    
    public int getOutBoundContainer_L() {
        return outBoundContainer_L;
    }

    public int getOutBoundContainer_M() {
        return outBoundContainer_M;
    }

    public int getOutBoundContainer_S() {
        return outBoundContainer_S;
    }
    
    //methods----------------------------------------------------------------
    void showContainerInventory(){
        
    }
    
    void addNewContainer(){
        
    }
    
    void removeOldContainer(){
        //decrease no. of containers
    }
    
    public int increaseContainerQuantityLarge(){
        containerQuantityLarge += getInboundContainer_L();
        return containerQuantityLarge;
    }
    
    public int increaseContainerQuantityMedium(){
        containerQuantityMedium += getInboundContainer_M();
        return containerQuantityLarge;
    }
    
    public int increaseContainerQuantitySmall(){
        containerQuantitySmall += getInboundContainer_S();
        return containerQuantityLarge;
    }
    
    public int decreaseContainerQuantityLarge(){
        containerQuantityLarge--;
        outBoundContainer_L++;
        return outBoundContainer_L;
    }
    
    public int decreaseContainerQuantityMedium(){
    	containerQuantityMedium--;
        outBoundContainer_M++;
        return outBoundContainer_M;
    }
    
    public int decreaseContainerQuantitySmall(){
    	containerQuantitySmall--;
        outBoundContainer_S++;
        return outBoundContainer_S;
    }
    
}
