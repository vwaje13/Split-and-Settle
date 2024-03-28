import java.sql.Date;
import java.util.List;

public class Expense {
    int expenseID;
    int groupID;
    String description;
    double amount;
    Date expenseDate; // when the expense was added
    User Payer; // who originally paid for the expense
    List <User> debtDividedOnto; // who the expense is being divided onto
    String receiptImage;

    void addExpense(String pDescription, double pAmount, int pGroupID, 
    User Payer, List<User> Involved){

    }

    void deleteExpense(int pExpenseiD){

    }

    void editExpense(int pExpenseID, String pDescription, double pAmount, 
    int pGroupID, User Payer, List <User> Involved, String receiptImage){
        
    }
}
