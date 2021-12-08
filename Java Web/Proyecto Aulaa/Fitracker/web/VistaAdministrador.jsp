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
    <title>Vista administrador</title>
    <link rel="stylesheet" href="css/VistaAdministrador.css">
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
    <div class="principal">
        <div class="principal">
            <div>
                <img src="images/admin.jpg" class="alfa">
            </div>
            <div class="beta">
                <p class="gama">BIENVENIDO ADMINISTRADOR</p>
                <br>
                <p class="delta">Aquí podrá agregar, eliminar y modificar todos los elementos para los ejercicios, dietas y comidas.</p>
            </div>
        </div>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
