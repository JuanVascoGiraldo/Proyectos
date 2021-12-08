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
    <title>Modificar Cuenta</title>
    <link rel="stylesheet" href="css/Isesion.css">
    <link rel="shortcut icon" href="img/logo.png">
</head>

<body background="img/FondoXD.png">
    <header>
        <div class="cabecera">
            <img src="img/corazon.png" class="logo">
            <span>
                <nav class="navigation">
                <ul class="show">
                    <li>
                        <a href="Cuenta.jsp">VOLVER</a>
                    </li>
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
    <div class="contenedor">
        <h1>Modificar Cuenta</h1>
        <form name="actuausu" method="POST" action="ModificarUsuario">
            <!--Aquí en el action va un JSP xd-->
            <label for="username">Usuario</label>
            <input type="text" placeholder="Ingresa tu usuario" name="nombre" value="<%=u.getUsuario()%>" required>
            <!-- USERNAME INPUT -->
            <label for="email">Correo</label>
            <input type="text" placeholder="Ingresa tu Email" name="email" value="<%=u.getEmail() %>"  required>
            <!-- EMAIL INPUT -->
            <label for="password">Contraseña</label>
            <input type="password" placeholder="Ingresa tu contraseña" name="contra" value="<%=u.getContrasena()%>" required>
            <!-- PASSWORD INPUT -->
            <label for="passwordConfirmation">Confirma tu Contraseña</label>
            <input type="password" placeholder="Ingresa tu contraseña" name="confcontrasena" required>
            <!--confirmacion-->
            <button type="button" onclick="modificarcuenta()">Modificar Cuenta</button>
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
