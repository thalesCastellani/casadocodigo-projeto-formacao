<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:url value="/" var="contextPath" />

<tags:pageTemplate titulo="Pedidos">

	<jsp:body>
	
	<div class="container">
		<h1>Lista de Pedidos atuais</h1>
	
			<table class="table table-bordered table-striped table-hover">
				<thead>
					<th>ID</th>
					<th>Valor</th>
					<th>Data Pedido</th> 
					<th>Títulos</th>
				</thead>
				<c:forEach items="${pedidos }" var="pedido">
					<tr>
						<td>${pedido.id }</td>
						<td>${pedido.valor }</td>
						<td><fmt:formatDate	value="${pedido.data.time }" pattern="dd/MM/yyyy"/></td>
						<td>
							<c:forEach items="${pedido.produtos }" var="produto">
								${produto.titulo } 
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	
</jsp:body>

</tags:pageTemplate>