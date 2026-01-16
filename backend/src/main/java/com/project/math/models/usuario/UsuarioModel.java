package com.project.math.models.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "usuario")

public class UsuarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Setter @Getter
    private Long idUsuario;
    @Setter @Getter
    private String nomeUsuario;
    @Setter @Getter
    private String email;
    @Setter @Getter
    private String senha;

    public UsuarioModel(){};
    public UsuarioModel(String nomeUsuario, String email,String senha){
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }


}
