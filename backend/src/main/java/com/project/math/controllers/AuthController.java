package com.project.math.controllers;

import com.project.math.dtos.RegistroDTO;
import com.project.math.models.role.RoleModel;
import com.project.math.models.usuario.UsuarioModel;
import com.project.math.models.usuario.UsuarioRoleModel;
import com.project.math.repositories.role.RoleRepository;
import com.project.math.repositories.usuario.UsuarioRepository;
import com.project.math.repositories.usuario.UsuarioRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    public UsuarioRepository usuarioRepository;
    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    public UsuarioRoleRepository usuarioRoleRepository;
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarNovaConta (@RequestBody RegistroDTO data){
        if (usuarioRepository.findByEmail(data.email()).isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este email está sendo utilizado");
        try {
            //cria usuario
            String senhaCriptografada = new BCryptPasswordEncoder().encode(data.senha());
            UsuarioModel novoUsuario = new UsuarioModel(data.nome(), data.email(), senhaCriptografada);
            usuarioRepository.save(novoUsuario);
            //adiciona id usuario e id role na tabela usuario_role
            Optional<RoleModel> role = roleRepository.findByNomeRole(data.role());
            RoleModel roleGet = role.get();
            UsuarioRoleModel salvarRole = new UsuarioRoleModel(novoUsuario, roleGet);
            usuarioRoleRepository.save(salvarRole);


        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar conta");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Conta criada com sucesso");
    }
}
