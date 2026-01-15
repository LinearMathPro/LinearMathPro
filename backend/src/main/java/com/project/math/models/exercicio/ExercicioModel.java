package com.project.math.models.exercicio;

import com.project.math.models.lista.ListaExerciciosModel;
import com.project.math.models.sala.SalaModel;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "exercicio")
@Getter
@Setter
public class ExercicioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercicio;
    private String enunciado;
    private Double tolerancia;
    private Double pontuacaoMaxima;

    @ElementCollection()
    @CollectionTable(
            name = "tipo_exercicio",
            joinColumns = @JoinColumn(name = "id_exercicio")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private Set<TipoExercicio> tipoExercicio = new HashSet<>();

    @ElementCollection()
    @CollectionTable(
            name = "criterio_correcao",
            joinColumns = @JoinColumn(name = "id_exercicio")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "criterio")
    private Set<CriterioCorrecao> criterioCorrecao = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "id_lista",
            nullable = false,
            foreignKey = @ForeignKey (name = "fk_idLista")
    )
    private ListaExerciciosModel lista;

    public ExercicioModel() {
    }

    public ExercicioModel( String enunciado, Double tolerancia, Double pontuacaoMaxima, Set<TipoExercicio> tipoExercicio, Set<CriterioCorrecao> criterioCorrecao, ListaExerciciosModel lista) {
        this.enunciado = enunciado;
        this.tolerancia = tolerancia;
        this.pontuacaoMaxima = pontuacaoMaxima;
        this.tipoExercicio = tipoExercicio;
        this.criterioCorrecao = criterioCorrecao;
        this.lista = lista;
    }
}
