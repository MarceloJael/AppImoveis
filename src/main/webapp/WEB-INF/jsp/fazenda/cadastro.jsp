<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row text-center">
    		
    		<div class="col-12">
    			<h2 class="text-center sub-tit">Cadastrar Fazenda</h2>
    		</div>
    	
    		<div class="p-3 m-3 text-center">			

				<form method="post" action="/incluir-fazenda">
					<div class="row p-2">
					
						<c:import url="/WEB-INF/jsp/imoveis/cadastro.jsp"/>
				 					
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Possui estabulo?</label> <br>
							Sim <input type="checkbox" value="true" id="estabulo" name="estabulo" class="input-checkbox"><br>
						</div>
						
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>Tamanho da fazenda em hectares</label> <br>
							<input type="int" placeholder="Digite o tamanho da fazenda" id="hectares" name="hectares" required>
						</div>
				 					 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Tipo de plantação?</label> <br>
	 						<input type="text" placeholder="Digite o tipo de plantacao" id="plantacao" name="plantacao" required>
	 					</div>
	
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 mx-auto p-2 text-left">
							<label>&nbsp;</label> <br>
 							<input type="submit" value="Gravar fazenda" class="btn-light">
	 					</div>
			
	 				</div>
				</form>
	 					
			</div>
    	
    	</div>
    </div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>