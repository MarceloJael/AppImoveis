<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <c:import url="/WEB-INF/jsp/menu.jsp"/>
    
   	<c:if test="${empty usuario}">
   	<div class="container">
    	<div class="row">
    		<div class="d-flex align-items-center" style="height: 80vh; width: 80vw">
    			<div class="col-xl-6 col-lg-6 col-sm-12 col-md-12 mx-auto py-2 text-center alerta">
    				Faça seu login pra continuar!
    			</div>
    		</div>
    	</div>
    </div>
    </c:if>
    
    <c:if test="${not empty usuario}">
   	<div class="container">
    	<div class="my-5">
    	
	    	<div class="row">
	    		
	    		<div class="col-xl-12 col-lg-12 col-sm-12 col-md-12 mx-auto text-center home-menus">	
	    			<a href="lista-imovel"><i class="fa-solid fa-shop"></i> IMOVEIS</a>
	    		</div>
	    		
	    		<div class="w-100"></div>
	    		
	    		<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto text-center home-menus">
	    			<a href="lista-casa"><i class="fa-solid fa-house"></i> <br>
	    			CASA</a>
	    		</div>
	    		
	    		<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto text-center home-menus">
	    			<a href="lista-apartamento"><i class="fa-sharp fa-solid fa-building"></i><br>
	    			APARTAMENTO</a>
	    		</div>
	    		
	    		<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 mx-auto text-center home-menus">
	    			<a href="lista-fazenda"><i class="fa-solid fa-tree-city"></i><br>
	    			FAZENDA</a>
	    		</div>
	    		
	    	</div>
    		
    	</div>
    </div>
    </c:if>
    
    
        
    <c:import url="/WEB-INF/jsp/footer.jsp"/>
