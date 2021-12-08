<%@page import="java.util.List"%>
<%@page import="Modelo.Dietas"%>
<%@page import="Control.AccionesDieta"%>
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
    }}catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }
    
    List<Dietas> lista = AccionesDieta.buscardietasusuario(((Integer)sesion.getAttribute("id")));
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dietas Guardadas</title>
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
                        <a href="VUVdieta.jsp" >VOLVER</a>
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
    <br>
    <div class="principal"><br>
        <div class="contenido"><br>
            <h3>DIETAS GUARDADAS</h3>
            <br>
            <h3>Dietas registradas por el usuario</h3><br>
            <% 
                for (Dietas d: lista){
            %>
                <div class="conteiner">
                    <h3><%=d.getNombre()%> </h3>
                    <br>
                    <h3><%=d.getClasi() %></h3>
                    <br>
                    <a href="Verdieta1.jsp?id=<%=d.getId()%>" class="button">Ver Más</a>
                </div>
                <br>
            <% } %>
        </div>
        <br>
    </div>
    <br><br><br>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
