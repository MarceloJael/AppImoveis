<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container-fluid">
    	<div class="py-3"> 		
			
			<c:if test="${not empty mensagem}">		
			<div class="row py-3">
				<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta-correto">
					${mensagem}
				</div>
			</div>		
			</c:if>
			
			<c:if test="${empty usuarios}">
			<div class="row py-3">
				<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
					Não encontrado usuários cadastrados.
				</div>
			</div>
			</c:if>
			
			<h2 class="text-center sub-tit">Lista de usuarios</h2>

			
			<table>
			
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Telefone</th>
						<th>CEP</th>
						<th>Logradouro</th>
						<th>Bairro</th>
						<th>Cidade</th>
						<th>UF</th>
						<th>Cargo</th>
						<th>Clientes</th>
						<th>Imoveis</th>
						<th>Pedidos</th>
				      	<c:if test="${usuario.cargo == 'administrador'}">		      
					      	<th></th>		
				      	</c:if>	
					</tr>
				</thead>
				

				
				<tbody>
					<c:forEach var="list" items="${usuarios}">
					<tr>
						<th>${list.id}</th>
						<th>${list.nome}</th>
						<th>${list.email}</th>
						<th>${list.telefone}</th>
						<th>${list.cep}</th>
						<th>${list.logradouro}</th>
						<th>${list.bairro}</th>
						<th>${list.localidade}</th>
						<th>${list.uf}</th>
						<th>${list.cargo}</th>
						<th>${list.clientes.size()}</th>
						<th>${list.imoveis.size()}</th>
						<th>${list.pedidos.size()}</th>
						<c:if test="${usuario.cargo == 'administrador' and list.id == usuario.id}">
							<th class="alerta-correto text-center"><i class="fa-sharp fa-solid fa-user"></i> USER LOGADO</th>
						</c:if>
						<c:if test="${usuario.cargo == 'administrador' and list.id != usuario.id}">
							<th class="alerta text-center"><a href="/usuario/${list.id}/excluir"><i class="fa-sharp fa-solid fa-trash"></i> Excluir</a></th>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>	
			
			</table>
			
			<c:if test="${not empty usuarios}">
			<div class="row py-3">
				<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto py-2 text-center alerta-info">
					Numero de usuários: ${usuarios.size()}
				</div>
			</div>
			</c:if>
    	
    	</div>
    </div>
    
    <c:import url="/WEB-INF/jsp/footer.jsp"/>