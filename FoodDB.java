/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Chinm
 */
import com.mongodb.client.*;
import org.bson.Document;
import java.util.Arrays;
public class FoodDB {

    public static void main(String[] args) {

        String uri = System.getenv("MONGO_URI");

        MongoClient client = MongoClients.create(uri);
        MongoDatabase db = client.getDatabase("foodDB");
        MongoCollection<Document> orders = db.getCollection("orders");

        // ---------------- INSERT ----------------
        Document o1 = new Document("order_id", 101)
                .append("customer_name", "Rahul")
                .append("restaurant", "Pizza Hut")
                .append("food_item", "Pizza")
                .append("quantity", 2)
                .append("price", 500)
                .append("city", "Bangalore")
                .append("status", "Delivered");

        orders.insertOne(o1);

        // ---------------- FIND ----------------
        System.out.println("\nAll Orders:");
        for (Document d : orders.find()) {
            System.out.println(d.toJson());
        }

        // ---------------- FILTER ----------------
        System.out.println("\nBangalore Orders:");
        for (Document d : orders.find(new Document("city", "Bangalore"))) {
            System.out.println(d.toJson());
        }

        // ---------------- AGGREGATION ----------------
        System.out.println("\nRevenue by City:");
        orders.aggregate(Arrays.asList(
                new Document("$group",
                        new Document("_id", "$city")
                                .append("total", new Document("$sum", "$price"))
                )
        )).forEach(doc -> System.out.println(doc.toJson()));

        // ---------------- ADVANCED QUERY ----------------
        System.out.println("\nPrice > 300:");
        for (Document d : orders.find(new Document("price",
                new Document("$gt", 300))).sort(new Document("price", -1))) {
            System.out.println(d.toJson());
        }

        client.close();
    }
}
