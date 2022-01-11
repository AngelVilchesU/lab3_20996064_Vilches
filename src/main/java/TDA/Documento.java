package TDA;

import java.util.ArrayList;
import java.util.Date;

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

    public int getiDdocumento(){
        return iDdocumento;
    }

    public String getAutor(){
        return autor;
    }

    public ArrayList<Acceso> getListaAccesos(){
        return listaAccesos;
    }

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

    // Metodos
}
