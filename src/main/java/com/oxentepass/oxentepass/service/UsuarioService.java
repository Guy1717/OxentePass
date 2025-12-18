package com.oxentepass.oxentepass.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.oxentepass.oxentepass.entity.Usuario;

public interface UsuarioService {

    public void cadastrarUsuario(Usuario usuario);

    public void loginUsuario(String cpf, String senha);

    public void editarUsuario(long id, Usuario dados);

    public void deletarUsuario(long id);

    public Page<Usuario> listarUsuarios(Pageable pageable);
}
