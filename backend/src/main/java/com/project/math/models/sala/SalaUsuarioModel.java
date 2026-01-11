package com.project.math.models.sala;

import com.project.math.models.usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table (name = "sala_usuario")
@Getter
public class SalaUsuarioModel {
    @EmbeddedId
    private SalaUsuarioId id;

    @ManyToOne
    @MapsId("idSala")
    @JoinColumn(name = "id_sala")
    private SalaModel sala;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    public SalaUsuarioModel() {
    }

    public SalaUsuarioModel(SalaUsuarioId id, SalaModel sala, UsuarioModel usuario) {
        this.id = id;
        this.sala = sala;
        this.usuario = usuario;
    }
}
