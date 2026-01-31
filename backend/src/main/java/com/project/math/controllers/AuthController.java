package com.project.math.controllers;

import com.project.math.dtos.LoginDTO;
import com.project.math.dtos.RegistroDTO;
import com.project.math.models.role.RoleModel;
import com.project.math.models.usuario.UsuarioModel;
import com.project.math.models.usuario.UsuarioRoleModel;
import com.project.math.repositories.role.RoleRepository;
import com.project.math.repositories.usuario.UsuarioRepository;
import com.project.math.repositories.usuario.UsuarioRoleRepository;
import com.project.math.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
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
    @Autowired
    public TokenService tokenService;
    @Autowired
    PasswordEncoder passwordEncoder;

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

            return tokenService.generateToken(novoUsuario);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar conta");
        }

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO data){
        Optional<UsuarioModel> userOptional = usuarioRepository.findByEmail(data.email());

        if(userOptional.isEmpty()) return ResponseEntity.badRequest().body("Credenciais Inválidas!");
        UsuarioModel user = userOptional.get();
        if (passwordEncoder.matches(data.senha(), user.getSenha())) {
            return this.tokenService.generateToken(user);
        }

        return ResponseEntity.badRequest().body("Credenciais Inválidas!");
    }

    @GetMapping("/professor/teste")
    public ResponseEntity<String> testeProfessor(){
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        return ResponseEntity.status(HttpStatus.OK).body(authorities.toString());
    }
    @GetMapping("/aluno/teste")
    public ResponseEntity<String> testeAluno(){
        Authentication auth = SecurityContextHolder
                .getContext()
                .getAuthentication();

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        return ResponseEntity.status(HttpStatus.OK).body(authorities.toString());
    }
}
