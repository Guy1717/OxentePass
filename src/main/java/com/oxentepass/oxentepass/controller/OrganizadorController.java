package com.oxentepass.oxentepass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oxentepass.oxentepass.controller.request.OrganizadorRequest;
import com.oxentepass.oxentepass.entity.Organizador;
import com.oxentepass.oxentepass.service.OrganizadorService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

/**
 * @author Guilherme Paes
 * Controller para manipular Organizador, através de OrganizadorService
 */

@RestController
@RequestMapping("/organizador")
public class OrganizadorController {

    @Autowired
    private OrganizadorService service;

    @Operation(summary="Promove um Usuário à Organizador", description="Promove um usuário à organizador de eventos")
    @PostMapping("/promover")
    public ResponseEntity<String> promoverUsuario(@RequestBody @Valid OrganizadorRequest dto) {
        service.promoverUsuario(dto);
        return new ResponseEntity<String>("Usuário promovido a Organizador com sucesso!", HttpStatus.CREATED);
    }

    @Operation(summary="Edita Organizador", description="Edita os dados de um organizador, exceto senha")
    @PutMapping
    public ResponseEntity<String> editarOrganizador(@RequestBody @Valid OrganizadorRequest dados) {
        service.editarOrganizador(dados.usuarioId(), dados);
        
        return new ResponseEntity<String>(
            "Organizador com id " + dados.usuarioId() + " atualizado com sucesso!",
            HttpStatus.OK
        );
    }

    @Operation(summary="Lista Organizadores", description="Lista todos os organizadores")
    @GetMapping
    public ResponseEntity<Page<Organizador>> listarOrganizadores(Pageable pageable) {
        return new ResponseEntity<>(service.listarOrganizadores(pageable), HttpStatus.OK);
    }
}
