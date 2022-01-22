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

        ParadigmaDocs paradigmaDocs = new ParadigmaDocs("ParadigmaDocs", fechaCreacion, listaUsuarios, listaDocumentos);

        // Registro de cinco usuarios (inicialmente)
        paradigmaDocs.register("Jaime L.", "pinturaseca");
        paradigmaDocs.register("Cale V.", "legustashingeki");
        paradigmaDocs.register("Aranza H.", "SUS");
        paradigmaDocs.register("Benjamin N.", "naarro");
        paradigmaDocs.register("Gonzalo M.", "golazomarimbio");

        // Creacion de diez documentos (inicialmente)
        paradigmaDocs.login("Jaime L.", "pinturaseca");
        paradigmaDocs.create("Documento 0", "Primer contenido del documento de ID 0");
        paradigmaDocs.create("Documento 1", "Primer contenido del documento de ID 1");
        paradigmaDocs.logout();

        paradigmaDocs.login("Cale V.", "legustashingeki");
        paradigmaDocs.create("Documento 2", "Primer contenido del documento de ID 2");
        paradigmaDocs.create("Documento 3", "Primer contenido del documento de ID 3");
        paradigmaDocs.logout();

        paradigmaDocs.login("Aranza H.", "SUS");
        paradigmaDocs.create("Documento 4", "Primer contenido del documento de ID 4");
        paradigmaDocs.create("Documento 5", "Primer contenido del documento de ID 5");
        paradigmaDocs.logout();

        paradigmaDocs.login("Benjamin N.", "naarro");
        paradigmaDocs.create("Documento 6", "Primer contenido del documento de ID 6");
        paradigmaDocs.create("Documento 7", "Primer contenido del documento de ID 7");
        paradigmaDocs.logout();

        paradigmaDocs.login("Gonzalo M.", "golazomarimbio");
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
                System.out.println("\nUsuario Activo: " + paradigmaDocs.nombreUsuarioActivo() + "\n");
            }
            else {
                System.out.println("\nUsuario Activo: " + paradigmaDocs.nombreUsuarioActivo() + "\n");
            }
            // Se imprime por pantalla las opciones a disposicion
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("Para registrar un nuevo usuario ingrese.......................................... 1");
            System.out.println("Para autenticar un usuario ingrese............................................... 2");
            System.out.println("Para cerrar sesion de usuario ingrese............................................ 3");
            System.out.println("Para crear un nuevo documento ingrese............................................ 4");
            System.out.println("Para compartir un documento ingrese.............................................. 5");
            System.out.println("Para aniadir texto a un documentos ingrese....................................... 6");
            System.out.println("Para restaurar una version antigua de un documento ingrese....................... 7");
            System.out.println("Para revocar todos los accesos a un documento ingrese............................ 8");
            System.out.println("Para buscar un texto especifico en un documento ingrese.......................... 9");
            System.out.println("Para ejecutar el metodo visualize ingrese........................................ 10");
            System.out.println("Para eliminar N caracteres del contenido de un documento ingrese................. 11");
            System.out.println("Para buscar y reemplazar una palabra en el contenido de un documento ingrese..... 12");

            System.out.println("Para cerrar el programa ingrese.................................................. 13");
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
                    if(paradigmaDocs.register(nombreUsuarioCase1, contraseniaUsuarioCase1)){
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
                    paradigmaDocs.login(nombreUsuarioCase2, contraseniaUsuarioCase2);


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

                    Scanner parametrosCase4 = new Scanner(System.in);
                    System.out.println("Introduzca el nombre del documento: ");
                    String nombreDocumentoCase4 = parametrosCase4.nextLine();
                    System.out.println("Introduzca el contenido del documento: ");
                    String textoContenidoCase4 = parametrosCase4.nextLine();

                    paradigmaDocs.create(nombreDocumentoCase4, textoContenidoCase4);
                    break;
                case 5:
                    System.out.println("Se ha seleccionado la opcion 5");

                    // Se inicia un proceso en donde se consulta por los usuarios a compartir filtrando
                    // aquellos usuarios que figuren como registrados para luego, una vez que el usuario
                    // indique que no desea compartir el documento con mas personas, solicitar el ID
                    // del documento a compartir y el tipo de acceso al mismo, sea permisos lectura ("R"),
                    // escritura ("W") o comentario ("C").
                    // Es importante comentar que, para no iterrumpir el proceso, los usuarios a compartir
                    // que no figuren registrados no seran considerados al momento de ejecutar el
                    // requerimiento funcional share
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
                            System.out.println("Es posible compartir el documento al usuario designado");
                            listaUsuariosCompartir.add(nombreUsuarioCase5);
                        } else {
                            System.out.println("No es posible compartir el documento al usuario designado");
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


                    System.out.println("Ingrese el tipo de acceso (R, W o C): ");
                    char tipoAccesoCase5 = parametrosCase5.next().charAt(0);

                    paradigmaDocs.share(listaUsuariosCompartir, iDdocumentoCase5, tipoAccesoCase5);
                    break;
                case 6:
                    System.out.println("Se ha seleccionado la opcion 6");

                    Scanner parametrosCase6 = new Scanner(System.in);
                    System.out.println("Ingrese el identificador del documento a editar: ");
                    int iDdocumentoCase6 = entrada.nextInt();
                    System.out.println("Ingrese el contenido a adicionar (String): ");
                    String textoContenidoCase6 = parametrosCase6.nextLine();

                    paradigmaDocs.add(iDdocumentoCase6, textoContenidoCase6);
                    break;
                case 7:
                    System.out.println("Se ha seleccionado la opcion 7");

                        Scanner parametrosCase7 = new Scanner(System.in);
                        System.out.println("Ingrese el identificador del documento sobre el cual operar: ");
                        int iDdocumentoCase7 = entrada.nextInt();
                        System.out.println("Ingrese el identificador de la version a restaurar: ");
                        int iDversionCase7 = parametrosCase7.nextInt();

                        paradigmaDocs.rollback(iDdocumentoCase7, iDversionCase7);
                    break;
                case 8:
                    System.out.println("Se ha seleccionado la opcion 8");

                        System.out.println("Ingrese el identificador del documento sobre el cual operar: ");
                        int iDdocumentoCase8 = entrada.nextInt();

                        paradigmaDocs.revokeAccess(iDdocumentoCase8);

                    break;
                case 9:
                    System.out.println("Se ha seleccionado la opcion 9");

                    Scanner parametrosCase9 = new Scanner(System.in);
                    System.out.println("Ingrese el texto a buscar: ");
                    String textoBuscarCase9 = parametrosCase9.nextLine();

                    paradigmaDocs.search(textoBuscarCase9);

                    break;
                case 10:
                    System.out.println("Se ha seleccionado la opcion 10");

                    paradigmaDocs.visualize();

                    break;
                case 11:
                    System.out.println("Se ha seleccionado la opcion 11");

                    System.out.println("Ingrese el ID del documento a trabajar: ");
                    int iDdocumentoCase11 = entrada.nextInt();
                    System.out.println("Ingrese la cantidad de caracteres a eliminar del contenido: ");
                    int cantCaracElimCase11 = entrada.nextInt();

                    paradigmaDocs.delete(iDdocumentoCase11, cantCaracElimCase11);
                    break;
                case 12:
                    System.out.println("Se ha seleccionado la opcion 12");

                    Scanner parametrosCase12 = new Scanner(System.in);
                    System.out.println("Ingrese el ID del documento a trabajar: ");
                    int iDdocumentoCase12 = entrada.nextInt();
                    System.out.println("Ingrese la palabra a buscar en el contenido: ");
                    String textoBuscarCase12 = parametrosCase12.nextLine();
                    System.out.println("Ingrese la palabra a reemplazar en el contenido: ");
                    String textoReemplazarCase12 = parametrosCase12.nextLine();

                    paradigmaDocs.searchAndReplace(iDdocumentoCase12, textoBuscarCase12, textoReemplazarCase12);

                    break;
                case 13:
                    System.out.println("Se ha seleccionado la opcion 13");

                    cerrarPrograma = true;
                    break;
                default:
                    System.out.println("Favor de seleccionar una opcion valida");
            }
        }
        System.out.println("Ha concluido la ejecucion del programa");
    }
}
