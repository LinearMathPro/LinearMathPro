package com.project.math.models.sala;

import com.project.math.models.usuario.UsuarioModel;
import jakarta.persistence.*;

@Entity
@Table (name = "sala")
public class SalaModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;
    private String NomeSala;
    private int codigoSala;
    @ManyToOne
    @JoinColumn(
            name = "id_professor",
            nullable = false,
            foreignKey = @ForeignKey (name = "fk_idProfessor_sala")
    )
    private UsuarioModel usuario;

    public SalaModel() {
    }

    public SalaModel( String nomeSala, int codigoSala, UsuarioModel usuario) {

        NomeSala = nomeSala;
        this.codigoSala = codigoSala;
        this.usuario = usuario;
    }
}
