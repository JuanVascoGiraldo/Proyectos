<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<% 
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("usuario") != null){
        MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
        if(usu.getRol() == 1){
            response.sendRedirect("MisEquipos.jsp");
        }else if( usu.getRol()== 2){
            response.sendRedirect("equipos.jsp");
        }
    }

%>  
<!DOCTYPE html>
<html lang="es">
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
    <link rel="stylesheet" href="./CSS/estilos.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="alinear">
        <div class="grid">
            <div class="form">
                <form action="" name="iniciar">
                    <input type="number" name="boleta" id="ISBoleta" class="texto" placeholder="Boleta">
                    <input type="password" name="contra" id="IScontra" class="texto" placeholder="Contraseña">
                    <button type="button" id="IniciarSesion" class="submit button" onclick="validarIS()">Iniciar sesión</button>
                </form>
                <div id="cambiar"></div>
                <button class="Registro" id="registrar" data-open="modalR">
                    <a href="#">Iniciar como Administrador</a>
                </button>
            </div>
            <div class="main-content">
                <div class="img">
                    <img src="./img/escudoCECyT9.png" alt="Escudo batiz">
                </div>
                <article class="main-text">
                      Este trabajo es realizado esta realizado por:Cruz Rodríguez Denise, Freyre Valderrama Aarón,
                     García Acosta Sergio Adrián , del Grupo: 4IV7 
                </article>
            </div>
            
        </div>
        <div class="modal" id="modalR">
            <div class="card">
                <form action="" name="passadmin">
                    <label for="" class="article">Ingresa la contraseña de administrador</label><br>
                    <hr class="linea">
                    <input type="password" name="pass" id="passadmin" placeholder="Contraseña" class="input">
                    <br>
                   <button type="button" class="submit" onclick="validarISA()" id="enviar">Ingresar</button>
                </form>
            </div>
        </div>
        <div id="cambiar1"></div>
    </div>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="./JS/validar.js"></script>
    <script src="./JS/funcionModal.js"></script>
</body>
</html>