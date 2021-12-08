<%@page import="Modelo.Ejercicio"%>
<%@page import="Control.AccionesEjercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    int id_eje = 0;
    HttpSession sesion = request.getSession(true);
    try{
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 1){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
    id_eje = Integer.parseInt(request.getParameter("id"));
    }catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
        Ejercicio e = AccionesEjercicio.ObtenerEjercioUsuarioByid(id_eje , ((Integer)sesion.getAttribute("id")));
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Ejercicio</title>
    <link rel="stylesheet" href="css/EjerciciosAdmin.css">
    <link rel="shortcut icon" href="./img/logo.png">
    <script src="js/myscript.js"></script>
</head>
<body background="img/FondoXD.png">
    <header>
        <div class="cabecera">
            <img src="img/corazon.png" class="logo">
            <span>
                <nav class="navigation">
                <ul class="show">
                    <li>
                        <a href="VUejercicio.jsp">EJERCICIO</a>
                    </li>
                    <li>
                        <a href="VUVdieta.jsp">DIETA</a>
                    </li>
                    <li>
                        <a href="Cuenta.jsp">CUENTA</a>
                    </li>
                    <li>
                        <a href="CerrarSesion">CERRAR SESIÓN</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <br>
    <h1 class="center">Modificar Ejercicio</h1><br>
    <div class="centrar">
        <a href="rutina.jsp" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Volver
        </a>
    </div>
    <br>
    <div class="principal">
        <form name="modiejeusu" method="POST" action="ModificarEjercicioUsuario">
            <!--Aquí en el action va un JSP xd-->
            <input value="<%=e.getId()%>" type="number" name="id_eje" max="99999999" readonly="readonly">
            <br>
            <input value="<%=e.getNombre()%>" type="text" name="nombre" readonly="readonly">
            <!-- Repeticiones INPUT -->
            <label for="Repeticiones">Repeticiones</label>
            <input type="number" name="repeticiones" max="99999999" value="<%=e.getRepeticiones()%>">
            <button type="button" onclick="modificarejerciciousuario()">Modificar Ejercicio</button>
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