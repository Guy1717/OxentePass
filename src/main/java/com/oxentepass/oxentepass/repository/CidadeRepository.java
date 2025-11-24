package com.oxentepass.oxentepass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oxentepass.oxentepass.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
