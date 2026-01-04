package com.oxentepass.oxentepass.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oxentepass.oxentepass.service.PagamentoVerificacaoService;

@Component
public class PagamentoStatusJob {

    // Service de verificação de pagamentos
    @Autowired
    private PagamentoVerificacaoService verificacaoService;

    // Executa a verificação de pagamentos pendentes a cada minuto
    @Scheduled(fixedDelay = 60000)
    public void executar() {
        verificacaoService.verificarPagamentosPendentes();
    }
}
