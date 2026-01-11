package com.project.math.repositories.correcao;

import com.project.math.models.correcao.resultado.ResultadoCorrecaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultadoCorrecaoRepository extends JpaRepository<ResultadoCorrecaoModel , Long> {
}
