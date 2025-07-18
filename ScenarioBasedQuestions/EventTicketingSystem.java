import java.util.*;

class Attendee {
    String name;
    int age;
    String email;

    Attendee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Attendee(String name, int age, String email) {
        this(name, age);
        this.email = email;
    }
}

public class EventTicketingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Queue<Attendee>> eventMap = new HashMap<>();

        System.out.print("Enter event name: ");
        String event = sc.nextLine();
        Queue<Attendee> queue = new LinkedList<>();
        eventMap.put(event, queue);

        System.out.print("Enter number of attendees: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter attendee name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter email (or 'none'): ");
            String email = sc.nextLine();
            if (email.equals("none")) queue.add(new Attendee(name, age));
            else queue.add(new Attendee(name, age, email));
        }

        int position = 1;
        System.out.print("Check position of attendee: ");
        String searchName = sc.nextLine();
        for (Attendee att : eventMap.get(event)) {
            if (att.name.equalsIgnoreCase(searchName)) {
                System.out.println(searchName + " is at position " + position);
                return;
            }
            position++;
        }
        System.out.println("Attendee not found.");
    }
}
