package padoca.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import padoca.backend.models.Usuario;
import padoca.backend.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService serviceImpl;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> getAllUsuarios(){
		
		List<Usuario> userList = serviceImpl.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	@PostMapping(value = "/cadastro")
	public ResponseEntity<Object> cadastroUsuario(@RequestBody Usuario usuario){
		
		Usuario user = new Usuario();
		
		user.setEmail(usuario.getEmail());
		user.setNomeUsuario(usuario.getNomeUsuario());
		user.setDataCadastro(usuario.getDataCadastro());
		user.setNomeCompleto(usuario.getNomeCompleto());
		user.setSenha(usuario.getSenha());
		
		serviceImpl.salvarUsuario(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

}
