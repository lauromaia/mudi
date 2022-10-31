package br.com.alura.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mudi.modelo.Oferta;

public class RequisicaoNovaOferta {
	
	private Long pedidoId;
	
	
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	@NotNull
	private String valor;
	
	private String comentario;
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDaEntrega;
	
	static private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	public Oferta toOferta() {
		
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setId(this.pedidoId);
		oferta.setValor(new BigDecimal(valor));
		oferta.setDataDeEntrega(LocalDate.parse(this.dataDaEntrega, this.formatter));
		
		return oferta;
	}
	
	
}
