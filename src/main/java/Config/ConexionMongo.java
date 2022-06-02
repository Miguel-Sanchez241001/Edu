/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

/**
 *
 * @author pc
 */
public class ConexionMongo {

//    private static MongoClient crearConexion() {
//        MongoClient mongo = null;
//        mongo = new MongoClient("localhost", 27017);
//        System.out.println("Conectamos a mongo");
//
//        return mongo;
//    }
//    private static void printDatabases(MongoClient mongo) {
//        List dbs = (List)mongo.listDatabases();
//        for (Object db : dbs) {
//            System.out.println(" - " + db);
//        }
//    }
    static MongoClient mongo;
    static String servidor = "localhost";
    static int puerto = 27017;

    public static MongoClient openConnection() {
        mongo = new MongoClient(servidor, puerto);
        System.out.println("Conectamos");
        return mongo;
    }

//    public static void main(String[] args) {
//
//        MongoClient mongwo = openConnection();
//
//        MongoDatabase db = mongwo.getDatabase("chat");
//        MongoCollection<Document> collection = db.getCollection("mensajes");
//
//        Document doc1 = new Document("nombre", "sdfa").append("mensaje", "afsdfasdfasasd");
//        collection.insertOne(doc1);
//        
//        FindIterable<Document> iterable = collection.find();
//        System.out.println(iterable.first());
//        mongo.close();
//    }
}
