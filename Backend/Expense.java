import java.sql.Date;
import java.util.List;
import java.util.*;

//Veer//

public class Expense {
    int expenseID;
    int groupID;
    String description;
    double amount;
    Date expenseDate; // when the expense was added
    User Payer; // who originally paid for the expense
    List <User> debtDividedOnto; // who the expense is being divided onto
    String receiptImage;

    void addExpense(String pDescription, double pAmount, int pGroupID, User Payer, List<User> Involved)
    {
        description = pDescription;
        amount = pAmount;
        groupID = pGroupID;
        this.Payer = Payer;
        debtDividedOnto = Involved;
        Date d = new Date();
        expenseDate = d;
        for(User u : debtDividedOnto) {
            List<Debt> debs = viewDebts(u.getUserID, groupID);
            for(Debt ds : debs) {
                ds.add(pAmount);
            }
        }
    }

    void deleteExpense(int pExpenseiD)
    {
        for(User u : debtDividedOnto) {
            List<Debt> debs = viewDebts(u.getUserID, groupID);
            for(Debt ds : debs) {
                ds.remove(pExpenseID);
            }
        }
    }

    void editExpense(int pExpenseID, String pDescription, double pAmount, int pGroupID, User Payer, List <User> Involved, String receiptImage)
    {
        for(User u : debtDividedOnto) {
            List<Debt> debs = viewDebts(u.getUserID, groupID);
            for(Debt ds : debs) {
                Expense e = ds.get(pExpenseID);
                e.amount = pAmount;
                e.description = pDescription;
                e.groupID = pGroupID;
                e.Payer = Payer;
                e.Involved = Involved;
            }
        }
    }
}
