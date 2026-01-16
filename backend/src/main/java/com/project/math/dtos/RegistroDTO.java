package com.project.math.dtos;

import com.project.math.models.role.TipoRole;

public record RegistroDTO(String nome , String email , String senha , TipoRole role) {
}
