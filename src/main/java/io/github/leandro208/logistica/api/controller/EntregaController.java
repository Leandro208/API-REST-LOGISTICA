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

import io.github.leandro208.logistica.api.assembler.EntregaAssembler;
import io.github.leandro208.logistica.api.dto.EntregaDTO;
import io.github.leandro208.logistica.api.dto.input.EntregaInput;
import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.repository.EntregaRepository;
import io.github.leandro208.logistica.domain.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaService entregaService;
	private EntregaRepository entregaRepository;
	private EntregaAssembler entregaAssembler;

	public EntregaController(EntregaService entregaService, EntregaRepository entregaRepository,
			EntregaAssembler entregaAssembler) {
		this.entregaService = entregaService;
		this.entregaRepository = entregaRepository;
		this.entregaAssembler = entregaAssembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaDTO> listar(){
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> buscarEntrega(@PathVariable Long id){
		return entregaRepository.findById(id)
				.map(entrega ->ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
}
