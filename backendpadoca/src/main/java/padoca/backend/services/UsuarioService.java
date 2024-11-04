package padoca.backend.services;

import java.util.List;

import padoca.backend.models.Usuario;

public interface UsuarioService {

	List<Usuario> findAll();

	void salvarUsuario(Usuario user);

}
