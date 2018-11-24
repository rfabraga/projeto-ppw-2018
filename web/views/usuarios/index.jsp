<%-- 
    Document   : master
    Created on : 09/11/2018, 22:00:15
    Author     : Rafael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Usuários</title>
        
        <c:import url="../include/header.jsp" />
    </head>
    <body>
        <!-- navbar -->
        <c:import url="../include/navbar.jsp" />
        
        <h3 class="text-center m-top">Usuários</h3>
        
        <div class="container-fluid m-top">
            <div class="row">
                <div class="col-8 offset-2">
                    
                    <a role="button" class="btn btn-success" href="${pageContext.request.contextPath}/views/usuarios/cadastrar.jsp">Novo</a>
                    
                     <table class="table">
                        <thead class="bg-secondary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                                <th scope="col" width="10%"></th>
                                <th scope="col" width="10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-light">
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                                <td>
                                    <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/views/usuarios/editar.jsp">Editar</a>
                                </td>
                                <td>
                                    <a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/views/usuarios/excluir">Excluir</a>
                                </td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                                <td>
                                    <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/views/usuarios/editar.jsp">Editar</a>
                                </td>
                                <td>
                                    <a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/views/usuarios/excluir">Excluir</a>
                                </td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                                <td>
                                    <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/views/usuarios/editar.jsp">Editar</a>
                                </td>
                                <td>
                                    <a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/views/usuarios/excluir">Excluir</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <!-- footer -->
        <c:import url="../include/footer.jsp" />
    </body>
</html>
