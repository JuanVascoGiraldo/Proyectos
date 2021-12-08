<%@page import="java.util.List"%>
<%@page import="Modelo.Ejercicio"%>
<%@page import="Control.AccionesEjercicio"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
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
    }
}catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
    int clasifi = 0;
    if( request.getParameter("clasi") != null){
        try{
            clasifi = Integer.parseInt(request.getParameter("clasi"));}
        catch(Exception e){
            System.out.println(e.getMessage());
            clasifi = 0;
        %>
    
        <jsp:forward page="VUejercicio.jsp?clasi=0">
            <jsp:param name="Error" value="Es obligatorio identificarse" />
        </jsp:forward>
    <%
        }
    }
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicios</title>
    <link rel="stylesheet" href="css/VUejercicio.css">
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
    <div class="principal"><br>
        <div class="contenido"><br>
            <form>
                <select name="area" onChange="location = form.area.options[form.area.selectedIndex].value;">
                    <option selected="true" disabled="disabled">Elige una Clasificación</option>
                    <option value="VUejercicio.jsp?clasi=0>">Ninguna</option>
                    <% List<Clasificacion> listas = AccionesClasificacion.clasificacioneje();
                    for (Clasificacion c : listas){ %>
                    <option value="VUejercicio.jsp?clasi=<%=c.getId()%>"><%=c.getDes() %></option>
                    <% } %>
                </select>
            </form>
            <br>
            <h3>Ejercicios</h3>
            <br>
            <% List<Ejercicio> lista = AccionesEjercicio.EjerciciosActivos();
                for(Ejercicio e: lista){
                    if(clasifi != 0 && e.getClasificacion() == clasifi){
            %>
            <div class="conteiner">
                <h3> <%=e.getNombre()  %> </h3>
                <br>
                <h3> Clasificación: <%=e.getClasi()  %> </h3>
                <br>
                <h3>Calorias: <%=e.getCantidad() %> </h3>
                <br>
                <br>
                <a href="AgregarEjercicioRutina.jsp?id=<%=e.getId()%>" class="button">Añadir a RUTINA</a>
            </div>
            <br>
            <%  }
                    if(clasifi == 0){
                    %>
            <div class="conteiner">
                <h3> <%=e.getNombre()  %> </h3>
                <br>
                <h3> Clasificación: <%=e.getClasi()  %> </h3>
                <br>
                <h3>Calorias: <%=e.getCantidad() %> </h3>
                <br>
                <br>
                <a href="AgregarEjercicioRutina.jsp?id=<%=e.getId()%>" class="button">Añadir a RUTINA</a>
            </div>
            <br>
            <%

                    }
                } 
            %>
        </div>
    </div>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
