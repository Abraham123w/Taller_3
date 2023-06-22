package data;

import model.Inmueble;
import model.Tipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO {
    private static final String rutaArchivo = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/taller3/Taller_3/inmueble.txt";
    public static boolean agregarArticulo(Inmueble articulo) {
        boolean exito = false;

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            // Crear una cadena con los datos del artículo
            String datosArticulo = articulo.getTipo() + "," + articulo.getUbicacion() + "," + articulo.getPrecio();

            // Agregar los datos del artículo al archivo de texto
            writer.println(datosArticulo);

            exito = true; // Marcar como éxito si se agrega correctamente
        } catch (IOException e) {
            // Manejar errores si ocurre algún problema al escribir en el archivo
            e.printStackTrace();
        }

        return exito;
    }

    public static List<Inmueble> buscarArticulos(String tipo, String ubicacion, String precio) {
        List<Inmueble> articulosEncontrados = new ArrayList<>();
        List<Inmueble> articulos = leerArticulos(); // Suponiendo que tienes un método para leer los artículos

        for (Inmueble articulo : articulos) {
            if (
                    articulo.getPrecio().trim().equalsIgnoreCase(precio) &&
                    articulo.getTipo().trim().equalsIgnoreCase(tipo) &&
                    articulo.getUbicacion().trim().equalsIgnoreCase(ubicacion)) {
                articulosEncontrados.add(articulo);
            }
        }

        return articulosEncontrados;
    }
    public static List<Inmueble> leerArticulos() {
        List<Inmueble> articulos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosArticulo = linea.split(",");
                String tipo = datosArticulo[0].trim();
                String ubicacion = datosArticulo[1].trim();
                String precio= datosArticulo[2].trim();


                Inmueble articulo = new Inmueble(tipo, ubicacion, precio);
                articulos.add(articulo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return articulos;
    }
}
