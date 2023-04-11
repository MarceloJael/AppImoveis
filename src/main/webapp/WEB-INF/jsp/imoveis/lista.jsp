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
		
		<c:if test="${empty imoveis}">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
				Não encontrado imoveis cadastrados.
			</div>
		</div>
		</c:if>
		
		<h2 class="text-center sub-tit">Lista de imoveis</h2>
	
		<table>
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Codigo</th>
					<th>Tipo</th>
					<th>Valor</th>
					<th>Usuario</th>
			      	<c:if test="${usuario.cargo == 'administrador'}">		      
				      	<th></th>		
			      	</c:if>	
				</tr>
			</thead>
				
			<tbody>
				<c:forEach var="list" items="${imoveis}">
				<tr>
					<th>${list.id}</th>
					<th>COD ${list.codigo}</th>
					
					<c:if test="${list.tipo == 'Casa'}">
						<th><i class="fa-solid fa-house"></i> Casa</th>
					</c:if>
					
					<c:if test="${list.tipo == 'Apartamento'}">
						<th><i class="fa-sharp fa-solid fa-building"></i> Apartamento</th>
					</c:if>
					
					<c:if test="${list.tipo == 'Fazenda'}">
						<th><i class="fa-solid fa-tree-city"></i> Fazenda</th>
					</c:if>
					
					<th>R$ ${list.valor}</th>
					<th>${list.usuario.nome}</th>
					<c:if test="${usuario.cargo == 'administrador'}">
						<th class="alerta text-center"><a href="/imovel/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>	
			
		</table>
	
	</div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>