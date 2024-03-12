package UCS;

public class Student {

    //Data Points
    private int creditBalance;
    private int MoneyBalance;
    private String studentID;

    public Student(){};
    //Parametrized constructor
    public Student(String studentID,int creditBalance,int MoneyBalance){
        this.studentID = studentID;
        this.creditBalance = creditBalance;
        this.MoneyBalance = MoneyBalance;
    }

    //getters
    public int getMoneyBalance(){
        return MoneyBalance;
    }

    public int getCreditBalance(){
        return creditBalance;
    }

    //setters
    public void setMoneyBalance(int MoneyBalance){
        this.MoneyBalance = MoneyBalance;
    }

    public void setCreditBalance(int creditBalance){
        this.creditBalance = creditBalance;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getStudentID(){
        return studentID;
    }

}
