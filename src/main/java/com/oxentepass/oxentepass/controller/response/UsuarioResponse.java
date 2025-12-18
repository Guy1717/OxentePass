package com.oxentepass.oxentepass.controller.response;

import com.oxentepass.oxentepass.entity.Usuario;

public record UsuarioResponse(
    long id,
    String nome,
    String cpf,
    String email
) {
    public static UsuarioResponse paraDTO(Usuario usuario) {
        return new UsuarioResponse(
            usuario.getId(), usuario.getNome(),
            usuario.getCpf(), usuario.getEmail()
        );
    }
}
