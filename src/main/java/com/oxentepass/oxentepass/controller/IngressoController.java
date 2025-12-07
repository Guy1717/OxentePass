package com.oxentepass.oxentepass.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oxentepass.oxentepass.controller.request.IngressoRequest;
import com.oxentepass.oxentepass.service.IngressoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.oxentepass.oxentepass.entity.Ingresso;


@RestController
@RequestMapping("/ingresso")
public class IngressoController {

    @Autowired
    private IngressoService ingressoService;
    
    //Operações Básicas
    @PostMapping("/cadastro")
    public ResponseEntity<String> cadatrarIngresso (@RequestBody @Valid IngressoRequest dto) {
        ingressoService.cadastrarIngresso(dto.paraEntidade());
        return new ResponseEntity<String>("Ingresso simples criado com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/deletar/{idIngresso}")
    public ResponseEntity<String> deletarIngresso (@PathVariable Long idIngresso) {
        ingressoService.deletarIngresso(idIngresso);
        return new ResponseEntity<String>("Ingresso deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Ingresso>> listarTodosIngressos () {
        return new ResponseEntity<Iterable<Ingresso>>(ingressoService.listarTodosIngressos(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{idIngresso}")
    public ResponseEntity<Ingresso> buscarIngressoPorId (@PathVariable Long idIngresso) {
        return new ResponseEntity<Ingresso>(ingressoService.buscarIngressoPorId(idIngresso), HttpStatus.OK);
    }

    @GetMapping("/buscar/tipo/{tipoIngresso}")
    public ResponseEntity<Ingresso> buscarIngressoPorTipo (@PathVariable String tipoIngresso) {
        return new ResponseEntity<Ingresso>(ingressoService.buscarIngressPorTipo(tipoIngresso), HttpStatus.OK);
    }

    @GetMapping("/disponivel/{idEvento}")
    public ResponseEntity<Ingresso> quantidadeIngressosDisponiveis (@PathVariable Long idEvento) {
        return new ResponseEntity<Ingresso>(ingressoService.ingressosDisponiveis(idEvento), HttpStatus.OK);
    }

}