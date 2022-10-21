package br.com.alura.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.mudi.modelo.Pedido;
import br.com.alura.mudi.modelo.StatusPedido;

public class RequisicaoNovoPedido {
	@NotBlank
	private String nomeProduto;
	@NotBlank
	private String urlDaImagem;
	@NotBlank
	private String urlDoProduto;
	private String descricao;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getUrlDaImagem() {
		return urlDaImagem;
	}
	public void setUrlDaImagem(String urlDaImagem) {
		this.urlDaImagem = urlDaImagem;
	}
	public String getUrlDoProduto() {
		return urlDoProduto;
	}
	public void setUrlDoProduto(String urlDoProduto) {
		this.urlDoProduto = urlDoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setUrlDaImagem(urlDaImagem);
		pedido.setUrlDoProduto(urlDoProduto);
		pedido.setNomeProduto(nomeProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		
		return pedido;
		
	}
	

	
}
