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
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Documento> listaDocumentos;

    // Constructor
    public ParadigmaDocs(String nombrePlataforma, Date fechaCreacion,
                                            ArrayList<Usuario> listaUsuarios, ArrayList<Documento> listaDocumentos){
        this.nombrePlataforma = nombrePlataforma;
        this.fechaCreacion = fechaCreacion;
        this.listaUsuarios = listaUsuarios;
        this.listaDocumentos = listaDocumentos;

    }

    // Metodos

    /**
     * EL siguiente metodo permite determinar la existencia de un usuario en el arreglo de objetos tipo Usuario.
     * Retorna un boolean correspondiente a la existencia de dicho usuario.
     */
    private boolean existeUsuario(Usuario usuario){
        int i;
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
        int i;
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
        int i;
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
        int i;
        char permisoLector = 'R';
        char permisoEditor = 'W';
        char permisoComentar = 'C';
        // Se recorre el arreglo de accesos buscando en paralelo el nombre del usuario con su respectivo
        // permiso de acceso
        for(i = 0; i < listaAccesos.size(); i ++){
            if(listaAccesos.get(i).getNombreUsuario().equals(usuario) && listaAccesos.get(i).getTipoAcceso() == permisoLector
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
        int i;
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
        return usuario.getSesion();
    }

    /**
     * EL siguiente metodo permite determinar la existencia de un usuario activo en la plataforma.
     * Retorna un boolean correspondiente a la existencia de un usuario activo.
     */
    public boolean existeUsuarioActivo(){
        int i;
        // Se recorre el arreglo de usuarios registrados buscando en paralelo la existencia de un usuario
        // activo
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion()){
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
        int i;
        // Se recorre el arreglo de usuarios registrados buscando en paralelo la existencia de unm usuario
        // activo retornando su nombre de usuario
        for(i = 0; i < this.listaUsuarios.size(); i ++){
            if(this.listaUsuarios.get(i).getSesion()){
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
    public void correlativo(ArrayList<Version> listaVersiones){
        int i;
        for (i = 0; i < listaVersiones.size(); i ++){
            listaVersiones.get(i).setiDversion(i);
        }
    }

    /**
     * EL siguiente metodo (como parte del requerimiento funcional authentication) permite el registro de un nuevo
     * usuario (objeto) a la plataforma u editor de modo que se evalua la existencia del nombre de usuario a registrar
     * (a modo de ID unico) con los ya registrados para, en caso de no encontrarse añadirle y, en caso de encontrarse
     * no añardirle.
     * Retorna un boolean de acuerdo a si la operacion fue realizada correctamente o no.
     */
    public boolean register(String nombreUsuario, String contraseniaUsuario){

        // Se crea un usuario nuevo

        Date fechaCreacion = new Date();
        boolean sesion = false;
        Usuario usuarioNuevo = new Usuario(nombreUsuario, contraseniaUsuario, fechaCreacion, sesion);

        // Se evalua la existencia del mismo en la plataforma para ser agregado, o no
        if(!this.existeUsuario(usuarioNuevo)){
            this.listaUsuarios.add(usuarioNuevo);
            System.out.println("Se ha registrado el usuario: " + nombreUsuario + " correctamente");
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * EL siguiente metodo (como parte del requerimiento funcional authentication) permite validar las credenciales
     * de acceso de usuario registrado en la plataforma u editor (objeto) de modo que se evalua la existencia del nombre
     * de usuario a registrar (a modo de ID unico) en paralelo con su respectiva contrasenia para, en caso de ser
     * correctas autenticarle y, en caso de ser erronea no autenticarle.
     * Retorna un boolean de acuerdo a si la operacion fue realizada correctamente o no.
     */
    public boolean login(String nombreUsuario, String contraseniaUsuario){

        // Se evalua la existencia del usuario para ser autenticado o no
        if(this.existeNombreUsuario(nombreUsuario)){
            int i;

            // Se recorre la zona de usuarios registrados evaluando en paralelo el nombre de usuario
            // y contrasenia ingresada
            for(i = 0; i < listaUsuarios.size(); i ++){
                if(listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuario) && listaUsuarios.get(i).getContraseniaUsuario().equals(contraseniaUsuario)){

                    boolean sesionActiva = true;
                    Usuario usuarioAutenticado = new Usuario(nombreUsuario, contraseniaUsuario, listaUsuarios.get(i).getFechaCreacion(), sesionActiva);
                    //usuarioAutenticado.Usuario(nombreUsuario, contraseniaUsuario, listaUsuarios.get(i).getFechaCreacion(), sesionActiva);
                    listaUsuarios.set(i, usuarioAutenticado);
                    System.out.println("El usuario ha sido autenticado existosamente");
                    return true;
                }
            }
            System.out.println("El usuario no ha sido autenticado (contrasenia incorrecta)");
            return false;
        }
        else {
            System.out.println("El usuario no ha sido autenticado (no existe)");
            return false;
        }
    }

    /**
     * EL siguiente metodo (como parte del requerimiento funcional authentication) permite cerrar la sesion
     * activa de un usuario autenticado en la plataforma u editor (objeto) de modo que se evalua la existencia de un
     * usuario activo para, en caso de existir cerrar su sesion y, en caso de no existir no cerrar ninguna sesion.
     * Retorna un boolean de acuerdo a si la operacion fue realizada correctamente o no.
     */
    public boolean logout(){
        int i;
        // Se busca un usuario en la zona de usuarios registrados el cual figure como sesion activa (true) para
        // en caso de existir, desactivar su sesion activa respondiendo a un false
        for(i = 0; i < listaUsuarios.size(); i ++){
            if(esUsuarioActivo(listaUsuarios.get(i))){

                boolean sesionInactiva = false;
                Usuario usuarioFinalizado = new Usuario(listaUsuarios.get(i).getNombreUsuario(), listaUsuarios.get(i).getContraseniaUsuario(), listaUsuarios.get(i).getFechaCreacion(), sesionInactiva);
                listaUsuarios.set(i, usuarioFinalizado);
                return true;
            }
        }
        return false;
    }

    /**
     * EL siguiente requerimiento funcional permite crear un nuevo documento en la plataforma u editor
     * de modo que se evalua la existencia de un usuario activo (objeto) para, considerando los parametros de
     * entrada ingresados por pantalla, crear el documento indicado (objeto). En caso de no existir usuario
     * autenticado, el nuevo documento no es creado
     * Proceso que crea e inserta en la plataforma un nuevo documento.
     */
    public void create(String nombreDocumento, String textoContenido){
        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            // Se generan y/o procesan los datos de entrada para la creacion del documento
            Date fechaCreacion = new Date();
            int iDdocumento = listaDocumentos.size();
            int iDversion = 0;
            String autor = nombreUsuarioActivo();

            ArrayList<Version> listaVersionesInicial = new ArrayList<>();
            ArrayList<Acceso> listaAccesosInicial = new ArrayList<>();
            Version versionInicial = new Version(iDversion, textoContenido, fechaCreacion);
            //versionInicial.Version(iDversion, textoContenido, fechaCreacion);
            listaVersionesInicial.add(versionInicial);

            // Se crea el documento y muestra por pantalla un mensaje de informacion relativa respecto del mismo
            Documento nuevoDocumento = new Documento(iDdocumento, autor, nombreDocumento, fechaCreacion, listaVersionesInicial, listaAccesosInicial);
            //nuevoDocumento.Documento(iDdocumento, autor, nombreDocumento, fechaCreacion, listaVersionesInicial, listaAccesosInicial);
            this.listaDocumentos.add(nuevoDocumento);
            System.out.println("Se ha creado/registrado un nuevo documento de ID: " + iDdocumento +
                    ", nombre: " + nombreDocumento + " y autor: " + autor +  " existosamente");
        }
        else {
            System.out.println("No se ha creado/registrado un nuevo documento (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente requerimiento funcional permite compartir un documento en la plataforma u editor
     * a un usuario registrado en la plataforma de modo que se evalua la existencia de un usuario activo (objeto)
     * el cual a su vez sea autor del documento a trabajar para, considerando los parametros de entrada
     * ingresados por pantalla, compartir el documento indicado contemplando uno o mas usuario (existentes),
     * y un acceso ingresado valido, sea permisos lectura ("R"), escritura ("W") o comentario ("C").
     * En caso de no cumplir con cualquier condicion, el documento no es compartido. Es importante referir que
     * se adiciona un objeto del tipo Acceso al arreglo destinado.
     * Proceso que comparte a uno o mas usuarios un documento en la plataforma.
     */
    public void share(ArrayList<String> usuariosCompartir, int iDdocumento, char permiso){

        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            // Se contempla que el usuario activo sea el propietario del documento a trabajar
            if(existeDocumentoAutor(iDdocumento, nombreUsuarioActivo())) {

                ArrayList<Acceso> listaAccesos = new ArrayList<>();
                Acceso acceso = new Acceso();

                // Si el permiso y/o acceso es valido ("R", "W" o "C")...
                if (acceso.accesoValido(permiso)) {
                    int i;
                    // Se elabora un arreglo de objetos del tipo Acceso
                    for (i = 0; i < usuariosCompartir.size(); i++) {
                        Acceso aCceso = new Acceso(usuariosCompartir.get(i), permiso);
                        //aCceso.Acceso(usuariosCompartir.get(i), permiso);
                        listaAccesos.add(aCceso);
                    }
                    // Se busca el documento y se ingresa el acceso
                    for (i = 0; i < this.listaDocumentos.size(); i++) {
                        if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                            this.listaDocumentos.get(i).agregarAcceso(listaAccesos);
                        }
                    }
                    System.out.println("El documento de ID: " + iDdocumento + " ha sido compartido a el/los usuario/s: " +
                            usuariosCompartir + " con permiso: " + permiso);
                    System.out.println("El proceso fue completado exitosamente");
                } else {
                    System.out.println("El acceso y/o permiso no es valido");
                    System.out.println("El documento no ha sido compartido");
                }
            }
            else {
                System.out.println("No es posible compartir el documento (no existe o usted no su autor)");
            }

        }
        else {
            System.out.println("No se ha compartido el documento (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente requerimiento funcional permite aniadir texto al contenido de la version actual de un
     * documento en la plataforma u editor de modo que se evalua la existencia de un usuario activo (objeto)
     * el cual a su vez sea autor y/o se le haya compartido el documento (permiso de edicion "W") a trabajar para,
     * considerando los parametros de entrada ingresados por pantalla, buscar el documento a trabajar, extraer el
     * contenido de su version actual y concatenarlo con el texto a adicionar. En caso de no cumplir con cualquier
     * condicion, el contenido no es adicionado al documento. Es importante referir que se adiciona un objeto
     * del tipo Version al arreglo destinado
     * Proceso que adiciona texto al contenido de un documento en la plataforma.
     */
    public void add(int iDdocumento, String textoContenido){

        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;
            // Se busca el documento de acuerdo a su identificador
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                    if (existeDocumentoAutor(iDdocumento, nombreUsuarioActivo()) || existeDocumentoEditor(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {
                        String textoUltimaVersion;
                        String textoConcatenado;
                        Date fechaModificacion = new Date();
                        int longitudVersiones = this.listaDocumentos.get(i).getListaVersiones().size() - 1;
                        textoUltimaVersion = this.listaDocumentos.get(i).getListaVersiones().get(longitudVersiones).getTextoContenido();
                        textoConcatenado = textoUltimaVersion + textoContenido;
                        Version nuevaVersion = new Version(longitudVersiones + 1, textoConcatenado, fechaModificacion);
                        //nuevaVersion.Version(longitudVersiones + 1, textoConcatenado, fechaModificacion);
                        this.listaDocumentos.get(i).agregarVersion(nuevaVersion);

                        System.out.println("El texto ingresado ha sido aniadido correctamente al documento de ID: " + iDdocumento);
                    }
                }
            }
        }
        else {
            System.out.println("No se ha aniadido texto al documento (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente requerimiento funcional permite restaurar un version anterior de un documento en la plataforma
     * u editor de modo que se evalua la existencia de un usuario activo (objeto) el cual a su vez sea autor del
     * documento a trabajar para, considerando los parametros de entrada ingresados por pantalla, buscar el documento
     * (objeto) a trabajar junto con su correspondiente version (objeto) a restaurar (si existe) e "intercambiar"
     * la posicion de la version actual y version a restaurar para luego corregir los identificadores internos de
     * las versiones para que estas sean correlativas una vez efectuado el cambio.
     * Proceso que restaura una version de un documento en la plataforma.
     */
    public void rollback(int iDdocumento, int iDversion){
        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;

            // Se busca el documento de acuerdo a su identificador
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                    // Si el usuario que ha ejecutado el presente metodo figura como autor del texto...
                    if (existeDocumentoAutor(iDdocumento, nombreUsuarioActivo())) {
                        // Se busca la version y, en caso de encontrarla esta es respaldada, removida ...
                        // e insertada al final de la lista u arreglo de versiones como la version actual
                        int j;

                        for (j = 0; j < this.listaDocumentos.get(i).getListaVersiones().size(); j++) {
                            if (this.listaDocumentos.get(i).getListaVersiones().get(j).getiDversion() == iDversion) {
                                Date fechaModificacion = new Date();
                                Version versionRollback = new Version(this.listaDocumentos.get(i).getListaVersiones().get(j).getiDversion(), this.listaDocumentos.get(i).getListaVersiones().get(j).getTextoContenido(), fechaModificacion);
                                //versionRollback.Version(this.listaDocumentos.get(i).getListaVersiones().get(j).getiDversion(), this.listaDocumentos.get(i).getListaVersiones().get(j).getTextoContenido(), fechaModificacion);
                                this.listaDocumentos.get(i).getListaVersiones().remove(j);
                                this.listaDocumentos.get(i).agregarVersion(versionRollback);
                                // Se corrigen los identificadores internos para que estos sean correlativos una vez ...
                                // realizada la operacion
                                correlativo(this.listaDocumentos.get(i).getListaVersiones());
                                System.out.println("Se ha restaurado la version: " + iDversion +
                                        " del documento ID: " + iDdocumento);
                            }
                        }

                    }
                }
            }
        }
        else {
            System.out.println("No se ha restaurado la version del documento (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente requerimiento funcional permite revorcar el acceso a todos los permisos otorgados de un documento en
     * la plataforma u editor (por permisos refiere el usuario y acceso) de modo que se evalua la existencia de un usuario
     * activo (objeto) el cual a su vez sea autor del documento a trabajar para, considerando los parametros de entrada
     * ingresados por pantalla, buscar el documento (objeto) a trabajar y, una vez encontrado (en caso de existir)
     * remover todo el contenido referente a accesos (objeto) del mismo.
     * Proceso que revoca todos los permisos de un documento en la plataforma.
     */
    public void revokeAccess(int iDdocumento){
        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;

            // Se busca el documento de acuerdo a su identificador
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                    // Si el usuario que ha ejecutado el presente metodo figura como autor del texto...
                    if (existeDocumentoAutor(iDdocumento, nombreUsuarioActivo())) {
                        this.listaDocumentos.get(i).getListaAccesos().clear();
                        System.out.println("Se han revocado todos los permisos en el documento ID: " + iDdocumento +
                                " por parte de su autor");
                    }
                    else{
                        System.out.println("No se han revocado los permisos de acceso en el documento senialado" +
                                " puesto que usted no es el autor del mismo");
                    }
                }
            }
        }
        else {
            System.out.println("No se ha restaurado la version del documento (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente requerimiento funcional permite buscar un texto especifico en el contenido de uno o mas documentos
     * en la plataforma u editor (considerando versiones anteriores) de modo que se evalua la existencia de un usuario
     * activo (objeto), luego considerando los parametros de entrada ingresados por pantalla, se buscan el/los documento
     * (en caso de existir) donde el usuario activo figure como autor o se le haya compartido, sea permisos lectura
     * ("R"), escritura ("W") o comentario ("C"), para evaluar la existencia en el contenido, del documento que cumpla
     * dichas condiciones, del texto a buscar ingresado en el contenido de todas las versiones (objeto) de dicho documento
     * expresandolas por pantalla.
     * Proceso que busca un texto especifico en el contenido de uno o mas documentos (y sus versiones) en la plataforma.
     */
    public void search(String textoBuscar){
        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;
            int j;
            boolean revisado = false;

            // Se buscan los documentos de acuerdo a su autor y/o acceso
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                // Si el usuario que ejecuto la funcionalidad figura como autor o se le ha compartido...
                if (existeDocumentoAutor(this.listaDocumentos.get(i).getiDdocumento(), nombreUsuarioActivo()) || existeDocumentoCompartido(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {
                    // Se busca en las versiones el texto introducido
                    for (j = 0; j < this.listaDocumentos.get(i).getListaVersiones().size(); j++) {
                        // Si existe en el documento (versiones) el texto a buscar...
                        if (this.listaDocumentos.get(i).getListaVersiones().get(j).getTextoContenido().contains(textoBuscar) && !revisado) {
                            System.out.println("El texto introducido se encuentra en el documento de ID " +
                                    this.listaDocumentos.get(i).getiDdocumento() + " y nombre " +
                                    this.listaDocumentos.get(i).getNombreDocumento());
                            revisado = true;

                        }
                    }
                    revisado = false;
                }
            }
        }
        else {
            System.out.println("No se ha realizado el proceso de busqueda (usuario inexistente o no autenticado)");
        }
    }

    /**
     * EL siguiente metodo (como parte del requerimiento funcional visualize) permite a un usuario autenticado o no
     * generar una representacion visual comprensible (String) la cual exprese, en caso de que un usuario autenticado
     * ejecute, todos los datos (objeto) referentes a dicho usuario, es decir, credenciales relativas, documentos propios y
     * compartidos. Por otra parte, en caso de que un usuario no autenticado ejecute el presente metodo, se expresan
     * todos los datos (objeto) referentes a la plataforma u editor.
     * Retorna un String correspondiente a una representacion visual de la plataforma de acuerdo a la existencia
     * o no de un usuario activo/autenticado.
     */
    public String editorToString(){
        // Si existe un usuario autenticado u activo...
        if(existeUsuarioActivo()){
            // Se inicializa la generacion del String a retornar
            int i;
            String usuarioDocString = "";
            // Se busca al usuario autenticado

            for(i = 0; i < this.listaUsuarios.size(); i ++){
                if(this.listaUsuarios.get(i).getNombreUsuario().equals(nombreUsuarioActivo())){
                    usuarioDocString = usuarioDocString.concat(this.listaUsuarios.get(i).toString() + "\n");

                }
            }


            // Se buscan los documentos donde figure el usuario activo como autor y/o posea acceso
            for(i = 0; i < this.listaDocumentos.size(); i ++){
                // Si el usuario que ejecuto la funcionalidad figura como autor o se le ha compartido...
                if(existeDocumentoAutor(this.listaDocumentos.get(i).getiDdocumento(), nombreUsuarioActivo()) || existeDocumentoCompartido(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {
                    usuarioDocString = usuarioDocString.concat(this.listaDocumentos.get(i).toString());
                }
            }
            return usuarioDocString;
        }
        // Si no existe un usuario autenticado u activo...
        else {
            // Se inicializa la generacion del String a retornar
            int i;
            String editorDocString = "";
            // Se concatenan los usuarios registrados

            for(i = 0; i < this.listaUsuarios.size(); i ++){
                editorDocString = editorDocString.concat(this.listaUsuarios.get(i).toString() + "\n");
            }


            // Se concatenan todos los documentos
            for(i = 0; i < this.listaDocumentos.size(); i ++){

                editorDocString = editorDocString.concat(this.listaDocumentos.get(i).toString());

            }
            return editorDocString;
        }

    }

    /**
     * EL siguiente metodo (como parte del requerimiento funcional visualize) imprime por pantalla el String
     * obtenido del metodo editorToString evitando expresar datos sensibles.
     * Proceso que muestra una representacion visual de la plataforma.
     */
    public void printEditor(String editorString){
        System.out.println(editorString);
    }

    /**
     * EL siguiente requerimiento funcional llama a los metodos editorToString en paralelo con printEditor,
     * ya explicados anteriormente, de modo que se genera e imprime un String como representacion
     * visual de la plaaforma.
     */
    public void visualize(){
        printEditor(editorToString());
    }

    /**
     * EL siguiente requerimiento funcional permite eliminar los ultimos N caracteres del contenido en un documentos
     * en la plataforma u editor (considerando la version actual) de modo que se evalua la existencia de un usuario
     * activo (objeto), luego considerando los parametros de entrada ingresados por pantalla, se busca el documento
     * (en caso de existir) donde el usuario activo figure como autor o se le haya compartido, con permiso de escritura
     * ("W"), para extraer el contenido del documento que cumpla dichas condiciones. Referente al texto se realiza
     * una comparacion entre la longitud del texto contenido y la cantidad de caracteres a eliminar, en caso de que
     * la longitud del texto contenido sea mayor a la cantidad de caracteres a eliminar, por medio de la funcion
     * substring se extrar el substring desde el indice (0) hasta la diferencia entre las longitudes. En caso de que
     * la cantidad de caracteres a eliminar sea mayor a la cantidad de caracteres existentes en el contenido del
     * documento, se elimina todo el contenido. Es importante comentar que tras la eliminacion se genera una nueva
     * version (objeto) del documento.
     * Proceso que elimina los ultimo N caracteres del contenido de un documento (version actual) en la plataforma.
     */
    public void delete(int iDdocumento, int cantCaracElim){

        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;
            // Se busca el documento de acuerdo a su identificador
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                    // Si el usuario activo es autor o posee permiso de edicion sobre el documento...
                    if (existeDocumentoAutor(iDdocumento, nombreUsuarioActivo()) || existeDocumentoEditor(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {


                        String textoUltimaVersion;
                        Date fechaModificacion = new Date();
                        int longitudVersiones = this.listaDocumentos.get(i).getListaVersiones().size() - 1;
                        textoUltimaVersion = this.listaDocumentos.get(i).getListaVersiones().get(longitudVersiones).getTextoContenido();
                        int longitudString = this.listaDocumentos.get(i).getListaVersiones().get(longitudVersiones).getTextoContenido().length();

                        // La cantidad de caracteres contenidos en la version actual del documento es mayor/igual a la
                        // cantidad de caracteres a eliminar (es posible eliminar)
                        if(longitudString >= cantCaracElim){
                            textoUltimaVersion = textoUltimaVersion.substring(0, longitudString - cantCaracElim);
                            Version nuevaVersion = new Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            //.Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            this.listaDocumentos.get(i).agregarVersion(nuevaVersion);
                            //this.listaDocumentos.get(i).getListaVersiones().add(nuevaVersion);
                            System.out.println("Se han eliminado " + cantCaracElim + " caracteres resultando en el siguiente contenido: " +
                                    textoUltimaVersion);
                        }
                        // Debe eliminarse todo
                        else{
                            textoUltimaVersion = "";
                            Version nuevaVersion = new Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            //nuevaVersion.Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            this.listaDocumentos.get(i).agregarVersion(nuevaVersion);
                            //this.listaDocumentos.get(i).getListaVersiones().add(nuevaVersion);
                            System.out.println("Se ha eliminado todo el contenido del documento (la cantidad de caracteres a" +
                                    " eliminar es supuerior a la cantidad de caracteres existentes en el contenido del " +
                                    "documento)");
                        }

                    }
                }
            }
        }
        else {
            System.out.println("No se ha eliminado los N caracteres del texto del documento (usuario inexistente o no autenticado)");
        }

    }

    /**
     * EL siguiente requerimiento funcional permite buscar y reemplazar todas las palabras (substring) en el contenido
     * (String) de un documento en la plataforma u editor (considerando la version actual) de modo que se evalua
     * la existencia de un usuario activo (objeto), luego considerando los parametros de entrada ingresados por pantalla,
     * se busca el documento (en caso de existir) donde el usuario activo figure como autor o se le haya compartido,
     * con permiso de escritura/edicion ("W"), para extraer el contenido del documento que cumpla dichas condiciones.
     * Referente al texto se determina la existencia de la palabra a buscar para, en caso de existir reemplazarla
     * generando una nueva version (objeto) segun el cambio realizado y, en caso de no existir indicarle al usuario su no
     * existencia sin realizar una nueva version (objeto) puesto que no se ha efectuado un cambio.
     * Proceso que busca y reemplaza una palabra (substring) en todo el contenido de un documento (version actual)
     * en la plataforma.
     */
    public void searchAndReplace(int iDdocumento, String textoBuscar, String textoReemplazar){

        // Se contempla la existencia de un usuario activo
        if(existeUsuarioActivo()) {
            int i;
            // Se busca el documento de acuerdo a su identificador
            for (i = 0; i < this.listaDocumentos.size(); i++) {
                if (this.listaDocumentos.get(i).getiDdocumento() == iDdocumento) {
                    // Si el usuario activo es autor o posee permiso de edicion sobre el documento...
                    if (existeDocumentoAutor(iDdocumento, nombreUsuarioActivo()) || existeDocumentoEditor(this.listaDocumentos.get(i).getListaAccesos(), nombreUsuarioActivo())) {

                        int longitudVersiones = this.listaDocumentos.get(i).getListaVersiones().size() - 1;
                        String textoUltimaVersion = this.listaDocumentos.get(i).getListaVersiones().get(longitudVersiones).getTextoContenido();
                        Date fechaModificacion = new Date();

                        // Si el contenido del documento posee al texto que debemos buscar para reemplazar...
                        if(textoUltimaVersion.contains(textoBuscar)) {
                            textoUltimaVersion = textoUltimaVersion.replaceAll(textoBuscar, textoReemplazar);
                            Version nuevaVersion = new Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            //nuevaVersion.Version(longitudVersiones + 1, textoUltimaVersion, fechaModificacion);
                            this.listaDocumentos.get(i).agregarVersion(nuevaVersion);
                            //this.listaDocumentos.get(i).getListaVersiones().add(nuevaVersion);
                            System.out.println("Se ha reemplazado la palabra ingresada: '" + textoBuscar +
                                    "', por: '" + textoReemplazar + "' correctamente en el documento ID: " + iDdocumento);
                        }
                        // Si el contenido del documento no posee al texto que debemos buscar para reemplazar...
                        else {
                            System.out.println("Advertencia: La palabra a reemplazar ingresada: '" + textoBuscar +
                                    "', por: '" + textoReemplazar + "' no existe/figura en el documento ID: " + iDdocumento);
                        }
                    }
                }
            }
        }
        else {
            System.out.println("No se ha reemplazado el texto ingresado en el contenido del documento (usuario inexistente o no autenticado)");
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
