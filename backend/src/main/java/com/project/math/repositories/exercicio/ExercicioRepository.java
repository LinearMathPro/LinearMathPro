package com.project.math.repositories.exercicio;

import com.project.math.models.exercicio.ExercicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioModel, Long> {
}
