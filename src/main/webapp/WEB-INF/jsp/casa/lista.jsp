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
		
		<c:if test="${empty casas}">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
				Nenhuma casa cadastrada ainda.
			</div>
		</div>
		</c:if>
		
		<h2 class="text-center sub-tit"><i class="fa-solid fa-house"></i> Lista de casas</h2>
		
		
			<div class="row py-3">
				<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center">
					<a href="cadastro-casa"><button class="btn-dark"><i class="fa-sharp fa-solid fa-plus"></i> Cadastrar nova casa</button></a>
				</div>
			</div>
			
		
		<table>
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Codigo</th>
					<th>Valor</th>
					<th>Possui quintal</th>
					<th>Disponivel pra pronta entrega?</th>
					<th>Tamanho da casa</th>
					<th>Cor da casa</th>
			      	<c:if test="${usuario.cargo == 'administrador'}">		      
				      	<th></th>		
			      	</c:if>	
				</tr>
			</thead>
				
			<tbody>
				<c:forEach var="list" items="${casas}">
				<tr>
					<th>${list.id}</th>
					<th>COD ${list.codigo}</th>					
					<th>R$ ${list.valor}</th>

					<c:if test="${list.quintal == 'true'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.quintal == 'false'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>
					
					<c:if test="${list.prontaentrega == 'Sim'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.prontaentrega == 'Não'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>

					<th>${list.tamanho}</th>
					<th>${list.cor}</th>

					<c:if test="${usuario.cargo == 'administrador'}">
						<th class="alerta text-center"><a href="/casa/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>	
			
		</table>
	
	</div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
