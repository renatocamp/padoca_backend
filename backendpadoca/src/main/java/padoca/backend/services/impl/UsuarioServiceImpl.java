package padoca.backend.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

	@Override
	public Optional<Usuario> findByID(UUID idUsuario) {
		return repository.findById(idUsuario);
	}

	@Override
	public void deleteUsuario(UUID idUsuario) {
		repository.deleteById(idUsuario);
		
	}

}
