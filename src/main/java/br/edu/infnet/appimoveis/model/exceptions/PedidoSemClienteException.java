package br.edu.infnet.appimoveis.model.exceptions;

public class PedidoSemClienteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PedidoSemClienteException(String mensagem) {
		super(mensagem);
	}

}
