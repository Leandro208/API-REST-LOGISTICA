package io.github.leandro208.logistica.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.leandro208.logistica.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	List<Cliente> findByNome(String nome);
	
	List<Cliente> findByNomeContaining(String nome);
}
