package com.project.math.models.sala;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
// Classe que representa a PK da SalaUsuario
public class SalaUsuarioId implements Serializable {
    private Long idSala;
    private Long idUsuario;

    public SalaUsuarioId(){}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaUsuarioId that = (SalaUsuarioId) o;
        return Objects.equals(idSala, that.idSala)
                && Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSala, idUsuario);
    }

}
