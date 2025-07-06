import java.util.*;

class User {
    String userID, name;
    int age;
    List<String> friends;
    User next;

    public User(String userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialNetwork {
    User head = null;

    void addUser(String userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) head = newUser;
        else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    void addFriend(String uid1, String uid2) {
        User u1 = findUser(uid1);
        User u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            if (!u1.friends.contains(uid2)) u1.friends.add(uid2);
            if (!u2.friends.contains(uid1)) u2.friends.add(uid1);
        }
    }

    void removeFriend(String uid1, String uid2) {
        User u1 = findUser(uid1);
        User u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            u1.friends.remove(uid2);
            u2.friends.remove(uid1);
        }
    }

    void displayFriends(String userID) {
        User u = findUser(userID);
        if (u != null) {
            System.out.println("Friends of " + u.name + ": " + u.friends);
        }
    }

    void mutualFriends(String uid1, String uid2) {
        User u1 = findUser(uid1);
        User u2 = findUser(uid2);
        if (u1 != null && u2 != null) {
            Set<String> mutual = new HashSet<>(u1.friends);
            mutual.retainAll(u2.friends);
            System.out.println("Mutual friends: " + mutual);
        }
    }

    User findUser(String userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID.equals(userID)) return temp;
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addUser("U1", "Pragati", 20);
        sn.addUser("U2", "Bhumi", 22);
        sn.addUser("U3", "Bhakti", 21);
        sn.addFriend("U1", "U2");
        sn.addFriend("U1", "U3");
        sn.addFriend("U2", "U3");
        sn.displayFriends("U1");
        sn.mutualFriends("U1", "U2");
    }
}
