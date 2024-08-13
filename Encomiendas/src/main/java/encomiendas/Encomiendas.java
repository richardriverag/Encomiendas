package encomiendas;

import encomiendas.views.transporte.JFRuta;
import encomiendas.views.transporte.JFTransporte;


/**
 *
 * @author Richard
 */
public class Encomiendas {

    public static void main(String[] args) {
        JFTransporte transporte = new JFTransporte();
        transporte.setVisible(true);
        transporte.setResizable(false);
        transporte.setLocationRelativeTo(null);
    }
}