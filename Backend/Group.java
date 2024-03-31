import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Ayush//

public class Group {
    private int groupID;
    private String name;
    private List<Integer> memberIDs;

    public Group(int groupID, String name) {
        this.groupID = groupID;
        this.name = name;
        this.memberIDs = new ArrayList<Integer>();
    }

    public Group createGroup(String name, List<Integer> newMemberIDs) {
        Group newGroup = new Group(generateGroupID(), name);
        newGroup.addMembers(newMemberIDs);
        return newGroup;
    }

    public void inviteMember(int invitedUserID) {
        memberIDs.add(invitedUserID);
        inviteUserToGroup(invitedUserID);
    }

    public void removeMember(int removedUserID) {
        memberIDs.remove(Integer.valueOf(removedUserID));
        removeUserFromGroup(removedUserID);
    }

    public void deleteGroup() {
        deleteGroupFromSystem(this);
    }

    private void addMembers(List<Integer> newMemberIDs) {
        memberIDs.addAll(newMemberIDs);
        for (int userID : newMemberIDs) {
            inviteUserToGroup(userID);
        }
    }

    private int generateGroupID() {
        // Generate a unique ID for the group using the UUID class
        return UUID.randomUUID().hashCode();
    }

    private void inviteUserToGroup(int userID) {
        // Add the user to the group's list of members
        System.out.println("Inviting user with ID " + userID + " to join group " + name);
    }

    private void removeUserFromGroup(int userID) {
        // Remove the user from the group's list of members
        System.out.println("Removing user with ID " + userID + " from group " + name);
    }

    private void deleteGroupFromSystem(Group group) {
        // Remove the group from the list of groups for all members
        for (int userID : group.getMemberIDs()) {
            removeUserFromGroup(userID);
        }
        // Remove the group from the system
        System.out.println("Deleting group " + name);
    }

    public List<Integer> getMemberIDs() {
        return memberIDs;
    }

    public String getName() {
        return name;
    }

    public int getGroupID() {
        return groupID;
    }
}
