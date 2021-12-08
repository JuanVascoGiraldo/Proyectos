<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Ejercicio"%>
<%@page import="Control.AccionesEjercicio"%>
<%@page import="Modelo.Clasificacion"%>
<%@page import="Control.AccionesClasificacion"%>
<%@page import="Control.accionesUsuario"%>
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
    
        <jsp:forward page="rutina.jsp?clasi=0">
            <jsp:param name="Error" value="Es obligatorio identificarse" />
        </jsp:forward>
    <%
        }
    }
    Calendar fecha = java.util.Calendar.getInstance();
    String fech=fecha.get(java.util.Calendar.DATE) + "/"
        + (fecha.get(java.util.Calendar.MONTH)+1) + "/" 
                + fecha.get(java.util.Calendar.YEAR);
    int id = (Integer)sesion.getAttribute("id");
    boolean respuesta = accionesUsuario.RutinaConfirmada(id, fech);
    List<Ejercicio> lista = AccionesEjercicio.EjerciciosdeUsuario((Integer)sesion.getAttribute("id"));
    %>
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Rutina</title>
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
                        <a href="VUejercicio.jsp">EJERCICIO</a>
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
            <h3>Rutina</h3>
            <br>
            <div class="principal">
        <% 
            if(respuesta == false){
                if(lista.size()>0){
                
        %>
        <a href="ConfirmarRutina.jsp" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Confirmar Rutina
        </a>
        <%
          }
            else{ %>
                <a href="ConfirmarRutina.jsp" class="btn-neon">
                <span id="span1"></span>
                <span id="span2"></span>
                <span id="span3"></span>
                <span id="span4"></span> Registra ejercicios en tu rutina
                </a>
                <% }
        }else{ %>
                <a href="#" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Ya se ha confirmado la rutina
                </a>
           <% } %>
            </div>
            <br>
            <a href="https://damp-retreat-83799.herokuapp.com/verProgreso/<%=id%>" class="btn-neon">
            <span id="span1"></span>
            <span id="span2"></span>
            <span id="span3"></span>
            <span id="span4"></span> Ver Progreso
            </a>
            <br>
            <form>
                <select name="area" onChange="location = form.area.options[form.area.selectedIndex].value;">
                    <option selected="true" disabled="disabled">Elige una Clasificación</option>
                    <option value="rutina.jsp?clasi=0">Ninguna</option>
                    <% List<Clasificacion> listas = AccionesClasificacion.clasificacioneje();
                    for (Clasificacion c : listas){ %>
                    <option value="rutina.jsp?clasi=<%=c.getId()%>"><%=c.getDes() %></option>
                    <% } %>
                </select>
            </form>
                <br>
            <br>
            <% 
                for(Ejercicio e: lista){
                    if(clasifi != 0 && e.getClasificacion() == clasifi){
            %>
            <div class="conteiner">
                <h3>Nombre:<%=e.getNombre() %></h3>
                <br>
                <h3><%=e.getClasi()%> </h3>
                <br>
                <h3><%=e.getRepeticiones()%> </h3>
                <br>
                <br>
                <a href="VUmodificarejercicio.jsp?id=<%=e.getId() %>" class="button">Modificar Ejercicio</a>
                <br>
                <br>
                <br>
                <a href="EliminarEjercicioUsuario?id_eje=<%=e.getId() %>" class="button">Eliminar Ejercicio</a>
            </div>
            <br>
            <%  }
                    if(clasifi == 0){
                    %>
                    <div class="conteiner">
                <h3>Nombre:<%=e.getNombre() %></h3>
                <br>
                <h3><%=e.getClasi()%> </h3>
                <br>
                <h3><%=e.getRepeticiones()%> </h3>
                <br>
                <br>
                <a href="VUmodificarejercicio.jsp?id=<%=e.getId() %>" class="button">Modificar Ejercicio</a>
                <br>
                <br>
                <br>
                <a href="EliminarEjercicioUsuario?id_eje=<%=e.getId() %>" class="button">Eliminar Ejercicio</a>
            </div>
            <br>
             <% }
                } 
            %>
        </div>
        <br>
    </div>
    <br>
    <footer>
        <p>Tecnología Administrativa Creativa y Operadora de Software</p>
    </footer>
</body>
</html>
