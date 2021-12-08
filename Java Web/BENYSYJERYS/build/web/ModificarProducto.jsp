<%@page import="Modelo.Producto"%>
<%@page import="Control.accionesProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"  language="java"%>
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
                </li>
                    <li><a href="Helados.jsp">Volver</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="main">
        <div>
            <h2> Modificar Producto</h2>
            <form name="modificarproducto" method="POST" action="modificarProducto">
                <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Producto p= accionesProducto.buscarProductoById(id);
                %>
                <input value="<%=p.getId()%>" type="number" name="identificador" max="99999999" readonly="readonly">
                <br>
                <input type="text" name="Nombre" placeholder="Nombre del Producto" maxlength="20" value="<%=p.getNombre() %>">
                <br>
                <br>
                <input value="<%=p.getPrecio() %>" type="number" name="Precio" placeholder="Precio del Producto" max="99999999">
                <br>
                <br>
                <select name="sabores" id="sabores">
                    <option value="Chocolate" <% 
                        if(p.getSabor().equals("Chocolate")){%>selected="true"<%}%>>Chocolate</option>
                    <option value="Fresa" <% 
                        if(p.getSabor().equals("Fresa")){%>selected="true"<%}%>>Fresa</option>
                    <option value="Piña" <% 
                        if(p.getSabor().equals("Piña")){%>selected="true"<%}%>>Piña</option>
                    <option value="Galleta" <% 
                        if(p.getSabor().equals("Galleta")){%>selected="true"<%}%>>Galleta</option>
                    <option value="Vanilla" <% 
                        if(p.getSabor().equals("Vanilla")){%>selected="true"<%}%>>Vanilla</option>
                    <option value="Napolitano" <% 
                        if(p.getSabor().equals("Napolitado")){%>selected="true"<%}%>>Napolitano</option>
                </select>
                <br>
                <br>
                <div class="opciones">
                    Imagen 1
                    <br>
                    <img src="multimedia/Helados.png" width="80px" height="80px">
                </div>
                <div class="opciones">
                    Imagen 2
                    <br>
                    <img src="multimedia/helado2.png" width="80px" height="80px">
                </div>
                <div  class="opciones">
                    Imagen 3
                    <br>
                    <img src="multimedia/helado3.png" width="80px" height="80px">
                </div>
                <br>
                <select name="icono" id="icono">
                    <option selected="true" disabled="disabled">Elige El icono</option>
                    <option value="Helados" <% 
                        if(p.getImagen().equals("Helados")){%>selected="true"<%}%>>Imagen 1</option>
                    <option value="helado2" <% 
                        if(p.getImagen().equals("helado2")){%>selected="true"<%}%>>Imagen 2</option>
                    <option value="helado3" <% 
                        if(p.getImagen().equals("helado3")){%>selected="true"<%}%>>imagen 3</option>
                </select>
                <br>
                <button type="button" onclick="validardatos2()">Guardar</button>
            </form>
            <script src="./js/validar.js"></script>
        </div>
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
