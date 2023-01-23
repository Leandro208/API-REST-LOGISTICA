package io.github.leandro208.logistica.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leandro208.logistica.domain.model.Cliente;
import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.model.StatusEntrega;
import io.github.leandro208.logistica.domain.repository.EntregaRepository;

@Service
public class EntregaService {

	private EntregaRepository entregaRepository;
	private ClienteService clienteService;
	
	public EntregaService(EntregaRepository entregaRepository, ClienteService clienteService) {
		this.entregaRepository = entregaRepository;
		this.clienteService = clienteService;
	}

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRepository.save(entrega);
	}
	
}
