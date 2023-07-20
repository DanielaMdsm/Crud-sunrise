<%-- 
    Document   : updateUsers
    Created on : 16 jul. 2023, 02:00:30
    Author     : danie
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <body> 
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
            $(document).ready(function () {
                $('.editar-usuario').click(function () { 
                    var id = $(this).data('id');
                    var nombre = $(this).data('nombre');
                    var apellido = $(this).data('apellido');
                    var email = $(this).data('email');
                    var consulta = $(this).data('consulta');
                    $('#id').val(id);
                    $('#nombre').val(nombre);
                    $('#apellido').val(apellido);
                    $('#mail').val(email);
                    $('#consulta').val(consulta);
                });
            });
        </script>
        <div class="modal fade" id="modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modificar usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div> 

                    <form id="updateUsuario" action="./admin?accion=update"
                          method="post" class="was-validated"> 
                        <input type="hidden" name="accion" value="update">
                        <input type="hidden" id="id" name="id" value="${usuario.id}">
                        <div class="modal-body">
                            <div class="row">
                                <div class="col-sm-6 mb-3">
                                    <label for="nombre" class="form-label">Nombre</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" value="${usuario.name}" required>
                                </div>
                                <div class="col-sm-6 mb-3">
                                    <label for="apellido" class="form-label">Apellido</label>
                                    <input type="text" class="form-control" id="apellido" name="apellido" value="${usuario.lastName}"required>
                                </div>
                                <div class="col-sm-6 mb-3">
                                    <label for="mail" class="form-label">Email</label>
                                    <input type="text" class="form-control" id="mail" name="email" value="${usuario.email}"required>
                                </div>

                                <div class="col-12 mb-3">
                                    <div class="mb-2">
                                        <textarea class="form-control" id= "consulta"name="consulta" rows="10" >${usuario.consultation}</textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                            <button type="submit" class="btn btn-success">Modificar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
        
    </body>
</html>
