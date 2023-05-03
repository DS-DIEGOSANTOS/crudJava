package com.gerencia.sistema.servicos;

import com.gerencia.sistema.dtos.atuacao.AtuacaoCriacaoDTO;
import com.gerencia.sistema.dtos.atuacao.AtuacaoResponse;
import com.gerencia.sistema.entidades.Atuacao;
import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import com.gerencia.sistema.repositorios.AtuacaoRepository;
import com.gerencia.sistema.repositorios.EngenheiroRepository;
import com.gerencia.sistema.repositorios.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AtuacaoService {
    @Autowired
    private AtuacaoRepository atuacaoRepository;

    @Autowired
    private EngenheiroRepository engenheiroRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public AtuacaoResponse cadastrar(AtuacaoCriacaoDTO dto){

        Optional<Engenheiro> engenheiro = engenheiroRepository.findById(dto.engenheiroId());
        Optional<Projeto> projeto = projetoRepository.findById(dto.projetoId());

        if(engenheiro.isPresent() && projeto.isPresent()){
            Atuacao atuacao = new Atuacao(
                    engenheiro.get(),
                    projeto.get(),
                    dto.duracao()
            );

            return new AtuacaoResponse(atuacaoRepository.save(atuacao));
        }

        return null;
    }

    public void deletar(Long id){
        atuacaoRepository.deleteById(id);
    }
}
