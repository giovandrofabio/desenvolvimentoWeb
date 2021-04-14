<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ attribute name="title" required="true"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Exibr menu">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="<c:url value="/"/>" >Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">
          Fazenda
        </a>
        <div class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
          <a class="dropdown-item" href="<c:url value="/fazenda"/>" >Cadastrar</a>
          <a class="dropdown-item" href="<c:url value="/listarfazendas"/>" >Listar</a>
        </div>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDarkDropdownMenuLink" role="button" data-toggle="dropdown" aria-expanded="false">
          Animal
        </a>
        <div class="dropdown-menu dropdown-menu-dark" aria-labelledby="navbarDarkDropdownMenuLink">
          <a class="dropdown-item" href="<c:url value="/animal"/>" >Cadastrar</a>
          <a class="dropdown-item" href="<c:url value="/listaranimais"/>" >Listar</a>
        </div>
      </li>
    </ul>
  </div>
  </div>
  <div class="container-fluid">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Exibr menu">
    <span class="navbar-toggler-icon"></span>
  </button>
</nav>
<div class="col-sm-12">
    <h3><c:out value="${title}" /></h3>
    <hr />
</div>