package br.com.casadocodigo.loja.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;

@Component
public class UsuarioValidation implements Validator {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "nome", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senha", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "senhaRepetida", "field.required");

		Usuario usuario = (Usuario) target;

		if (contemUsuario(usuario.getEmail())) {
			errors.rejectValue("email", "duplicate.entry");
		}
		
		if (usuario.getSenha().length() < 5) {
			errors.rejectValue("senha", "password.size");
		}

		if (!usuario.getSenha().equals(usuario.getSenhaRepetida())) {
			errors.rejectValue("senha", "password.mismatch");
			errors.rejectValue("senhaRepetida", "password.mismatch");
		}
	}

	private boolean contemUsuario(String email) {

		if (usuarioDao.findUsuarioPeloEmail(email) == null) {
			return false;
		}
		return true;
	}
}
