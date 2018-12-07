<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Transação</title>
        
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
                            <form action="${pageContext.request.contextPath}/processaTransacoes" method="POST">
                                <input type="hidden" name="acao" value="cadastrar">
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="data">Data</label>
                                            <input type="text" class="form-control" id="data" name="data" placeholder="Data">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="valor">Valor</label>
                                            <input type="text" class="form-control" id="valor" name="valor" placeholder="Valor">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <jsp:useBean id="usuarios" scope="page" class="projetopagamento.servicos.UsuarioServices"  />
                            
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="remetente">Remetente</label>
                                            <select class="form-control" id="remetente" name="remetente">
                                                <option value="">Selecione...</option>
                                                <c:forEach items="${usuarios.todos}" var="usuario">
                                                    <option value="${usuario.id}">${usuario.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="destinatario">Destinatário</label>
                                            <select class="form-control" id="destinatario" name="destinatario">
                                                <option value="">Selecione...</option>
                                                <c:forEach items="${usuarios.todos}" var="usuario">
                                                    <option value="${usuario.id}">${usuario.nome}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <jsp:useBean id="contas" scope="page" class="projetopagamento.servicos.ContaServices"  />
                                <jsp:useBean id="cartoes" scope="page" class="projetopagamento.servicos.CartaoServices"  />
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="beneficiada">Conta Beneficiada</label>
                                            <select class="form-control" id="beneficiada" name="beneficiada">
                                                <option value="">Selecione...</option>
                                                <c:forEach items="${contas.todos}" var="conta">
                                                    <option value="${conta.id}">${conta.numero}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cartao">Cartão Utilizado</label>
                                            <select class="form-control" id="cartao" name="cartao">
                                                <option value="">Selecione...</option>
                                                <c:forEach items="${cartoes.todos}" var="cartao">
                                                    <option value="${cartao.id}">${cartao.numero}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-3 offset-9">
                                        <button type="submit" class="btn btn-success btn-block">Cadastrar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                
        <!-- footer -->
        <c:import url="../include/footer.jsp" />
    </body>
</html>
