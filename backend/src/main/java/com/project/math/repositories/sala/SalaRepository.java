package com.project.math.repositories.sala;

import com.project.math.models.sala.SalaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<SalaModel, Long> {
}
