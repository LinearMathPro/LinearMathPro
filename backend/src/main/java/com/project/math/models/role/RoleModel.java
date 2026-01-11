package com.project.math.models.role;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
@Data
public class RoleModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private TipoRole nomeRole;

    public RoleModel(){}

    public RoleModel(Long idRole, TipoRole nomeRole) {
        this.idRole = idRole;
        this.nomeRole = nomeRole;
    }
}
