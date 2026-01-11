package com.project.math.repositories.aluno;

import com.project.math.models.aluno.VetorRespostaAlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetorRespostaAlunoRepository extends JpaRepository<VetorRespostaAlunoModel, Long> {
}
