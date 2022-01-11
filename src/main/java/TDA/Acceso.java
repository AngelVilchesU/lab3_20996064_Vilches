package TDA;

import javax.swing.*;
import java.util.ArrayList;

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

    // Metodos
    public String getNombreUsuario(){
        return nombreUsuario;
    }

    public char getTipoAcceso() {
        return tipoAcceso;
    }

    // Metodo que permite determinar si un tipo de acceso es valido o no
    public boolean accesoValido(char tipoAcceso){
        char leer = 'R';
        char escribir = 'W';
        char compartir = 'C';

        if(tipoAcceso == leer || tipoAcceso == escribir || tipoAcceso == compartir){
            return true;
        }
        return false;
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
