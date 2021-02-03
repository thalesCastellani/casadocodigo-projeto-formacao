package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
    private UsuarioValidation usuarioValidation;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(usuarioValidation);
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("/usuarios/form");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return form(usuario);
		}
		
		usuarioDao.gravar(usuario);
		redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
		
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("/usuarios");
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	@RequestMapping("/formRoles")
	public ModelAndView atualizarRoles(Usuario usuario) {
		Usuario user = usuarioDao.findUsuarioById(usuario.getEmail());
		List<Role> roles = user.getRoles();
		System.out.println(user);
		System.out.println(roles);
		ModelAndView modelAndView = new ModelAndView("usuarios/formRoles");
		modelAndView.addObject("usuario", user);
		modelAndView.addObject("roles", roles);
		
		return modelAndView;
    }
	
}
