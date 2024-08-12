/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encomiendas.model.entity.almacenamiento;

/**
 *
 * @author tandr
 */
public class Agencia {
    private int id;
    private String nombre;

    public Agencia() {
    }

    public Agencia(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre; // Esto se usará para mostrar en el JComboBox
    }
}
