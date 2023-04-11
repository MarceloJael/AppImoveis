package br.edu.infnet.appimoveis.models.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appimoveis.model.exceptions.TamanhoImovelInvalidoException;
import br.edu.infnet.appimoveis.model.exceptions.ValorZeradoException;

@Entity
@Table(name = "casa")
public class Casa extends Imovel {
	
	private String tipo = "Casa";
	private boolean quintal;
	private int tamanho;
	private String cor;
	
	public Casa() {
		// TODO Auto-generated constructor stub
	}
	
	public Casa(String codigo, float valor, String cor) throws ValorZeradoException {
		super(codigo, valor);
		this.cor = cor;
	}

	
	@Override
	public float calcularValorVenda() throws TamanhoImovelInvalidoException {
		
		if(tamanho < 250) {
			throw new TamanhoImovelInvalidoException("O tamanho do imovel está invalido");
		}
		
		return this.getValor() + (quintal ? 3 : 0) + tamanho * 5f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(quintal ? "quintal=S" : "quintal=N");
		sb.append(";");
		sb.append(tamanho);
		sb.append(";");
		sb.append(cor);

		return sb.toString();
	}
	
	

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isQuintal() {
		return quintal;
	}

	public void setQuintal(boolean quintal) {
		this.quintal = quintal;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
}
