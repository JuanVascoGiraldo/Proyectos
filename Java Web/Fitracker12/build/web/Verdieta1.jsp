<%@page import="java.util.List"%>
<%@page import="Modelo.Dietas"%>
<%@page import="Control.AccionesDieta"%>
<%@page import="Modelo.Comidas"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>

<%  
    int id_die = 0;
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 1){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
    id_die = Integer.parseInt(request.getParameter("id"));
    }catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
        Dietas die = AccionesDieta.buscarDietaById(id_die);
        List<Comidas> manana = die.getMañana();
        List<Comidas> tarde = die.getTarde();
        List<Comidas> noche = die.getNoche();
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ver Dieta</title>
    <link rel="stylesheet" href="css/Verdieta.css">
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
                        <a href="DietasGuardadas.jsp" >VOLVER</a>
                    </li>
                    <li>
                        <a href="rutina.jsp">RUTINA</a>
                    </li>
                    <li>
                        <a href="VUejercicio.jsp">EJERCICIO</a>
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
    <div class="centrar">
        <a href="EliminarDietadeUsuario?id_die=<%=id_die%>" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Eliminar
        </a>
    </div>
            <br>
    <h1 class="center">Dietas del usuario</h1><br>
    <br>
    <div class="principal">
        <div class="contenedor">
            <h3><%=die.getNombre()%></h3>
            <br>
            <h3><%=die.getClasi() %></h3>
            <br>
            <h3><%=die.getDescripcion() %></h3>
            <br>
            <div class="M">
                <h3>Comidas Mañana</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : manana){ %>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                    </tr>
                    <% } %>
                </table>
            </div><br>
            <div class="T">
                <h3>Comidas Tarde</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : tarde){ %>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                    </tr>
                    <% } %>
                </table>
            </div><br>
            <div class="N">
                <h3>Comidas Noche</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : noche){ %>
                    <tr>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </div>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
