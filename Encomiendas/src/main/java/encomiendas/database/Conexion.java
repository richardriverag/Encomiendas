package encomiendas.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //Patron singleton
        private static String url = "jdbc:mysql://localhost:3306/encomiendas";
        private static String user = "root";
        private static String password = "12345";
        private static Connection myConn = null;

        public static Connection getInstance()  {
            if (myConn == null) {
                try {
                    myConn = DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                    System.out.println("Existio un error al conectar a la base de datos" + e.getMessage());
                }
            }
            return myConn;
        }

    
}


