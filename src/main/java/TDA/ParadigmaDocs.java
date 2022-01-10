package TDA;

import java.util.ArrayList;
import java.util.Date;

public class ParadigmaDocs {
    // Atributos
    private String nombrePlataforma;
    private Date fechaCreacion;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Documento> listaDocumentos = new ArrayList<>();

    // Constructor
    public ParadigmaDocs crearParadigmaDocs(String nombrePlataforma, Date fechaCreacion,
                                            ArrayList listaUsuarios, ArrayList listaDocumentos){
        this.nombrePlataforma = nombrePlataforma;
        this.fechaCreacion = fechaCreacion;
        this.listaUsuarios = listaUsuarios;
        this.listaDocumentos = listaDocumentos;
        return this;
    }

    // Metodos

}
