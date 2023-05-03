package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.projeto.ProjetoDTO;
import com.gerencia.sistema.dtos.projeto.ProjetoResponse;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepository repository;

    public ProjetoResponse cadastrar(ProjetoDTO request){
        var data = repository.save(new Projeto(request));
        return new ProjetoResponse(data);
    }

    public List<ProjetoResponse> listarTodos(){
        return repository.findAll().stream().map(ProjetoResponse::new).toList();
    }

    public ProjetoResponse atualizar(Long id, ProjetoDTO dto){
        return repository.findById(id).map(
                record -> {
                    record.setNome(dto.nome());
                    record.setCusto(dto.custo());
                    record.setCategoria(dto.categoria());
                    return new ProjetoResponse(repository.save(record));
                }
        ).orElse(null);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
