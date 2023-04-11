<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row text-center">
    		
    		<div class="col-12">
    			<h2 class="text-center sub-tit">Cadastrar casa</h2>
    		</div>
    	
    		<div class="p-3 m-3 text-center">			

				<form method="post" action="/incluir-casa">
					<div class="row p-2">
					
						<c:import url="/WEB-INF/jsp/imoveis/cadastro.jsp"/>
				 					
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Possui quintal?</label> <br>
							Sim <input type="checkbox" value="true" id="quintal" name="quintal" class="input-checkbox"><br>
						</div>
						
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Tamanho da casa em metros</label> <br>
							<input type="int" placeholder="Digite o tamanho da casa" id="tamanho" name="tamanho" required>
						</div>
				 					 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Cor da casa</label> <br>
	 						<input type="text" placeholder="Digite a cor da casa" id="cor" name="cor" required>
	 					</div>
	
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 mx-auto p-2 text-left">
							<label>&nbsp;</label> <br>
 							<input type="submit" value="Gravar casa" class="btn-light">
	 					</div>
			
	 				</div>
				</form>
	 					
			</div>
    	
    	</div>
    </div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>