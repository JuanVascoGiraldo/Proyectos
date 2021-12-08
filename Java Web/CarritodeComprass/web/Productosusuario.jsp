<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.*"%>
<%@page import="Control.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java" %>
<%  
    try{
    HttpSession sesion = request.getSession(true);
    if(sesion.getAttribute("id")== null || ((Integer)sesion.getAttribute("permiso"))== 1){
    %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }}catch(Exception e){
        System.out.println(e.getMessage());
        %>
    
    <jsp:forward page="error.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    <%
    }   
        String NUMEROS2 = "[0-9]*";
        List<Catalogo> sabores = AccionesCatalogo.Sabores();
        List<Catalogo> presentacion = AccionesCatalogo.Presentacion();
        List<Catalogo> tamano = AccionesCatalogo.Tamano();
        int sab = 0;
        if( request.getParameter("sab") != null){
            Pattern pattern = Pattern.compile(NUMEROS2);
            Matcher matcher = pattern.matcher(request.getParameter("sab"));        
            boolean r = matcher.matches();
            if(r == true){
                boolean r2= false;
                for(Catalogo c: sabores){
                if(c.getId() == Integer.parseInt(request.getParameter("sab"))){
                        r2 = true;
                        break;
                    }
                }
                if(r2 == true){
                    sab = Integer.parseInt(request.getParameter("sab"));
                }
            }
        }
        int pre = 0;
        if( request.getParameter("pre") != null){
            Pattern pattern = Pattern.compile(NUMEROS2);
            Matcher matcher = pattern.matcher(request.getParameter("pre"));        
            boolean r = matcher.matches();
            if(r == true){
                boolean r2= false;
                for(Catalogo c: presentacion){
                if(c.getId() == Integer.parseInt(request.getParameter("pre"))){
                        r2 = true;
                        break;
                    }
                }
                if(r2 == true){
                    pre = Integer.parseInt(request.getParameter("pre"));
                }
            }
        }
        int tam = 0;
        if( request.getParameter("tam") != null){
            Pattern pattern = Pattern.compile(NUMEROS2);
            Matcher matcher = pattern.matcher(request.getParameter("tam"));        
            boolean r = matcher.matches();
            if(r == true){
                boolean r2= false;
                for(Catalogo c: tamano){
                if(c.getId() == Integer.parseInt(request.getParameter("tam"))){
                        r2 = true;
                        break;
                    }
                }
                if(r2 == true){
                    tam = Integer.parseInt(request.getParameter("tam"));
                }
            }
        }
        List<MProducto> lista = AccionesProducto.buscarAllProductoconStock();
        
    %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos Usuario</title>
    <link rel="stylesheet" href="css/styleProductos.css">
    <link rel="icon" type="image/png" href="img/favicon.ico">
    <script src="js/myscript.js"></script>
</head>

