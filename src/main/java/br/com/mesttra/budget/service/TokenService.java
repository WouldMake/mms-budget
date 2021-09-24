package br.com.mesttra.budget.service;

import br.com.mesttra.budget.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration.local}")
    private String tokenExpirationTimeout;
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateJwt(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();

        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + Long.parseLong(tokenExpirationTimeout));

        String stringJwt = Jwts.builder()
                .setIssuer("mms.mesttra.com.br")
                .setSubject(currentUser.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(KEY)
                .claim("test",true)
                .compact();

        this.isTokenValid(stringJwt);

        return stringJwt;

    }

    public boolean isTokenValid (String tokenWithoutBearer) {

        try {
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(KEY).build();
            jwtParser.parseClaimsJws(tokenWithoutBearer);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Long getSub (String tokenWithoutBearer) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(KEY).build();
        Claims payload = jwtParser.parseClaimsJws(tokenWithoutBearer).getBody();

        String subject = payload.getSubject();
        return Long.parseLong(subject);
    }
}
