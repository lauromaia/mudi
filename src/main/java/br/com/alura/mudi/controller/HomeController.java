package br.com.alura.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.modelo.Pedido;
import br.com.alura.mudi.modelo.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;
import br.com.alura.mudi.repository.UsuarioRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	

	
	@GetMapping
	public ModelAndView home(Principal principal) {
		
		Sort sort = Sort.by("dataDaEntrega").ascending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
}
