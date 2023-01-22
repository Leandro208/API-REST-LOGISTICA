package io.github.leandro208.logistica.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.repository.EntregaRepository;
import io.github.leandro208.logistica.domain.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaService entregaService;
	private EntregaRepository entregaRepository;

	public EntregaController(EntregaService entregaService, EntregaRepository entregaRepository) {
		this.entregaService = entregaService;
		this.entregaRepository = entregaRepository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return entregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar(){
		return entregaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Entrega> buscarEntrega(@PathVariable Long id){
		return entregaRepository.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
