<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuário</title>
        
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
                            <h5>Dados do Usuário</h5>
                        </div>
                        <div class="card-body bg-light">
                            <form action="${pageContext.request.contextPath}/processaUsuarios" method="POST">
                                <input type="hidden" name="acao" value="cadastrar">
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nome">Nome</label>
                                            <input type="text" class="form-control" id="nome_usuario" name="nome" placeholder="Nome">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="sobrenome">Sobrenome</label>
                                            <input type="text" class="form-control" id="sobrenome_usuario" name="sobrenome" placeholder="Sobrenome">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cpf">CPF</label>
                                            <input type="text" class="form-control" id="cpf_usuario" name="cpf" placeholder="CPF">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nascimento">Data de Nascimento</label>
                                            <input type="text" class="form-control" id="nascimento_usuario" name="nascimento" placeholder="Data de Nascimento">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="email">E-mail</label>
                                            <input type="text" class="form-control" id="email_usuario" name="email" placeholder="E-mail">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="senha">Senha</label>
                                            <input type="text" class="form-control" id="senha_usuario" name="senha" placeholder="Senha">
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
