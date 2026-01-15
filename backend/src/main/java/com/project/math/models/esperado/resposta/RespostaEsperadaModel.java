package com.project.math.models.esperado.resposta;

import com.project.math.models.exercicio.ExercicioModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resposta_esperada")
@Getter
@Setter
public class RespostaEsperadaModel {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRespostaEsperada;
    private int dimensao;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TipoObjeto tipoObjeto;

    @ManyToOne
    @JoinColumn(
            name = "id_exercicio",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_idExercicio_respostaEsperada")
    )
    private ExercicioModel exercicio;

    public RespostaEsperadaModel() {
    }

    public RespostaEsperadaModel( int dimensao, TipoObjeto tipoObjeto, ExercicioModel exercicio) {
        this.dimensao = dimensao;
        this.tipoObjeto = tipoObjeto;
        this.exercicio = exercicio;
    }
}
