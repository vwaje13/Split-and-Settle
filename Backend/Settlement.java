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

        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Expense ID: " + expense.expenseID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
        System.out.println("Payer: " + payer.getName());
        System.out.println("Receiver: " + receiver.getName());


        settleStatus = true;

        System.out.println("Transaction settled successfully.");
    }


    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public static boolean getSettleStatus() {
        return settleStatus;
    }

    public static void setSettleStatus(boolean settleStatus) {
        Settlement.settleStatus = settleStatus;
    }
}


