package com.oxentepass.oxentepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxentepass.oxentepass.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
