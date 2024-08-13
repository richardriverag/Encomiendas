package encomiendas;

import encomiendas.views.transporte.JFMantenimiento;
import encomiendas.views.transporte.JFRuta;
import encomiendas.views.transporte.JFTransporte;


public class Encomiendas {

    public static void main(String[] args) {
        JFMantenimiento transporte = new JFMantenimiento();
        transporte.setVisible(true);
        transporte.setResizable(false);
        transporte.setLocationRelativeTo(null);
    }
}
