package com.project.math.repositories.aluno;

import com.project.math.models.aluno.RespostaAlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaAlunoRepository extends JpaRepository<RespostaAlunoModel, Long> {
}
