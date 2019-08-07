package robot.com.myapplication.pal;
import java.util.ArrayList;
import java.util.List;

import robot.com.myapplication.R;


public class FriendsData {
    public FriendsData() {
    }

    public static List<NewFriend> myFriendList = new ArrayList<>();//我的好友
    public static List<NewFriend> recomFriendList = new ArrayList<>();//推荐好友
    public static List<NewFriend> newFriendList = new ArrayList<>();//好友申请
    public static List<NewFriend> tempNewFriendList = new ArrayList<>();//暂存好友申请

    //初始化用户信息
    public static NewFriend UserInfo = new NewFriend("CM", "男", "今天也要加油", "武汉", R.drawable.sign_pic, "添加好友");

    public static void addMyFriend(NewFriend friend) {
        myFriendList.add(friend);
    }

    public static void deleteMyFriend(int position) {
        myFriendList.remove(position);
    }

    public static void addRecomFriend(NewFriend friend) {
        recomFriendList.add(friend);
    }

    public static void deleteRecomFriend(int position) {
        recomFriendList.remove(position);
    }

    public static void addNewFriend(NewFriend friend) {
        newFriendList.add(friend);
    }

    public static void deleteNewFriend(int position) {
        newFriendList.remove(position);
    }

    //初始化推荐好友
    static {
        recomFriendList.add(new NewFriend("HFH", "今天也要加油", "女", "武汉", R.drawable.sign_pic));
        recomFriendList.add(new NewFriend("HZH", "今天也要加油", "女", "武汉", R.drawable.person1));
        recomFriendList.add(new NewFriend("LT", "今天也要加油", "女", "武汉", R.drawable.person2));
        recomFriendList.add(new NewFriend("LJH", "今天也要加油", "男", "武汉", R.drawable.person3));
        recomFriendList.add(new NewFriend("CM", "今天也要加油", "男", "武汉", R.drawable.person4));
    }
}
