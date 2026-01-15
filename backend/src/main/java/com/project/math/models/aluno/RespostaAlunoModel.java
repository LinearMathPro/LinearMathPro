package com.project.math.models.aluno;

import com.project.math.models.exercicio.ExercicioModel;
import com.project.math.models.usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "resposta_aluno")
@Getter
@Setter
public class RespostaAlunoModel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRespostaAluno;
    private Date dataEnvio;
    @ManyToOne
    @JoinColumn(
            name = "id_exercicio",
            nullable = false,
            foreignKey = @ForeignKey (name = "fk_idExercicio_respostaAluno")
    )
    private ExercicioModel exercicio;
    @ManyToOne
    @JoinColumn(
            name = "id_usuario",
            nullable = false,
            foreignKey = @ForeignKey (name = "fk_idUsuario")
    )
    private UsuarioModel usuario;

    public RespostaAlunoModel(){}

    public RespostaAlunoModel( Date dataEnvio, ExercicioModel exercicio, UsuarioModel usuario) {
        this.dataEnvio = dataEnvio;
        this.exercicio = exercicio;
        this.usuario = usuario;
    }
}
