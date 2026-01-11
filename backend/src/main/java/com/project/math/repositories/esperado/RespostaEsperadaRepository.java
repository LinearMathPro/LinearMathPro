package com.project.math.repositories.esperado;

import com.project.math.models.esperado.resposta.RespostaEsperadaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaEsperadaRepository extends JpaRepository<RespostaEsperadaModel, Long> {
}
