<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
    <div class="container">
    	<div class="row">
    		<div class="d-flex align-items-center" style="height: 100vh; width: 100vw">
    			<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto p-2 text-center">
    			
    				<h2 class="sub-tit">Realize o login</h2>
    				
    				<c:if test="${not empty mensagem}">	
    				<div class="row">
    					<div class="col-xl-12 col-lg-12 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
    						<b>ATENÇÂO:</b> ${mensagem}
    					</div>
    				</div>
    				</c:if>
    				
    				<form action="/login" method="post">
    					<div class="p-2 m-2">
    						<input type="email" placeholder="Digite o e-mail" name="email" value="marcelojael@marcelojael.com">
    					</div>
    					
    					<div class="w-100"></div>
    					
    					<div class="p-2 m-2">
    						<input type="password" placeholder="Digite a senha" name="senha" value="marcelojael@marcelojael.com">
    					</div>
    					
    					<div class="p-2 m-2">
    						<button type="submit" class="btn-dark"><i class="fa-sharp fa-solid fa-right-to-bracket"></i> Acessar</button>
    					</div>
    									
    				</form>
    				
    			</div>
    		</div>
    	</div>
    </div>
    
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
