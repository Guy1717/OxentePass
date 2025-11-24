package com.oxentepass.oxentepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxentepass.oxentepass.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

}
