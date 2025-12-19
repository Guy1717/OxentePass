package com.oxentepass.oxentepass.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrganizadorRequest(
    @NotNull(message = "O ID do usuário é obrigatório") 
    Long usuarioId,

    // Removido @NotNull. A validação de tamanho só ocorre se o campo for enviado.
    @Size(min = 14, max = 18, message = "O CNPJ deve ter entre 14 e 18 caracteres") 
    String cnpj,

    String telefone,
    
    String biografia
) {}
