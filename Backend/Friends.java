//Nigel//

import java.util.ArrayList;

class Friend extends User {

    private ArrayList<User> friends;
    this.friends = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getUserID() {
        return userID;
    }

    public void addFriend(User friend) {
        if (friend != null && !friend.contains(friend)) {
            friends.add(friend);
            friend.friends.add(this);
            System.out.println(name + " added " + friend.userID() + " as a friend.");
        }
        else {
            System.out.println("Invalid Friend Request");
        }
    }

    public void viewFriends() {
        System.out.println("Friends of " + name + ":");
        for (User friend : friends) {
            System.out.println("- " + friend.getName());
        }
    }
}


