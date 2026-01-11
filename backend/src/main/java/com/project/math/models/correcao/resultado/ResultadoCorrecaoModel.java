package com.project.math.models.correcao.resultado;

import com.project.math.models.aluno.RespostaAlunoModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resultado_correcao")
@Getter
@Setter
public class ResultadoCorrecaoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultadoCorrecao;
    private String feedbackTexto;
    private Double nota;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(
            name = "id_resposta_aluno",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_idRespostaAluno_resultadoCorrecao")
    )
    private RespostaAlunoModel respostaAluno;

    public ResultadoCorrecaoModel(){}

    public ResultadoCorrecaoModel(Long idResultadoCorrecao, String feedbackTexto, Double nota, Status status, RespostaAlunoModel respostaAluno) {
        this.idResultadoCorrecao = idResultadoCorrecao;
        this.feedbackTexto = feedbackTexto;
        this.nota = nota;
        this.status = status;
        this.respostaAluno = respostaAluno;
    }
}
