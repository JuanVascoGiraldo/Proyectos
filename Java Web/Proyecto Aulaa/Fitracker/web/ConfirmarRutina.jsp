<%@page import="Control.accionesUsuario"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Ejercicio"%>
<%@page import="Control.AccionesEjercicio"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    HttpSession sesion = request.getSession(true);
    try{
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 1){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
}catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
        Calendar fecha = java.util.Calendar.getInstance();
        String fech=fecha.get(java.util.Calendar.DATE) + "/"
            + (fecha.get(java.util.Calendar.MONTH)+1) + "/" 
                    + fecha.get(java.util.Calendar.YEAR);
        int id = (Integer)sesion.getAttribute("id");
        boolean respuesta = accionesUsuario.RutinaConfirmada(id, fech);
        if(respuesta == true){
            response.sendRedirect("rutina.jsp");
        }
        List<Ejercicio> lista = AccionesEjercicio.EjerciciosdeUsuario((Integer)sesion.getAttribute("id"));
        if(lista.size() == 0){
            response.sendRedirect("rutina.jsp");
        }
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirmar Rutina</title>
    <link rel="stylesheet" href="css/ConfirmarRutina.css">
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
    <h1 class="center">Confirmar Rutina</h1><br>
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
        <form name="confrutina" method="POST" action="ConfirmarRutina">
            <%
                for(Ejercicio e: lista){
            %>
            <div class="centrar">
                <label for="Nombre">Nombre</label> &nbsp;&nbsp;&nbsp;&nbsp;
                <input value="<%=e.getNombre() %>" type="Text" name="nombreEjercicio" readonly="readonly">
                <br> &nbsp;&nbsp;&nbsp;&nbsp;
                <!-- Repeticiones INPUT -->
                <label for="Repeticiones">Repeticiones</label> &nbsp;&nbsp;&nbsp;&nbsp;
                <input type="number" name="<%=e.getId()%>" max="99999999"  value="<%=e.getRepeticiones()%>" required>
            </div>
            <br>
            <%  } %>
            <input type="submit" value="Confirmar Rutina">
            <!--Pongo la validación tanto en el form como en el button, porque no sé cual es el que se debe
            aplicar en estos casos juas juas xdddd-->
        </form>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
