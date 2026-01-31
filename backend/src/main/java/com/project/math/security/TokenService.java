package com.project.math.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.math.dtos.TokenDataDTO;
import com.project.math.models.role.RoleModel;
import com.project.math.models.role.TipoRole;
import com.project.math.models.usuario.UsuarioModel;
import com.project.math.models.usuario.UsuarioRoleModel;
import com.project.math.repositories.role.RoleRepository;
import com.project.math.repositories.usuario.UsuarioRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    @Autowired
    UsuarioRoleRepository usuarioRoleRepository;
    @Autowired
    RoleRepository roleRepository;
    public ResponseEntity<String> generateToken(UsuarioModel usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("login-auth-api")
                    .withSubject(usuario.getIdUsuario().toString()) // ID como subject
                    .withClaim("role", descobrirRole(usuario.getIdUsuario()).toString())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);

            //
            ResponseCookie cookie = ResponseCookie.from("authToken",token)
                    .httpOnly(true)
                    .secure(true)
                    .path("/")
                    .maxAge(7 * 24 * 60 * 60)
                    .sameSite("None")
                    .build();


            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body(cookie.toString());

            //return ResponseEntity.status(HttpStatus.OK).body(token);
        } catch (JWTCreationException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro ao autenticar");
        }
    }

    public TokenDataDTO validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            DecodedJWT jwt = JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token);

            Long userId = Long.parseLong(jwt.getSubject());
            String role = jwt.getClaim("role").asString();

            return new TokenDataDTO(userId, role);

        } catch (JWTVerificationException e) {
            return null;
        }
    }
    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }

    private TipoRole descobrirRole(Long idUsuario) {

        UsuarioRoleModel usuarioRole = usuarioRoleRepository
                .findByUsuario_IdUsuario(idUsuario)
                .orElseThrow(() -> new RuntimeException("Role não encontrada"));

        return usuarioRole.getRole().getNomeRole();
    }
}
