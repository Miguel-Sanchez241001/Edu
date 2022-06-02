/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.ConexionMongo;
import Entidades.Chat;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Scanner;

import org.bson.Document;

/**
 *
 * @author pc
 */
public class chatDao {

    public static MongoClient mongo;

    public chatDao() {
        mongo = ConexionMongo.openConnection();
    }

    public String agregarMensaje(Chat chatt) {
        String men;
        MongoDatabase db = mongo.getDatabase("chat");
        try {
            MongoCollection<Document> collection = db.getCollection("mensajes");
            Document doc1 = new Document("Nombre", chatt.getNombre()).append("Mensaje", chatt.getMensaje()).append("Destinatatio", chatt.getDestinatario());
            collection.insertOne(doc1);
            men = "Se inserto el mensaje:  " + chatt.getMensaje() + " de " + chatt.getNombre() + " para " + chatt.getDestinatario();
        } catch (Exception e) {
            men = "error";
            System.err.print(e);
        }

        return men;

    }
    public String cursos() {
        String men;
        MongoDatabase db = mongo.getDatabase("bdEscuela");
        try {
            MongoCollection<Document> collection = db.getCollection("Telefono");
            int numero = (int)(Math.random() * 1000000);
            Document doc1 = new Document("numero", Integer.parseInt ( "995" +  String.valueOf(numero)));
            collection.insertOne(doc1);
            men = "Se inserto el curso:  " + numero ;
        } catch (Exception e) {
            men = "error";
            System.err.print(e);
        }

        return men;

    }
//    public static void main(String[] args) {
//        chatDao dao = new chatDao();
//        Scanner obj = new Scanner(System.in);
//       // Chat chat = new Chat("JUANITO", "FELIZ NAVIDAD", "LUCHOITO");
//        for (int i = 1; i <=10; i++) {
//            System.out.println(dao.cursos());
//        }
//
//        
//
//    }

}
