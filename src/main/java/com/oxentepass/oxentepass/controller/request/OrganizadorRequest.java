package com.oxentepass.oxentepass.controller.request;

import com.oxentepass.oxentepass.entity.Organizador;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrganizadorRequest(
    @NotBlank(message = "O campo \"telefone\" é obrigatório")
    @Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 caracteres")
    String telefone,

    @Size(min = 14, max = 18, message = "O CNPJ deve ter entre 14 e 18 caracteres")
    String cnpj,
    
    @NotBlank(message = "O campo \"biografia\" é obrigatório")
    String biografia
) {
    public Organizador paraEntidade() {
        Organizador organizador = new Organizador();

        if(cnpj != null && !cnpj.isBlank()){
            organizador.setCnpj(cnpj);
        }

        organizador.setTelefone(telefone);
        organizador.setBiografia(biografia);
        organizador.setNotaReputacao(5.0);

        return organizador;
    }
}