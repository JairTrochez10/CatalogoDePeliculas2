package servicio;

import dominio.Pelicula;

public interface IServicioPeliculas {
    public void listarPeliculas();
    public void agregarPeliculas(Pelicula nombre);
    public void buscarPeliculas(Pelicula nombre);
}
