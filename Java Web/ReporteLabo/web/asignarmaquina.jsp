<%@page import="java.util.List"%>
<%@page import="Control.Acciones"%>
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
    boolean seg = false;
    int id = 0;
    try{
        id = Integer.valueOf(request.getParameter("id"));
    }catch(Exception e){
        seg = true;
    }
    
    MUsuario uu = Acciones.ConUsuario(id);
    if(uu.getNombre().equals("no encontrado"))seg=true;
    List<CCatalogo> mate = Acciones.MateriasAsginadas(id, uu.getGrupo());
    if(mate.size() == 0)seg=true;
    if(seg){
        %> 
        <jsp:forward page="equipos.jsp">
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
    <title>Asignar maquina</title>
    <link rel="icon" type="image/png" href="./img/escudoCECyT9.png">
    <link rel="stylesheet" href="./CSS/normalize.css">
    <link rel="stylesheet" href="./CSS/misequipos.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <div class="mainuwu">
        <a href="./equipos.jsp"class="aa">
            <img src="./img/bxs-left-arrow.svg" alt="Imagen" class="imagen"> Volver
        </a>
        <div class="materia">
            <%
                for(CCatalogo c: mate){
            %>
            <button class="boton33" onclick="mandardato(<%=c.getId() %>,'<%=c.getDes() %>')"><%=c.getDes() %></button>
            <%
                }
            %>
            <form name="Maquina" action="AMaquina">
                <input type="hidden" name="estudiante" id="estudiante" value="<%=id%>">
                <input type="hidden" name="id" id="id" value="">
                <div class="materia-c" style="width: 100%">
                    Materia: <input id="materia" name="materia" type="text" value="Escoge una materia" style="width: 80%" readonly>
                </div>
                <div id="cambiar">    
                    
                </div>
           
            </form>
                <script src="./JS/validar.js"></script>
                <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <script>
                var loading = "<script>"+
                "Swal.fire({"+
                 "title: 'Datos enviados',"+
                 "html: 'espere un momento',"+
                "timer: 3500,"+
                 "timerProgressBar: true,"+
                 "didOpen: () => {"+
                   "Swal.showLoading()"+
                 "}"+
               "})"+
                 "<"+"/script>";
                function mandardato(idd, nombre){
                    document.getElementById("id").value= idd;
                    document.getElementById("materia").value= nombre;
                    var grupo = "<%=uu.getGrupo()%>"
                     $('#cambiar').html(loading);
                    $.post('MaquinasLabo', {
                        grupo: grupo,
                        materia: idd
                        }, function(responseText) {
                                $('#cambiar').html(responseText);
                        });
                }
            </script>
        </div> 
    </div>
</body>
</html>