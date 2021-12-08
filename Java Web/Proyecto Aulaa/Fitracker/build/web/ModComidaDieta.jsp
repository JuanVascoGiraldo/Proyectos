<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    int id_comida = 0;
    int id_dieta = 0;
    int horario =0;
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 0){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
        id_comida = Integer.parseInt(request.getParameter("id_comi"));
        id_dieta = Integer.parseInt(request.getParameter("id_die"));
        horario = Integer.parseInt(request.getParameter("horario"));
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
    <title>Modificar Comida de Dieta</title>
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
        <h1>Modificar Comida De Dieta</h1>
        <form name="modiDieComi" method="POST" action="ModificarComidaDieta">
            <!--Aquí en el action va un JSP xd-->
            <label for="IDDie">ID Dieta:</label>
            <input value="<%=id_comida%>" type="number" name="idcomi" max="99999999" readonly="readonly">
            <br>
            <label for="IDCom">ID Comida:</label><br>
            <input value="<%=id_dieta%>" type="number" name="iddie" max="99999999" readonly="readonly">
            <br>
            <select name="horario" id="horario">
                    <option disabled>Elige un Horario</option>
                    <% List<Clasificacion> lista= AccionesClasificacion.Horario();
                        for (Clasificacion c: lista){
                    %>
                        <option value="<%=c.getId()%>" <% if(c.getId() == horario){%>selected<%}%> ><%=c.getDes()%></option> 
                    <% } %>
                </select><br>
            <!--Horario INPUT SELECT-->
            <button type="button" onclick="modificarcomidadedieta()" >Modificar La Comida De Dieta</button><br>
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