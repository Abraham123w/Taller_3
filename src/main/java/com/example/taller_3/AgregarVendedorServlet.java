package com.example.taller_3;

import data.VendedorDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Vendedor;

import java.io.IOException;
import java.io.PrintWriter;

import static validadores.ValidarRut.validarRut;

@WebServlet(name = "AgregarVendedorServlet", value = "/AgregarVendedorServlet")
public class AgregarVendedorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String tituloProfesional = request.getParameter("tituloProfesional");
        String estadoCivil = request.getParameter("estadoCivil");

        RequestDispatcher respuesta1 = request.getRequestDispatcher("/VendedorAgregado.jsp");
        RequestDispatcher respuesta2 = request.getRequestDispatcher("/errorAgregarVendedor.jsp");

        Vendedor vendedor = new Vendedor(nombre,rut,direccion,tituloProfesional,estadoCivil);


        boolean rutValido = validarRut(rut);
        boolean clienteDuplicado = VendedorDAO.existeCliente(nombre, rut);

        //  boolean correoValido = true;
        //boolean rutValido = true;
        // boolean clienteDuplicado = true;


        if ( rutValido && clienteDuplicado) {
           VendedorDAO.agregarCliente(vendedor);
            request.setAttribute("vendedor", vendedor);
            respuesta1.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Error al agregar el vendedor");
            respuesta2.forward(request, response);
        }
    }
}
