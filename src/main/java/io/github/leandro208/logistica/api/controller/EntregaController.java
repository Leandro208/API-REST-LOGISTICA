package io.github.leandro208.logistica.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaService entregaService;

	public EntregaController(EntregaService entregaService) {
		this.entregaService = entregaService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@RequestBody Entrega entrega) {
		return entregaService.solicitar(entrega);
	}
	
	
}
