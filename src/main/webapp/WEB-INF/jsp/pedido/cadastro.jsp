<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row text-center">
    		
    		<div class="col-12">
    			<h2 class="text-center sub-tit">Cadastrar pedido</h2>
    		</div>
    	
    		<div class="p-3 m-3 text-center col-12">
    		
    		
    		<c:if test="${empty imoveis or empty clientes}">
    		
    			<c:if test="${empty imoveis}">
    		
	    			<div class="row">
	    				<div class="col-xl-8 col-lg-8 col-sm-12 col-md-12 p-2 mx-auto my-2 text-center alerta">
	    				
	    					Não é possivel fazer um pedido pois não tem imoveis cadastrado.
	    				
	    				</div>
	    			</div>
	    		</c:if>
	    		
    			<c:if test="${empty clientes}">
    		
	    			<div class="row">
	    				<div class="col-xl-12 col-lg-12 col-sm-12 col-md-12 p-2 mx-auto my-2 text-center alerta">
	    				
	    					Não é possivel fazer um pedido pois não tem clientes cadastrado.
	    				
	    				</div>
	    			</div>
	    		</c:if>
	    		
	    	</c:if>
	    	
	    	<c:if test="${not empty imoveis and not empty clientes}">
	    	  					
				<form method="post" action="/incluir-pedido">
					<div class="row p-2">
				 					
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Descrição do pedido</label> <br>
							<input type="text" placeholder="Digite a descrição do pedido" id="descricao" name="descricao" required>
						</div>
						
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Deseja realizar financiamento:</label> <br>
							Sim <input type="checkbox" value="true" id="financiamento" name="financiamento" class="input-checkbox"><br>
						</div>
						
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Quer pra pronta entrega:</label> <br>
							<select name="prontaentrega">
								<option value="Sim" selected >Sim</option>
								<option value="Não">Não</option>
							</select>
						</div>
				 					 					
	 					<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">~
	 					
	 						<label>Qual cliente</label> <br>
							<select name="cliente" required>
								<c:forEach var="list" items="${clientes}">
									<option value="${list.id}">${list.nome}</option>
								</c:forEach>
							</select>
							
	 					</div>
	 					
	 					<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">
	 					
	 						<label>Qual imovel</label> <br>
							<select name="imovelDesejado" required>
								<c:forEach var="list" items="${imoveis}">
									<option value="${list.tipo} (COD ${list.codigo})">${list.tipo} (COD ${list.codigo})</option>
								</c:forEach>
							</select>
	 						
	 					</div>
	
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left mx-auto">
							<label>&nbsp;</label> <br>
								<input type="submit" value="Gravar cliente" class="btn-light">
	 					</div>
			
	 				</div>
				</form>
				
			</c:if>
	 					
			</div>
    	
    	</div>
    </div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>