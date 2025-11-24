package com.oxentepass.oxentepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxentepass.oxentepass.entity.PontoVenda;

@Repository
public interface PontoVendaRepository extends JpaRepository<PontoVenda, Long> {

}
