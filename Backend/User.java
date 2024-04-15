 //Dat//

import java.util.List;
import java.util.ArrayList;

public class User {
    
    private static List<user> users = new ArrayList<>();
    
    int userID;
    String name;
    String email;
    String phoneNumber;
    String password;


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
        //Iterate through the users list.
        for (User user : users) {
            //If inputted email and password match a user in the list, then login is successful.
            if (user.email.equals(attempEmail) && user.password.equals(attemptPassword)) {
                System.out.println(attempEmail + " has logged in.");
            }
        }
        //No match was found and an error message is displayed.
        System.out.println("Login failed. Email or password is incorrect.");
    }

    //Print message to user saying that they logged out.
    void logout(){
        System.out.println(this.name + " has logged out.");
    }

    //ID is increased sequentially as users are added, which is the size of the users list. Creates a new user with inputted data and adds the user to the list.
    void createAccount(String pName, String pEmail, String pPhoneNumber, String pPassword){
        //As more users get added, userID sequentially gets larger.
        ID = users.size() + 1;
        //Create new user with data and adds user to the list.
        User user = new User(ID, pName, pEmail, pPhoneNumber, pPassword);
        users.add(user);
        System.out.println("New account has been created for " + pEmail);
    }

    void resetPassword(String attemptName, String attemptEmail, String attemptPhoneNumber){
        //Iterate through the users list.
        for (User user: users) {
            //Valid user ID
            if (user.name.equals(attemptName)) {
                //valid email
                if (user.email.equals(attemptEmail)) {
                   //valid phone number
                   if (user.phoneNumber.equals(attemptPhoneNumber)) {
                      //Test case 1 valid input
                      System.out.println("Further instructions to delete account sent to email address.");
                      return;
                   }
                   else {
                      //Test case 4 invalid phone number
                      System.out.println("Invalid phone number");
                      return;
                   }
                }
                else {
                 //Test case 3 invalid email address
                 System.out.println("Invalid email address");
                 return;
                }
             
            }
        }
        //No matching user was found, Test case 2 user ID invalid
        System.out.println("user ID was not found");
    }

    //If the user email exists, then send instructions to reset password to the email. If user does not exist, then output error.
    void resetPassword(String resetEmail){
        //Iterate through the users list.
        for (User user: users) {
            //If there is a user in the list with a matching email.
            if (user.email.equals(resetEmail)) {
                //Send instructions to email
                System.out.println("An email has been sent to " + resetEmail + " to reset your password.");
                return;
            }
        }
        //No matching email was found for any user.
        System.out.println(resetEmail + " not found.");
    }

    public int getUserID() {
        return userID;
    }
}
