package io.github.leandro208.logistica.api.dto.input;

import javax.validation.constraints.NotNull;

public class ClienteIdINput {

	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
