package br.edu.infnet.appimoveis.models.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.appimoveis.model.exceptions.TamanhoImovelInvalidoException;
import br.edu.infnet.appimoveis.model.exceptions.ValorZeradoException;

@Entity
@Table(name = "apartamento")
public class Apartamento extends Imovel{
	
	private String tipo = "Apartamento";
	private boolean salaofesta;
	private int andar;
	private String cor;
	
	public Apartamento() {
		// TODO Auto-generated constructor stub
	}
	
	public Apartamento(String codigo, float valor, String cor) throws ValorZeradoException {
		super(codigo, valor);
		this.cor = cor;
	}
	
	@Override
	public float calcularValorVenda() throws TamanhoImovelInvalidoException {
		
		if(andar < 1) {
			throw new TamanhoImovelInvalidoException("O andar do imovel está invalido");
		}
		
		return this.getValor() + (salaofesta ? 3 : 0) + andar * 5f;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(";");
		sb.append(salaofesta ? "salaofesta=S" : "salaofesta=N");
		sb.append(";");
		sb.append(andar);
		sb.append(";");
		sb.append(cor);

		return sb.toString();
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = "Apartamento";
	}


	public boolean isSalaofesta() {
		return salaofesta;
	}

	public void setSalaofesta(boolean salaofesta) {
		this.salaofesta = salaofesta;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
