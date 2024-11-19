package backend;
import java.sql.*;

public class DailySales_bcknd extends Expenses{
    
    private double totalDayProfits;

    //getters---------------------------------
    public double getTotalDayProfits() {
        return totalDayProfits;
    }

    //setters-----------------------------------------------
    public void setTotalDayProfits(double totalDayProfits) {
        this.totalDayProfits = totalDayProfits;
    }
    
    //methods----------------------------------
    void calculateTotalSales(){
       totalDayProfits = getProfit() - getTotalExpense();
    }
}
