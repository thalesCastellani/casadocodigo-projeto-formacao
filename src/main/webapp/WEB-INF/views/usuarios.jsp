<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Usuarios">

	<jsp:body>
	
	<div class="container">
		
		<a href="${s:mvcUrl('UC#form').build() }">Novo usuário</a>
		<h1>Lista de Usuários</h1>
		<p> ${sucesso} </p>
	
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<th>Nome</th>
					<th>Email</th>
					<th>Roles</th>
					<th></th>
				</thead>
				<c:forEach items="${usuarios }" var="usuario">
					<tr>
						<td>${usuario.nome }</td>
						<td>${usuario.email }</td>
						<td>${usuario.roles }</td>
						<td><a href="${s:mvcUrl('UC#atualizarRoles').build() }" class="Button">+</a></td>
					</tr>
				</c:forEach>
			</table>
	</div>
	
</jsp:body>

</tags:pageTemplate>