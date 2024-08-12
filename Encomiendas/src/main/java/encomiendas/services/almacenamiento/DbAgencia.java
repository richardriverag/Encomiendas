/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.services.almacenamiento;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.entidades.Agencia;

/**
 *
 * @author tandr
 */
public class DbAgencia extends Conexion {
     private static final String SQL_SELECT = "SELECT id_agencia, nombre_agencia FROM agencia";

    public List<Agencia> obtenerAgencias() {
        List<Agencia> agencias = new ArrayList<>();
        try (Connection con = getConexion();
             PreparedStatement ps = con.prepareStatement(SQL_SELECT);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_agencia");
                String nombre = rs.getString("nombre_agencia");
                agencias.add(new Agencia(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agencias;
    }
}
