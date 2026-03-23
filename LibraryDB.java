/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication7;

/**
 *
 * @author Chinm
 */
import com.mongodb.client.*;
import org.bson.Document;
public class LibraryDB {

    public static void main(String[] args) {
               // Connection String
        String uri = "mongodb+srv://student_db_user:9KV9yURMlUp2s9Jn@cluster0.8dupopr.mongodb.net/";

        // Connect
        MongoClient client = MongoClients.create(uri);

        // Database
        MongoDatabase db = client.getDatabase("libraryDB");

        // Collection
        MongoCollection<Document> books = db.getCollection("books");

        // ---------------- INSERT ----------------
        Document book1 = new Document("book_id", 101)
                .append("title", "Data Structures")
                .append("author", "Mark Allen")
                .append("genre", "Computer Science")
                .append("status", "Available");

        books.insertOne(book1);

        System.out.println("Book inserted!");

        // ---------------- FIND ----------------
        System.out.println("\nAll Books:");
        for (Document doc : books.find()) {
            System.out.println(doc.toJson());
        }

        // ---------------- UPDATE ----------------
        books.updateOne(
                new Document("book_id", 101),
                new Document("$set", new Document("status", "Issued"))
        );

        System.out.println("Book updated!");

        // ---------------- DELETE ----------------
        books.deleteOne(new Document("book_id", 103));

        System.out.println("Book deleted!");

        client.close();
  
    }
    
}
