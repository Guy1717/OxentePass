package com.oxentepass.oxentepass.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxentepass.oxentepass.entity.Usuario;
import com.oxentepass.oxentepass.exceptions.EstadoInvalidoException;
import com.oxentepass.oxentepass.exceptions.RecursoDuplicadoException;
import com.oxentepass.oxentepass.exceptions.RecursoNaoEncontradoException;
import com.oxentepass.oxentepass.repository.UsuarioRepository;
import com.oxentepass.oxentepass.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void cadastrarUsuario(Usuario usuario) {

        Optional<Usuario> existingUser = repository.findByCpf(usuario.getCpf());

        if (existingUser.isPresent()) {
            throw new RecursoDuplicadoException("Já existe um usuário registrado com este CPF");
        }

        // TODO (Guilherme): criptografia para senha?

        repository.save(usuario);
    };

    @Override
    public Boolean autenticarUsuario(String email, String senha) {
        Optional<Usuario> optionalUser = repository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new RecursoNaoEncontradoException("Nenhum usuário encontrado para o e-mail" + email);
        }

        if (!senha.equals(optionalUser.get().getSenha())) {
            throw new EstadoInvalidoException("Senha incorreta para este usuário");
        }

        return true;
    };

    @Override
    public void atualizarDadosUsuario(Long id, Usuario dados) {

        Optional<Usuario> optionalUser = repository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new RecursoNaoEncontradoException("Usuário com id" + id + "não encontrado");
        }

        Usuario user = optionalUser.get();

        // TODO (Guilherme): fazer melhor validação
        user.setCpf(dados.getCpf());
        user.setEmail(dados.getEmail());
        user.setNome(dados.getNome());
        user.setSenha(dados.getSenha());

        repository.save(user);
    };


}