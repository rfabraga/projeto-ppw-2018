<%-- 
    Document   : navbar
    Created on : 10/11/2018, 18:08:26
    Author     : Pichau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-success">
    <a class="navbar-brand h1" href="#">Painel Transferências</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Abrir Navegação">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbar">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link active" href="${pageContext.request.contextPath}/">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/views/usuarios/index.jsp">Usuários</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/views/transacoes/index.jsp">Transferências</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0">
        <button class="btn btn-light my-2 my-sm-0" type="submit">Logout</button>
      </form>
    </div>
 </nav>
