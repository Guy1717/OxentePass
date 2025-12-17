package com.oxentepass.oxentepass.controller.request;

import com.oxentepass.oxentepass.entity.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequest(
        @NotBlank(message = "O campo \"nome\" é obrigatorio") String nome,

        @NotBlank(message = "O campo \"cpf\" é obrigatorio") @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 dígitos") String cpf,

        @NotBlank(message = "O campo \"email\" é obrigatorio") @Email String email,

        @NotBlank(message = "O campo \"senha\" é obrigatorio") String senha) {

    public Usuario paraEntidade() {
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        return usuario;
    }
}
