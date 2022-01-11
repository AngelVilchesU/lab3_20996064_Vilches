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

    // Metodo que permite determinar si un usuario figura como autor de un documento de acuerdo a su identificador
    public boolean existeDocumentoAutor(int iDdocumento, String autor){
        int i = 0;
        for(i = 0; i < this.listaDocumentos.size(); i ++){
            if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento && this.listaDocumentos.get(i).getAutor().equals(autor)){
                return true;
            }
        }
        return false;
    }

    // Metodo que permite determinar la existencia de un nombre de usuario
    public boolean existeNombreUsuario(String nombreUsuario){
        int i = 0;
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
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

    // Metodo que permite compartir compartir un documento por parte del usuario autenticado ...
    // quien tambien debe figurar como autor del escrito de acuerdo con los tipos de acceso ...
    // y/o permisos lectura ("R"), escritura ("W") o comentario ("C")
    public void share(ArrayList usuariosCompartir, int iDdocumento, char permiso){
        ArrayList<Acceso> listaAccesos = new ArrayList<>();
        Acceso acceso = new Acceso();

        // Si el permiso y/o acceso es valido ("R", "W" o "C")...
        if(acceso.accesoValido(permiso)) {
            int i = 0;
            // Se elabora un arreglo de objetos del tipo Acceso
            for (i = 0; i < usuariosCompartir.size(); i++) {
                Acceso aCceso = new Acceso();
                aCceso.Acceso(usuariosCompartir.get(i).toString(), permiso);
                listaAccesos.add(aCceso);
            }
            // Se busca el documento
            for(i = 0; i < this.listaDocumentos.size(); i ++){
                if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento){
                    this.listaDocumentos.get(i).getListaAccesos().addAll(listaAccesos);
                }
            }
            System.out.println("El proceso fue completado exitosamente");
        }
        else {
            System.out.println("El acceso y/o permiso no es valido");
            System.out.println("El documento no ha sido compartido");
        }
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
