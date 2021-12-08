<%@page import="Modelo.Dietas"%>
<%@page import="Control.AccionesDieta"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    int id_comi = 0;
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 0){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
        id_comi = Integer.parseInt(request.getParameter("id"));
    }catch(Exception e){
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
    <title>Agregar Comida a Dietas</title>
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
        <h1>Agregar Comida a Dietas</h1>
        <form name="agregarcomiadieta" method="POST" action="RegistrarComidaenDieta">
            <input value="<%=id_comi %>" type="number" name="ID" max="99999999" readonly="readonly">
            <br>
            <select name="dieta" id="dieta">
                    <option selected disabled>Elige una dieta</option>
                    <% List<Dietas> dieta= AccionesDieta.buscarAllNombreDie();
                        for (Dietas d: dieta){
                            if(d.isActiva() == 1){
                    %>
                    <option value="<%=d.getId()%>"><%=d.getNombre() %></option> 
                    <% }} %>
                </select><br>
            <br>
            <!--INPUT SELECT HORARIO-->
            <select name="horario" id="horario">
                    <option selected disabled>Elige un horario</option>
                    <% List<Clasificacion> lista= AccionesClasificacion.Horario();
                        for (Clasificacion c: lista){
                    %>
                        <option value="<%=c.getId()%>"><%=c.getDes()%></option> 
                    <% } %>
                </select><br>
            <button type="button" onclick="agregarcomidaadieta()">Agregar Comida A Dieta</button><br>
            <!--Pongo la validación tanto en el form como en el button, porque no sé cual es el que se debe
            aplicar en estos casos juas juas xdddd-->
        </form>
        <script src="js/Validacion.js"></script>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
