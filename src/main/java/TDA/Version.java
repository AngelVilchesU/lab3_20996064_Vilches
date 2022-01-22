package TDA;

import java.util.Date;

/**
 * Clase para representar la version que posee un documento en la plataforma.
 * Cada Version se encuentra determinada por el identificador de la version, texto contenido
 * y fecha de modificacion.
 * @author Angel Vilches
 */

public class Version {
    // Atributos
    private int iDversion;
    private String textoContenido;
    private Date fechaModificacion;

    // Constructor
    public Version(int iDversion, String textoContenido, Date fechaModificacion){
        this.iDversion = iDversion;
        this.textoContenido = textoContenido;
        this.fechaModificacion = fechaModificacion;
    }

    // Metodos

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al identificador de la version.
     * Retorna un int correspondiente al identificador de la version.
     */
    public int getiDversion(){
        return iDversion;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al texto contenido.
     * Retorna un String correspondiente al texto contenido en la version.
     */
    public String getTextoContenido(){
        return textoContenido;
    }

    /**
     * EL siguiente metodo permite modificar el dato correspondiente al identificador de la version.
     * En una version que se determina como actual luego de una restauracion es necesario modificar
     * su identificador para de esta forma establecer identificadores valido y correlativos entre versiones.
     */
    public void setiDversion(int iDversion){
        this.iDversion = iDversion;
    }

    /**
     * EL siguiente metodo permite representar una Version como un String.
     * Retorna un String correspondiente a la Version.
     */
    @Override
    public String toString(){
        return "Version{" +
                "iDversion=" + iDversion +
                ", textoContenido='" + textoContenido + '\'' +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }
}
