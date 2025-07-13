package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import med.voll.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secred;

    public String generarToken(Usuario usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secred);
            return JWT.create()
                    .withIssuer("Api Voll.med")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error al generar token ", exception);
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(12).toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm = Algorithm.HMAC256(secred);
            return JWT.require(algorithm)
                    .withIssuer("Api Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT Inválido o expirado");
        }
    }
}
