/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Richard
 */
public class Conexion {
        public static Connection getCon(){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/encomiendas","root","12345");
            return con;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Fallo de conexión", "alert", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}


