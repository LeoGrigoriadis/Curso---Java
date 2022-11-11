package clase12.clase_12.Configuration;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtils implements Serializable{
    
    private final String secret  = "fmkt";
    private Date expirationDate = new Date(System.currentTimeMillis() + 604800L + 1000); 

    public String generateToken(Map<String, Object> claims) throws UnsupportedEncodingException{
        
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).
        signWith(SignatureAlgorithm.HS512, secret.getBytes("UTF-8")).compact();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret.getBytes("UTF-8")).parseClaimsJws(token);
            return true;
        }catch (Exception e){
            System.err.println("problemas con el token...");
            return false;
        }
    }

    public String generateToken( UserDetails userDetails) throws UnsupportedEncodingException{
        HashMap<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate).
        signWith(SignatureAlgorithm.HS512, secret.getBytes("UTF-8")).compact();
    }
}
