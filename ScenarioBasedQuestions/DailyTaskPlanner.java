import java.util.*;

abstract class Task {
    String description;
    Task(String description) {
        this.description = description;
    }
    abstract void execute();
}

class Meeting extends Task {
    Meeting(String desc) { super(desc); }
    public void execute() {
        System.out.println("Meeting: " + description);
    }
}

class Workout extends Task {
    Workout(String desc) { super(desc); }
    public void execute() {
        System.out.println("Workout: " + description);
    }
}

class CodingSession extends Task {
    CodingSession(String desc) { super(desc); }
    public void execute() {
        System.out.println("Coding: " + description);
    }
}

public class DailyTaskPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Task> tasks = new LinkedList<>();

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter task type (Meeting/Workout/Coding): ");
            String type = sc.nextLine();
            System.out.print("Enter task description: ");
            String desc = sc.nextLine();

            switch (type.toLowerCase()) {
                case "meeting": tasks.add(new Meeting(desc)); break;
                case "workout": tasks.add(new Workout(desc)); break;
                case "coding": tasks.add(new CodingSession(desc)); break;
            }
        }

        for (Task task : tasks) task.execute();

        System.out.print("Search task by keyword: ");
        String keyword = sc.nextLine();
        boolean found = false;
        for (Task task : tasks) {
            if (task.description.contains(keyword)) {
                System.out.println("Found: " + task.description);
                found = true;
            }
        }
        if (!found) System.out.println("No matching task found.");
    }
}

