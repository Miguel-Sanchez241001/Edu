/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc
 */

public class Conexion {
    private static Connection conn;
    
    public static Connection openConnection() {
        if ( conn != null )
            return conn;

        try {
            String usuario = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/edutin?useSSL=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectamos");

        } catch (Exception e) {
            System.out.println( e.getMessage() );
            System.out.println("Algo salio mal :( ");
        }
        return conn;
    }
   
    public static void closeConnection() {
        try {
            if( conn != null ) {
                conn.close();
            }
            System.out.println("Desaconectados de la BD");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
