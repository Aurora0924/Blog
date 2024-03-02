import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class JWTTest {

    private final static String SIGN = "Even";

    /**
     * JWT的使用
     */
    @Test
    public void Test(){
        JwtBuilder jwtBuilder = Jwts.builder();
        String compact = jwtBuilder.setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")

                .claim("username", "admin").claim("nickname", "管理员")
                .setSubject("admin-even").setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS256, SIGN)
                .compact();
        System.out.println(compact);
    }
    @Test
    public void ConformJWT(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwibmlja25hbWUiOiLnrqHnkIblkZgiLCJzdWIiOiJhZG1pbi1ldmVuIiwianRpIjoiMGQ0YjE3NjItOWE5ZC00NGJhLTgxYTUtOTQwYzVlNzY1ODBlIn0.imM1zhnVtIoX7t2U1UZYNqx_o0sjafGVm809Rpgk-PI";
        boolean result = Jwts.parser().isSigned(token);
        System.out.println(result);


    }
    @Test
    public void JwtInfo(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwibmlja25hbWUiOiLnrqHnkIblkZgiLCJzdWIiOiJhZG1pbi1ldmVuIiwianRpIjoiMGQ0YjE3NjItOWE5ZC00NGJhLTgxYTUtOTQwYzVlNzY1ODBlIn0.imM1zhnVtIoX7t2U1UZYNqx_o0sjafGVm809Rpgk-PI";

       Jws<Claims> jws = Jwts.parser().setSigningKey(SIGN).parseClaimsJws(token);
        System.out.println(jws.getBody().get("username"));
        System.out.println(jws.getBody().get("nickname"));
        System.out.println(jws.getBody().getId());
        System.out.println(jws.getBody().getSubject());
    }
}
