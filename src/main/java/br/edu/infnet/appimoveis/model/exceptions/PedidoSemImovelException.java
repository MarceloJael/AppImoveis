package br.edu.infnet.appimoveis.model.exceptions;

public class PedidoSemImovelException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PedidoSemImovelException(String mensagem) {
		super(mensagem);
	}
	
}
