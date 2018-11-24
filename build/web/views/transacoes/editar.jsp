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
        <title>Edição de Transação</title>
        
        <c:import url="../include/header.jsp" />
    </head>
    <body>
        <!-- navbar -->
        <c:import url="../include/navbar.jsp" />
        
        <div class="container-fluid m-top">
            <div class="row">
                <div class="col-6 offset-3">
                  
                    <div class="card">
                        <div class="card-header bg-secondary text-center">
                            <h5>Dados da Transação</h5>
                        </div>
                        <div class="card-body bg-light">
                            <form action="" method="POST">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="data_trans">Data</label>
                                            <input type="text" class="form-control" id="data_trans" name="data_trans" placeholder="Data">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="valor_trans">Valor</label>
                                            <input type="text" class="form-control" id="valor_trans" name="valor_trans" placeholder="Valor">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="remetente_trans">Remetente</label>
                                            <input type="text" class="form-control" id="remetente_trans" name="remetente_trans" placeholder="Remetente">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="destinatario_trans">Destinatário</label>
                                            <input type="text" class="form-control" id="destinatario_trans" name="destinatario_trans" placeholder="Destinatário">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="beneficiada_trans">Conta Beneficiada</label>
                                            <input type="text" class="form-control" id="beneficiada_trans" name="beneficiada_trans" placeholder="Conta Beneficiada">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cartao_trans">Cartão Utilizado</label>
                                            <input type="text" class="form-control" id="cartao_trans" name="cartao_trans" placeholder="Cartão Utilizado">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-3 offset-9">
                                        <button type="submit" class="btn btn-success btn-block">Editar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
        
        <!-- footer -->
        <c:import url="../include/footer.jsp" />
    </body>
</html>
