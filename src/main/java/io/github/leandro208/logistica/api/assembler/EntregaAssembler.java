package io.github.leandro208.logistica.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.github.leandro208.logistica.api.dto.EntregaDTO;
import io.github.leandro208.logistica.api.dto.input.EntregaInput;
import io.github.leandro208.logistica.domain.model.Entrega;

@Component
public class EntregaAssembler {

	private ModelMapper modelMapper;

	public EntregaAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public EntregaDTO toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	public List<EntregaDTO> toCollectionModel(List<Entrega> entregas){
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
