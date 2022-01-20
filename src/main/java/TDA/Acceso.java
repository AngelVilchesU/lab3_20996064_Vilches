package TDA;

/**
 * Clase para representar el acceso que posee un usuario sobre un documento en la plataforma.
 * Cada Acceso se encuentra determinado por el nombre de usuario y el acceso que dicho usuario
 * posee para un documento determinado.
 * @author Angel Vilches
 */

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

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al nombre de usuario.
     * Retorna un String correspondiente al nombre de usuario.
     */
    public String getNombreUsuario(){
        return nombreUsuario;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al tipo de acceso.
     * Retorna un char correspondiente al tipo de acceso.
     */
    public char getTipoAcceso() {
        return tipoAcceso;
    }

    /**
     * EL siguiente metodo permite determinar si un tipo de acceso es valido o no.
     * Retorna un boolean correspondiente a la validez del acceso/permiso.
     */
    public boolean accesoValido(char tipoAcceso){
        // Accesos validos
        char leer = 'R';
        char escribir = 'W';
        char compartir = 'C';

        return tipoAcceso == leer || tipoAcceso == escribir || tipoAcceso == compartir;
    }



    /**
     * EL siguiente metodo permite representar un Acceso como un String.
     * Retorna un String correspondiente al Acceso.
     */
    @Override
    public String toString(){
        return "Acceso{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", tipoAcceso=" + tipoAcceso +
                '}';
    }
}
