<%@page import="java.util.List"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>

<%  
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 0){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }}catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar Ejercicio</title>
    <link rel="stylesheet" href="css/agregarejercicio.css">
    <link rel="shortcut icon" href="./img/logo.png">
</head>
<body background="img/FondoXD.png">
    <header>
        <div class="cabecera">
                <img src="img/corazon.png" class="logo">
            <span>
                <nav class="navigation">
                <ul class="show">
                    <li>
                        <a href="EjerciciosAdmin.jsp">EJERCICIO</a>
                    </li>
                    <li>
                        <a href="DietasAdmin.jsp">DIETA</a>
                    </li>
                    <li>
                        <a href="ComidasAdmin.jsp">COMIDA</a>
                    </li>
                    <li>
                        <a href="CerrarSesion">CERRAR SESIÓN</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <div class="contenedor">
        <h1>Añadir Ejercicio</h1>
        <form name="agregareje" method="POST" action="RegistrarEjercicio">
            <!--Aquí en el action va un JSP xd-->
            <!-- Nombre INPUT -->
            <label for="nombre">Nombre</label>
            <input type="text" placeholder="Ingresa el nombre del ejercicio" name="nombre" required>
            <!-- CAlORIAS INPUT -->
            <label for="calorias">calorias</label>
            <input type="number" placeholder="Ingresa las calorias" name="calorias" required>
            <!--Clasificacion-->
            <label for="clasificacion">clasificacion</label><br>
            <select name="clasificacion" id="Clasificacion">
                <option selected disabled>Elige una clasificacion</option>
                    <% List<Clasificacion> lista = AccionesClasificacion.clasificacioneje();
                    for (Clasificacion c : lista){ %>
                    <option value="<%=c.getId() %>"><%=c.getDes() %></option>
                    <% } %>
                </select><br>
            <button type="button" onclick="agregarejercicio()">Agregar Ejercicio</button><br>
            <!--Pongo la validación tanto en el form como en el button, porque no sé cual es el que se debe
            aplicar en estos casos juas juas xdddd-->
        </form>
    </div>
    <script src="js/Validacion.js"></script>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
