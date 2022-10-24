package br.com.alura.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.modelo.Pedido;
import br.com.alura.mudi.modelo.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	

	
	@GetMapping("/pedido")
	public ModelAndView home(Principal principal) {
		
		List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		ModelAndView mv = new ModelAndView("usuario/home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(Model model, @PathVariable("status") String status, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		return "usuario/home";
	}

}
