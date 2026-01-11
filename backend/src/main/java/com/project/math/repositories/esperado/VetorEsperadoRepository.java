package com.project.math.repositories.esperado;

import com.project.math.models.esperado.VetorEsperadoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetorEsperadoRepository extends JpaRepository<VetorEsperadoModel, Long> {
}
