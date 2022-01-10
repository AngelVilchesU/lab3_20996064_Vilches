package TDA;

import java.util.ArrayList;
import java.util.Date;

public class Documento {
    // Atributos
    private int iDdocumento;
    private String nombreDocumento;
    private Date fechaCreacion;
    private ArrayList<Version> listaVersiones = new ArrayList<>();
    private ArrayList<Acceso> listaAccesos = new ArrayList<>();

    // Constructor
    public Documento crearDocumento(int iDdocumento, String nombreDocumento, Date fechaCreacion,
                                    ArrayList listaVersiones, ArrayList listaAccesos){
        this.iDdocumento = iDdocumento;
        this.nombreDocumento = nombreDocumento;
        this.fechaCreacion = fechaCreacion;
        this.listaVersiones = listaVersiones;
        this.listaAccesos = listaAccesos;
        return this;
    }

    // Metodos
}
