package br.com.senai.entregas.service;

import br.com.senai.entregas.model.Usuario;
import br.com.senai.entregas.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    // Injecao de dependencia
    //  Falar que Service depende de alguem
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository repo) {
        usuarioRepository = repo;
    }

    // Listar todos os Clientes
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrarUsuario(Usuario cl) {
        return usuarioRepository.save(cl);


    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);

    }

    public Usuario deletarCliente(Integer id) {
        Usuario cliente = buscarPorId(id);

        if (cliente == null) {
            return null;
        }

        usuarioRepository.delete(cliente);
        return cliente;
    }

    public Usuario atualizarUsuario(Integer id, Usuario usuarioNovo) {
        // 1. Procurar quem eu quero atualizar
        Usuario usuarioAntigo = buscarPorId(id);

        // 2. Se eu não achar, retorno nulo
        if (usuarioAntigo == null) {
            return null;
        }

        // 3. Se eu achar eu atualizo
        usuarioAntigo.setNomeCompleto(usuarioNovo.getNomeCompleto());
        usuarioAntigo.setSenha(usuarioNovo.getSenha());
        usuarioAntigo.setEmail(usuarioNovo.getEmail());
        return usuarioRepository.save(usuarioAntigo);

    }


}
