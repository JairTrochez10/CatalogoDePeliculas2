package servicio;

import dominio.Pelicula;

import java.util.ArrayList;

public class Servicio implements IServicioPeliculas{

    ArrayList<Pelicula> peliculas=new ArrayList();
    @Override
    public void listarPeliculas() {
        System.out.println("Listando pelicula...");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Agregando pelicula...");
    }

    @Override
    public void buscarPeliculas(Pelicula pelicula) {
        var index = peliculas.indexOf(pelicula);
        if(index>=0){
            System.out.println("Pelicula Encontrada en el indice ["+index+"]");
        }
        System.out.println("Pelicula no encontrada en la lista...");
    }
    public static void main(String[] args) {
        //objetos
        var pelicula1 = new Pelicula("Pedro y Pablo");
        var pelicula2 = new Pelicula("Snnopy");

        //creamos servicio
        IServicioPeliculas sp = new Servicio();

        //instancias de metodos
        sp.agregarPeliculas(pelicula1);
        sp.agregarPeliculas(pelicula2);

        //listamos peliculas
        sp.listarPeliculas();

        //buscar pelicula
        sp.buscarPeliculas(new  Pelicula("Jair"));

    }

}
