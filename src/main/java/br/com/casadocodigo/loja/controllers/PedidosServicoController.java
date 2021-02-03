package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView consomeServico(String json) {
		
		String uri = "https://book-payment.herokuapp.com/orders";
		Pedido[] pedidos = restTemplate.getForObject(uri, Pedido[].class);
		
		ModelAndView modelAndView = new ModelAndView("/pedidos");
		modelAndView.addObject("pedidos", pedidos);
		
		return modelAndView;
		
	}
	
}
