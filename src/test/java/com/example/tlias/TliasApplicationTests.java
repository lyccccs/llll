package com.example.tlias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasApplicationTests {

    @Test
    void contextLoads() {
    }
   @Test
    public void testUuid(){
       for (int i = 0; i < 1000; i++) {
          String uuid = UUID.randomUUID().toString();
           System.out.println(uuid);
       }
   }
   @Test
   public  void testJwt(){
       Map<String, Object> claims = new HashMap<>();
       claims.put("id",1);
       claims.put("name","tom");
       String jwt = Jwts.builder()
               .signWith(SignatureAlgorithm.HS256,"itheima")
               .setClaims(claims)
               .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
               .compact();
       System.out.println(jwt);
   }
   @Test
    public void testParseJwt(){
       Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwMzI1MzEzNH0.yetoB-ktsUhDFBfPZ6SxreeoXWrDYg-bHkV-5s-XnT8")
                .getBody();
       System.out.println(claims);
   }
}
