<%@page import="java.util.List"%>
<%@page import="Modelo.Ejercicio"%>
<%@page import="Control.AccionesEjercicio"%>
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
    <title>Ejercicios Admin</title>
    <link rel="stylesheet" href="css/EjerciciosAdmin.css">
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
    <h1 class="center">EJERCICIOS</h1>
    <div class="centrar">
        <a href="agregarejercicio.jsp" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Agregar Ejercicio
        </a>
    </div>
    <div class="principal">
        <%  List<Ejercicio> lista= AccionesEjercicio.buscarAllEjercicio();
            for (Ejercicio e : lista){
                if(e.isActiva() == 1){
        %>
        <div class="contenedor">
            <h3>ID:<%=e.getId() %></h3>
            <br>
            <h3><%=e.getNombre() %></h3>
            <br>
            <h3>Calorias:<%=e.getCantidad() %></h3>
            <br>
            <h3><%=e.getClasi()%></h3>
            <br>
            <a href="modificarejercicio.jsp?id=<%=e.getId()%>">
                <img src="img/edit.png" width="60px">
            </a>
            <a href="CambiarUsoEjercicio?id=<%=e.getId()%>&accion=desactivar">
                <img src="img/Cross.png" width="50px">
            </a>
        </div>
        <% }else{ %>
        <div class="contenedor2">
            <h3>ID:<%=e.getId() %></h3>
            <br>
            <h3><%=e.getNombre() %></h3>
            <br>
            <h3>Calorias:<%=e.getCantidad() %></h3>
            <br>
            <h3><%=e.getClasi()%></h3>
            <br>
            <a href="CambiarUsoEjercicio?id=<%=e.getId()%>&accion=activar">
                <img src="img/check.png" width="50px">
            </a>
        </div>
        <% }} %>
    </div>
    <div class="creditos">
        <a target="_blank" href="undefined/icons/set/close-window">Cerrar ventana icon</a> icono de <a target="_blank" href="">Icons8</a>
        <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>