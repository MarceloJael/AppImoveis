package br.edu.infnet.appimoveis.models.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.appimoveis.model.exceptions.PedidoSemClienteException;
import br.edu.infnet.appimoveis.model.exceptions.PedidoSemImovelException;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private boolean financiamento;
	private LocalDateTime data;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.DETACH)
	private List<Imovel> imoveis;
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Cliente cliente, List<Imovel> imoveis) throws PedidoSemClienteException, PedidoSemImovelException {
		this();
		
		if(cliente == null) {
			throw new PedidoSemClienteException("Não existe cliente para esse pedido");
		}
		
		if(imoveis == null) {
			throw new PedidoSemImovelException("Não existe nenhum imovel associado a esse pedido");
		}

		this.cliente = cliente;
		this.imoveis = imoveis;
		
		data = LocalDateTime.now();
	}
	
	public void imprimir(){
		System.out.println("Pedido: " + this);
		System.out.println("Cliente: " + cliente);
		System.out.println("Qtde Imoveis: " + imoveis.size());
		System.out.println("Imoveis:");
		for(Imovel p : imoveis) {
			System.out.println("- " + p.getId());
		}
	}
	
	public String obterLinha() {	
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yyyy");
		
		return this.getData().format(formato)+";"+
			   this.getDescricao()+";"+
			   this.getCliente()+";"+
			   this.getImoveis().size()+"\r\n";
	}
	
	@Override
	public String toString() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return  String.format("%s;%s;%s", 
				descricao, 
				financiamento ? "financiamento" : "À vista",  
				data.format(formato)
			);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinanciamento() {
		return financiamento;
	}

	public void setFinanciamento(boolean financiamento) {
		this.financiamento = financiamento;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
