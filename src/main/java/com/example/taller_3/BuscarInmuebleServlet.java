package com.example.taller_3;

import data.InmuebleDAO;
import data.TipoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Inmueble;
import model.Tipo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.example.taller_3.AgregarInmuebleServlet.generarTablaLibros;

@WebServlet(name = "BuscarInmuebleServlet", value = "/BuscarInmuebleServlet")
public class BuscarInmuebleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtener los parámetros enviados desde el formulario
        String tipo = request.getParameter("tipo").trim();
        String ubicacion = request.getParameter("ubicacion").trim();
        String precio = request.getParameter("precio").trim();


        RequestDispatcher respuesta1 = request.getRequestDispatcher("/inmuebleEncontrado.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorBuscarInmueble.jsp");
        RequestDispatcher respuesta3 = request.getRequestDispatcher("/errorBuscarInmuebleNumerico.jsp");
        double precioValor;

        try {
            // Intentar convertir las cadenas de peso y precio a valores numéricos de tipo double

            precioValor = Double.parseDouble(precio);
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el peso y el precio no son valores numéricos
            // Imprimir un mensaje de error en la respuesta
            PrintWriter out = response.getWriter();
            out.println("Error: precio deben ser valores numéricos.");

            // Redirigir a la página de error correspondiente y finalizar el método
            respuesta3.forward(request, response);

            return;
        }
// Crear instancia de la categoría
        Inmueble articulo = new Inmueble( tipo,ubicacion,precio);

        // Lógica para agregar
       InmuebleDAO articuloDAO = new InmuebleDAO();
        boolean exito = articuloDAO.agregarArticulo(articulo);
        List<Inmueble> articulosEncontrados = articuloDAO.buscarArticulos(tipo,ubicacion,precio);
      /*  List<Articulo> articulosEncontrados = new ArrayList<>();
        articulosEncontrados.add(articulo);*/

        if (exito) {
            String tablaArticulos = generarTablaLibros(articulosEncontrados);
            request.setAttribute("tablaArticulos", tablaArticulos);
            respuesta1.forward(request, response);
        } else {
            respuesta2.forward(request, response);
        }
    }
    public static List<String> obtenerTipo() {
        List<Tipo> listaTipo = TipoDAO.obtenerTipos();
        List<String> formatos = new ArrayList<>();

        for (Tipo tipo : listaTipo) {
            formatos.add(tipo.getNombre());
        }

        return formatos;
    }
}
