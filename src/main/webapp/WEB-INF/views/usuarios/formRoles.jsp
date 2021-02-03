<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Cadastro de Permissões">

<jsp:body>
	
	<div class="container">
		<h1>Cadastro de Permissões para ${usuario.nome }</h1>
		<form:form action="${s:mvcUrl('UC#atualizarRoles').build() }" method="post" commandName="usuario">
			<div class="form-group">
				<label>Permissões</label>
				<form:checkboxes items="${roles }" path="roles" />
				<form:errors path="roles" />
			</div>
			
			<button type="submit" class="btn btn-primary">Atualizar</button>
		</form:form>
	</div>
	
</jsp:body>

</tags:pageTemplate>