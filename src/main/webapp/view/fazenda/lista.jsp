<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>



<tag:maintemplate title="Lista de fazendas">

<div class="d-grid gap-2 d-md-flex justify-content-md-end">
   <a  href="<c:url value="/animal"/>" class="btn btn-primary me-md-2">Novo</a>
</div>
    </p>
    <table class="table table-dark table-striped">
        <thead>
            <tr>
              <th scope="col">Cod. Fazenda</th>
              <th scope="col">Fazenda</th>
              <th scope="col">-</th>
              <th scope="col">-</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="fazenda" items="${fazendas}">
                <tr>
                    <td><c:out value="${fazenda.codigo}" /></td>
                    <td><c:out value="${fazenda.descricao}" /></td>
                    <td><a href="<c:url value="/fazenda?codigo=${fazenda.codigo}"/>"><button type="submit" class="btn btn-warning">Editar</button></a></td>
                    <td><a href="<c:url value="/excluirfazenda?codigo=${fazenda.codigo}"/>"><button type="submit" class="btn btn-danger">Excluir</button></a></td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>

</tag:maintemplate>