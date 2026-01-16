package com.project.math.models.usuario;

import com.project.math.models.role.RoleModel;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "usuario_role")
@Getter
public class UsuarioRoleModel {

    @EmbeddedId
    private UsuarioRoleId id = new UsuarioRoleId();

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    @ManyToOne
    @MapsId("idRole")
    @JoinColumn(name = "id_role")
    private RoleModel role;

    public UsuarioRoleModel(UsuarioModel usuario, RoleModel role) {
        this.usuario = usuario;
        this.role = role;
    }
    public UsuarioRoleModel(){}
}
