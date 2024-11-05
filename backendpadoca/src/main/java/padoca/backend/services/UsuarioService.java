package padoca.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import padoca.backend.models.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();

	void salvarUsuario(Usuario user);

	Optional<Usuario> findByID(UUID idUsuario);

	void deleteUsuario(UUID idUsuario);

}
