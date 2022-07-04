/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author pc
 */

public class Conexion {
    public static Connection conn;
    private static final Logger LOG = Logger.getLogger(Conexion.class.getName());
   
    public static Connection openConnection() {
        BasicConfigurator.configure();
        if ( conn != null )
            return conn;

        try {
            String usuario = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/edutin?useSSL=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);
           LOG.info("Conectamos");

        } catch (Exception e) {
           LOG.warn(e.getMessage() );
            LOG.warn("Algo salio mal :( ");
        }
        return conn;
    }
   
    public static void closeConnection() {
        try {
            if( conn != null ) {
                conn.close();
            }
            LOG.info("Desaconectados de la BD");
        } catch(Exception e) {
             LOG.warn(e.getMessage());
        }

    }

}
