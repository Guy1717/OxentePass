package com.oxentepass.oxentepass.service;

import com.oxentepass.oxentepass.entity.Pagamento;

public interface MercadoPagoService {

    // Realiza o pagamento de uma venda utilizando Pix
    Pagamento pagarComPix(Long idVenda);

    // Realiza o pagamento de uma venda utilizando cartão de crédito
    Pagamento pagarComCartao(Long idVenda, String tokenCartao);
}
