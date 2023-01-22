package io.github.leandro208.logistica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.leandro208.logistica.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {

}
