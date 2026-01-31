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

    private String nomeUsuario;

    private String email;

    private String senha;

    public UsuarioModel(){};
    public UsuarioModel(String nomeUsuario, String email,String senha){
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
