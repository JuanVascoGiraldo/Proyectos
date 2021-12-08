
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" language="java"%>
<!DOCTYPE html>
<html>
    <%
        HttpSession sesion = request.getSession(true);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inicio</title>
    </head>
    <body>
        <table>
            <tr>
                <td>p</td>
                <td><%=sesion.getAttribute("p")%></td>
            </tr>
            <tr>
                <td>q</td>
                <td><%=sesion.getAttribute("q")%></td>
            </tr>
            <tr>
                <td>fi</td>
                <td><%=sesion.getAttribute("fi")%></td>
            </tr>
            <tr>
                <td>n</td>
                <td><%=sesion.getAttribute("n")%></td>
            </tr>
            <tr>
                <td>e (Clave publica)</td>
                <td><%=sesion.getAttribute("e")%></td>
            </tr>
            <tr>
                <td>d (Clave privada)</td>
                <td><%=sesion.getAttribute("d")%></td>
            </tr>
            <tr>
                <td>p</td>
                <td><%=sesion.getAttribute("p")%></td>
            </tr>
        </table>
            <div>
                <form action="aciion">
                    <label>Ingresar el texto</label>
                    <input name="texto" type="text">
                    <label>Elige la accion a realizar</label>
                    <select name="accion">
                        <option value="cifrar">Cifrar</option>
                        <option value="descifrar">Descifrar</option>
                    </select>
                    <button type="submit">Seguir</button>
                </form>
            </div>
    </body>
</html>
