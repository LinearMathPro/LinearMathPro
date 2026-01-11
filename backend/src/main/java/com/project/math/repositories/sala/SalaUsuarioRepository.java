package com.project.math.repositories.sala;

import com.project.math.models.sala.SalaUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaUsuarioRepository extends JpaRepository<SalaUsuarioModel, Long> {
}
