package br.com.alura.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mudi.modelo.Oferta;
import br.com.alura.mudi.modelo.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("api/oferta")
public class OfertaRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@PostMapping
	public Oferta novaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Oferta novaOferta = requisicao.toOferta();
		
		Pedido pedido = pedidoBuscado.get();
		
		novaOferta.setPedido(pedido);
		pedido.getOfertas().add(novaOferta);
		pedidoRepository.save(pedido);
		
		return novaOferta;
		
		
	}
	
}
