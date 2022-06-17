<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<% 
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("usuario") != null){
        MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
        if( usu.getRol()== 1){
            response.sendRedirect("MisEquipos.jsp");
        }
    }else{
        %> 
        <jsp:forward page="index.jsp">
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
    <% 
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
    %>
    <title>Inicio</title>
    <link rel="icon" type="image/png" href="./img/escudoCECyT9.png">
    <link rel="stylesheet" href="./CSS/normalize.css">
    <link rel="stylesheet" href="./CSS/misequipos.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="fill">
        <div class="fil" id="fil" onclick="equipos()"><h3>Mis Equipos</h3></div>
        <div class="fil2" id="fil2" onclick="cuenta()"><h3>Estudiante</h3></div>
        <div class="fil2" onclick="CSesion()"><h3>Cerrar Sesion</h3></div>
    </div>
    <br>
    <div id="cambiar1"></div>
    <div class="compus" id="compus">
        <button class="boton3" data-open="modalR">Registrar Equipo</button>
        <br>
        <br>
        <button class="boton333" onclick="VerMaquinas(0);" type="button">Todos</button>
        <button class="boton333" onclick="VerMaquinas(1);" type="button">Funcionamiento</button>
        <button class="boton333" onclick="VerMaquinas(3);" type="button">Mantenimiento</button>
        <button class="boton333" onclick="VerMaquinas(2);" type="button">No Funcionando</button>
        <div id="cambiar">
            
        </div>
    </div>
    <div class="cuenta" id="cuenta">
        <button class="boton3" data-open="modalR2">Registrar Alumno</button>
        <div id="cambiarr">

        </div>
    </div>
    <div class="modal" id="modalR2">
        <div class="card">
            <form action="" name="RegistrarEstudiante">
                <label for="" class="article">Registra Una nuevo estudiante</label><br>
                <hr class="linea">
                <label for="" class="article">Nombre Estudiante</label><br>
                <input type="text" name="nombre" id="nombre" class="texto">
                <br>
                <label for="" class="article">Numero de boleta</label><br>
                <input type="number" name="boleta" id="boleta" class="texto">
                <br>
                <label for="" class="article">Grupo</label>
                <br>
                <select name="grupo" id="grupo">
                    <option value="1" >3IM7</option>
                    <option value="2" >3IM8</option>
                    <option value="3" >3IM9</option>
                    <option value="4" >3IM10</option>
                    <option value="5" >3IV7</option>
                    <option value="6" >3IV8</option>
                    <option value="7" >3IV9</option>
                    <option value="8" >3IV10</option>
                    <option value="9" >4IM7</option>
                    <option value="10" >4IM8</option>
                    <option value="11" >4IM9</option>
                    <option value="12" >4IM10</option>
                    <option value="13" >4IV7</option>
                    <option value="14" >4IV8</option>
                    <option value="15" >4IV9</option>
                    <option value="16" >4IV10</option>
                    <option value="17" >5IM7</option>
                    <option value="18" >5IM8</option>
                    <option value="19" >5IM9</option>
                    <option value="20" >5IV7</option>
                    <option value="21" >5IV8</option>
                    <option value="22" >5IV9</option>
                    <option value="23" >6IM7</option>
                    <option value="24" >6IM8</option>
                    <option value="25" >6IM9</option>
                    <option value="26" >6IV7</option>
                    <option value="27" >6IV8</option>
                    <option value="28" >6IV9</option>
                </select>
                <br>
               <button type="button" class="submit" onclick="RegistrarEstudianteN()" id="enviar">Registrar</button>
            </form>
        </div>
    </div>
    <div class="modal" id="modalR">
        <div class="card">
            <form action="" name="RegistrarEquipo">
                <label for="" class="article">Registra Una nueva maquina</label><br>
                <hr class="linea">
                <label for="" class="article">Laborartorio</label>
                <br>
                <select name="labo" id="labo">
                    <option value="1" >LBD</option>
                    <option value="2" >LNV</option>
                    <option value="3" >LDS</option>
                    <option value="4" >4.0</option>
                </select>
                <br>
                <label for="" class="article">Numero de maquina</label><br>
                <input type="number" name="numero" id="numero" class="texto">
                <br>
               <button type="button" class="submit" onclick="RegistrarEquipoN()" id="enviar">Registrar</button>
            </form>
        </div>
    </div>
    <script src="./JS/validar.js"></script>
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
        
        VerEstudiantes();
        VerMaquinas(0);
    </script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    
    <script src="./JS/funcionModal.js"></script>
</body>
</html>