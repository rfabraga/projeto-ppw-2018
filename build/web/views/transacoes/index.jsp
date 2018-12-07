<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Transações</title>
        
        <c:import url="../include/header.jsp" />
    </head>
    <body>
        <!-- navbar -->
        <c:import url="../include/navbar.jsp" />
        
        <h3 class="text-center m-top">Transações</h3>
        
        <div class="container-fluid m-top">
            <div class="row">
                <div class="col-8 offset-2">
                    
                    <a role="button" class="btn btn-success" href="${pageContext.request.contextPath}/views/transacoes/cadastrar.jsp">Novo</a>
                    
                     <table class="table">
                        <thead class="bg-secondary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Data</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Remetente</th>
                                <th scope="col">Cartão</th>
                                <th scope="col">Destinatário</th>
                                <th scope="col">Conta Beneficiada</th>
                                <th scope="col" width="10%"></th>
                                <th scope="col" width="10%"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <jsp:useBean id="servicos" scope="page" class="projetopagamento.servicos.TransacaoServices"  />
                            
                            <c:forEach items="${servicos.todos}" var="transacao">
                                <tr class="bg-light">
                                    <th scope="row">${transacao.id}</th>
                                    <td>${transacao.data}</td>
                                    <td>${transacao.valor}</td>
                                    <td>${transacao.remetente.nome}</td>
                                    <td>${transacao.cartao.numero}</td>
                                    <td>${transacao.destinatario.nome}</td>
                                    <td>${transacao.contaBeneficiada.numero}</td>
                                    <td>
                                        <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/processaTransacoes?acao=prepEdicao&id=${transacao.id}">Editar</a>
                                    </td>
                                    <td>
                                        <a role="button" class="btn btn-danger" href="${pageContext.request.contextPath}/processaTransacoes?acao=excluir&id=${transacao.id}">Excluir</a>
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
