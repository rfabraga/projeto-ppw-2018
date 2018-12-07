<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cartão</title>
        
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
                            <h5>Dados do Cartão</h5>
                        </div>
                        <div class="card-body bg-light">
                            <form action="${pageContext.request.contextPath}/processaCartoes" method="POST">
                                <input type="hidden" name="acao" value="editar">
                                <input type="hidden" name="id_usu" value="${id_usu}">
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="id">ID</label>
                                            <input type="text" class="form-control" id="id" name="id" value="${cartao.id}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="numero">Número</label>
                                            <input type="text" class="form-control" id="numero" name="numero" value="${cartao.numero}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="nomeTitular">Nome Titular</label>
                                            <input type="text" class="form-control" id="nomeTitular" name="nomeTitular" value="${cartao.nomeTitular}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="dataVencimento">Data de vencimento</label>
                                            <input type="text" class="form-control" id="dataVencimento" name="dataVencimento" value="${cartao.dataVencimento}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cvv">CVV</label>
                                            <input type="text" class="form-control" id="cvv" name="cvv" value="${cartao.cvv}">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="cvv">Bandeira</label>
                                            <input type="text" class="form-control" id="bandeira" name="bandeira" value="${cartao.cvv}">
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


