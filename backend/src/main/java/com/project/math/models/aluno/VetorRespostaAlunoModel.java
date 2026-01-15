package com.project.math.models.aluno;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table (name = "vetor_resposta_aluno")
@Getter
@Setter
public class VetorRespostaAlunoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVetorRespostaAluno;
    private String ordem; //nao tenho certeza se é String ou int

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> componente;

    @ManyToOne
    @JoinColumn(
            name = "id_resposta_aluno",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_respostaAluno")
    )
    private RespostaAlunoModel respostaAluno;

    public VetorRespostaAlunoModel(){}

    public VetorRespostaAlunoModel(String ordem, Map<String, Object> componente, RespostaAlunoModel respostaAluno) {
        this.ordem = ordem;
        this.componente = componente;
        this.respostaAluno = respostaAluno;
    }
}
