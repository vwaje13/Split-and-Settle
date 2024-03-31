//Ben//
//Im not sure if any of this works, would like someone to look over

/* Important Settings to have:
 * Change userName
 * Change password
 * Change email
 * Change name
 * Change phone
 * Delete Account
 */

//using User.java to access the ArrayList of users and using method logout() in deleteAccount()
//using Settlement.java to check if user's account isSettled in order to deleteAccount
import java.util.*;
import User.java;
import Settlement.java;

public class Settings{

    void changeUserID(String newUserID, String userID){
        //check string size length if its too short/long
        if(userID.length() < 1){
            System.out.println("User ID too short!");
        } else if(userID.length() > 10){
            System.out.println("User ID too long!");
        } else{
          
            //parse to the given userID to perform change
            int oldUserID = -1;
            for(int i = 0; i < users.size(); i++){
                int temp = users.get(i);

                //check if newUserID is already in user ArrayList
                if(temp == newUserID){
                    System.out.println("User ID is taken!")
                    return;
                }
              
                if(temp == userID){
                    oldUserID = userID;
                }
            }
            if(oldUserID == -1){
                System.out.println("Error, userID not valid.");
            }
            else{
                //make change to the userID of the user
                this.user.userID = newUserID;
                System.out.println(oldUserID + " has been changed to " + userID);
            }
        }
    }

    void changePassword(String password, String userID){
        //check string size length if its too short/long
        if(password.length() < 4){
            System.out.println("Password too short!");
        } else if(password.length() > 20){
            System.out.println("Password too long!");
        } else{
          
            //parse to the given userID to perform change
            for(int i = 0; i < users.size(); i++){
                int temp = users.get(i);
              
                if(temp == userID){
                    //now that parsing is pointing to the correct user, perform the change
                    this.user.password = password;
                    return;
                }
            }
            System.out.println("Error, userID not valid.");
        }
    }

    void changeEmail(String email, String userID){
        //parse to the given userID to perform change
        for(int i = 0; i < users.size(); i++){
            int temp = users.get(i);

            if(temp == userID){
                //now that parsing is pointing to the correct user, perform the change
                this.user.email = email;
                return;
            }
        }
        System.out.println("Error, userID not valid.");
    }

    void changeName(String name, String userID){
        //check string size length if its too short/long
        if(name.length() < 1){
            System.out.println("Name is too short!");
        } else if(name.length() > 100){
            System.out.println("Name is too long!");
        } else{
          
            //parse to the given userID to perform change
            for(int i = 0; i < users.size(); i++){
                int temp = users.get(i);

                if(temp == userID){
                    //now that parsing is pointing to the correct user, perform the change
                    this.user.name = name;
                    return;
                }
            }
            System.out.println("Error, userID not valid.");
        }
    }

    void changePhoneNumber(String phoneNumber, String userID){
        //check string size length is valid
        if(phoneNumber.length() == 10){
            //parse to the given userID to perform change
            for(int i = 0; i < users.size(); i++){
                int temp = users.get(i);

                if(temp == userID){
                    //now that parsing is pointing to the correct user, perform the change
                    this.user.phoneNumber = phoneNumber;
                    break;
                }
            }
            System.out.println("Error, userID not valid.");
        }
        else{
            System.out.println("Phone Number not valid!");
        }
    }

    void deleteAccount(int userID){
        //check if the userID has their account settled and has no outstanding balance
        if(Settlement.isSettled(userID))
        {
            //parse to the userID
            for(int i = 0; i < users.size(); i++){
                int temp = users.get(i);

                if(temp == userID){
                    //logout first bc if you delete the userID, then there is no userID to logout from
                    //and you are stuck on the deleted userID
                    User.logout();
                    users.remove(userID);
                    break;
                }
            }
        } else{
            System.out.println("Account still has an outsatanding balance!");
        }
    }
}