<body background="img/Fondo.jpg">
    <header>
        <div class="cabecera">
            <img src="img/corazon.png" class="logo">
            <span>
                <nav class="navigation">
                <ul class="show">
                    <li>
                        <a href="cuenta.jsp">MI CUENTA</a>
                    </li>
                    <li>
                        <a href="Vercarrito.jsp">MI CARRITO</a>
                    </li>
                    <li>
                        <a href="VerCompras.jsp">MIS COMPRAS</a>
                    </li>
                    <li>
                        <a href="CerrarSesion">CERRAR SESIÓN</a>
                    </li>
                </ul>
                </nav>
            </span>
        </div>
    </header>
    <form>
    <div class="center2">
        <h1 class="center">Filtrar Productos</h1>
        <br>
        <div class="centrar">
                <div class="box">
                    <select name="area" onChange="location = form.area.options[form.area.selectedIndex].value;">
                        <option <% if(sab ==0){%> selected <%}%> disabled>Por Sabor:</option>
                        <option value="Productosusuario.jsp?sab=0&&pre=<%=pre %>&&tam=<%=tam %>">Ninguna</option>
                     <%  
                    for (Catalogo c: sabores){
                %>
                        <option value="Productosusuario.jsp?sab=<%=c.getId()%>&&pre=<%=pre%>&&tam=<%=tam%>" <% if(sab == c.getId()){%> selected <%}%> ><%=c.getDescripcion()%> </option>
                <%  
                }
                %>
                    </select>
                </div>
                <div class="box">
                    <select name="area1" onChange="location = form.area1.options[form.area1.selectedIndex].value;">
                        <option <% if(pre == 0){%> selected <%}%> disabled>Por Presentación:</option>
                        <option value="Productosusuario.jsp?pre=0&&sab=<%=sab%>&&tam=<%=tam%>" >Ninguna</option>
                <%  
                        for (Catalogo c: presentacion){
                    %>
                        <option value="Productosusuario.jsp?pre=<%=c.getId()%>&&sab=<%=sab%>&&tam=<%=tam%>" <% if(pre == c.getId()){%> selected <%}%>><%=c.getDescripcion()%> </option>
                    <%  
                    }
                %>
                    </select>
                </div>
                <div class="box">
                    <select name="area2" onChange="location = form.area2.options[form.area2.selectedIndex].value;">
                        <option <% if(tam == 0){%> selected <%}%> disabled>Por Tamaño:</option>
                        <option value="Productosusuario.jsp?tam=0&&pre=<%=pre%>&&sab=<%=sab%>">Ninguna</option>
                    <%  
                        for (Catalogo c: tamano){
                    %>
                        <option value="Productosusuario.jsp?tam=<%=c.getId()%>&&pre=<%=pre%>&&sab=<%=sab%>" <% if(tam == c.getId()){%> selected <%}%>><%=c.getDescripcion()%> </option>
                    <%  
                    }
                    %>
                    </select>
                </div>
                <div class="box">
                    <select name="area3" onChange="location = form.area3.options[form.area3.selectedIndex].value;">
                        <option selected disabled>Ninguna</option>
                        <option value="Productosusuario.jsp?tam=0&&pre=0&&sab=0">Ninguna</option>
                    </select>
                </div>
        </div>
    </div>
    </form>
    <br>
    <h1 class="center">Productos</h1>
    <br>
    <div class="principal">
        <% 
        for(MProducto p: lista){
                if(sab != 0){
                    if( pre != 0){
                        if( tam != 0){
                                if(sab == p.getSabor() && pre == p.getPresentacion() && tam == p.getTamano()){
                                        %>   
                                   <div class="contenedor">
                                       <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                       <br>
                                       <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                       <br>
                                       <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                       <br>
                                       <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                       <br>
                                       <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                       <br>
                                       <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                       <br>
                                       <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                           <button class="btn btn1">Añadir al carrito</button>
                                       </a>
                                   </div>
                                   <%
                                }
                            }else{
                                if(sab == p.getSabor() && pre == p.getPresentacion()){
                                     %>   
                                        <div class="contenedor">
                                            <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                            <br>
                                            <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                            <br>
                                            <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                            <br>
                                            <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                            <br>
                                            <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                            <br>
                                            <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                            <br>
                                            <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                                <button class="btn btn1">Añadir al carrito</button>
                                            </a>
                                        </div>
                                        <%
                                }
                            }
                    }else{
                         if( tam != 0){
                                if(sab == p.getSabor() && tam == p.getTamano()){
                                     %>   
                                        <div class="contenedor">
                                            <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                            <br>
                                            <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                            <br>
                                            <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                            <br>
                                            <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                            <br>
                                            <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                            <br>
                                            <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                            <br>
                                            <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                                <button class="btn btn1">Añadir al carrito</button>
                                            </a>
                                        </div>
                                        <%
                                }
                            }else{
                                if(sab == p.getSabor()){
                                     %>   
                                    <div class="contenedor">
                                        <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                        <br>
                                        <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                        <br>
                                        <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                        <br>
                                        <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                        <br>
                                        <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                        <br>
                                        <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                        <br>
                                        <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                            <button class="btn btn1">Añadir al carrito</button>
                                        </a>
                                    </div>
                                    <%
                                }
                            }
                    }
                }else{
                    if( pre != 0){
                        if( tam != 0){
                                if(pre == p.getPresentacion() && tam == p.getTamano()){
                                                                    %>   
                                       <div class="contenedor">
                                           <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                           <br>
                                           <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                           <br>
                                           <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                           <br>
                                           <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                           <br>
                                           <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                           <br>
                                           <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                           <br>
                                           <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                               <button class="btn btn1">Añadir al carrito</button>
                                           </a>
                                       </div>
                                       <%
                                }
                            }else{
                                if(pre == p.getPresentacion()){
                                     %>   
                                        <div class="contenedor">
                                            <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                            <br>
                                            <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                            <br>
                                            <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                            <br>
                                            <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                            <br>
                                            <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                            <br>
                                            <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                            <br>
                                            <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                                <button class="btn btn1">Añadir al carrito</button>
                                            </a>
                                        </div>
                                        <%
                                }
                            }
                    }else{
                         if( tam != 0){
                                if(tam == p.getTamano()){
                                     %>   
                                        <div class="contenedor">
                                            <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                            <br>
                                            <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                            <br>
                                            <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                            <br>
                                            <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                            <br>
                                            <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                            <br>
                                            <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                            <br>
                                            <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                                <button class="btn btn1">Añadir al carrito</button>
                                            </a>
                                        </div>
                                        <%
                                }
                            }else{
                              %>   
                                <div class="contenedor">
                                    <h3>Precio: <%=p.getPrecio()%> MXN</h3>
                                    <br>
                                    <h3>Stock: <%=p.getCantidad()%> Unidades</h3>
                                    <br>
                                    <h3>Sabor: <%=p.getDes_sabor()%> </h3>
                                    <br>
                                    <h3>Presentación: <%=p.getDes_presentacion()%></h3>
                                    <br>
                                    <h3>Tamaño: <%=p.getDes_tamano()%></h3>
                                    <br>
                                    <h3>Descuento: <%=p.getDes_descuento()%> %</h3>
                                    <br>
                                    <a href="anadirCarrito.jsp?id=<%=p.getId()%>">
                                        <button class="btn btn1">Añadir al carrito</button>
                                    </a>
                                </div>
                                <%
                            }
                    }
                }
            } 
        %>
    </div>
    </div>
    <div class="creditos">
        <a target="_blank" href="undefined/icons/set/close-window">Cerrar ventana icon</a> icono de <a target="_blank" href="">Icons8</a>
        <div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>
    </div>
</body>
</html>
