package padoca.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import padoca.backend.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, UUID> {

}
