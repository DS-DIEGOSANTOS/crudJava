package com.gerencia.sistema.dtos.engenheiro;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Especialidade;

public record EngenheiroResponse(String nome, Especialidade especialidade){

    public EngenheiroResponse(Engenheiro engenheiro){
        this(engenheiro.getNome(), engenheiro.getEspecialidade());
    }
}