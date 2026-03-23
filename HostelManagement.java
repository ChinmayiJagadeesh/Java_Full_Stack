
import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;
public class HostelManagement {

    static MongoCollection<Document> students;
    static MongoCollection<Document> complaints;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
    static MongoCollection<Document> bookings;

    public static void main(String[] args) {

        String uri = "mongodb+srv://student_db_user:9KV9yURMlUp2s9Jn@cluster0.8dupopr.mongodb.net/";

        MongoClient client = MongoClients.create(uri);
        MongoDatabase db = client.getDatabase("hostelDB");

        students = db.getCollection("students");
        complaints = db.getCollection("complaints");
        bookings = db.getCollection("bookings");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    studentMenu(sc);
                    break;
                case 2:
                    adminMenu(sc);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    // ---------------- STUDENT MENU ----------------
    static void studentMenu(Scanner sc) {
        System.out.println("\nEnter Student ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name:");
        String name = sc.nextLine();

        students.insertOne(new Document("studentId", id).append("name", name));

        while (true) {
            System.out.println("\n1. Raise Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Book Resource");
            System.out.println("4. Logout");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) raiseComplaint(sc, id);
            else if (ch == 2) viewComplaints(id);
            else if (ch == 3) bookResource(sc, id);
            else break;
        }
    }

    // ---------------- COMPLAINT ----------------
    static void raiseComplaint(Scanner sc, int id) {
        System.out.println("Enter Type:");
        String type = sc.nextLine();

        System.out.println("Enter Description:");
        String desc = sc.nextLine();

        Document doc = new Document("studentId", id)
                .append("type", type)
                .append("description", desc)
                .append("status", "Pending");

        complaints.insertOne(doc);

        System.out.println("Complaint Registered!");
    }

    static void viewComplaints(int id) {
        for (Document doc : complaints.find(new Document("studentId", id))) {
            System.out.println(doc.toJson());
        }
    }

    // ---------------- BOOKING ----------------
    static void bookResource(Scanner sc, int id) {
        System.out.println("Enter Resource:");
        String res = sc.nextLine();

        System.out.println("Enter Time Slot:");
        String slot = sc.nextLine();

        // Check duplicate
        Document existing = bookings.find(new Document("resource", res)
                .append("timeSlot", slot)).first();

        if (existing != null) {
            System.out.println("Slot already booked!");
            return;
        }

        bookings.insertOne(new Document("resource", res)
                .append("studentId", id)
                .append("timeSlot", slot));

        System.out.println("Booking Successful!");
    }

    // ---------------- ADMIN ----------------
    static void adminMenu(Scanner sc) {

        while (true) {
            System.out.println("\n1. View Complaints");
            System.out.println("2. Update Complaint Status");
            System.out.println("3. View Bookings");
            System.out.println("4. Logout");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                for (Document d : complaints.find())
                    System.out.println(d.toJson());
            }

            else if (ch == 2) {
                System.out.println("Enter studentId:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter new status:");
                String status = sc.nextLine();

                complaints.updateOne(
                        new Document("studentId", id),
                        new Document("$set", new Document("status", status))
                );

                System.out.println("Updated!");
            }

            else if (ch == 3) {
                for (Document d : bookings.find())
                    System.out.println(d.toJson());
            }

            else break;
        }
    }
}

