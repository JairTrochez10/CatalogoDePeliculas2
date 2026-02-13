package servicio;

import dominio.Pelicula;
import historial.HistorialLogger;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO="peliculas.txt";


    public ServicioPeliculasArchivo(){
        var archivo=new File(NOMBRE_ARCHIVO);
        try{
            if(archivo.exists()){
                System.out.println("ya esta el archivo");
            }else{
                var salida=new PrintWriter(new FileWriter(archivo));
            }
        }catch(IOException e){
            System.out.println("Error al abrir el archivo"+e.getMessage());
        }
    }


    @Override
    public void listarPeliculas() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listando peliculas");
            HistorialLogger.agg("user","Listando peliculas");
            //abrir el archivo para lectura
            var entrada =new BufferedReader(new FileReader(archivo));
            //leemos linea a linea el archivo
            String linea;
            linea= entrada.readLine();

            //ciclo para leer todos el documento
            while(linea!=null){
                var pelicula=new Pelicula(linea);
                System.out.println(pelicula);
                //volvemos a llamar y captura el valor de la siguiente
                linea= entrada.readLine();
            }
            //cerrar archivo siempre
            entrada.close();


        }catch (Exception e){
            System.out.println("Error al abrir el archivo"+e.getMessage());
        }
    }

    @Override
    public void agregarPeliculas(Pelicula pelicula) {
        boolean anexar=false;
        var archivo=new File(NOMBRE_ARCHIVO);
        try{
            if(archivo.exists()){
                anexar=archivo.exists();
                var salida= new PrintWriter(new FileWriter(archivo,anexar));
                //agregar la peli
                salida.println(pelicula);
                System.out.println("Se agrego la pelicula "+pelicula+" al archivo");
                HistorialLogger.agg("user","Se agrego la pelicula "+pelicula+" al archivo");
                salida.close();
            }
        } catch (Exception e) {
            System.out.println("Error al agregar la pelicula"+e.getMessage());
        }
    }

    @Override
    public void buscarPeliculas(Pelicula pelicula) {
        var archivo=new File(NOMBRE_ARCHIVO);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;

            for(String peliculaBuscar = pelicula.getNombre(); lineaTexto != null; ++indice) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }

                lineaTexto = entrada.readLine();
            }

            if (encontrada) {
                System.out.println("Peli " + lineaTexto + " esta aqui papa! en  linea " + indice);
            } else {
                System.out.println("Peli " + pelicula.getNombre() + " no encontrado");
            }

            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al buscar el archivo" + e.getMessage());
        }
    }

    @Override
    public void eliminarPeliculas(Pelicula pelicula) {
        var archivo=new File(NOMBRE_ARCHIVO);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;

            for(String peliculaBuscar = pelicula.getNombre(); lineaTexto != null; ++indice) {
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }

                lineaTexto = entrada.readLine();
            }

            if (encontrada) {
                System.out.println("Peli " + lineaTexto + " esta aqui papa! en  linea " + indice);
            } else {
                System.out.println("Peli " + pelicula.getNombre() + " no encontrado");
            }

            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al buscar el archivo" + e.getMessage());
        }

    }
}