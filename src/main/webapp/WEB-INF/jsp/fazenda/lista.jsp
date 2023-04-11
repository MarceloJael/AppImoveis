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
		
		<c:if test="${empty fazendas}">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
				Nenhuma fazenda cadastrada ainda.
			</div>
		</div>
		</c:if>
		
		<h2 class="text-center sub-tit"><i class="fa-solid fa-tree-city"></i> Lista de fazendas</h2>
		
		
			<div class="row py-3">
				<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center">
					<a href="cadastro-fazenda"><button class="btn-dark"><i class="fa-sharp fa-solid fa-plus"></i> Cadastrar nova fazenda</button></a>
				</div>
			</div>
		
		<table>
		
			<thead>
				<tr>
					<th>ID</th>
					<th>Codigo</th>
					<th>Valor</th>
					<th>Possui estabulo</th>
					<th>Disponivel pra pronta entrega?</th>
					<th>Tamanho da fazenda</th>
					<th>tipo de plantacao</th>
			      	<c:if test="${usuario.cargo == 'administrador'}">		      
				      	<th></th>		
			      	</c:if>	
				</tr>
			</thead>
				
			<tbody>
				<c:forEach var="list" items="${fazendas}">
				<tr>
					<th>${list.id}</th>
					<th>COD ${list.codigo}</th>					
					<th>R$ ${list.valor}</th>

					<c:if test="${list.estabulo == 'true'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.estabulo == 'false'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>
					
					<c:if test="${list.prontaentrega == 'Sim'}">
						<th class="seraFinanciamento">Sim</th>
					</c:if>
					<c:if test="${list.prontaentrega == 'Não'}">
						<th class="naoSeraFinanciamento">Não</th>
					</c:if>

					<th>${list.hectares}</th>
					<th>${list.tipoplantacao}</th>

					<c:if test="${usuario.cargo == 'administrador'}">
						<th class="alerta text-center"><a href="/casa/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
					</c:if>
				</tr>
				</c:forEach>
			</tbody>	
			
		</table>
			
		</table>
	
	</div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
