
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<% 
    HttpSession ss = request.getSession(true);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bonito.css">
        <title>Inicio</title>
    </head>
    <body>
        <div class="blanco">
        <% 
            if(ss.getAttribute("q") == null || ss.getAttribute("p") == null ){
        
        %>
        <div class="Formulario">
                <br>
                <center><b><p class="titulo">Ingresar p y q</p></b></center>
                <hr>
                <form action="registrarpq">
                    <center>
                        <p>Ingresar p</p>
                        <input type="number" name="nump" placeholder="Ingresar el numero p">
                        <br>
                        <p>Ingresar q</p>
                        <br>
                        <input type="number" name="numq" placeholder="Ingresar el numero q">
                        <br>
                        <input type="submit" value="enviar" class="boton">
                    </center>
                </form>
            </div>
        <%  }else{   %>
        <div>
            <br>
            <center><b><p class="titulo">Valores</p></b></center>
            <hr>
            <center>
            <h1>Numero p: <%=ss.getAttribute("p") %></h1>
            <br>
            <h1>Numero q:<%=ss.getAttribute("q") %></h1>
            <br>
            <h1>Numero n:<%=ss.getAttribute("n") %></h1>
            <br>
            <h1>Numero fi:<%=ss.getAttribute("fi") %></h1>
            <br>
            <h1>Clave Publica e:<%=ss.getAttribute("e") %></h1>
            <br>
            <h1>Clave Privada d:<%=ss.getAttribute("d") %></h1>
            <br>
            </center>
            <br>
            <form action="CifrarODescifrar">
                <h3>Ingresar Texto</h3>
                <input name="numero" type="text">
                <br>
                <br>
                <h3>Elije la acción a hacer</h3>
                <br>
                <h3><input type="radio" name="accion" value="cifrar">Cifrar</h3>
                <br>
                <h3><input type="radio" name="accion" value="descifrar">Descifrar</h3>
                <br>
                <input type="submit" value="Realizar">
            </form>
            <%
                if(request.getParameter("respuesta") != null){
                    

            %>
            <div>
                <center>
                Respuesta: <%=request.getParameter("respuesta") %>
                </center>
            </div>
       
        <%
            }
%>
        </div>
<%
            }
        %>
        </div>
    </body>
</html>
