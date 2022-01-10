package TDA;

import java.util.Date;

public class Acceso {
    // Atributos
    private String nombreUsuario;
    private char tipoAcceso;

    // Constructor
    public Acceso Acceso(String nombreUsuario, char tipoAcceso){
        this.nombreUsuario = nombreUsuario;
        this.tipoAcceso = tipoAcceso;
        return this;
    }

    @Override
    public String toString() {
        return "Acceso{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", tipoAcceso=" + tipoAcceso +
                '}';
    }

    // Metodos
}
