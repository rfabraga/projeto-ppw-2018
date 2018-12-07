<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de Usuário</title>
        
        <c:import url="../include/header.jsp" />
    </head>
    <body>
        <!-- navbar -->
        <c:import url="../include/navbar.jsp" />
        
        <div class="container-fluid m-top">
            <div class="row">
                <div class="col-1 offset-3">
                    <a role="button" class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/processaContas?acao=prepCadastro&id_usu=${usuario.id}">Nova Conta</a>
                </div>
                
                <div class="col-1">
                    <a role="button" class="btn btn-primary btn-block" href="${pageContext.request.contextPath}/processaCartoes?acao=prepCadastro&id_usu=${usuario.id}">Novo Cartão</a>
                </div>
            </div>
                
            <br>
            
            <div class="row">
                <div class="col-6 offset-3">
                  
                    <div class="card">
                        <div class="card-header bg-secondary text-center">
                            <h5>Dados do Usuário</h5>
                        </div>
                        <div class="card-body bg-light">
                            <form action="${pageContext.request.contextPath}/processaUsuarios" method="POST">
                                <input type="hidden" name="acao" value="editar">
                                <input type="hidden" name="id" value="${usuario.id}">
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nome">Nome</label>
                                            <input type="text" class="form-control" id="nome" name="nome" value="${usuario.nome}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="sobrenome">Sobrenome</label>
                                            <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${usuario.sobrenome}">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cpf">CPF</label>
                                            <input type="text" class="form-control" id="cpf" name="cpf" value="${usuario.cpf}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="data_nascimento">Data de Nascimento</label>
                                            <input type="text" class="form-control" id="data_nascimento" name="data_nascimento" value="${usuario.dataNascimento}">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="email">E-mail</label>
                                            <input type="text" class="form-control" id="email" name="email" value="${usuario.email}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="senha">Senha</label>
                                            <input type="password" class="form-control" id="senha" name="senha" value="${usuario.senha}">
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
                    
                    <h5 class="text-center m-top">Contas</h5>

                    <table class="table">
                        <thead class="bg-secondary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Número</th>
                                <th scope="col">Agência</th>
                                <th scope="col" width="10%"></th>
                            </tr>
                        </thead>

                        <c:forEach items="${usuario.contas}" var="conta">
                            <tbody>
                                <tr class="bg-light">
                                    <th scope="row">${conta.id}</th>
                                    <td>${conta.numero}</td>
                                    <td>${conta.agencia}</td>
                                    <td>
                                        <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/processaContas?acao=prepEdicao&id=${conta.id}&id_usu=${usuario.id}">Editar</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>

                    <h5 class="text-center m-top">Cartões</h5>
                    
                    <table class="table">
                        <thead class="bg-secondary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Número</th>
                                <th scope="col">Nome do Titular</th>
                                <th scope="col">Data de Vencimento</th>
                                <th scope="col">CVV</th>
                                <th scope="col">Bandeira</th>
                                <th scope="col" width="10%"></th>
                            </tr>
                        </thead>
                        <c:forEach items="${usuario.cartoes}" var="cartao">
                            <tbody>
                                <tr class="bg-light">
                                    <th scope="row">${cartao.id}</th>
                                    <td>${cartao.numero}</td>
                                    <td>${cartao.nomeTitular}</td>
                                    <td>${cartao.dataVencimento}</td>
                                    <td>${cartao.cvv}</td>
                                    <td>${cartao.bandeira}</td>
                                    <td>
                                        <a role="button" class="btn btn-primary" href="${pageContext.request.contextPath}/processaCartoes?acao=prepEdicao&id=${cartao.id}&id_usu=${usuario.id}">Editar</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        
        <!-- footer -->
        <c:import url="../include/footer.jsp" />
    </body>
</html>
