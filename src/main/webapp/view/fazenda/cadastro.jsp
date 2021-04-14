<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Cadastrar nova Fazenda">
    <form name="cadFazenda" action="/fazenda" method="post" >
        <div class="form-group row">
            <label class="col-sm-3 text-right"> Código: </label>
            <input class="form-control col-sm-9" readonly name="codigo" value="<c:out value="${fazenda.codigo}" />" />
        </div>

        <div class="form-group row">
            <label class="col-sm-3 text-right"> Descrição: </label>
            <input class="form-control col-sm-9" name="descricao" placeholder="Informe o nome da Fazenda" value="<c:out value="${fazenda.descricao}" />" />
        </div>

        <div class="form-group col-sm-12 text-right">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</tag:maintemplate>