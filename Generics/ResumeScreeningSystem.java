package Generics;

import java.util.*;

abstract class JobRole {
    private String name;
    private int experience;

    public JobRole(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public abstract String requiredSkill();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int experience) {
        super(name, experience);
    }

    public String requiredSkill() {
        return "Java, Spring Boot";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, int experience) {
        super(name, experience);
    }

    public String requiredSkill() {
        return "Python, Machine Learning";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, int experience) {
        super(name, experience);
    }

    public String requiredSkill() {
        return "Leadership, Market Strategy";
    }
}

class Resume<T extends JobRole> {
    private T applicant;

    public Resume(T applicant) {
        this.applicant = applicant;
    }

    public void displayResume() {
        System.out.println("Name: " + applicant.getName());
        System.out.println("Experience: " + applicant.getExperience() + " years");
        System.out.println("Key Skills: " + applicant.requiredSkill());
    }

    public T getApplicant() {
        return applicant;
    }
}

public class ResumeScreeningSystem {
    public static void processResumes(List<? extends JobRole> resumes) {
        for (JobRole r : resumes) {
            System.out.println("\nProcessing Resume:");
            System.out.println("Candidate: " + r.getName());
            System.out.println("Experience: " + r.getExperience());
            System.out.println("Required Skills: " + r.requiredSkill());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<JobRole> candidates = new ArrayList<>();

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCandidate " + i + ":");
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter experience (years): ");
            int exp = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter job role (software / data / product): ");
            String role = sc.nextLine().toLowerCase();

            switch (role) {
                case "software":
                    candidates.add(new SoftwareEngineer(name, exp));
                    break;
                case "data":
                    candidates.add(new DataScientist(name, exp));
                    break;
                case "product":
                    candidates.add(new ProductManager(name, exp));
                    break;
                default:
                    System.out.println("Invalid role. Skipping this candidate.");
            }
        }

        System.out.println("\n--- AI Resume Screening Results ---");
        processResumes(candidates);
    }
}
