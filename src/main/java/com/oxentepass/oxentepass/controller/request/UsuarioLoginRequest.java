package com.oxentepass.oxentepass.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioLoginRequest(
                @NotBlank @Size(min = 11, max = 14, message = "O CPF deve ter entre 11 e 14 dígitos") String cpf,
                @NotBlank String senha) {
}
