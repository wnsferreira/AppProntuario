package br.edu.infnet.appProntuario.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appProntuario.model.domain.Usuario;
import br.edu.infnet.appProntuario.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario validar(String email, String senha) {
		
		return usuarioRepository.autenticacao(email, senha);
		
	}
	
	public List<Usuario> obterLista(){
		
		return (List<Usuario>) usuarioRepository.findAll();
		
	}
	
	public void incluir(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}
	
}
