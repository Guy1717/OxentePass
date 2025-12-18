package com.oxentepass.oxentepass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oxentepass.oxentepass.controller.request.OrganizadorRequest;
import com.oxentepass.oxentepass.entity.Organizador;
import com.oxentepass.oxentepass.service.OrganizadorService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/organizador")
public class OrganizadorController {

    @Autowired
    OrganizadorService service;

    @GetMapping
    public ResponseEntity<Page<Organizador>> listarOrganizadores(Pageable pageable) {
        return new ResponseEntity<Page<Organizador>>(service.listarOrganizadores(pageable), HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<String> cadastrarOrganizador(@PathVariable long userId, @RequestBody @Valid OrganizadorRequest dto) {

        service.cadastrarOrganizador(userId, dto.paraEntidade());

        return new ResponseEntity<String>("Organizador com id " + userId + " definido com sucesso!", HttpStatus.CREATED);

    }

}
