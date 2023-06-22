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

@WebServlet(name = "AgregarInmuebleServlet", value = "/AgregarInmuebleServlet")
public class AgregarInmuebleServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtener los parámetros enviados desde el formulario
        String tipo = request.getParameter("tipo");
        String ubicacion = request.getParameter("ubicacion");
        String precio = request.getParameter("precio");

        RequestDispatcher respuesta1 = request.getRequestDispatcher("/exitoAgregarInmueble.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorAgregarInmueble.jsp");
        RequestDispatcher respuesta3 = request.getRequestDispatcher("/q.jsp");


        //VALIDAR PRECIO Y PESO QUE SEAN VALORES POSITOVOS Y NUMERICOS
        // Declaración de variables para almacenar el valor numérico del peso y el precio

        double precioValor;

        try {
            // Intentar convertir las cadenas de peso y precio a valores numéricos de tipo double

            precioValor = Double.parseDouble(precio);
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el peso y el precio no son valores numéricos
            // Imprimir un mensaje de error en la respuesta
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el artículo: peso y precio deben ser valores numéricos.");

            // Redirigir a la página de error correspondiente y finalizar el método
            respuesta3.forward(request, response);

            return;
        }



       // Crear instancia
        Inmueble articulo = new Inmueble(tipo,ubicacion,precio);

        // Lógica para agregar
        InmuebleDAO articuloDAO = new  InmuebleDAO();
        boolean exito = InmuebleDAO.agregarArticulo(articulo);

        if (exito) {
            request.setAttribute("Articulo", articulo);
            respuesta1.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.println("Error al agregar Inmueble");
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
    public static String generarTablaLibros(List<Inmueble> libros) {
        StringBuilder tabla = new StringBuilder();

        tabla.append("<table>");
        tabla.append("<tr>");
        tabla.append("<th>Tipo</th>");
        tabla.append("<th>Ubicacion</th>");
        tabla.append("<th>Precio</th>");

        tabla.append("</tr>");

        for (Inmueble libro : libros) {
            String tipo = libro.getTipo().trim();
            String ubicacion= libro.getUbicacion().trim();
            String precio = libro.getPrecio().trim();



            tabla.append("<tr>");
            tabla.append("<td>").append(tipo).append("</td>");
            tabla.append("<td>").append(ubicacion).append("</td>");
            tabla.append("<td>").append(precio).append("</td>");

            tabla.append("</tr>");
        }

        tabla.append("</table>");

        return tabla.toString();
    }
}
