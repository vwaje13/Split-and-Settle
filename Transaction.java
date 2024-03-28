import java.sql.Date;

public class Transaction { // what is diff between this & expense?
    int transactionID;
    int expenseID;
    double amount;
    User payer;
    User receiver;
    Date transactionDate;

    void createTransaction(int pExpenseID, double pAmount, User pPayer, User pReceiver){

    }

    void settleTransaction(int ptransactionID){
        
    }

}
