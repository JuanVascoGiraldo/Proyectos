<%@page import="Modelo.Dietas"%>
<%@page import="Control.AccionesDieta"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
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
        Dietas d = AccionesDieta.buscarDieta(id_die);
        
    %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Dieta</title>
    <link rel="stylesheet" href="css/agregardieta.css">
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
        <h1>Modificar Dietas</h1>
        <form name="modidieta" method="POST" action="ModificarDieta">
            <!--Aquí en el action va un JSP xd-->
            <input value="<%=d.getId() %>" type="number" name="ID" max="99999999" readonly="readonly">
            <br>
            <label for="nombre">Nombre</label>
            <input type="text" placeholder="Ingresa el nombre de la dieta" name="nombre" value="<%=d.getNombre()%>" required>
            <!--Nombre INPUT-->
            <br>
            <label for="descripcion">Descripcion</label><br>
            <br>
            <textarea maxlength="200" name="descripcion" required><%=d.getDescripcion()%></textarea>
            <!--Descripción INPUT-->
            <br>
            <select name="clasificacion" id="clasificacion">
                    <option selected disabled>Elige una clasificacion</option>
                    <% List<Clasificacion> lista = AccionesClasificacion.clasificaciondie(); 
                    for (Clasificacion c : lista){ %>
                    <option value="<%=c.getId() %>" <% if(c.getDes().equals(d.getClasi())){
                    %> selected <%}%> ><%=c.getDes() %></option>
                    <% } %>
                </select><br>
            <!--Clasificacion INPUT SELECT-->
            <button type="button" onclick="modificardieta()">Modificar Dieta</button><br>
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