<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<tag:maintemplate title="Cadastrar novo Animal">
    <form name="cadAnimal" action="/animal" method="post" >
        <div class="form-group row">
            <label class="col-sm-3 text-right"> Código: </label>
            <input class="form-control col-sm-9" readonly name="codigo" value="<c:out value="${animal.codigo}" />" />
        </div>

        <div class="form-group row">
            <label class="col-sm-3 text-right"> Nome do Animal: </label>
            <input class="form-control col-sm-9" name="descricao" placeholder="Informe o nome do Animal" value="<c:out value="${animal.descricao}" />" />
        </div>

         <div class="form-group row">
                    <label class="col-sm-3 text-right">Fazenda: </label>
                    <select class="form-control col-sm-9" aria-label="Default select example" name='fazenda'>
                         <c:forEach var="fazenda" items="${fazendas}">
                            <option value="<c:out value="${fazenda.codigo}" />"
                                <c:if test="${fazenda.codigo == animal.fazenda.codigo}">
                                    selected='selected'
                                </c:if>
                            ><c:out value="${fazenda.descricao}" /></option>
                         </c:forEach>
                   </select>
           </div>


        <div class="form-group col-sm-12 text-right">
            <button type="submit" class="btn btn-primary">Enviar</button>
        </div>
    </form>
</tag:maintemplate>