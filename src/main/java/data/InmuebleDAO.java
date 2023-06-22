package data;

import model.Inmueble;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
}
