<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row text-center">
    		
    		<h2 class="text-center sub-tit">Cadastrar cliente</h2>
    	
    		<div class="p-3 m-3 text-center">			

				<form method="post" action="/incluir-cliente">
					<div class="row p-2">
				 					
						<div class="col-xl-8 col-lg-8 col-sm-12 col-md-12 p-2 text-left">
							<label>Nome do usuario</label> <br>
							<input type="text" placeholder="Digite o nome do cliente" id="nome" name="nome" required>
						</div>
						
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
							<label>CPF</label> <br>
							<input type="text" placeholder="Digite o CPF do cliente" id="cpf" name="cpf" required>
						</div>
				 					 					
	 					<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">
	 						<label>E-mail</label> <br>
	 						<input type="email" placeholder="Digite o e-mail do cliente" id="email" name="email" required>
	 					</div>
	
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">
							<label>&nbsp;</label> <br>
 							<input type="submit" value="Gravar cliente" class="btn-light">
	 					</div>
			
	 				</div>
				</form>
	 					
			</div>
    	
    	</div>
    </div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>