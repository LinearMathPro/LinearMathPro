package com.project.math.repositories.role;

import com.project.math.models.role.RoleModel;
import com.project.math.models.role.TipoRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByNomeRole (TipoRole nome);
}
