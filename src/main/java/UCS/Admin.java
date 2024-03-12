package UCS;

public class Admin {
    //Data points
    private int MoneyBalance;

    //Parametrized Constructor
    public Admin(int MoneyBalance){
        this.MoneyBalance = MoneyBalance;
    }

    public Admin(){};
    public int getMoneyBalance(){
        return MoneyBalance;
    }

    //Setters
    public void setMoneyBalance(int MoneyBalance){
        this.MoneyBalance = MoneyBalance;
    }

}
