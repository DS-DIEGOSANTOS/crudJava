package com.gerencia.sistema.servicos;

import java.util.List;

import com.gerencia.sistema.dtos.engenheiro.EngenheiroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencia.sistema.dtos.engenheiro.EngenheiroAtualizarDTO;
import com.gerencia.sistema.dtos.engenheiro.EngenheiroCriacaoDTO;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.repositorios.EngenheiroRepository;

@Service
public class EngenheiroService {

	  @Autowired
	  private EngenheiroRepository repository;

	  public EngenheiroResponse cadastrar(EngenheiroCriacaoDTO dto) {
	    return new EngenheiroResponse(repository.save(new Engenheiro(dto)));
	  }

	  public List<EngenheiroResponse> listarTodos() {
	    return repository
	        .findAll()
	        .stream()
	        .map(EngenheiroResponse::new).toList();
	  }

	  public EngenheiroResponse atualizar(Long id, EngenheiroAtualizarDTO dto) {
	    return repository
	        .findById(id)
	        .map(
	            record -> {
	              record.setNome(dto.nome());
	              record.setEspecialidade(dto.especialidade());
					return new EngenheiroResponse(repository.save(record));
	            }
	        )
	        .orElse(null);
	  }

	  public void deletar(Long id) {
		  repository.deleteById(id);
	  }
}
