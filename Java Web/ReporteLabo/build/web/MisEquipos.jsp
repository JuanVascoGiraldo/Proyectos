<%@page import="java.util.List"%>
<%@page import="Control.Acciones"%>
<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<% 
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("usuario") != null){
        MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
        if( usu.getRol()== 2){
            response.sendRedirect("equipos.jsp");
        }
    }else{
        %> 
        <jsp:forward page="index.jsp">
            <jsp:param name="Error" value="Es obligatorio identificarse" />
        </jsp:forward>
<%
    }
    MUsuario usu = (MUsuario)sesion.getAttribute("usuario");


%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <% 
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
    %>
    <title>Inicio Usuario</title>
    <link rel="icon" type="image/png" href="./img/escudoCECyT9.png">
    <link rel="stylesheet" href="./CSS/normalize.css">
    <link rel="stylesheet" href="./CSS/misequipos.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="fill">
        <div class="fil" id="fil" onclick="equipos()"><h3>Mis Equipos</h3></div>
        <div class="fil2" id="fil2" onclick="cuenta()"><h3>Cuenta</h3></div>
        <div class="fil2" onclick="CSesion()"><h3>Cerrar Sesion</h3></div>
    </div>
    <br>
    <div class="compus" id="compus">
        <%
            List<MEquipo> lista = Acciones.VermiEquipos(usu.getId());
            
            for(MEquipo e:lista){
        
        %>
        <div class="equipo">
            <img src="./img/computadora.png">
            <br>
            Numero de Equipo: <%=e.getNumero() %>
            <br>
            Laboratorio:<%=e.getDes_labo() %>
            <br>
            Materia:<%=e.getDes_materia() %>
            <br>
            Estado:<%=e.getDes_estado() %>
            <br>
            <button class="boton" onclick="mandardato(<%=e.getId() %>)" data-open="modalR">Realizar Reporte</button>
            <button class="boton" onclick="location.href = './verReporte.jsp?id=<%=e.getId() %>'">Ver Reportes</button>
        </div>
        <%
            }
        %>
    </div>
    <div class="cuenta" id="cuenta">
        <div class="cuen">
            <img src="./img/usuario.png" class="imgusu">
            <br>
            Nombre de Alumno:<%=usu.getNombre() %>
            <br>
            Boleta Alumno:<%=usu.getBoleta() %>
            <br>
            Grupo:<%=usu.getGrupo() %>
            <br>
            Cambiar Contraseña
            <br>
            <form action="CambiarContra" name="changepass">
                <input type="password" name="contra" id="IScontra" class="texto" placeholder="Contraseña">
                <button type="button" id="IniciarSesion" class="boton1" onclick="CambiarContra()">Cambiar</button>
            </form>
        </div>
    </div>
    <div class="modal" id="modalR">
        <div class="card">
            <form action="Hreporte" name="hacerreporte">
                <label for="" class="article">Ingrese la descripción del reporte</label><br>
                <hr class="linea">
                <input type="hidden" name="id" id="id" value="" >
                <textarea name="reporte" id="reporte" class="area" placeholder="Escribe Aqui tu reporte"></textarea>
                <br>
               <button type="button" class="submit" onclick="RealizarReporte()" id="enviar">Realizar</button>
            </form>
        </div>
    </div>
    <script>
        function equipos(){
            document.getElementById("compus").style.display = "inline";
            document.getElementById("cuenta").style.display = "none";
            document.getElementById("fil").style.borderBottom = "2px solid #0066FF";
            document.getElementById("fil2").style.borderBottom = "none";
            document.getElementById("fil").style.hover = "border-bottom: 2px solid #ffffff"
    
            document.getElementById("fil").addEventListener("mouseover", function() {
                document.getElementById("fil").style.borderBottom  = "2px solid #ffffff";
            });
                
            document.getElementById("fil2").addEventListener("mouseout", function() {
                document.getElementById("fil2").style.borderBottom = "none";
            });
    
            document.getElementById("fil2").addEventListener("mouseover", function() {
                document.getElementById("fil2").style.borderBottom  = "2px solid #ffffff";
            });
                
            document.getElementById("fil").addEventListener("mouseout", function() {
                document.getElementById("fil").style.borderBottom = "2px solid #0066FF";
            });
        }
    
        function cuenta(){
            document.getElementById("compus").style.display = "none";
            document.getElementById("cuenta").style.display = "inline";
            document.getElementById("fil").style.borderBottom = "none";
            document.getElementById("fil2").style.borderBottom = "2px solid #0066FF";
    
            document.getElementById("fil").addEventListener("mouseover", function() {
                document.getElementById("fil").style.borderBottom  = "2px solid #ffffff";
            });
                
            document.getElementById("fil").addEventListener("mouseout", function() {
                document.getElementById("fil").style.borderBottom = "none";
            });
    
            document.getElementById("fil2").addEventListener("mouseover", function() {
                document.getElementById("fil2").style.borderBottom  = "2px solid #ffffff";
            });
                
            document.getElementById("fil2").addEventListener("mouseout", function() {
                document.getElementById("fil2").style.borderBottom = "2px solid #0066FF";
            });
    
        }
        function mandardato(idd){
            document.getElementById("id").value= idd;
        }
    </script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="./JS/validar.js"></script>
    <script src="./JS/funcionModal.js"></script>
</body>
</html>