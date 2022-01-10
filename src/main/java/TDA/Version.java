package TDA;

import java.util.Date;

public class Version {
    // Atributos
    private int iDversion;
    private String textoContenido;
    private Date fechaModificacion;

    // Constructor
    public Version Version(int iDversion, String textoContenido, Date fechaModificacion){
        this.iDversion = iDversion;
        this.textoContenido = textoContenido;
        this.fechaModificacion = fechaModificacion;
        return this;
    }

    @Override
    public String toString() {
        return "Version{" +
                "iDversion=" + iDversion +
                ", textoContenido='" + textoContenido + '\'' +
                ", fechaModificacion=" + fechaModificacion +
                '}';
    }

    // Metodos
}
