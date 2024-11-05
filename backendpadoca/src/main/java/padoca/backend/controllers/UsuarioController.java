package padoca.backend.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padoca.backend.models.Usuario;
import padoca.backend.services.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService serviceImpl;
	
	@PostMapping(value = "/cadastro")
	public ResponseEntity<Object> cadastroUsuario(@RequestBody Usuario usuario){
		
		Usuario user = new Usuario();
		
		user.setEmail(usuario.getEmail());
		user.setNomeUsuario(usuario.getNomeUsuario());
		user.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
		user.setLastUpdateData(LocalDateTime.now(ZoneId.of("UTC")));
		user.setNomeCompleto(usuario.getNomeCompleto());
		user.setSenha(usuario.getSenha());
		
		serviceImpl.salvarUsuario(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Object> getUsuarioPorID(@PathVariable(value = "idUsuario") UUID idUsuario){
		
		Optional<Usuario>userOptional =  serviceImpl.findByID(idUsuario);
		
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
		}
	}
	
	@GetMapping(value = "/todos", produces = "application/json")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		
		List<Usuario> userList = serviceImpl.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@PutMapping(value = "/atualizar/{idUsuario}")
	public ResponseEntity<Object> atualizarUsuario(@RequestBody Usuario usuario, @PathVariable(value = "idUsuario") UUID idUsuario){
		
		Optional<Usuario>userOptional =  serviceImpl.findByID(idUsuario);
		
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		} else {
			Usuario user = userOptional.get();
			
			user.setEmail(usuario.getEmail());
			user.setNomeUsuario(usuario.getNomeUsuario());
			user.setNomeCompleto(usuario.getNomeCompleto());
			user.setLastUpdateData(LocalDateTime.now(ZoneId.of("UTC")));
			user.setSenha(usuario.getSenha());
			
			serviceImpl.salvarUsuario(user);
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		
		
	}
	
	@DeleteMapping(value = "/delete/{idUsuario}")
	public ResponseEntity<Object>deleteUser(@PathVariable(value = "idUsuario") UUID idUsuario){
		
		Optional<Usuario>userOptional =  serviceImpl.findByID(idUsuario);
		
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USUÁRIO NÃO FOI ENCONTRADO!");
		} else {
			serviceImpl.deleteUsuario(idUsuario);
			
			return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
		}
	}
	


}
