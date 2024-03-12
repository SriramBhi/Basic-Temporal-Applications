package UCS;

public class Retailer {
    //Data points
    private int creditBalance;
    private int MoneyBalance;
    private String retailerID;

    //Parametrized Constructor
    public Retailer(String retailerID,int creditBalance,int MoneyBalance){
        this.retailerID = retailerID;
        this.creditBalance = creditBalance;
        this.MoneyBalance = MoneyBalance;
    }

    public Retailer(){};
    //Getters
    public int getCreditBalance(){
        return creditBalance;
    }

    public int getMoneyBalance(){
        return MoneyBalance;
    }

    public String getRetailerID(){
        return retailerID;
    }

    //Setters
    public void setMoneyBalance(int MoneyBalance){
        this.MoneyBalance = MoneyBalance;
    }

    public void setCreditBalance(int creditBalance){
        this.creditBalance = creditBalance;
    }

    public void setRetailerID(String retailerID){
        this.retailerID = retailerID;
    }
}
