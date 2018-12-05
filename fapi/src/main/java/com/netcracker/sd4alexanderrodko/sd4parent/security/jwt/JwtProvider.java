package com.netcracker.sd4alexanderrodko.sd4parent.security.jwt;

import com.netcracker.sd4alexanderrodko.sd4parent.models.AccountViewModel;
import com.netcracker.sd4alexanderrodko.sd4parent.service.UserDataService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${app.secret}")
    private String secret;

    @Value("${app.expiration}")
    private int expiration;


    @Autowired
    private UserDataService userDetailsService;

    public String generate(AccountViewModel user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(roleClaim(userDetails.getAuthorities().toArray()[0].toString()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expiration * 30))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validate(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }

    public String getRoleFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody().get("role").toString();
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }


    private Map<String,Object> roleClaim(String role){
        Map<String,Object> claims = new HashMap<>();
        claims.put("Role",role);
        return claims;
    }




}