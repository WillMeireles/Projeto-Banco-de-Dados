package br.com.senai.entregas.controller;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.service.UsuarioService;
import jakarta.persistence.TableGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
private final UsuarioService usuarioService;

public UsuarioController(UsuarioService service) {
usuarioService = service;

}

@GetMapping

public ResponseEntity<List<Usuario>> listarUsuario() {
// 1. Pegar a lista de usuarios
List<Usuario> clientes = usuarioService.listarTodos();
return ResponseEntity.ok(clientes);

}

@PostMapping
public ResponseEntity<Usuario> cadastrarUsuario(
    @RequestBody Usuario usuario
) {
usuarioService.cadastrarUsuario(usuario);

return ResponseEntity.status(201).body(usuario);


}

@GetMapping("/{id}")
public ResponseEntity<?> buscarusuarioPorId(@PathVariable Integer id) {
Usuario usuario = usuarioService.buscarPorId(id);

if (usuario == null) {
    return ResponseEntity.status(404).body("usuario" + id + " nao encontrado!");

}

return ResponseEntity.ok(usuario);

}

@DeleteMapping("/{id}")
public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
// 1. Verifica se o usuario existe
Usuario usuario = usuarioService.deletarCliente(id);

// 2. Se não existir retorno erro
if (usuario == null) {
    return ResponseEntity.status(404)
            .body("Usuario" + id + " não encontrado!");


}
return ResponseEntity.ok(usuario);

}

@PutMapping("/{id}")
public ResponseEntity<?> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {

Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);

if (usuarioAtualizado == null) {
    return ResponseEntity.status(404).body("cliente nao encontrado!");

}
return ResponseEntity.ok(usuarioAtualizado);

}

}