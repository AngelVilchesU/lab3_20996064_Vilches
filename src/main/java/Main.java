import TDA.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){

        // Creacion del editor y/o plataforma con informacion inicialmente integrada
        Date fechaCreacion = new Date();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Documento> listaDocumentos = new ArrayList<>();

        ParadigmaDocs paradigmaDocs = new ParadigmaDocs().ParadigmaDocs("ParadigmaDocs", fechaCreacion, listaUsuarios, listaDocumentos);

        // Registro de cinco usuarios (inicialmente)
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        Usuario user3 = new Usuario();
        Usuario user4 = new Usuario();
        Usuario user5 = new Usuario();
        user1.Usuario("Jaime L.", "pinturaseca", 0);
        user2.Usuario("Cale V", "legustashingeki", 0);
        user3.Usuario("Aranza H", "SUS", 0);
        user4.Usuario("Benjamin N", "naarro", 0);
        user5.Usuario("Gonzalo M", "golazomarimbio", 0);
        paradigmaDocs.register(user1.getNombreUsuario(), user1.getContraseniaUsuario(), user1.getSesion());
        paradigmaDocs.register(user2.getNombreUsuario(), user2.getContraseniaUsuario(), user2.getSesion());
        paradigmaDocs.register(user3.getNombreUsuario(), user3.getContraseniaUsuario(), user3.getSesion());
        paradigmaDocs.register(user4.getNombreUsuario(), user4.getContraseniaUsuario(), user4.getSesion());
        paradigmaDocs.register(user5.getNombreUsuario(), user5.getContraseniaUsuario(), user5.getSesion());

        // Creacion de diez documentos (inicialmente)
        paradigmaDocs.login(user1.getNombreUsuario(), user1.getContraseniaUsuario(), user1.getSesion());
        paradigmaDocs.create("Documento 0", "Primer contenido del documento de ID 0");
        paradigmaDocs.create("Documento 1", "Primer contenido del documento de ID 1");
        paradigmaDocs.logout();

        paradigmaDocs.login(user2.getNombreUsuario(), user2.getContraseniaUsuario(), user2.getSesion());
        paradigmaDocs.create("Documento 2", "Primer contenido del documento de ID 2");
        paradigmaDocs.create("Documento 3", "Primer contenido del documento de ID 3");
        paradigmaDocs.logout();

        paradigmaDocs.login(user3.getNombreUsuario(), user3.getContraseniaUsuario(), user3.getSesion());
        paradigmaDocs.create("Documento 4", "Primer contenido del documento de ID 4");
        paradigmaDocs.create("Documento 5", "Primer contenido del documento de ID 5");
        paradigmaDocs.logout();

        paradigmaDocs.login(user4.getNombreUsuario(), user4.getContraseniaUsuario(), user4.getSesion());
        paradigmaDocs.create("Documento 6", "Primer contenido del documento de ID 6");
        paradigmaDocs.create("Documento 7", "Primer contenido del documento de ID 7");
        paradigmaDocs.logout();

        paradigmaDocs.login(user5.getNombreUsuario(), user5.getContraseniaUsuario(), user5.getSesion());
        paradigmaDocs.create("Documento 8", "Primer contenido del documento de ID 8");
        paradigmaDocs.create("Documento 9", "Primer contenido del documento de ID 9");
        paradigmaDocs.logout();


        // Menu interactivo

        Scanner entrada = new Scanner(System.in);
        boolean cerrarPrograma = false;
        int eleccion;

        // Mientras no se ordene/seleccione la opcion que responde al cierre del programa...
        while(!cerrarPrograma){

            // Se refleja por pantella la existencia (o no) de un usuario autenticado
            if(paradigmaDocs.existeUsuarioActivo()){
                System.out.println("Usuario Activo: " + paradigmaDocs.nombreUsuarioActivo() + "\n");
            }
            else {
                System.out.println("Usuario Activo: " + paradigmaDocs.nombreUsuarioActivo() + "\n");
            }
            // Se imprime por pantalla las opciones a disposicion
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("Para registrar un nuevo usuario ingrese: 1");
            System.out.println("Para autenticar un usuario ingrese: 2");
            System.out.println("Para cerrar sesion de usuario ingrese: 3");
            System.out.println("Para crear un nuevo documento ingrese: 4");
            System.out.println("Para compartir un documento ingrese: 5");
            System.out.println("Para aniadir texto a un documentos ingrese: 6");
            System.out.println("Para ejecutar el metodo rollback a la version de un documento ingrese: 7");
            System.out.println("Para revocar los accesos a un documento ingrese: 8");
            System.out.println("Para buscar un texto especifico en un documento ingrese: 9");

            System.out.println("Para cerrar el programa selecciones el entero 10");
            System.out.println("Introduzca su eleccion: ");
            eleccion = entrada.nextInt();

            // Se evalua la eleccion introducida
            switch(eleccion){
                case 1:
                    System.out.println("Se ha seleccionado la opcion 1");
                    Scanner parametrosCase1 = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de usuario: ");
                    String nombreUsuarioCase1 = parametrosCase1.nextLine();
                    System.out.println("Introduzca la contrasenia de usuario: ");
                    String contraseniaUsuarioCase1 = parametrosCase1.nextLine();
                    if(paradigmaDocs.register(nombreUsuarioCase1, contraseniaUsuarioCase1, 0)){
                        System.out.println("El usuario ha sido registrado existosamente");
                    }
                    else {
                        System.out.println("El usuario no ha sido registrado (ya existe)");
                    }
                    break;
                case 2:
                    System.out.println("Se ha seleccionado la opcion 2");
                    Scanner parametrosCase2 = new Scanner(System.in);
                    System.out.println("Introduzca el nombre de usuario: ");
                    String nombreUsuarioCase2 = parametrosCase2.nextLine();
                    System.out.println("Introduzca la contrasenia de usuario: ");
                    String contraseniaUsuarioCase2 = parametrosCase2.nextLine();
                    if(paradigmaDocs.login(nombreUsuarioCase2, contraseniaUsuarioCase2, 0)){
                        System.out.println("El usuario ha sido autenticado existosamente");
                    }
                    else {
                        System.out.println("El usuario no ha sido autenticado");
                    }
                    break;
                case 3:
                    System.out.println("Se ha seleccionado la opcion 3");
                    if(paradigmaDocs.logout()){
                        System.out.println("El usuario ha finalizado su sesion activa existosamente");
                    }
                    else {
                        System.out.println("No es posible finalizar la sesion del usuario (no existe o no se encuentra activo)");
                    }
                    break;
                case 4:
                    System.out.println("Se ha seleccionado la opcion 4");
                    // Inicialmente se verifica la existencia de un usuario registrado activo
                    if(paradigmaDocs.existeUsuarioActivo()){
                        Scanner parametrosCase4 = new Scanner(System.in);
                        System.out.println("Introduzca el nombre del documento (String): ");
                        String nombreDocumentoCase4 = parametrosCase4.nextLine();
                        System.out.println("Introduzca el contenido del documento (String): ");
                        String textoContenidoCase4 = parametrosCase4.nextLine();

                        paradigmaDocs.create(nombreDocumentoCase4, textoContenidoCase4);
                        System.out.println("Se ha creado/registrado un nuevo documento existosamente");
                        System.out.println("\n");
                    }
                    else {
                        System.out.println("No se ha creado/registrado un nuevo documento (usuario inexistente o no autenticado)");
                    }
                    break;
                case 5:
                    System.out.println("Se ha seleccionado la opcion 5");

                    // Inicialmente se verifica la existencia de un usuario registrado activo
                    if(paradigmaDocs.existeUsuarioActivo()) {

                        boolean nuevoCompartido = false;
                        int agregarCompartido;
                        ArrayList<String> listaUsuariosCompartir = new ArrayList<>();
                        Scanner parametrosCase5 = new Scanner(System.in);

                        while (!nuevoCompartido) {

                            Scanner parametrosCase5w = new Scanner(System.in);
                            System.out.println("Ingrese el nombre de usuario a compartir su documento: ");
                            String nombreUsuarioCase5 = parametrosCase5w.nextLine();
                            System.out.println("\n");
                            System.out.println("Si desea agregar otro usuario introduzca: 1");
                            System.out.println("Si no desea agregar otro usuario introduzca: 0");
                            agregarCompartido = entrada.nextInt();

                            // Se verifica que el/los usuario/s a compartir exista/n
                            if (paradigmaDocs.existeNombreUsuario(nombreUsuarioCase5)) {
                                System.out.println("Es posible compartir el documento al/los usuario/s designado/s");
                                listaUsuariosCompartir.add(nombreUsuarioCase5);
                            } else {
                                System.out.println("No posible compartir el documento al/los usuario/s designado/s");
                            }

                            switch (agregarCompartido) {
                                case 0:
                                    System.out.println("Ha seleccionado: 0");
                                    nuevoCompartido = true;
                                    break;
                                case 1:
                                    System.out.println("Ha seleccionado: 1");
                                    break;
                                default:
                                    System.out.println("Favor de seleccionar una opcion valida");
                            }
                        }

                        System.out.println("Ingrese el identificador numerico del documento a compartir: ");
                        int iDdocumentoCase5 = parametrosCase5.nextInt();

                        // Se verifica que el usuario autenticado figure como autor del documento
                        if(paradigmaDocs.existeDocumentoAutor(iDdocumentoCase5, paradigmaDocs.nombreUsuarioActivo())){
                            System.out.println("Si es posible compartir el documento");
                            System.out.println("Ingrese el tipo de acceso (R, W o C): ");
                            char tipoAccesoCase5 = parametrosCase5.next().charAt(0);

                            paradigmaDocs.share(listaUsuariosCompartir, iDdocumentoCase5, tipoAccesoCase5);
                        }
                        else {
                            System.out.println("No es posible compartir el documento (no existe o usted no su autor)");
                        }
                    }
                    else {
                        System.out.println("No se ha compartido el documento (usuario inexistente o no autenticado)");
                    }
                    break;
                case 6:
                    System.out.println("Se ha seleccionado la opcion 6");

                    if(paradigmaDocs.existeUsuarioActivo()) {

                        Scanner parametrosCase6 = new Scanner(System.in);
                        System.out.println("Ingrese el identificador del documento a editar: ");
                        int iDdocumentoCase6 = entrada.nextInt();
                        System.out.println("Ingrese el contenido a adicionar (String): ");
                        String textoContenidoCase6 = parametrosCase6.nextLine();

                        paradigmaDocs.add(iDdocumentoCase6, textoContenidoCase6);

                    }
                    else {
                        System.out.println("No se ha aniadido texto al documento (usuario inexistente o no autenticado)");
                    }
                    break;
                case 7:
                    System.out.println("Se ha seleccionado la opcion 7");

                    if(paradigmaDocs.existeUsuarioActivo()) {

                        Scanner parametrosCase7 = new Scanner(System.in);
                        System.out.println("Ingrese el identificador del documento sobre el cual operar: ");
                        int iDdocumentoCase7 = entrada.nextInt();
                        System.out.println("Ingrese el identificar de la version a restaurar: ");
                        int iDversionCase7 = parametrosCase7.nextInt();

                        paradigmaDocs.rollback(iDdocumentoCase7, iDversionCase7);

                    }
                    else {
                        System.out.println("No se ha restaurado la version del documento (usuario inexistente o no autenticado)");
                    }
                    break;
                case 8:
                    System.out.println("Se ha seleccionado la opcion 8");

                    if(paradigmaDocs.existeUsuarioActivo()) {

                        System.out.println("Ingrese el identificador del documento sobre el cual operar: ");
                        int iDdocumentoCase8 = entrada.nextInt();

                        paradigmaDocs.revokeAccess(iDdocumentoCase8);

                    }
                    else {
                        System.out.println("No se ha restaurado la version del documento (usuario inexistente o no autenticado)");
                    }
                    break;
                case 9:
                    System.out.println("Se ha seleccionado la opcion 9");

                    Scanner parametrosCase9 = new Scanner(System.in);

                    if(paradigmaDocs.existeUsuarioActivo()) {


                        System.out.println("Ingrese el texto a buscar: ");
                        String textoBuscarCase9 = parametrosCase9.nextLine();

                        paradigmaDocs.search(textoBuscarCase9);

                    }
                    else {
                        System.out.println("No se ha realizado el proceso de busqueda (usuario inexistente o no autenticado)");
                    }

                    break;



                case 10:
                    System.out.println("Se ha seleccionado la opcion 9");



                    cerrarPrograma = true;
                    break;


                default:
                    System.out.println("Favor de seleccionar una opcion valida");
            }
        }
        System.out.println("Ha concluido la ejecucion del programa");


        System.out.println("--------------");
        System.out.println(paradigmaDocs);
    }
}
