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

    public TipoUsuario cadastrarTipoUsuario(TipoUsuario cl) {
        return tipoUsuarioRepository.save(cl);


    }

    public TipoUsuario buscarPorId(Integer id) {
        return tipoUsuarioRepository.findById(id).orElse(null);


    }

    public TipoUsuario deletarTipoUsuario(Integer id) {
        TipoUsuario tipoUsuario = buscarPorId(id);

        if (tipoUsuario == null) {
            return null;

        }

        tipoUsuarioRepository.delete(tipoUsuario);
        return tipoUsuario;

    }

    public TipoUsuario atualizarTipoUsuario(Integer id, TipoUsuario tipoUsuario) {
        // 1. Procurar quem eu quero atualizar
        TipoUsuario tipoAntigo = buscarPorId(id);

        // 2. Se eu não achar, retorno nulo
        if (tipoAntigo == null) {
            return null;

        }

        tipoAntigo.setDescricao(tipoUsuario.getDescricao());
        return tipoUsuarioRepository.save(tipoAntigo);
    }

    }