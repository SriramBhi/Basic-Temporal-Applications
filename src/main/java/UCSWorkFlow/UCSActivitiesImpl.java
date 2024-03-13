package UCSWorkFlow;

import io.temporal.activity.Activity;
import io.temporal.activity.ActivityExecutionContext;
import io.temporal.client.ActivityCompletionException;

import java.util.Scanner;
public class UCSActivitiesImpl  implements  UCSActivities {

    //Dynamic input assignment function -- HardCoded
    @Override
    public void setInitialValues() {
        student.setCreditBalance(100);
        student.setMoneyBalance(100);
        retailer.setCreditBalance(100);
        retailer.setMoneyBalance(100);
        admin.setMoneyBalance(1000);
        student.setStudentID("Sriram");
        retailer.setRetailerID("Yubi");
    }

    //Dynamic input assignment function -- User assigned
//    @Override
//    public void setInitialValues() {
//        //Setting parameters inside the activity implementation
//        System.out.println("Enter the required values...");
//        Scanner sc = new Scanner(System.in);
//        student.setCreditBalance(sc.nextInt());
//        student.setMoneyBalance(sc.nextInt());
//        retailer.setCreditBalance(sc.nextInt());
//        retailer.setMoneyBalance(sc.nextInt());
//        admin.setMoneyBalance(sc.nextInt());
//        student.setStudentID(sc.nextLine());
//        sc.next();
//        retailer.setRetailerID(sc.nextLine());
//        System.out.println("Values Set...");
//    }

    // Process :
    // 1. Checks the student initial credit balance and contemplates with the price
    // 2. Conditional execution based on the result of above condition
    // True -- decrease student cred balance and increase retailer cred balance -- return price.
    // False -- return 0 (representing no transaction occured)
    @Override
    public int transactionStuToRet(int creditBalance, int price) {
        if (student.getCreditBalance() >= price) {

            student.setCreditBalance(student.getCreditBalance() - price);
            retailer.setCreditBalance(retailer.getCreditBalance() + price);
            return price;
        }
        System.out.println("Transaction is not initiated due to low balance..");
        return 0;
    }

    //Process :
    //Adds up money and decrease credits from retailer account
    //Adds up credit and decrease money from the admin account
    @Override
    public int transferCreditToMoney(int creditsToBeTransferred) {

        // Edge case
        if (retailer.getCreditBalance() < creditsToBeTransferred) {
            System.out.println("Credit Balance is not sufficient for retailer : " + retailer.getRetailerID());
            return 0;
        }

        //Edge case
        if (admin.getMoneyBalance() < creditsToBeTransferred) {
            System.out.println("Money Balance is not sufficient for Admin for credit transfer");
            return 0;
        }

        // Retailer changes
        retailer.setMoneyBalance(creditsToBeTransferred + retailer.getMoneyBalance());
        retailer.setCreditBalance(retailer.getCreditBalance() - creditsToBeTransferred);

        //Admin changes
        admin.setMoneyBalance(admin.getMoneyBalance() - creditsToBeTransferred);

        System.out.println("Credit -> Money....Successful for retailer : " + retailer.getRetailerID());
        return 1;
    }

    //Process
    //Adds up money and decrease credits in retailer account
    //Adds up money
    @Override
    public int transferMoneyToCredit(int MoneyToBeTransferred) {
        //Edge case
        if (student.getMoneyBalance() < MoneyToBeTransferred) {
            System.out.println("Money balance is not sufficient for student : " + student.getStudentID());
            return 0;
        }
        //Student changes
        student.setCreditBalance(student.getCreditBalance() + MoneyToBeTransferred);
        student.setMoneyBalance(student.getMoneyBalance() - MoneyToBeTransferred);

        //Admin changes
        admin.setMoneyBalance(admin.getMoneyBalance() + MoneyToBeTransferred);

        System.out.println("Money -> Credit....Successful for Student : " + student.getStudentID());
        return 1;
    }

}



