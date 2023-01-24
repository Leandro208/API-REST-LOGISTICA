package io.github.leandro208.logistica.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leandro208.logistica.domain.model.Entrega;
import io.github.leandro208.logistica.domain.model.Ocorrencia;

@Service
public class OcorrenciaService {

	private BuscaEntregaService service;
	
	public OcorrenciaService(BuscaEntregaService service) {
		this.service = service;
	}

	@Transactional
	public Ocorrencia registrar(Long idEntrega, String descricao) {
		Entrega entrega = service.buscar(idEntrega);
		return entrega.adicionarOcorencia(descricao);
	}
}
