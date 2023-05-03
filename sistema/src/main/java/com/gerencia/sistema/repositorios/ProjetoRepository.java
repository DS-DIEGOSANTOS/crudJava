package com.gerencia.sistema.repositorios;

import com.gerencia.sistema.entidades.Engenheiro;
import com.gerencia.sistema.entidades.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
