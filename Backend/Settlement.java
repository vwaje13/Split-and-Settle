//Huzaifa//

import java.util.Date;

public class Settlement{
    int transactionID, expenseID;
    double amount;
    Date date;
    User payer, receiver;

    static boolean settleStatus;


    public void createTransaction(int expenseID,double amount,User payer, User receiver){
        this.expenseID=expenseID;
        this.amount=amount;
        this.payer=payer;
        this.receiver=receiver;
        this.date = new Date();
    }

    public void settleTransaction(int transactionID){
        this.transactionID=transactionID;
    }

    public static Boolean isSettled(int userID){
        return settleStatus;
    }

}


