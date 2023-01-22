package io.github.leandro208.logistica.api.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.leandro208.logistica.domain.model.Cliente;
import io.github.leandro208.logistica.domain.repository.ClienteRepository;
import io.github.leandro208.logistica.domain.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteService service;
	
	private ClienteRepository clienteReposiory;
	
	public ClienteController(ClienteService service, ClienteRepository clienteReposiory) {
		this.service = service;
		this.clienteReposiory = clienteReposiory;
	}

	@GetMapping
	public List<Cliente> listar() {
		return clienteReposiory.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		return clienteReposiory.findById(id)
				.map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adcionar(@Valid @RequestBody Cliente cliente) {
		return service.salvar(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id,
			@Valid @RequestBody Cliente cliente){
		if(!clienteReposiory.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente =  service.salvar(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if(!clienteReposiory.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		service.excluir(id);
		 return ResponseEntity.noContent().build();
	}
}
