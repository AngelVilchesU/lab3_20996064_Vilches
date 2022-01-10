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
        ArrayList<Acceso> listaAccesos = new ArrayList<>();
        ArrayList<Version> listaVersiones = new ArrayList<>();
        paradigmaDocs.crearDocumento(user1, 0, "Documento 0", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 0");
        paradigmaDocs.crearDocumento(user1, 1, "Documento 1", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 1");
        paradigmaDocs.crearDocumento(user2, 2, "Documento 2", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 2");
        paradigmaDocs.crearDocumento(user2, 3, "Documento 3", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 3");
        paradigmaDocs.crearDocumento(user3, 4, "Documento 4", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 4");
        paradigmaDocs.crearDocumento(user3, 5, "Documento 5", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 5");
        paradigmaDocs.crearDocumento(user4, 6, "Documento 6", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 6");
        paradigmaDocs.crearDocumento(user4, 7, "Documento 7", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 7");
        paradigmaDocs.crearDocumento(user5, 8, "Documento 8", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 8");
        paradigmaDocs.crearDocumento(user5, 9, "Documento 9", fechaCreacion,
                listaVersiones, listaAccesos, "Primer contenido del documento de ID 9");
















        Scanner entrada = new Scanner(System.in);
        boolean cerrarPrograma = false;
        int eleccion;

        while(!cerrarPrograma){
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("Para registrar un nuevo usuario ingrese: 1");
            System.out.println("Para autenticar un usuario ingrese: 2");
            System.out.println("Para cerrar sesion de usuario ingrese: 3");
            System.out.println("Para restaurar la version de un documento selecciones el entero 4");
            System.out.println("Para revorcar el acceso a un documento selecciones el entero 5");
            System.out.println("Para buscar en los documentos selecciones el entero 6");
            System.out.println("Para visualizar documentos selecciones el entero 7");
            System.out.println("Para cerrar sesion selecciones el entero 8");
            System.out.println("Para cerrar el programa selecciones el entero 9");
            System.out.println("Introduzca su eleccion: ");
            eleccion = entrada.nextInt();

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
                    break;
                case 5:
                    System.out.println("Se ha seleccionado la opcion 5");
                    break;
                case 6:
                    System.out.println("Se ha seleccionado la opcion 6");
                    break;
                case 7:
                    System.out.println("Se ha seleccionado la opcion 7");
                    break;
                case 8:
                    System.out.println("Se ha seleccionado la opcion 8");
                    break;
                case 9:
                    System.out.println("Se ha seleccionado la opcion 9");
                    cerrarPrograma = true;
                    break;
                default:
                    System.out.println("Favor de seleccionar una opcion valida");
            }
        }
        System.out.println("Ha concluido la ejecucion del programa");


        System.out.println(paradigmaDocs);
    }
}
