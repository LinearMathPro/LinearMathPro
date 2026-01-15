package com.project.math.models.lista;

import com.project.math.models.sala.SalaModel;
import com.project.math.models.usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "lista_exercicios")
@Getter
@Setter
public class ListaExerciciosModel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idListaExercicios;
    private String nomeListaExercicios;
    private Date data_criacao;

    @ManyToOne
    @JoinColumn(
            name = "idSala",
            nullable = false,
            foreignKey = @ForeignKey ( name = "fk_idSala")
    )
    private SalaModel sala;

    @ManyToOne
    @JoinColumn(
            name = "idProfessor",
            nullable = false,
            foreignKey = @ForeignKey (name = "fk_idProfessor_lista")
    )
    private UsuarioModel usuario;

    public ListaExerciciosModel() {
    }

    public ListaExerciciosModel(String nomeListaExercicios, Date data_criacao, SalaModel sala, UsuarioModel usuario) {
        this.nomeListaExercicios = nomeListaExercicios;
        this.data_criacao = data_criacao;
        this.sala = sala;
        this.usuario = usuario;
    }
}
