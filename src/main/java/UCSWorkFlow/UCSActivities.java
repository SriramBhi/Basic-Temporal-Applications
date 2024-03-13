package UCSWorkFlow;
import UCS.Admin;
import UCS.Retailer;
import UCS.Student;
import io.temporal.activity.ActivityInterface;
import  io.temporal.activity.ActivityMethod;
@ActivityInterface
public interface UCSActivities {

    Student student = new Student();
    Retailer retailer = new Retailer();
    Admin admin = new Admin();


    //Transaction happens when student buys something from the retailer
    @ActivityMethod
    int transactionStuToRet(int creditBalance,int price);

    //Transfer happens when retailer requests money for this particular amount of credit he/she has.
    @ActivityMethod
    int transferCreditToMoney(int creditsToBeTransferred);

    //Transfer happens when student requests credit for this particular amount of money he/she has.
    @ActivityMethod
    int transferMoneyToCredit(int MoneyToBeTransferred);

    @ActivityMethod
    void setInitialValues();
}
