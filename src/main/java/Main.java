import TDA.Documento;
import TDA.ParadigmaDocs;
import TDA.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){

        // Creacion del editor y/o plataforma con informacion inicialmente integrada

        Date fechaCreacion = new Date();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Documento> listaDocumentos = new ArrayList<>();

        ParadigmaDocs paradigmaDocs = new ParadigmaDocs().crearParadigmaDocs("ParadigmaDocs", fechaCreacion, listaUsuarios, listaDocumentos);

        // Registro de cinco usuarios
        Usuario user1 = new Usuario();
        Usuario user2 = new Usuario();
        Usuario user3 = new Usuario();
        Usuario user4 = new Usuario();
        Usuario user5 = new Usuario();
        user1.crearUsuario("Jaime L.", "pinturaseca");
        user2.crearUsuario("Cale V", "legustashingeki");
        user3.crearUsuario("Aranza H", "SUS");
        user4.crearUsuario("Benjamin N", "naarro");
        user5.crearUsuario("Gonzalo M", "golazomarimbio");
        










/*
        Scanner entrada = new Scanner(System.in);
        boolean cerrarPrograma = false;
        int eleccion;

        while(!cerrarPrograma){
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("Para crear un nuevo documento selecciones el entero 1");
            System.out.println("Para compartir un documento selecciones el entero 2");
            System.out.println("Para agregar contenido a un documento selecciones el entero 3");
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
                    break;
                case 2:
                    System.out.println("Se ha seleccionado la opcion 2");
                    break;
                case 3:
                    System.out.println("Se ha seleccionado la opcion 3");
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
    */


    }
}
