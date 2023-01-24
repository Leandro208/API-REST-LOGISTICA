package io.github.leandro208.logistica.domain.service;

import org.springframework.stereotype.Service;

import io.github.leandro208.logistica.domain.exception.EntidadeNaoEncontradaException;
import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.repository.EntregaRepository;

@Service
public class BuscaEntregaService {

	private EntregaRepository entregaRepository;
	
	public BuscaEntregaService(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada!"));
	}
}
