<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    
		<c:if test="${not empty mensagem}">		
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta-correto">
				${mensagem}
			</div>
		</div>		
		</c:if>
		
		<c:if test="${empty clientes}">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
				N�o encontrado clientes cadastrados.
			</div>
		</div>
		</c:if>
		
		<h2 class="text-center sub-tit">Lista de usuarios</h2>
		
		<div class="row py-3">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center">
				<a href="cadastro-cliente"><button class="btn-dark"><i class="fa-sharp fa-solid fa-plus"></i> Cadastrar novo cliente</button></a>
			</div>
		</div>
		
		<table>
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>CPF</th>
					<th>Usuario que cadastrou</th>
			      	<c:if test="${usuario.cargo == 'administrador'}">		      
				      	<th></th>		
			      	</c:if>	
				</tr>
			</thead>
				
			<tbody>
				<c:forEach var="list" items="${clientes}">
				<tr>
					<th>${list.id}</th>
					<th>${list.nome}</th>
					<th>${list.email}</th>
					<th>${list.cpf}</th>
					<th>${list.usuario.nome}</th>
					<c:if test="${usuario.cargo == 'administrador'}">
						<th class="alerta text-center"><a href="/cliente/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>	
			
		</table>
	
	</div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
