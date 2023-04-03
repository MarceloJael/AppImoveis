<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
 	<head>
	    <!-- Meta tags Obrigatórias -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	    <!-- Bootstrap CSS -->
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,400;0,600;0,800;1,400;1,600;1,800&display=swap" rel="stylesheet">
		
		<!-- Icon Awesome -->
		<script src="https://kit.fontawesome.com/5bdb09f0fb.js" crossorigin="anonymous"></script>
		
		<!-- Style CSS -->
		<link rel="stylesheet" href="css/style.css">
		
	    <title>AppImoveis</title>
	</head>
  <body>
  
	<header>
		<nav class="navbar navbar-expand-xl py-3">
			<div class="container-fluid">
			
				<div class="navbar-header">
					<a class="navbar-brand" href="/"><img src="img/logo.png" alt="Logo do app" width="30" height="30" class="d-inline-block align-top"> <span class="tit-app">AppImoveis</span></a>
				</div>
				
			    <ul class="nav navbar-nav text-center menu-nav">
	    			<li class="active nav-item p-1 m-1"><a href="/">Home</a></li>
	    			<c:if test="${not empty usuario}">
						<li class="nav-item p-1 m-1"><a href="/lista-usuario">Users</a></li>	
		      			<li class="nav-item p-1 m-1"><a href="/lista-cliente">Clientes</a></li>
						<li class="nav-item p-1 m-1"><a href="/lista-imovel">Imoveis</a></li>
						<li class="nav-item p-1 m-1"><a href="/lista-casa">Casas</a></li>
						<li class="nav-item p-1 m-1"><a href="/lista-apartamento">Apartamentos</a></li>
						<li class="nav-item p-1 m-1"><a href="/lista-fazenda">Fazendas</a></li>
						<li class="nav-item p-1 m-1"><a href="/lista-pedido">Pedidos</a></li>
					</c:if>
	    		</ul>
	    		
	   		    <ul class="nav navbar-nav navbar-right acessos-menu">
	   		    	<c:if test="${empty usuario}">
				      <li class="nav-item p-1 m-1"><a href="/cadastrar"><i class="fa-sharp fa-solid fa-user-plus"></i> Cadastrar</a></li>
				      <li class="nav-item p-1 m-1"><a href="/login"><i class="fa-sharp fa-solid fa-right-to-bracket"></i> Acessar</a></li>
					</c:if>
					
					<c:if test="${not empty usuario}">
				      <li class="nav-item p-1 m-1"><a href="/logout"><i class="fa-sharp fa-solid fa-right-from-bracket"></i> Sair, ${usuario.nome}</a></li>
				     </c:if>
				      
	    		</ul>
			</div>
		</nav>
	</header>