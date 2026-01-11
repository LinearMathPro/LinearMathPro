package com.project.math.models.correcao;

import com.project.math.models.aluno.RespostaAlunoModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "analise_correcao")
@Getter
@Setter
public class AnaliseCorrecaoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnaliseCorrecao;
    private boolean pertenceSpan;
    private boolean dependenteLinear;
    private boolean subespacosIguais;
    private Double erroResidual;
    private int dimensaoEncontrada;
    @ManyToOne
    @JoinColumn(
            name = "id_resposta_aluno",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_idRespostaAluno_analiseCorrecao")
    )
    private RespostaAlunoModel respostaAluno;

    public AnaliseCorrecaoModel(){}

    public AnaliseCorrecaoModel(Long idAnaliseCorrecao, boolean pertenceSpan, boolean dependenteLinear, boolean subespacosIguais, Double erroResidual, int dimensaoEncontrada, RespostaAlunoModel respostaAluno) {
        this.idAnaliseCorrecao = idAnaliseCorrecao;
        this.pertenceSpan = pertenceSpan;
        this.dependenteLinear = dependenteLinear;
        this.subespacosIguais = subespacosIguais;
        this.erroResidual = erroResidual;
        this.dimensaoEncontrada = dimensaoEncontrada;
        this.respostaAluno = respostaAluno;
    }
}
