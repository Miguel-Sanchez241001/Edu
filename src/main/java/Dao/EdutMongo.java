/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.ConexionMongo;
import Entidades.Chat;
import Entidades.Contacto;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.bson.Document;

/**
 *
 * @author pc
 */
public class EdutMongo {

    public static MongoClient mongo;
    public static Logger logger = Logger.getLogger(EdutMongo.class);
    public static MongoDatabase db;

    public EdutMongo() {
        mongo = ConexionMongo.openConnection();
        BasicConfigurator.configure();
        db = mongo.getDatabase("Edutinbd");
    }

    public void agregarMensaje(Chat chatt) {

        try {
            MongoCollection<Document> collection = db.getCollection("mensajes");
            Document doc1 = new Document("Nombre", chatt.getNombre())
                    .append("Mensaje", chatt.getMensaje())
                    .append("Destinatatio", chatt.getDestinatario());
            collection.insertOne(doc1);
            logger.info("Mensaje de ".concat(chatt.getNombre()).concat("Para").concat(chatt.getDestinatario()));
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

    }

    public void NewContacto(Contacto contac) {

        try {
            MongoCollection<Document> collection = db.getCollection("MensajesContacto");
            Document doc1 = new Document("Nombre", contac.getNombre())
                    .append("Apellido", contac.getApellido())
                    .append("correo", contac.getCorreo())
                    .append("Telefono", contac.getNumero())
                    .append("Mensaje", contac.getMensaje());
            collection.insertOne(doc1);
           logger.info("Mensaje contacto de "+ contac.getNombre());
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

    }

}
