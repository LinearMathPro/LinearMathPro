package com.project.math.models.usuario;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
// Classe que representa a PK da UsuarioRole
@Getter
@Setter
public class UsuarioRoleId implements Serializable {

    private Long idUsuario;
    private Long idRole;
    public UsuarioRoleId() {}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRoleId that = (UsuarioRoleId) o;
        return Objects.equals(idUsuario, that.idUsuario)
                && Objects.equals(idRole, that.idRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idRole);
    }
}