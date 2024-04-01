import java.util.List;
import java.util.ArrayList;

public class User {
    
    private static List<user> users = new ArrayList<>();
    
    int userID;
    String name;
    String email;
    String phoneNumber;
    String password;

    //Dat//

    public User(int userID, String name, String email, String phoneNumber, String password){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    void login(String attemptEmail, String attemptPassword){
        for (User user : users) {
            if (user.email.equals(attempEmail) && user.password.equals(attemptPassword)) {
                System.out.println(attempEmail + " has logged in.");
            }
        }
        System.out.println("Login failed. Email or password is incorrect.");
    }

    void logout(){
        System.out.println(this.name + " has logged out.");
    }

    void createAccount(String pName, String pEmail, String pPhoneNumber, String pPassword){
        ID = users.size() + 1;
        User user = new User(ID, pName, pEmail, pPhoneNumber, pPassword);
        users.add(user);
        System.out.println("New account has been created for " + pEmail);
    }

    void resetPassword(String resetEmail){
        for (User user: users) {
            if (user.email.equals(resetEmail)) {
                System.out.println("An email has been sent to " + resetEmail + " to reset your password.");
                return;
            }
        }
        System.out.println(resetEmail + " not found.");
    }
}
