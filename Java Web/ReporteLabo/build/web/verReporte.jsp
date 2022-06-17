<%@page import="java.util.List"%>
<%@page import="Control.Acciones"%>
<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<% 
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("usuario") == null){
        %> 
        <jsp:forward page="index.jsp">
            <jsp:param name="Error" value="Es obligatorio identificarse" />
        </jsp:forward>
<%
    }
    boolean seg = false;
    int id = 0;
    try{
        id = Integer.valueOf(request.getParameter("id"));
    }catch(Exception e){
        seg = true;
    }
    MUsuario usu = (MUsuario)sesion.getAttribute("usuario");
    MEquipo eq = Acciones.ConsultarEquipo(id);
    if(eq.getId_estado()==0)seg=true;
    
    if(seg){
        if(usu.getRol()==1){
            %> 
        <jsp:forward page="MisEquipos.jsp">
            <jsp:param name="Error" value="Es obligatorio identificarse" />
        </jsp:forward>
<%
        }else if(usu.getRol()==2){
            %> 
        <jsp:forward page="equipos.jsp">
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
    <% 
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma","no-cache");
        response.setDateHeader("Expires", 0);
    %>
    <title>Ver Reporte</title>
    <link rel="icon" type="image/png" href="./img/escudoCECyT9.png">
    <link rel="stylesheet" href="./CSS/normalize.css">
    <link rel="stylesheet" href="./CSS/verreporte.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="main">
        <a href="./MisEquipos.jsp">
            <img src="./img/bxs-left-arrow.svg" alt="Imagen"> Volver
        </a>
        <div class="main-contentimg">
            <img src="./img/computadora.png" alt="imagen pc" class="img1">
        </div>
        <div class="main-content">
            Laboratorio:  <%=eq.getDes_labo() %>
            <br>
            <br>
            Numero de Computadora:  <%=eq.getNumero() %>
            <br>
            <br>
            Estado: <%=eq.getDes_estado() %>
            <br>
            <%
                if(usu.getRol() == 2){
            %>
            <button class="boton" onclick="location.href = './CEstado?id=<%=id%>&&estado=1'">Funcionamiento</button>
            <button class="boton" onclick="location.href = './CEstado?id=<%=id%>&&estado=3'">Mantenimiento</button>
            <button class="boton" onclick="location.href = './CEstado?id=<%=id%>&&estado=2'">Deshabilitada</button>
            
            <%
                }
            %>
        </div>
        <br>
        <br>
        <%
            List<MReporte> reportes = Acciones.ConsultarReportes(id);
            for(MReporte re:reportes){
        %>
        <div class="reporte">
            <img src="./img/descargar.png" class="imgre">
            <div class="texto">
                Fecha y hora de reporte: <%=re.getFecha_re()%> a las <%=re.getHora_re() %>
                <br>
                Nombre y boleta de estudiante que realizo el reporte:
                <br>
                 <%=re.getNom_usu() %> con boleta <%=re.getBoleta() %>
                <br>
                descripción del reporte:
                <br><%=re.getReporte() %>
                <br>
                Fecha y hora de solucion: <%=re.getFecha_so()%> a las <%=re.getHora_so() %>
                <br>
                descripción de la solución:
                <br>
                <%=re.getSolucion() %>
                <br>
                <%
                    
                    String text = "Dar Solución";
                    if(!re.getFecha_so().equals("Esperando Solución"))text= "Cambiar Solución";
                    
                    if(usu.getRol() ==2){
                %>
                <button class="boton" onclick="enviarDatos(<%=re.getId() %>)" data-open="modalR"><%=text%></button>
                <%
                    }
                %>
            </div>
        </div>
        <%
            }
        %>
    </div>
    <%
                    if(usu.getRol() ==2){
                %>
                                
                <div class="modal" id="modalR">
                    <div class="card">
                        <form action="Rereporte" name="resolvereporte">
                            <label for="" class="article">Ingrese la descripción de la solución</label><br>
                            <hr class="linea">
                            <input type="hidden" name="maq" id="maq" value="<%=id%>" >
                            <input type="hidden" name="id" id="id" value="" >
                            <textarea name="solucion" id="solucion" class="area" placeholder="Escribe Aqui la solución"></textarea>
                            <br>
                           <button type="button" class="submit" onclick="ResolverResporteN()" id="enviar">Solucionar</button>
                        </form>
                    </div>
                </div>
    <%
                    }
                %>
    <script>
        function enviarDatos(idd){
            document.getElementById("id").value= idd;
        }
    </script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="./JS/validar.js"></script>
    <script src="./JS/funcionModal.js"></script>
</body>
</html>