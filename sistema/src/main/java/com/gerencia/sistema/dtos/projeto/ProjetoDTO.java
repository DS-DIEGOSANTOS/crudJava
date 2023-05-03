
package com.gerencia.sistema.dtos.projeto;

import com.gerencia.sistema.entidades.Categoria;
import jakarta.validation.constraints.NotNull;

public record ProjetoDTO(
        @NotNull
        String nome,
        @NotNull
        double custo,
        @NotNull
        Categoria categoria
) {
}
