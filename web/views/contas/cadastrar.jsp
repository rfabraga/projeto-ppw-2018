<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Conta</title>
        
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
                            <h5>Dados da Conta</h5>
                        </div>
                        <div class="card-body bg-light">
                            <form action="${pageContext.request.contextPath}/processaContas" method="POST">
                                <input type="hidden" name="acao" value="cadastrar">
                                <input type="hidden" name="id_usu" value="${id_usu}">
                                
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="numero">Número</label>
                                            <input type="text" class="form-control" id="numero" name="numero" placeholder="Número">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="agencia">Agência</label>
                                            <input type="text" class="form-control" id="agencia" name="agencia" placeholder="Agência">
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

