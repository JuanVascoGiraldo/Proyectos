<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>

<%  
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 1){
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
    <title>Vista de Usuario</title>
    <link rel="stylesheet" href="css/masterstyle.css">
    <link rel="shortcut icon" href="./img/logo.png">
</head>

<body background="img/FondoXD.png">
    <header>
        <div class="cabecera">
            <img src="img/corazon.png" class="logo">
            </span>
        </div>
    </header>
    <h1>SELECCIONE LA ACCION QUE DESEA HACER EN FITRACKER</h1>
    <div class="principal">

        <div class="alfa">
            <img src="images/ejercicio.jpg" height="200px">
            <br>
            <a href="VUejercicio.jsp">
                <div class="button-container-1">
                    <div class="button-container-1">
                        <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Ejercicios</button>
                    </div>
                </div>
        </div>
        </a>
        <br>

        <div class="alfa">
            <img src="images/rutina.jpg" height="200px">
            <br>
            <a href="rutina.jsp">
                <div class="button-container-1">
                    <div class="button-container-1"> <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Gestionar Rutinas</button> </div>
                </div>
            </a>
        </div>
        <div class="alfa">
            <img src="img/Blanco_con_Icono_Colorido_Computadoras_Logo_1.png" height="200px">
            <br>
            <a href="Cuenta.jsp">
                <div class="button-container-1">
                    <div class="button-container-1">
                        <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Gestionar Cuenta</button>
                    </div>
                </div>
        </div>
        </a>
        <br>

        <div class="alfa">
            <img src="images/dieta.jpg" height="200px">
            <br>
            <a href="VUVdieta.jsp">
                <div class="button-container-1">
                    <div class="button-container-1"> <span class="mas">FITRACKER</span> <button id='work' type="button" name="Hover">Gestionar Dietas</button> </div>
                </div>
            </a>
        </div>
    </div>
    <br>
    <br>
    <br>
    <div class="principal">
        <a href="CerrarSesion">
            <div class="button-container-1">
                <div class="button-container-1"> <span class="mas">FITRACKER</span> <a href="CerrarSesion"><button id='work' type="button" name="Hover">CERRAR SESION</button></a> </div>
        </a>
        </div>
        <footer>
            <p>Tecnología Administrativa Creativa y Operadora de Software</p>
        </footer>
</body>
</html>
