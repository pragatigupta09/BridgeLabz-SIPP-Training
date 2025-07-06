import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    char grade;
    Student next;

    Student(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManager {
    Student head = null;
    public void addStudentEnd(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newStudent;
    }

    public void addStudentBeginning(int roll, String name, int age, char grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addStudentAtPosition(int pos, int roll, String name, int age, char grade) {
        if (pos <= 1) {
            addStudentBeginning(roll, name, age, grade);
            return;
        }
        Student newStudent = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.roll == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.roll != roll)
            temp = temp.next;
        if (temp.next != null)
            temp.next = temp.next.next;
        else
            System.out.println("Roll number not found.");
    }

    public void searchStudent(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void updateGrade(int roll, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found.");
    }

    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll: " + temp.roll + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManager manager = new StudentRecordManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add at End 2.Add at Beginning 3.Add at Position 4.Delete by Roll 5.Search 6.Update Grade 7.Display All 8.Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter roll, name, age, grade:");
                    manager.addStudentEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 2:
                    System.out.println("Enter roll, name, age, grade:");
                    manager.addStudentBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 3:
                    System.out.println("Enter position, roll, name, age, grade:");
                    manager.addStudentAtPosition(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 4:
                    System.out.println("Enter roll:");
                    manager.deleteByRoll(sc.nextInt());
                    break;
                case 5:
                    System.out.println("Enter roll:");
                    manager.searchStudent(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Enter roll and new grade:");
                    manager.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;
                case 7:
                    manager.displayAll();
                    break;
                case 8: 
                    return;
            }
        }
    }
}
