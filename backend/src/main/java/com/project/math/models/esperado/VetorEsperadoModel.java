package com.project.math.models.esperado;

import com.project.math.models.esperado.resposta.RespostaEsperadaModel;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table (name =  "vetor_esperado")
@Getter
@Setter
public class VetorEsperadoModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVetorEsperado;
    private String ordem; //nao tenho certeza se é String ou int

    @Type(JsonType.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> componente;

    @ManyToOne
    @JoinColumn(
            name = "id_resposta_esperada",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_idRespostaEsperada")
    )
    private RespostaEsperadaModel respostaEsperada;

    public VetorEsperadoModel() {
    }

    public VetorEsperadoModel( String ordem, Map<String, Object> componente, RespostaEsperadaModel respostaEsperada) {
        this.ordem = ordem;
        this.componente = componente;
        this.respostaEsperada = respostaEsperada;
    }
}
