package br.com.limpay.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class TokenConsultaSecurity {
    private static final String SECRET_KEY = "chave do JWT";
    private static final long EXPIRATION_TIME = 864_000_000;

    public static String gerarToken(String email){
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extrairEmail(String token){
        return extrairClaims(token, Claims::getSubject);
    }

    public Date extrairExpiration(String token){
        return extrairClaims(token, Claims::getExpiration);
    }

    public <T> T extrairClaims(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extrairTodosClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extrairTodosClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean tokenExpired(String token){
        return extrairExpiration(token).before(new Date());
    }

    public Boolean validarToken(String token, UserDetails userDetails){
        final String email = extrairEmail(token);
        return (email.equals(userDetails.getUsername()) && !tokenExpired(token));
    }
}
