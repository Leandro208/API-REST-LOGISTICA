package io.github.leandro208.logistica.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.leandro208.logistica.api.assembler.OcorrenciaAssembler;
import io.github.leandro208.logistica.api.dto.OcorrenciaDTO;
import io.github.leandro208.logistica.api.dto.input.OcorrenciaInput;
import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.model.Ocorrencia;
import io.github.leandro208.logistica.domain.service.BuscaEntregaService;
import io.github.leandro208.logistica.domain.service.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private OcorrenciaService ocorrenciaService;
	private BuscaEntregaService buscaEntregaService;
	private OcorrenciaAssembler assembler;

	public OcorrenciaController(OcorrenciaService ocorrenciaService, BuscaEntregaService buscaEntregaService,
			OcorrenciaAssembler assembler) {
		this.ocorrenciaService = ocorrenciaService;
		this.buscaEntregaService = buscaEntregaService;
		this.assembler = assembler;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId, 
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return assembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId){
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return assembler.toCollectionModel(entrega.getOcorrencias());
	}
}
