package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.entidades.Atuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtuacaoRepository extends JpaRepository<Atuacao, Long> {
}
