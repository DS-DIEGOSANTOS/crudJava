package com.gerencia.sistema.dtos.engenheiro;

import com.gerencia.sistema.entidades.Especialidade;

import jakarta.validation.constraints.NotNull;

public record EngenheiroAtualizarDTO(
	@NotNull
	String nome,
	@NotNull
	Especialidade especialidade) {

}
