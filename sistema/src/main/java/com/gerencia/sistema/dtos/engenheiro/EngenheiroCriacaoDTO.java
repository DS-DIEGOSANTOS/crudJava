package com.gerencia.sistema.dtos.engenheiro;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;

import jakarta.validation.constraints.NotNull;

public record EngenheiroCriacaoDTO(
	    @NotNull
	    String nome,
	    @NotNull
	    String CREA,
	    @NotNull
	    Especialidade especialidade) {
	
	public EngenheiroCriacaoDTO(Engenheiro engenheiro) {
		this(engenheiro.getNome(), engenheiro.getCREA(), engenheiro.getEspecialidade());
	}

}
