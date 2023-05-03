package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.engenheiro.EngenheiroAtualizarDTO;
import com.gerencia.sistema.dtos.engenheiro.EngenheiroCriacaoDTO;
import com.gerencia.sistema.dtos.engenheiro.EngenheiroResponse;
import com.gerencia.sistema.servicos.EngenheiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;

import java.util.List;

@RestController
@RequestMapping(path = "/engenheiros")
public class EngenheiroController {

    @Autowired
    private EngenheiroService service;


    @PostMapping
    public ResponseEntity<EngenheiroResponse> cadastrar(@RequestBody @Valid EngenheiroCriacaoDTO engenheiroDTO){

        EngenheiroResponse dto = service.cadastrar(engenheiroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @GetMapping
    public ResponseEntity<List<EngenheiroResponse>> listarTodos(){
        return ResponseEntity.ok().body(service.listarTodos());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EngenheiroResponse> atualizar(@PathVariable Long id, @RequestBody @Valid EngenheiroAtualizarDTO request){
        return ResponseEntity.ok().body(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
