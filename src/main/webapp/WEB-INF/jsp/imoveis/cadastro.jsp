<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
	<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
		<label>Codigo do produto</label> <br>
		<input type="text" placeholder="Digite o codigo do produto" id="codigo" name="codigo" required>
	</div>
	
	
	<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
		<label>Qual o valor do imovel?</label> <br>
		<input type="text" placeholder="Digite o preço do imovel" id="valor" name="valor" required>
	</div>
	
	<div class="col-xl-4 col-lg-4 col-sm-12 col-md-12 p-2 text-left">
		<label>Imovel é pronta entrega?</label> <br>
		<select name="prontaentrega">
			<option value="Sim" selected >Sim</option>
			<option value="Não">Não</option>
		</select>
	</div>
	
	