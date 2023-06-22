<%@ page import="java.util.List" %>
<%@ page import="com.example.taller_3.AgregarInmuebleServlet" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Buscar Inmueble</title>
  <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Buscar Inmueble</h1>
<form action="BuscarInmuebleServlet" method="POST">
  <label for="tipo">Tipo:</label>
  <select name="tipo" id="tipo">
    <%-- Iterar sobre la lista de categorías obtenida desde LibroServlet --%>
    <%
      List<String> tipos = (List<String>) AgregarInmuebleServlet.obtenerTipo();
      for (String tipo : tipos) {
    %>
    <option value="<%= tipo %>"><%= tipo %></option>
    <%-- Fin del bucle --%>
    <% } %>
  </select><br>

  <label for="ubicacion">Ubicacion:</label>
  <input type="text" name="ubicacion" id="ubicacion"><br>

  <label for="precio">Precio:</label>
  <input type="text" name="precio" id="precio"><br>

  <input type="submit" value="Buscar">
</form>
</body>
</html>
