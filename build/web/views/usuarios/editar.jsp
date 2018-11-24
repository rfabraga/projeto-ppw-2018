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
        <title>Edição de Usuário</title>
        
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
                            <form action="" method="POST">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nome_usuario">Nome</label>
                                            <input type="text" class="form-control" id="nome_usuario" name="nome_usuario" placeholder="Nome">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="sobrenome_usuario">Sobrenome</label>
                                            <input type="text" class="form-control" id="sobrenome_usuario" name="sobrenome_usuario" placeholder="Sobrenome">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cpf_usuario">CPF</label>
                                            <input type="text" class="form-control" id="cpf_usuario" name="cpf_usuario" placeholder="CPF">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nascimento_usuario">Data de Nascimento</label>
                                            <input type="text" class="form-control" id="nascimento_usuario" name="nascimento_usuario" placeholder="Data de Nascimento">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="email_usuario">E-mail</label>
                                            <input type="text" class="form-control" id="email_usuario" name="email_usuario" placeholder="E-mail">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="senha_usuario">Senha</label>
                                            <input type="text" class="form-control" id="senha_usuario" name="senha_usuario" placeholder="Senha">
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
                                <th scope="col">Nome</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-light">
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
                            </tr>
                        </tbody>
                    </table>
                  
                    
                    <h5 class="text-center m-top">Cartões</h5>
                    
                    <table class="table">
                        <thead class="bg-secondary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Last</th>
                                <th scope="col">Handle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="bg-light">
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>@mdo</td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">2</th>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>@fat</td>
                            </tr>
                            <tr class="bg-light">
                                <th scope="row">3</th>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>@twitter</td>
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
