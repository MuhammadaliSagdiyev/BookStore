package uz.yt.springdata.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${spring.security.secret.key}")
    private String secretKey;

    public String generateToken(String uuid){
        return Jwts.builder()
                .setSubject(uuid)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(1)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Claims getClaims(String token){
            return Jwts
                    .parserBuilder()
                    .setSigningKey(secretKey)
                    .build()//parser
                    .parseClaimsJws(token)
                    .getBody();
    }

    /**
     * Returns null if token is invalid
     * @return String or null
     */
    public String validateTokenAndGetSubject(String token){
        try {
            return getClaims(token).getSubject();
        }catch (Exception e){
            return null;
        }
    }


}
