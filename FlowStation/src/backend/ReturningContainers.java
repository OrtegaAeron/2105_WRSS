package backend;
import java.sql.*;

public class ReturningContainers extends Customers_bcknd{
    
    private int inboundContainer_L = getLargeLentContainer();
    private int inboundContainer_M = getMediumLentContainer();
    private int inboundContainer_S = getSmallLentContainer();

    //setters------------------------------------------------------
    public void setInboundContainer_L(int inboundContainer_L) {
        this.inboundContainer_L = inboundContainer_L;
    }

    public void setInboundContainer_M(int inboundContainer_M) {
        this.inboundContainer_M = inboundContainer_M;
    }

    public void setInboundContainer_S(int inboundContainer_S) {
        this.inboundContainer_S = inboundContainer_S;
    }

    //getters----------------------------------------------------
    public int getInboundContainer_L() {
        return inboundContainer_L;
    }

    public int getInboundContainer_M() {
        return inboundContainer_M;
    }

    public int getInboundContainer_S() {
        return inboundContainer_S;
    }
    
    
}
