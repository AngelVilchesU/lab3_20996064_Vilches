package TDA;

import java.util.Date;

/**
 * Clase para representar el usuario que posee una plataforma.
 * Cada Usuario se encuentra determinada por el nombre de usuario, contrasenia de usuario,
 * fecha de creacion y un indicador que refleja si un usuario se encuentra activo o no.
 * @author Angel Vilches
 */

public class Usuario {
    // Atributos
    private String nombreUsuario;
    private String contraseniaUsuario;
    private Date fechaCreacion;
    private boolean sesion;

    // Constructor
    public Usuario(String nombreUsuario, String contraseniaUsuario, Date fechaCreacion, boolean sesion){
        this.nombreUsuario = nombreUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.fechaCreacion = fechaCreacion;
        this.sesion = sesion;
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
     * EL siguiente metodo permite obtener el dato correspondiente a la contrasenia de usuario.
     * Retorna un String correspondiente a la contrasenia de usuario.
     */
    public String getContraseniaUsuario(){
        return contraseniaUsuario;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente a la fecha de creacion de usuario.
     * Retorna Date correspondiente a la fecha de creacion de usuario.
     */
    public Date getFechaCreacion(){
        return fechaCreacion;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente a la sesion de usuario.
     * Retorna un int correspondiente a la sesion de usuario.
     */
    public boolean getSesion(){
        return sesion;
    }


    /**
     * EL siguiente metodo permite representar un Usuario como un String.
     * Retorna un String correspondiente al Usuario.
     */
    @Override
    public String toString() {
        return "Nombre usuario: " + nombreUsuario + "\n" +
                "Fecha de Creacion: " + fechaCreacion + "\n";
    }
}
