package com.project.math.models.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "usuario")
@Getter
@Setter
@Data
public class UsuarioModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;

    public UsuarioModel(){};
    public UsuarioModel(Long idUsuario,String nomeUsuario, String email,String senha){
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

}
