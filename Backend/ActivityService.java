//Dhriti//

import java.util.ArrayList;
import java.util.List;

public class ActivityService {
  User activeUser;
  List<Activity> activityList;

  public ActivityService(User user) {
    this.activeUser = user;
    this.activityList = new ArrayList<Activity>();
  }

  public void addActivity(Activity activity) { // adds activity into activityList
    this.activityList.add(activity);
  };

  public List<Activity> getActivityForUser(User user) { // getting all the activities for certain user (any user)
    List<Activity> userActivities = new ArrayList<Activity>();
    
    for (Activity activity : this.activityList) {
      if (activity.activeUser.equals(user)) {
        userActivities.add(activity);
      }
    }

    return userActivities;
  };

  public List<Activity> getActivityForGroup(int groupID) { // getting all the activities for the group ID passed in 
    List<Activity> groupActivities = new ArrayList<Activity>(); 

    for (Activity activity : this.activityList) {
      if (activity.groupID == groupID) {
        groupActivities.add(activity);
      }
    }

    return groupActivities;
  }
}
