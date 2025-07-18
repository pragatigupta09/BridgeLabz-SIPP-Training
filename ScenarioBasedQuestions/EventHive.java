import java.util.*;

class User {
    String name;
    User(String name) {
        this.name = name;
    }
}

class Event {
    String title;
    Event(String title) {
        this.title = title;
    }
}

class Ticket {
    String eventTitle;
    String userName;
    int ticketId;
    static int counter = 1;

    Ticket(String eventTitle, String userName) {
        this.eventTitle = eventTitle;
        this.userName = userName;
        this.ticketId = counter++;
    }

    void showTicket() {
        System.out.println("Ticket ID: " + ticketId + ", Name: " + userName + ", Event: " + eventTitle);
    }
}

interface EventManager {
    void updateEvent(String title);
    void removeEvent(String title);
}

class Admin implements EventManager {
    public void updateEvent(String title) {
        System.out.println("Event '" + title + "' has been updated.");
    }

    public void removeEvent(String title) {
        System.out.println("Event '" + title + "' has been removed.");
    }
}

public class EventHive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();

        System.out.print("Enter event title: ");
        String eventTitle = sc.nextLine();
        Event event = new Event(eventTitle);

        System.out.print("Enter number of users registering: ");
        int numUsers = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= numUsers; i++) {
            System.out.print("Enter name for user " + i + ": ");
            String userName = sc.nextLine();
            User user = new User(userName);
            Ticket ticket = new Ticket(event.title, user.name);
            tickets.add(ticket);
        }

        System.out.println("\nGenerated Tickets:");
        for (Ticket t : tickets) {
            t.showTicket();
        }

        Admin admin = new Admin();
        admin.updateEvent(eventTitle);
    }
}
