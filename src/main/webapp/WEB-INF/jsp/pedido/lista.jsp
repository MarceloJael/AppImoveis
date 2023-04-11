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
		
		<c:if test="${empty pedidos}">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
				Não encontrado pedido cadastrado.
			</div>
		</div>
		</c:if>
		
		<h2 class="text-center sub-tit">Lista de pedidos</h2>
		
		<div class="row py-3">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center">
				<a href="cadastro-pedido"><button class="btn-dark"><i class="fa-sharp fa-solid fa-plus"></i> Cadastrar novo pedido</button></a>
			</div>
		</div>
		
		<table>
			
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Será financiamento?</th>
					<th>Deseja pronta entrega?</th>
					<th>Data</th>
					<th>Qual cliente</th>
					<th>Qual imovel</th>
			      	<c:if test="${usuario.cargo == 'administrador'}">		      
				      	<th></th>		
			      	</c:if>	
				</tr>
			</thead>
				
			<tbody>
				<c:forEach var="list" items="${pedidos}">
				<tr>
					<th>${list.id}</th>
					<th>${list.descricao}</th>
					
					<c:if test="${list.financiamento == 'true'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.financiamento == 'false'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>
					
					<c:if test="${list.prontaentrega == 'Sim'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.prontaentrega == 'Não'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>
									
					<th>${list.data}</th>
					<th>${list.cliente.nome}</th>
					<th>${list.imovelDesejado}</th>
					<c:if test="${usuario.cargo == 'administrador'}">
						<th class="alerta text-center"><a href="/pedido/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>	
			
		</table>
	
	</div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
