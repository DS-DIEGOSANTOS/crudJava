package com.gerencia.sistema.dtos.projeto;


import com.gerencia.sistema.entidades.Categoria;
import com.gerencia.sistema.entidades.Projeto;

public record ProjetoResponse(String nome, Categoria categoria){

    public ProjetoResponse(Projeto projeto){
        this( projeto.getNome(), projeto.getCategoria());
    }
}