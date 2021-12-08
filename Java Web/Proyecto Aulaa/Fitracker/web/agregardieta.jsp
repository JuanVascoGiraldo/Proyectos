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
    <title>Agregar Dietas</title>
    <link rel="stylesheet" href="css/agregardieta.css">
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
        <h1>Agregar Dietas</h1>
        <form name="agregardieta" method="POST" action="RegistrarDieta">
            <!--Aquí en el action va un JSP xd-->
            <label for="nombre">Nombre</label>
            <input type="text" placeholder="Ingresa el nombre de la dieta" name="nombre" required>
            <!--Nombre INPUT-->
            <br>
            <label for="descripcion">Descripcion</label><br>
            <br>
            <textarea maxlength="200" name="descripcion" required></textarea>
            <!--Descripción INPUT-->
            <br>
            <select name="clasificacion" id="clasificacion">
                    <option selected disabled>Elige una clasificacion</option>
                    <% List<Clasificacion> lista= AccionesClasificacion.clasificaciondie();
                        for (Clasificacion c: lista){
                    %>
                    <option value="<%=c.getId()%>"><%=c.getDes()%></option> 
                    <% } %>
                </select><br>
            <!--Clasificacion INPUT SELECT-->
            <button type="button" onclick="agregardietas()">Agregar Dieta</button><br>
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
