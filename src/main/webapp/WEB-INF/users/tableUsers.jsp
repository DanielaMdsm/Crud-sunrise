<%-- 
    Document   : tableUsers
    Created on : 15 jul. 2023, 20:28:47
    Author     : danie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
        <title>Sunrise-Admin</title>
    </head>
    <body>

        <div class="container-fluid row d-flex justify-content-center align-items-center">
            <div class="table-responsive"  style="overflow-x: hidden;">
                <table class="table caption-top table-bordered ms-2">
                    <caption>Lista de usuarios</caption>
                    <thead>
                        <tr class="table-dark">
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>Consulta</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
                        <c:forEach items="${listaUsuarios}" var="usuario">
                            <tr>
                                <td>${usuario.id}</td>
                                <td>${usuario.name}</td>
                                <td>${usuario.lastName}</td>
                                <td>${usuario.email}</td>
                                <td>${usuario.consultation}</td>
                                <td> <a href="#" class="btn btn-success editar-usuario" data-id="${usuario.id}" data-nombre="${usuario.name}" data-apellido="${usuario.lastName}" data-email="${usuario.email}" data-consulta="${usuario.consultation}"
                                        data-bs-toggle="modal" data-bs-target="#modal">
                                        Modificar</a> 
                                        <jsp:include page="updateUsers.jsp"/>
                                    <a href="./admin?accion=eliminar&id=${usuario.id}" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr> 
                        </c:forEach> 
                    </tbody>
                </table> 
            </div>
            
            <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
                    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
                    integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
            crossorigin="anonymous"></script>

    </body>
</html>
