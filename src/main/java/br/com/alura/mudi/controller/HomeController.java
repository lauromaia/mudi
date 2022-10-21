package br.com.alura.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.modelo.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public ModelAndView home() {
		
		List<Pedido> pedidos = pedidoRepository.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
}
