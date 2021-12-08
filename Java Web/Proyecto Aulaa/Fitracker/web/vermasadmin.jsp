<%@page import="Modelo.Dietas"%>
<%@page import="Control.AccionesDieta"%>
<%@page import="Modelo.Comidas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    int id_die = 0;
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 0){
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
    <title>Ver Mas</title>
    <link rel="stylesheet" href="css/VerMas.css">
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
                        <a href="DietasAdmin.jsp">VOLVER</a>
                    </li>
                    <li>
                        <a href="CerrarSesion">CERRAR SESIÓN</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <div class="alinear">
        <div class="principal">
            <div class="TextOne">
                <h3>ID:&nbsp;&nbsp; <%=die.getId()%></h3>
                <br>
                <h3>Nombre:&nbsp;&nbsp; <%=die.getNombre()%></h3>
                <br>
                <h3>Clasicación:&nbsp;&nbsp; <%=die.getClasi()%></h3>
                <br>
                <h3>Descripcion
                    <br><%=die.getDescripcion()%>
                </h3>
                <br>
            </div>
            <br>
            <br>
            <div class="M">
                <h3>Comidas Mañana</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>ID Comida</th>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : manana){ %>
                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                        <td><a href="EliminarComidaDieta?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>">Eliminar</a></td>
                        <td><a href="ModComidaDieta.jsp?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>&horario=1">Modificar</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <br>
            <br>
            <div class="T">
                <h3>Comidas Tarde</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>ID Comida</th>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : tarde){ %>
                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                        <td><a href="EliminarComidaDieta?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>">Eliminar</a></td>
                        <td><a href="ModComidaDieta.jsp?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>&horario=2">Modificar</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <br>
            <br>
            <div class="N">
                <h3>Comidas Noche</h3><br>
                <table class="Tabla">
                    <tr>
                        <th>ID Comida</th>
                        <th>Nombre Comida</th>
                        <th>Descripcion</th>
                    </tr>
                    <% for (Comidas c : noche){ %>
                    <tr>
                        <td><%=c.getId()%></td>
                        <td><%=c.getNombre()%></td>
                        <td><%=c.getDescripcion() %></td>
                        <td><a href="EliminarComidaDieta?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>">Eliminar</a></td>
                        <td><a href="ModComidaDieta.jsp?id_comi=<%=c.getId()%>&id_die=<%=die.getId()%>&horario=3">Modificar</a></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <br>
        </div>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>