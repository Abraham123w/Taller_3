package data;

import model.Tipo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TipoDAO {
    private static final String NOMBRE_ARCHIVO = "C:/Users/abrah/OneDrive/Escritorio/UNIVERSIAS 2023/OneDrive/TAREAS DE PRAGRAMACION/taller3/Taller_3/tipo.txt";
    public static List<Tipo> obtenerTipos() {
        List<Tipo> tipos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Tipo tipo = new Tipo(linea.trim());
                tipos.add(tipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tipos;
    }

}
