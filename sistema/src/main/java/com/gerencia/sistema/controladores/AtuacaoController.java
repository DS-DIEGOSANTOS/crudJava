package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.atuacao.AtuacaoCriacaoDTO;
import com.gerencia.sistema.dtos.atuacao.AtuacaoResponse;
import com.gerencia.sistema.servicos.AtuacaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/atuacoes")
public class AtuacaoController {

    @Autowired
    private AtuacaoService service;


    @PostMapping
    public ResponseEntity<AtuacaoResponse> cadastrar(@RequestBody @Valid AtuacaoCriacaoDTO dto){

        AtuacaoResponse response = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}