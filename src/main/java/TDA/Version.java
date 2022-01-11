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

    // Metodos

    public int getiDversion(){
        return iDversion;
    }

    public String getTextoContenido(){
        return textoContenido;
    }

    public void setiDversion(int iDversion){
        this.iDversion = iDversion;
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
