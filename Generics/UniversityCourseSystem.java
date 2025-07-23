package Generics;

import java.util.*;

abstract class CourseType {
    protected String title;
    protected int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public abstract void evaluate();
    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }
}

class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    public void evaluate() {
        System.out.println(title + " is evaluated via written exams.");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    public void evaluate() {
        System.out.println(title + " is evaluated via assignments and projects.");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    public void evaluate() {
        System.out.println(title + " is evaluated via research and thesis submissions.");
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public void displayCourses() {
        for (T course : courseList) {
            System.out.println("Course: " + course.getTitle() + " | Credits: " + course.getCredits());
            course.evaluate();
        }
    }

    public List<T> getCourseList() {
        return courseList;
    }
}

public class UniversityCourseSystem {
    public static void displayAllCourses(List<? extends CourseType> courses) {
        System.out.println("\n--- All Courses Overview ---");
        for (CourseType course : courses) {
            System.out.println(course.getTitle() + " | Credits: " + course.getCredits());
            course.evaluate();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Course<CourseType> allCourses = new Course<>();

        System.out.print("Enter number of courses to add: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Course " + i);
            System.out.print("Course Title: ");
            String title = scanner.nextLine();
            System.out.print("Credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Course Type (1. Exam, 2. Assignment, 3. Research): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1:
                    allCourses.addCourse(new ExamCourse(title, credits));
                    break;
                case 2:
                    allCourses.addCourse(new AssignmentCourse(title, credits));
                    break;
                case 3:
                    allCourses.addCourse(new ResearchCourse(title, credits));
                    break;
                default:
                    System.out.println("Invalid type. Skipping course.");
            }
        }

        allCourses.displayCourses();
        displayAllCourses(allCourses.getCourseList());
        scanner.close();
    }
}
