<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id") != null){
        if((Integer)sesion.getAttribute("permiso") == 1){
                response.sendRedirect("VistaAdministrador.jsp");
                }
        if((Integer)sesion.getAttribute("permiso") == 0){
            response.sendRedirect("vistausuario.jsp");
            }
        }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="css/Isesion.css">
    <link rel="shortcut icon" href="./img/logo.png">
</head>
<body background="img/FondoXD.png">
    <header>
        <div class="cabecera">
            <a href="index.html"><img src="img/corazon.png" class="logo"></a>
            <span>
                <nav class="navigation">
                <ul class="show">
                    <li>
                        <a href="index.html">Volver</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <div class="contenedor">
        <h1>Inicia Sesión</h1>
            <form name="iniciarSesion" method="POST" action="iniciarsesion">
              <!-- EMAIL INPUT -->
              <label for="email">Correo</label>
              <input type="text" placeholder="Ingresa tu Email" name="email" required>
              <!-- PASSWORD INPUT -->
              <label for="password">Contraseña</label>
              <input type="password" placeholder="Ingresa tu contraseña" name="contra" required>
              <button type="button" onclick="iniciosesion()">Iniciar Sesión</button>
              <!--Pongo la validación tanto en el form como en el button, porque no sé cual es el que se debe
            aplicar en estos casos juas juas xdddd-->
              <a href="Registrarse.html">¿No tienes cuenta? Regístrate aquí</a>
            </form>
        <script src="js/Validacion.js"></script>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
