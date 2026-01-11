package com.project.math.repositories.lista;

import com.project.math.models.lista.ListaExerciciosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaExerciciosRepository extends JpaRepository<ListaExerciciosModel, Long> {
}
