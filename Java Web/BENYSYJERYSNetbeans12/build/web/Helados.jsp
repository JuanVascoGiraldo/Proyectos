
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="Control.accionesProducto"%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
    <link rel="stylesheet" href="./css/helados.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="./multimedia/administrador.png">
</head>
<body style="font-family: 'Noto Sans JP', sans-serif;">
    <header class="header">
        <div class="container logo-nav-container">
            <h1 style="font-family: 'Noto Sans JP', sans-serif;">BENYS Y JERYS</h1>
            <span class="menu-icon">Ver menú</span>
            <nav class="navigation">
                <ul class="show">
                    <li><form>
                        <select name="area" onChange="location = form.area.options[form.area.selectedIndex].value;">
                            <option selected="true" disabled="disabled">Inicio</option>
                            <option value="">Productos</option>
                            <option value=""> Promociones</option>
                        </select>
                    </form>
                <br>
                </li>
                    <li><a href="index.html"><img src="./multimedia/usuario.png" alt="registrarse" width="60px" height="60px"></a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="main"> <% Calendar fecha = java.util.Calendar.getInstance();%>
                  <h1>Productos <%=fecha.get(java.util.Calendar.DATE) + "/"
                + (fecha.get(java.util.Calendar.MONTH)+1) + "/" 
                        + fecha.get(java.util.Calendar.YEAR) %>
                
                  </h1>
                  <a href="AgregarHelado.html"><div class="boton2">AGREGAR PRODUCTO</div></a>
                  <%List<Producto> productos= accionesProducto.buscarAllProducto();
                    for(Producto p : productos){
                  %>
                    <div class="heladitos">
                    <h3>Id: <%=p.getId()%></h3>
                    <h3><%=p.getNombre()%></h3>
                    <img src="./multimedia/<%=p.getImagen()%>.png" alt="imagenhelado" width="100px" height="100px" style="margin-left: 10px;">
                    <h3>Sabor: <%=p.getSabor() %></h3>
                    <h3>Precio: <%=p.getPrecio() %> MXN</h3>
                    <a href="EliminarProducto?id=<%=p.getId()%>"><div class="boton">Eliminar</div></a>
                    <a href="ModificarProducto.jsp?id=<%=p.getId()%>"><div class="boton">Modificar</div></a>
                    <br>
                    <br>
                  </div>
                  <%
                    }
                  %>
        </div>
        <br>
        <br>
    </div>
    <footer>
        Iconos diseñados por <a href="https://www.freepik.com" title="Freepik">
            Freepik</a> from <a href="https://www.flaticon.es/" title="Flaticon">www.flaticon.es</a><br>
        <div>Iconos diseñados por <a href="" title="xnimrodx">xnimrodx</a> from 
            <a href="https://www.flaticon.es/" title="Flaticon">www.flaticon.es</a></div>
    </footer>
</body>
</html>
