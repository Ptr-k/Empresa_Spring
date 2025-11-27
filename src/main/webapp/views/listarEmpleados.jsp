<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Listar Empleados</title>
    <style>
        body {
            font-family: Arial;
            margin: auto;
            text-align: center;
            background-color: #343434;
        }
        div {
            border-radius: 10px;
            box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;
            padding: 15px;
            margin: 10%;
            display: inline-block;
            vertical-align: middle;
            text-align: justify;
            background-color: #232323;
            color: white;
            text-decoration: none;
        }

        table td {
            border: 1px solid black;
            padding: 10px;
            margin: 10px;
        }

        button {
            border-radius: 10px;
            background-color: white;
            padding: 10px 15px;
            text-align: center;
            font-size: 16px;
            margin: 10px 0px;
            display: block;
            align-content: center;
            align-items: center;
        }
    </style>
</head>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${empty empleados}">
            <p>No hay empleados registrados.</p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>DNI</th>
                    <th>Sexo</th>
                    <th>Categoría</th>
                    <th>Años Trabajados</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="empleado" items="${empleados}">
                    <tr>
                        <td>${empleado.id}</td>
                        <td>${empleado.nombre}</td>
                        <td>${empleado.dni}</td>
                        <td>${empleado.sexo}</td>
                        <td>${empleado.categoria}</td>
                        <td>${empleado.anyos}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>