/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JobportalConsole;

/**
 *
 * @author Chinm
 */
import java.util.*;

class Candidate {
    int id;
    String name;
    String skills;

    Candidate(int id, String name, String skills) {
        this.id = id;
        this.name = name;
        this.skills = skills;
    }
}

class Company {
    int id;
    String name;

    Company(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Job {
    int id;
    String title;
    String companyName;
    boolean isOpen;

    Job(int id, String title, String companyName) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.isOpen = true;
    }
}

class Application {
    int candidateId;
    int jobId;
    String status;

    Application(int candidateId, int jobId) {
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.status = "Applied";
    }
}

public class JobPortal {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Candidate> candidates = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();
    static ArrayList<Job> jobs = new ArrayList<>();
    static ArrayList<Application> applications = new ArrayList<>();

    static int candidateIdCounter = 1;
    static int companyIdCounter = 1;
    static int jobIdCounter = 1;

    public static void main(String[] args) {
        // TODO code application logic here
        while (true) {
            System.out.println("\n===== JOB PORTAL SYSTEM =====");
            System.out.println("1. Candidate");
            System.out.println("2. Company");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> candidateMenu();
                case 2 -> companyMenu();
                case 3 -> adminMenu();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // ================= CANDIDATE MENU =================

    static void candidateMenu() {
        System.out.println("\n1. Register");
        System.out.println("2. View Jobs");
        System.out.println("3. Apply for Job");
        System.out.println("4. View Applications");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Skills: ");
                String skills = sc.nextLine();
                candidates.add(new Candidate(candidateIdCounter++, name, skills));
                System.out.println("Registered Successfully!");
            }
            case 2 -> viewJobs();
            case 3 -> applyJob();
            case 4 -> viewApplications();
        }
    }

    // ================= COMPANY MENU =================

    static void companyMenu() {
        System.out.println("\n1. Register Company");
        System.out.println("2. Post Job");
        System.out.println("3. Close Job");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter Company Name: ");
                String name = sc.nextLine();
                companies.add(new Company(companyIdCounter++, name));
                System.out.println("Company Registered!");
            }
            case 2 -> {
                System.out.print("Enter Company Name: ");
                String cname = sc.nextLine();
                System.out.print("Enter Job Title: ");
                String title = sc.nextLine();
                jobs.add(new Job(jobIdCounter++, title, cname));
                System.out.println("Job Posted Successfully!");
            }
            case 3 -> {
                System.out.print("Enter Job ID to Close: ");
                int id = sc.nextInt();
                for (Job j : jobs) {
                    if (j.id == id) {
                        j.isOpen = false;
                        System.out.println("Job Closed!");
                    }
                }
            }
        }
    }

    // ================= ADMIN MENU =================

    static void adminMenu() {
        System.out.println("\n--- ADMIN PANEL ---");
        System.out.println("Total Candidates: " + candidates.size());
        System.out.println("Total Companies: " + companies.size());
        System.out.println("Total Jobs: " + jobs.size());
        System.out.println("Total Applications: " + applications.size());
    }

    // ================= HELPER METHODS =================

    static void viewJobs() {
        System.out.println("\n--- Available Jobs ---");
        for (Job j : jobs) {
            if (j.isOpen)
                System.out.println("ID: " + j.id + " | " + j.title + " | Company: " + j.companyName);
        }
    }

    static void applyJob() {
        System.out.print("Enter Candidate ID: ");
        int cid = sc.nextInt();
        System.out.print("Enter Job ID: ");
        int jid = sc.nextInt();
        applications.add(new Application(cid, jid));
        System.out.println("Applied Successfully!");
    }

    static void viewApplications() {
        System.out.println("\n--- Applications ---");
        for (Application a : applications) {
            System.out.println("Candidate ID: " + a.candidateId +
                    " | Job ID: " + a.jobId +
                    " | Status: " + a.status);
        }
    }
    
}
