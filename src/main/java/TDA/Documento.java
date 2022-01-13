package TDA;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para representar el documento que posee una plataforma.
 * Cada Documento se encuentra determinada por el identificador del documento, autor, nombre del
 * documento, fecha de creacion, arreglo de objetos tipo Version y arreglo de objetos tipo Acceso.
 * @author Angel Vilches
 */

public class Documento {
    // Atributos
    private int iDdocumento;
    private String autor;
    private String nombreDocumento;
    private Date fechaCreacion;
    private ArrayList<Version> listaVersiones = new ArrayList<>();
    private ArrayList<Acceso> listaAccesos = new ArrayList<>();

    // Constructor
    public Documento Documento(int iDdocumento, String autor, String nombreDocumento, Date fechaCreacion,
                                    ArrayList listaVersiones, ArrayList listaAccesos){
        this.iDdocumento = iDdocumento;
        this.autor = autor;
        this.nombreDocumento = nombreDocumento;
        this.fechaCreacion = fechaCreacion;
        this.listaVersiones = listaVersiones;
        this.listaAccesos = listaAccesos;
        return this;
    }

    // Metodos

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al identificador del documento.
     * Retorna un int correspondiente al identificador del documento.
     */
    public int getiDdocumento(){
        return iDdocumento;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al autor del documento.
     * Retorna un String correspondiente al autor del documento.
     */
    public String getAutor(){
        return autor;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al arreglo de objetos tipo Version.
     * Retorna un ArrayList correspondiente al arreglo de objetos tipo Version de un documento.
     */
    public ArrayList<Version> getListaVersiones(){
        return listaVersiones;
    }

    /**
     * EL siguiente metodo permite obtener el dato correspondiente al arreglo de objetos tipo Acceso.
     * Retorna un ArrayList correspondiente al arreglo de objetos tipo Acceso de un documento.
     */
    public ArrayList<Acceso> getListaAccesos(){
        return listaAccesos;
    }

    /**
     * EL siguiente metodo permite representar un Documento como un String.
     * Retorna un String correspondiente al Documento.
     */
    @Override
    public String toString() {
        return "Documento{" +
                "iDdocumento=" + iDdocumento +
                ", autor=" + autor +
                ", nombreDocumento='" + nombreDocumento + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", listaVersiones=" + listaVersiones +
                ", listaAccesos=" + listaAccesos +
                '}';
    }
}
