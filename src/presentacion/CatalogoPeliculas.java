package presentacion;

import dominio.Pelicula;
import servicio.IServicioPeliculas;
import servicio.Servicio;

import java.util.Scanner;

public class CatalogoPeliculas {
    public static void main(String[] args) {
        //declaracion de variables
        var salir= false;
        var consola= new Scanner(System.in);

        //agregamos la implemantacion de los servicios
        IServicioPeliculas servicioPeliculas= new Servicio();

        //menu
        do{
            try{
                salir=ejecutarOpciones(consola,servicioPeliculas);
            }catch(Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }


        }while(!salir);
    }

    private static void mostarMenu(){
        System.out.println("""
            
            *** Catalogo de Peliculas ***
            1. Agregar peliculas
            2. Listar peliculas
            3. Buscar peliculas
            4. Salir
            """);
    }//mostrar menu

    private static boolean ejecutarOpciones(Scanner consola,
                                            IServicioPeliculas servicioPeliculas){

        mostarMenu();
        var opciones= Integer.parseInt(consola.nextLine());
        var salir= false;

        switch (opciones){
            case 1->{
                System.out.println("Ingrese el nombre del pelicula: ");
                var nombrePeli= consola.nextLine();
                servicioPeliculas.agregarPeliculas(new Pelicula(nombrePeli));
            }//1
            case 2->{
                servicioPeliculas.listarPeliculas();
            }//2
            case 3->{
                System.out.println("Ingrese el nombre del pelicula a buscar: ");
                var buscar= consola.nextLine();
                servicioPeliculas.buscarPeliculas(new Pelicula(buscar));
            }
            case 4->{
                System.out.println("Saliendo del programa...");
                salir=true;
            }
            default -> {
                System.out.println("Opcion no permitida, del 1 al 4.");
            }
        }//opciones
        return salir;
    }//ejecutar opciones
}//fin main