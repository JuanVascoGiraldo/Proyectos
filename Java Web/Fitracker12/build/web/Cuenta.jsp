<%@page import="Modelo.Usuario "%>
<%@page import="Control.accionesUsuario"%>
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
    Usuario u = accionesUsuario.buscarUsuarioById((Integer)sesion.getAttribute("id"));
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cuenta</title>
    <link rel="stylesheet" href="css/masterstyle.css">
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
                        <a href="rutina.jsp">RUTINA</a>
                    </li>
                    <li>
                        <a href="VUVdieta.jsp">DIETA</a>
                    </li>
                    <li>
                        <a href="VUejercicio.jsp">EJERCICIO</a>
                    </li>
                    <li>
                        <a href="CerrarSesion">CERRAR SESIÓN</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <div class="beta">
        <h2>Bienvenido a su cuenta</h2>
        <h3>
            Correo:<%=u.getEmail() %>
        </h3>
        <h3>
            Nombre:<%=u.getUsuario() %>
        </h3>
    </div>
    <div class="principal">

        <div class="alfa">
            <img src="images/crearusuario.jpg" height="200px">
            <br>
            <a href="CambiarUsoUsuario">
                <div class="button-container-1">
                    <div class="button-container-1">
                        <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Desactivar Cuenta</button>
                    </div>
                </div>
        </div>
        </a>
        <br>

        <div class="alfa">
            <img src="images/iniciarsesion.jpg" height="200px">
            <br>
            <a href="ModificarCuenta.jsp">
                <div class="button-container-1">
                    <div class="button-container-1"> <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Modificar Cuenta</button> </div>
                </div>
            </a>
        </div>
        <footer>
            <p>Tecnología Administrativa Creativa y Operadora de Software</p>
        </footer>
</body>
</html>