package com.gerencia.sistema.dtos.atuacao;

import jakarta.validation.constraints.NotNull;

public record AtuacaoCriacaoDTO(
	    @NotNull
	    Long engenheiroId,
	    @NotNull
	    Long projetoId,
	    @NotNull
	    int duracao){

	}
