package io.github.leandro208.logistica.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import io.github.leandro208.logistica.domain.model.Entrega;

import io.github.leandro208.logistica.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	private BuscaEntregaService service;
	private EntregaRepository repository;

	public FinalizacaoEntregaService(BuscaEntregaService service, EntregaRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	@Transactional
	public void finalizar(Long entregaId) {
		Entrega entrega = service.buscar(entregaId);
		
		entrega.finalizar();
		repository.save(entrega);
	}
}
