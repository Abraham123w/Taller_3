<html>
<head>
  <meta charset="UTF-8">
  <title>Obtener Parámetros</title>
  <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
<h1>Obtener Parámetros</h1>
<form action="AgregarVendedorServlet" method="POST">
  <label for="nombre">Nombre:</label>
  <input type="text" name="nombre" id="nombre"><br>

  <label for="rut">RUT:</label>
  <input type="text" name="rut" id="rut"><br>

  <label for="direccion">Direccion:</label>
  <input type="text" name="direccion" id="direccion"><br>

  <label for="titulo">Titulo:</label>
  <input type="text" name="titulo" id="titulo"><br>

  <label for="estadoCivil">Estado Civil:</label>
  <input type="text" name="estadoCivil" id="estadoCivil"><br>

  <input type="submit" value="Enviar">
</form>
</body>
</html>