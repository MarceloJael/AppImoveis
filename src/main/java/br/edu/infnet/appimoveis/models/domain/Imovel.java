package br.edu.infnet.appimoveis.models.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.infnet.appimoveis.model.exceptions.TamanhoImovelInvalidoException;
import br.edu.infnet.appimoveis.model.exceptions.ValorZeradoException;


@Entity
@Table(name = "imovel")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private float valor;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@ManyToMany(mappedBy = "imoveis")
	private List<Pedido> pedidos;
	
	public Imovel() {
		// TODO Auto-generated constructor stub
	}
	
	public Imovel(String codigo, float valor) throws ValorZeradoException {
		
		if(valor == 0) {
			throw new ValorZeradoException("O imovel está sem valor!");
		}
		
		if(valor < 0) {
			throw new ValorZeradoException("O imovel está com o valor negativo!");
		}

		this.codigo = codigo;
		this.valor = valor;
	}
	
	public abstract float calcularValorVenda() throws TamanhoImovelInvalidoException;
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(codigo);
		sb.append(";");
		sb.append(valor);

		return sb.toString();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public float getValor() {
		return valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
}
