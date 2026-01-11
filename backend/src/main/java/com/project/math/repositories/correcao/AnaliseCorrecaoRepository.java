package com.project.math.repositories.correcao;

import com.project.math.models.correcao.AnaliseCorrecaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseCorrecaoRepository extends JpaRepository<AnaliseCorrecaoModel , Long> {
}
