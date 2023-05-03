package com.gerencia.sistema.dtos.atuacao;

import com.gerencia.sistema.dtos.engenheiro.EngenheiroCriacaoDTO;
import com.gerencia.sistema.dtos.projeto.ProjetoResponse;
import com.gerencia.sistema.entidades.Atuacao;

public record AtuacaoResponse(EngenheiroCriacaoDTO engenheiro, ProjetoResponse projeto, int duracao){
    public AtuacaoResponse(Atuacao atuacao){
        this(
                new EngenheiroCriacaoDTO(atuacao.getEngenheiro()),
                new ProjetoResponse(atuacao.getProjeto()),
                atuacao.getDuracao()
        );
    }
}