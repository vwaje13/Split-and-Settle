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

    //The user will input their name, email, phone number, and password. userID is automatically done by the system and it is the size of the users list.
    public User(int userID, String name, String email, String phoneNumber, String password){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    //Check through users list for a matching email and password combination. A success message is shown if there is a match and if there are no matches, then output an error message.
    void login(String attemptEmail, String attemptPassword){
        for (User user : users) {
            if (user.email.equals(attempEmail) && user.password.equals(attemptPassword)) {
                System.out.println(attempEmail + " has logged in.");
            }
        }
        System.out.println("Login failed. Email or password is incorrect.");
    }

    //Print message to user saying that they logged out.
    void logout(){
        System.out.println(this.name + " has logged out.");
    }

    //ID is increased sequentially as users are added, which is the size of the users list. Creates a new user with inputted data and adds the user to the list.
    void createAccount(String pName, String pEmail, String pPhoneNumber, String pPassword){
        ID = users.size() + 1;
        User user = new User(ID, pName, pEmail, pPhoneNumber, pPassword);
        users.add(user);
        System.out.println("New account has been created for " + pEmail);
    }

    //If the user email exists, then send instructions to reset password to the email. If user does not exist, then output error.
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
