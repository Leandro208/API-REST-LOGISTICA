package io.github.leandro208.logistica.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.github.leandro208.logistica.api.dto.OcorrenciaDTO;
import io.github.leandro208.logistica.domain.model.Ocorrencia;

@Component
public class OcorrenciaAssembler {

	private ModelMapper modelMapper;
	
	public OcorrenciaAssembler(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}
	
	public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias){
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
