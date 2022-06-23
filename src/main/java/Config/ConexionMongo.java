/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import com.mongodb.MongoClient;

/**
 *
 * @author pc
 */
public class ConexionMongo {

    static MongoClient mongo;
    static String servidor = "localhost";
    static int puerto = 27017;

    public static MongoClient openConnection() {
        mongo = new MongoClient(servidor, puerto);
        System.out.println("Conectamos");
        return mongo;
    }
}
