package br.edu.infnet.appimoveis.models.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appimoveis.model.exceptions.TamanhoImovelInvalidoException;
import br.edu.infnet.appimoveis.model.exceptions.ValorZeradoException;

@Entity
@Table(name = "fazenda")
public class Fazenda extends Imovel{
	
	private boolean estabulo;
	private int hectares;
	private String tipoplantacao;
	
	public Fazenda() {
		// TODO Auto-generated constructor stub
	}
	
	public Fazenda(String codigo, float valor, String tipoplantacao) throws ValorZeradoException {
		super(codigo, valor);
		this.tipoplantacao = tipoplantacao;
	}
	
	@Override
	public float calcularValorVenda() throws TamanhoImovelInvalidoException {
		
		if(hectares < 250) {
			throw new TamanhoImovelInvalidoException("O tamanho dos hectares está invalido");
		}
		
		return this.getValor() + (estabulo ? 3 : 0) + hectares * 5f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(estabulo ? "estabulo=S" : "estabulo=N");
		sb.append(";");
		sb.append(hectares);
		sb.append(";");
		sb.append(tipoplantacao);

		return sb.toString();
	}

	public boolean isEstabulo() {
		return estabulo;
	}

	public void setEstabulo(boolean estabulo) {
		this.estabulo = estabulo;
	}

	public int getHectares() {
		return hectares;
	}

	public void setHectares(int hectares) {
		this.hectares = hectares;
	}

	public String getTipoplantacao() {
		return tipoplantacao;
	}

	public void setTipoplantacao(String tipoplantacao) {
		this.tipoplantacao = tipoplantacao;
	}
	
}
