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
        <title>Home</title>
        
        <c:import url="./views/include/header.jsp" />
    </head>
    <body>
        <!-- navbar -->
        <c:import url="./views/include/navbar.jsp" />
        
        <jsp:useBean id="master" scope="page" class="projetopagamento.servicos.MasterServices" />
        <h3 class="text-center">Usuários</h3>
        
        <div class="container m-top">
            <div class="row">
                <div class="col-4">
                    <div class="card">
                        <div class="card-header bg-primary">
                            Usuários
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${master.usuarios} Cadastrados</h5>
                        </div>
                    </div>
                </div>
                
                <div class="col-4">
                    <div class="card">
                        <div class="card-header bg-danger">
                            Transações
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${master.transacoes} Concluídas</h5>
                        </div>
                    </div>
                </div>
                
                <div class="col-4">
                    <div class="card">
                        <div class="card-header bg-warning">
                            Total Movimentado
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">R$ ${master.total}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- footer -->
        <c:import url="./views/include/footer.jsp" />
    </body>
</html>
