<%@page import="Modelo.Comidas"%>
<%@page import="Control.AccionesComida"%>
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
        Comidas c = AccionesComida.ConsultarcomidaByid(id_comi);
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Comida</title>
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
        <h1>Modificar Comida</h1>
        <form name="modicomi" method="POST" action="ModificarComida">
            <!--Aquí en el action va un JSP xd-->
            <input type="number" name="ID" max="99999999" value="<%=c.getId() %>" readonly="readonly">
            <label for="nombre">Nombre</label>
            <input type="text" placeholder="Ingresa el nombre de la comida" name="nombre" value="<%=c.getNombre()%>" required>
            <!-- Nombre INPUT -->
            <br>
            <label for="descripcion">Descripcion</label><br>
            <br>
            <textarea maxlength="200" name="descripcion" required><%=c.getDescripcion()%></textarea>
            <!-- DESCRIPCIÓN INPUT -->
            <button type="button" onclick="modificarcomidas()">Modificar Ejercicio</button><br>
            <!--Pongo la validación tanto en el form como en el button, porque no sé cual es el que se debe
            aplicar en estos casos juas juas xdddd-->
        </form>
    </div>
    <script src="js/Validacion.js"></script>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
