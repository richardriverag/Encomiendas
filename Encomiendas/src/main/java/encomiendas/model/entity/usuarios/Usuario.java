package encomiendas.model.entity.usuarios;

import lombok.*;

@Getter @Setter @NoArgsConstructor
public class Usuario {
    
    private String idUsuario;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rol;
    private String direccion;
    private String ciudad;
    private String telefonoAdicional;
    private Character tipoLicencia;
    private Boolean estadoCuenta;
    private Integer idAgencia;
    
}

