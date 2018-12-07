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
                                <th scope="col">Sobrenome</th>
                                <th scope="col">CPF</th>
                                <th scope="col">Data de Nascimento</th>
                                <th scope="col">E-mail</th>
                                <th scope="col" width="10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <jsp:useBean id="servicos" scope="page" class="projetopagamento.servicos.UsuarioServices" />
                            
                            <c:forEach items="${servicos.todos}" var="usuario">
                                <tr class="bg-light">
                                    <th scope="row">${usuario.id}</th>
                                    <td>${usuario.nome}</td>
                                    <td>${usuario.sobrenome}</td>
                                    <td>${usuario.cpf}</td>
                                    <td>${usuario.dataNascimento}</td>
                                    <td>${usuario.email}</td>
                                    <td>
                                        <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/processaUsuarios?acao=prepEdicao&id=${usuario.id}">Editar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <!-- footer -->
        <c:import url="../include/footer.jsp" />
    </body>
</html>
