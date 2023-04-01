<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row">
    	
    		<div class="p-3 m-3 text-center">
    		 		
	 			<form method="post" action="/form_cep">
					<div class="row p-2">
	 					
	 					<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 mx-auto text-center">
	 						<label>Digite o CEP</label> <br>
	 						<div class="row">
	 							<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12">
	 								<input type="number" placeholder="Digite o cep" id="cep" name="cep" required>
	 							</div>	 							
	 							<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12">
	 								<input type="submit" value="Buscar CEP" class="btn-light">
	 							</div>	 						
	 						</div>
	 					</div>				
	 					
	 				</div>
	 			</form>	 			

				<form method="post" action="/form_endereco">
					<div class="row p-2">
				 					
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">
							<label>Nome do usuario</label> <br>
							<input type="text" placeholder="Digite o nome" id="nome" name="nome" required>
						</div>
						
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 p-2 text-left">
							<label>Senha</label> <br>
							<input type="password" placeholder="Digite a senha" id="senha" name="senha" required>
						</div>
				 					 					
	 					<div class="col-xl-8 col-lg-8 col-sm-12 col-md-12 p-2 text-left">
	 						<label>E-mail</label> <br>
	 						<input type="email" placeholder="Digite o e-mail" id="email" name="email" required>
	 					</div>
				 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Telefone</label> <br>
	 						<input type="text" placeholder="Digite o número do telefone" id="telefone" name="telefone" required>
	 					</div>
				 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>CEP</label> <br>
	 						<input type="text" id="cep" name="cep" value="${endereco.cep}" readonly required>
	 					</div>
				 						 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Logradouro</label> <br>
	 						<input type="text" id="logradouro" name="logradouro" value="${endereco.logradouro}" readonly required>
	 					</div>
				 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Bairro</label> <br>
	 						<input type="text" id="bairro" name="bairro" value="${endereco.bairro}" readonly required>
	 					</div>
				 					
						<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Cidade</label> <br>
	 						<input type="text" id="localidade" name="localidade" value="${endereco.localidade}" readonly required>
	 					</div>
				 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Estado</label> <br>
	 						<input type="text" id="uf" name="uf" value="${endereco.uf}" readonly required>
	 					</div>
				 					
	 					<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
	 						<label>Cargo</label> <br>
							<select name="cargo" required>
								<option value="vendedor">Vendedor</option>
								<option value="representante">Representante</option>
								<option value="administrador" selected>Administrador</option>
							</select>
	 					</div>
				 		
				 					
				 					
						<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 m-5 px-2 mx-auto ">
	 							<input type="submit" value="Gravar cadastro" class="btn-light">
	 					</div>
			
	 				</div>
				</form>
	 					
			</div>
    	
    	</div>
    </div>
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>