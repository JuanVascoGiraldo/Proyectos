
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<% 
    String texto = request.getParameter("texto");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=texto%></h1>
        <br>
        <a href="descifrar.html">Volver</a>
    </body>
</html>
