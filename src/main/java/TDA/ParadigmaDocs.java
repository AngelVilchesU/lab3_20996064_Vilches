package TDA;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;

public class ParadigmaDocs {
    // Atributos
    private String nombrePlataforma;
    private Date fechaCreacion;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Documento> listaDocumentos = new ArrayList<>();

    // Constructor
    public ParadigmaDocs ParadigmaDocs(String nombrePlataforma, Date fechaCreacion,
                                            ArrayList listaUsuarios, ArrayList listaDocumentos){
        this.nombrePlataforma = nombrePlataforma;
        this.fechaCreacion = fechaCreacion;
        this.listaUsuarios = listaUsuarios;
        this.listaDocumentos = listaDocumentos;
        return this;
    }

    // Metodos

    // Metodo que permite determinar la existencia de un usuario
    private boolean existeUsuario(Usuario usuario){
        int i = 0;
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())){
                return true;
            }
        }
        return false;
    }

    // Metodo que permite determinar si un usuario determinado se encuentra activo
    private boolean esUsuarioActivo(Usuario usuario){
        if(usuario.getSesion() == 1){
            return true;
        }
        return false;
    }

    // Metodo que permite determinar si existe un usuario activo
    public boolean existeUsuarioActivo(){
        int i = 0;
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion() == 1){
                return true;
            }
        }
        return false;
    }

    // Metodo que permite retornar el nombre de un usuario activo
    public String nombreUsuarioActivo(){
        int i = 0;
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion() == 1){
                return this.listaUsuarios.get(i).getNombreUsuario();
            }
        }
        return "No existe usuario activo";
    }

    // Metodo que permite el registro de un usuario en la plataforma
    public boolean register(String nombreUsuario, String contraseniaUsuario, int sesion){
        // Se crea un usuario nuevo
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.Usuario(nombreUsuario, contraseniaUsuario, sesion);
        // Se evalua la existencia del mismo en la plataforma para ser agregado, o no
        if(this.existeUsuario(usuarioNuevo) == false){
            this.listaUsuarios.add(usuarioNuevo);
            return true;
        }
        else {
            return false;
        }
    }

    // Metodo que permite autenticar un usuario en la plataforma
    public boolean login(String nombreUsuario, String contraseniaUsuario, int sesion){
        // Se crea un usuario nuevo
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.Usuario(nombreUsuario, contraseniaUsuario, sesion);
        // Se evalua la existencia del mismo en la plataforma para ser agregado, o no
        if(this.existeUsuario(usuarioNuevo)){
            int indice;
            for(int contador = 0; contador < listaUsuarios.size(); contador ++){
                if(listaUsuarios.get(contador).getNombreUsuario().equals(usuarioNuevo.getNombreUsuario())){
                    Usuario usuarioAutenticado = new Usuario();
                    usuarioAutenticado.Usuario(nombreUsuario, contraseniaUsuario, 1);
                    listaUsuarios.set(contador, usuarioAutenticado);
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    // Metodo que permite cerrar una sesion activa de usuario
    public boolean logout(){
        for(int contador = 0; contador < listaUsuarios.size(); contador ++){
            if(esUsuarioActivo(listaUsuarios.get(contador))){
                Usuario usuarioFinalizado = new Usuario();
                usuarioFinalizado.Usuario(listaUsuarios.get(contador).getNombreUsuario(), listaUsuarios.get(contador).getContraseniaUsuario(), 0);
                listaUsuarios.set(contador, usuarioFinalizado);
                return true;
            }
        }
        return false;
    }

    // Metodo que permite crear e insertar un documento al editor y/o plataforma
    // Es importante comentar que su uso esta reservado unicamente a la definicion de documentos...
    // inicial en la plataforma
    public void crearDocumento(Usuario usuario, int iDdocumento, String nombreDocumento, Date fechaCreacion,
                               ArrayList listaVersiones, ArrayList listaAccesos, String textoContenido){

        Documento nuevoDocumento = new Documento();
        Version nuevaVersion = new Version();
        int iDversion = listaVersiones.size();
        nuevaVersion.Version(iDversion, textoContenido, fechaCreacion);
        ArrayList<Version> listaVersionesNueva = new ArrayList<>();
        listaVersionesNueva.add(nuevaVersion);
        nuevoDocumento.Documento(iDdocumento, usuario.getNombreUsuario(), nombreDocumento, fechaCreacion, listaVersionesNueva, listaAccesos);
        this.listaDocumentos.add(nuevoDocumento);
    }

    // Metodo que permite la creacion de un nuevo documento en la plataforma validando la autenticacion del usuario
    public void create(String nombreDocumento, String textoContenido){
        Date fechaCreacion = new Date();
        int iDdocumento = listaDocumentos.size();
        int iDversion = 0;
        String autor = nombreUsuarioActivo();
        Documento nuevoDocumento = new Documento();
        Version versionInicial = new Version();
        Acceso accesos = new Acceso();
        ArrayList<Version> listaVersionesInicial = new ArrayList<>();
        ArrayList<Acceso> listaAccesosInicial = new ArrayList<>();
        versionInicial.Version(iDversion, textoContenido, fechaCreacion);
        listaVersionesInicial.add(versionInicial);

        nuevoDocumento.Documento(iDdocumento, autor, nombreDocumento, fechaCreacion, listaVersionesInicial, listaAccesosInicial);
        this.listaDocumentos.add(nuevoDocumento);
    }


    @Override
    public String toString() {
        return "ParadigmaDocs{" +
                "nombrePlataforma='" + nombrePlataforma + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", listaUsuarios=" + listaUsuarios +
                ", listaDocumentos=" + listaDocumentos +
                '}';
    }
}
