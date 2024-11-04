package padoca.backend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padoca.backend.models.Usuario;
import padoca.backend.repositories.UsuarioRepository;
import padoca.backend.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public List<Usuario> findAll() {

		return (List<Usuario>) repository.findAll();
	}

	@Override
	public void salvarUsuario(Usuario user) {
		repository.save(user);
	}

}
