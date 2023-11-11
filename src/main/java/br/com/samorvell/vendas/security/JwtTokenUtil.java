package br.com.samorvell.vendas.security;

import br.com.samorvell.vendas.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class JwtTokenUtil {

    private static final String SECRET_KEY = "*sa@R@faellaPedroMaria@28262419*";
    private static final int EXPIRATION = 3*60*1000;
    private static final String PREFIX = "Bearer ";
    private static final String HEADER_AUTH = "Authorization";

    private JwtTokenUtil(){
    }


    public static String genarateToken(Usuario usuario){

    Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    String jwt = Jwts.builder()
            .setSubject(usuario.getUsername())
            .setIssuer("*Ghandalf*")
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact();
    return PREFIX + jwt;

    }

    private static boolean isIssuerValid(String issuer){
        return issuer.equals("*Ghandalf*");
    }

    private static boolean isSubjectValid(String subject){
        return subject != null && subject.length()>0;
    }

    private static boolean isExpirationValid(Date expiration){
        return expiration.after(new Date(System.currentTimeMillis()));
    }

    public static UsernamePasswordAuthenticationToken decodeToken (HttpServletRequest request){

        String token = request.getHeader(HEADER_AUTH);
        token = token.replace(PREFIX, ""); //retira o Bearer

        Jws<Claims> jswClaims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.getBytes())
                .build()
                .parseClaimsJws(token);

        var username = jswClaims.getBody().getSubject();
        var emissor = jswClaims.getBody().getIssuer();
        var expiration = jswClaims.getBody().getExpiration();

        if(isSubjectValid(username) && isIssuerValid(emissor) && isExpirationValid(expiration)){
            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        }

        return null;
    }

}
