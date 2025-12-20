package com.oxentepass.oxentepass.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.oxentepass.oxentepass.entity.Venda;
import com.oxentepass.oxentepass.entity.IngressoVenda;
import com.oxentepass.oxentepass.entity.Pagamento;
import com.oxentepass.oxentepass.entity.StatusVenda;

public record VendaResponse(
    long id,
    UsuarioResponse usuario,
    List<IngressoVenda> ingressos,
    BigDecimal valorTotal,
    Pagamento pagamento,
    LocalDateTime dataHoraVenda,
    StatusVenda status
) {

    public static VendaResponse paraDTO(Venda venda) {
        return new VendaResponse(
            venda.getId(),
            UsuarioResponse.paraDTO(venda.getUsuario()),
            venda.getIngressos(),
            venda.getValorTotal(),
            venda.getPagamento(),
            venda.getDataHoraVenda(),
            venda.getStatus()
        );
    }
}
