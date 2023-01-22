package io.github.leandro208.logistica.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leandro208.logistica.domain.exception.NegocioException;
import io.github.leandro208.logistica.domain.model.Cliente;
import io.github.leandro208.logistica.domain.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso =  clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
