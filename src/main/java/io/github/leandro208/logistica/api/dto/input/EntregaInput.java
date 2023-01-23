package io.github.leandro208.logistica.api.dto.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class EntregaInput {

	@Valid
	@NotNull
	private ClienteIdINput cliente;
	
	@Valid
	@NotNull
	private DestinatarioInput destinatario;
	
	@NotNull
	private BigDecimal taxa;

	public ClienteIdINput getCliente() {
		return cliente;
	}

	public void setCliente(ClienteIdINput cliente) {
		this.cliente = cliente;
	}

	public DestinatarioInput getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(DestinatarioInput destinatario) {
		this.destinatario = destinatario;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	
	
	
}	
