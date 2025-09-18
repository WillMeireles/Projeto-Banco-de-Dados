package br.com.senai.entregas.service;


import br.com.senai.entregas.model.TipoUsuario;
import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.TipoUsuarioRepository;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoUsuarioService {
private final TipoUsuarioRepository tipoUsuarioRepository;

public TipoUsuarioService(TipoUsuarioRepository repo) {
tipoUsuarioRepository = repo;
}

// Listar todos os Clientes
public List<TipoUsuario> listarTodos() {
return tipoUsuarioRepository.findAll();


}


}


