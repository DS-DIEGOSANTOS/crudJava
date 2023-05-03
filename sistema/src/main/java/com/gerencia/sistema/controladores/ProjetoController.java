package com.gerencia.sistema.controladores;

import com.gerencia.sistema.dtos.projeto.ProjetoDTO;
import com.gerencia.sistema.dtos.projeto.ProjetoResponse;
import com.gerencia.sistema.servicos.ProjetoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResponse> cadastrar(@RequestBody @Valid ProjetoDTO projetoDTO){
        ProjetoResponse dto = service.cadastrar(projetoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponse>> listarTodos(){
        return ResponseEntity.ok().body(service.listarTodos());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProjetoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ProjetoDTO dto){
        return ResponseEntity.ok().body(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}