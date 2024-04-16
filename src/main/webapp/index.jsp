<%-- 
    Document   : index
    Created on : 15 abr. de 2024, 23:20:11
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.crud_seminarios.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("seminarios") == null) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        session.setAttribute("seminarios", estudiantes);
    }


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/index.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <header><h1>Listado de Inscritos</h1></header>
        <main>
            <a class="nuevo" href="servRegistro?op=create">Nuevo</a>
            <table border="1" cellspacing="0">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Turno</th>
                        <th>Seminarios</th>
                        <th colspan="2">Operaciones</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="estudiante" items="${sessionScope.seminarios}" >
                        <tr>
                            <td>${estudiante.getId()}</td>
                            <td>${estudiante.getFecha()}</td>
                            <td>${estudiante.getNombre()}</td>
                            <td>${estudiante.getApellidos()}</td>
                            <td>${estudiante.getTurno()}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${estudiante.getSeminarios().isEmpty()}">
                                        sin cursos
                                    </c:when>
                                    <c:otherwise>
                                        ${estudiante.getSeminarios()}
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a href="servRegistro?op=update&id=${estudiante.getId()}"><img src="./images//edit.png" alt="image edit"/></a></td>
                            <td><a href="servRegistro?op=delete&id=${estudiante.getId()}"><img src="./images/erase.png" alt="image erase"/></a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </main>

    </body>
</html>
