package TDA;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para representar la plataforma/editor.
 * Cada ParadigmaDocs se encuentra determinada por el nombre de plataforma, fecha de creacion
 * un arreglo de objetos tipo Usuario y arreglo de objetos tipo Documento.
 * @author Angel Vilches
 */

public class ParadigmaDocs {
    // Atributos
    private String nombrePlataforma;
    private Date fechaCreacion;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Documento> listaDocumentos = new ArrayList<>();

    // Constructor
    public ParadigmaDocs ParadigmaDocs(String nombrePlataforma, Date fechaCreacion,
                                            ArrayList<Usuario> listaUsuarios, ArrayList<Documento> listaDocumentos){
        this.nombrePlataforma = nombrePlataforma;
        this.fechaCreacion = fechaCreacion;
        this.listaUsuarios = listaUsuarios;
        this.listaDocumentos = listaDocumentos;
        return this;
    }

    // Metodos

    /**
     * EL siguiente metodo permite determinar la existencia de un usuario en el arreglo de objetos tipo Usuario.
     * Retorna un boolean correspondiente a la existencia de dicho usuario.
     */
    private boolean existeUsuario(Usuario usuario){
        int i = 0;
        // Se recorre el arreglo buscando en paralelo la existencia del usuario ingresado
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar si un usuario figura como autor de un documento de acuerdo a su identificador.
     * Retorna un boolean correspondiente a la existencia de un usuario como autor de un documento determinado.
     */
    public boolean existeDocumentoAutor(int iDdocumento, String autor){
        int i = 0;
        // Se recorre el arreglo buscando en paralelo el documento (con su identificador) junto con
        // la existencia del usuario ingresado como su respectivo autor.
        for(i = 0; i < this.listaDocumentos.size(); i ++){
            if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento && this.listaDocumentos.get(i).getAutor().equals(autor)){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar si un usuario se le ha compartido un documento, de acuerdo a su arreglo
     * contenedor de accesos, con acceso/permiso de edicion.
     * Retorna un boolean correspondiente a la existencia de un usuario como editor de un documento determinado.
     */
     public boolean existeDocumentoEditor(ArrayList<Acceso> listaAccesos, String editor){
        int i = 0;
        char permisoEditor = 'W';
        // Se recorre el arreglo de accesos buscando en paralelo el nombre del editor con su respectivo
        // permiso de edición
        for(i = 0; i < listaAccesos.size(); i ++){
            if(listaAccesos.get(i).getNombreUsuario().equals(editor) && listaAccesos.get(i).getTipoAcceso() == permisoEditor){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar si un usuario se le ha compartido un documento, de acuerdo a su arreglo
     * contenedor de accesos, con acceso/permiso de edicion.
     * Retorna un boolean correspondiente a la existencia de un usuario como editor de un documento determinado.
     */
    public boolean existeDocumentoCompartido(ArrayList<Acceso> listaAccesos, String usuario){
        int i = 0;
        char permisoLector = 'R';
        char permisoEditor = 'W';
        char permisoComentar = 'C';
        // Se recorre el arreglo de accesos buscando en paralelo el nombre del usuario con su respectivo
        // permiso de acceso
        for(i = 0; i < listaAccesos.size(); i ++){
            if(listaAccesos.get(i).getNombreUsuario().equals(usuario) && listaAccesos.get(i).getTipoAcceso() == permisoEditor
            || listaAccesos.get(i).getTipoAcceso() == permisoEditor || listaAccesos.get(i).getTipoAcceso() == permisoComentar){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar la existencia de un nombre de usuario en el arreglo de objetos tipo
     * Usuario.
     * Retorna un boolean correspondiente a la existencia de un usuario registrado en la plataforma.
     */
    public boolean existeNombreUsuario(String nombreUsuario){
        int i = 0;
        // Se recorre el arreglo de usuarios registrados buscando en paralelo el nombre de aquel usuario
        // que se busca determinar su existencia
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuario)){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar si un usuario especifico esta activo.
     * Retorna un boolean correspondiente a la verificacion de si el usuario esta activo o no.
     */
    public boolean esUsuarioActivo(Usuario usuario){
        if(usuario.getSesion() == 1){
            return true;
        }
        return false;
    }

    /**
     * EL siguiente metodo permite determinar la existencia de un usuario activo en la plataforma.
     * Retorna un boolean correspondiente a la existencia de un usuario activo.
     */
    public boolean existeUsuarioActivo(){
        int i = 0;
        // Se recorre el arreglo de usuarios registrados buscando en paralelo la existencia de un usuario
        // activo
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion() == 1){
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente metodo permite obtener el nombre de un usuario activo en la plataforma.
     * Retorna un String correspondiente al nombre de usuario activo.
     */
    public String nombreUsuarioActivo(){
        int i = 0;
        // Se recorre el arreglo de usuarios registrados buscando en paralelo la existencia de unm usuario
        // activo retornando su nombre de usuario
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion() == 1){
                return this.listaUsuarios.get(i).getNombreUsuario();
            }
        }
        return "No existe usuario activo";
    }

    /**
     * EL siguiente metodo permite modificar el arreglo de versiones de un documento tras una restauracion
     * de modo que al finalizar el proceso el arreglo sea correlativo (identificador).
     * Proceso que "ordena" los identificadores del arreglo de versiones.
     */
    private void correlativo(ArrayList<Version> listaVersiones){
        int i;
        for (i = 0; i < listaVersiones.size(); i ++){
            listaVersiones.get(i).setiDversion(i);
        }
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

    // Metodo que permite añadir texto al final de la version activa de un documento
    // Enfatizando en la existencia de permisos u accesos de edición y/o presencia de autor
    public void add(int iDdocumento, String textoContenido){
        // Se busca el documento de acuerdo a su identificador
        int i = 0;

        for(i = 0; i < this.listaDocumentos.size(); i ++){
            if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento){
                if(existeDocumentoAutor(iDdocumento, nombreUsuarioActivo()) || existeDocumentoEditor(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {
                    Version nuevaVersion = new Version();
                    String textoUltimaVersion;
                    String textoConcatenado;
                    Date fechaModificacion = new Date();
                    int longitudVersiones = this.listaDocumentos.get(i).getListaVersiones().size() - 1;
                    textoUltimaVersion = this.listaDocumentos.get(i).getListaVersiones().get(longitudVersiones).getTextoContenido();
                    textoConcatenado = textoUltimaVersion + textoContenido;
                    nuevaVersion.Version(longitudVersiones+1, textoConcatenado, fechaModificacion);
                    this.listaDocumentos.get(i).getListaVersiones().add(nuevaVersion);

                }
            }
        }
    }

    // Metodo que permite restaurar, a un usuario autenticado y que figure como autor del documento referenciado, ...
    // una version anterior de un documento
    public void rollback(int iDdocumento, int iDversion){
        // Se busca el documento de acuerdo a su identificador
        int i = 0;

        for(i = 0; i < this.listaDocumentos.size(); i ++){
            if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento){
                // Si el usuario que ha ejecutado el presente metodo figura como autor del texto...
                if(existeDocumentoAutor(iDdocumento, nombreUsuarioActivo())) {
                    // Se busca la version y, en caso de encontrarla esta es respaldada, removida ...
                    // e insertada al final de la lista u arreglo de versiones como la version actual
                    int j = 0;

                    int iDultimaversion = this.listaDocumentos.get(i).getListaVersiones().size() - 1;
                    for (j = 0; j < this.listaDocumentos.get(i).getListaVersiones().size(); j ++){
                        if(this.listaDocumentos.get(i).getListaVersiones().get(j).getiDversion() == iDversion){
                            Version versionRollback = new Version();
                            Date fechaModificacion = new Date();
                            versionRollback.Version(this.listaDocumentos.get(i).getListaVersiones().get(j).getiDversion(), this.listaDocumentos.get(i).getListaVersiones().get(j).getTextoContenido(), fechaModificacion);
                            this.listaDocumentos.get(i).getListaVersiones().remove(j);
                            this.listaDocumentos.get(i).getListaVersiones().add(versionRollback);
                            // Se corrigen los identificadores internos para que estos sean correlativos una vez ...
                            // realizada la operacion
                            correlativo(this.listaDocumentos.get(i).getListaVersiones());
                        }
                    }

                }
            }
        }
    }

    // Metodo que permite a un usuario autor de un documento determinado revocar/remover todos ...
    // los accesos hacia su documento
    public void revokeAccess(int iDdocumento){
        // Se busca el documento de acuerdo a su identificador
        int i = 0;

        for(i = 0; i < this.listaDocumentos.size(); i ++){
            if(this.listaDocumentos.get(i).getiDdocumento() == iDdocumento){
                // Si el usuario que ha ejecutado el presente metodo figura como autor del texto...
                if(existeDocumentoAutor(iDdocumento, nombreUsuarioActivo())) {
                    Acceso accesosRevocado = new Acceso();
                    System.out.println(this.listaDocumentos.get(i).getListaAccesos());
                    this.listaDocumentos.get(i).getListaAccesos().clear();
                }
            }
        }
    }

    // Metodo que permite a un usuario autenticado (por ende registrado) realizar una busqueda
    // de un texto especifico tanto en sus documentos (autor) como en aquellos que le hayan sido
    // compartidos (lectura, escritura o comentario)
    public void search(String textoBuscar){
        // Se buscan los documentos de acuerdo a su autor y/o acceso
        int i = 0;
        int j = 0;

        for(i = 0; i < this.listaDocumentos.size(); i ++){
            // Si el usuario que ejecuto la funcionalidad figura como autor o se le ha compartido...
            if(existeDocumentoAutor(this.listaDocumentos.get(i).getiDdocumento(), nombreUsuarioActivo()) || existeDocumentoCompartido(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {
                // Se busca en las versiones el texto introducido
                for(j = 0; j < this.listaDocumentos.get(i).getListaVersiones().size(); j ++){
                    // Si existe en el documento (versiones) el texto a buscar...
                    if(this.listaDocumentos.get(i).getListaVersiones().get(j).getTextoContenido().contains(textoBuscar)){
                        System.out.println("El texto introducido se encuentra en el documento de ID " +
                                this.listaDocumentos.get(i).getiDdocumento() + "y nombre " +
                                this.listaDocumentos.get(i).getNombreDocumento());
                    }
                }
            }
        }
    }




















    /**
     * EL siguiente metodo permite representar una plataforma como un String.
     * Retorna un String correspondiente a ParadigmaDocs.
     */
    @Override
    public String toString(){
        return "ParadigmaDocs{" +
                "nombrePlataforma='" + nombrePlataforma + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", listaUsuarios=" + listaUsuarios +
                ", listaDocumentos=" + listaDocumentos +
                '}';
    }
}
