package com.oxentepass.oxentepass.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class MercadoPagoConfigApp {

    // Token de acesso do MercadoPago
    @Value("${mercadopago.access.token}")
    private String accessToken;

    // Inicializa a configuração do MercadoPago com o token de acesso
    @PostConstruct
    public void init() {
        // Chamada da classe do SDK importada
        com.mercadopago.MercadoPagoConfig.setAccessToken(accessToken);
    }
}