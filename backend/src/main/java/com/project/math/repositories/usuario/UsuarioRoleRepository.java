package com.project.math.repositories.usuario;

import com.project.math.models.usuario.UsuarioRoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRoleModel, Long> {
}
