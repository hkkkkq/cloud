package com.lwhtarena;

import io.jsonwebtoken.*;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.xml.transform.Source;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwh
 * @Title: TestJWT
 * @Package com.lwhtarena
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/16 20:38
 */
public class TestJWT {

    /**
     * 1) 标准注册声明
     *   iss: jwt签发者
     *   sub: jwt所面向的用户
     *   aud: 接收jwt的一方
     *   exp: jwt的过期时间，这个过期时间必须要大于签发时间
     *   nbf: 定义在什么时间之前，该jwt都是不可用的.
     *   iat: jwt的签发时间
     *   jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     */
    @Test
    public void testCreateJWT(){
        /**构建jwt令牌的对象**/
        JwtBuilder builder =Jwts.builder();
        builder.setId("888");          //设置唯一编号
        builder.setIssuer("lwhtarena公司"); //颁发者
        builder.setIssuedAt(new Date());//颁发时间
        builder.setSubject("jwt令牌测试"); //主题信息
        builder.setAudience("声明"); //接收jwt的一方
        builder.setExpiration(new Date(System.currentTimeMillis()+500000)); //设置5秒过期
        builder.signWith(SignatureAlgorithm.HS256, "lwhtarena");//1.签名算法 2.秘钥（盐）

        /**可以自定义载荷**/
        Map<String, Object> map = new HashMap<>();
        map.put("campany","lwhtarena");
        map.put("address","广州天河珠江新城");
        map.put("money","2千万");
        builder.addClaims(map);

        String token =builder.compact();
        System.out.println(token);

        System.out.println(Jwts.parser().setSigningKey("lwhtarena").parseClaimsJws(token).getBody());
    }

    @Test
    public void testParseJWT(){
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI4ODgiLCJpc3MiOiJsd2h0YXJlbmHlhazlj7giLCJpYXQiOjE1OTQ5MDU0MTcsInN1YiI6Imp3dOS7pOeJjOa1i-ivlSIsImF1ZCI6IuWjsOaYjiIsImV4cCI6MTU5NDkwNTQ2N30.vJSG5bEoapLrUX0ss5K_LL2x1XtkW4TL6xC9HDDFRQg";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey("lwhtarena").parseClaimsJws(token);

        System.out.println(claimsJws.getBody());
        System.out.println(claimsJws.getSignature());
        System.out.println(claimsJws.getHeader());
    }



    @Test
    public void createJwt(){
        long currentTimeMillis = System.currentTimeMillis();
        long l = currentTimeMillis + 20000;
        //生成令牌
        //创建jwtbuilder
        JwtBuilder builder = Jwts.builder();
        //1.头(不设置,默认) 2 载荷(数据) 3. 签名
        builder.setId("唯一的标识")
                .setIssuer("颁发者")//生成令牌的一方
                .setSubject("主题")//就是描述 jwt的信息
                .setExpiration(new Date(l))//设置过期时间
                .signWith(SignatureAlgorithm.HS256,"itcast");//设置签名

        //3.可以自定义载荷
        Map<String, Object> map = new HashMap<>();
        map.put("myaddress","cn");
        map.put("mycity","sz");
        builder.addClaims(map);

        //生成令牌
        String compact = builder.compact();
        System.out.println(compact);

    }

    @Test
    public void parseJwt(){
        //String  st = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLllK_kuIDnmoTmoIfor4YiLCJpc3MiOiLpooHlj5HogIUiLCJzdWIiOiLkuLvpopgifQ.AU33UoJ8Vz_ZoCtKcvCEm5R0UFknLE-06E49z1h0nfI";
        //String  st = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLllK_kuIDnmoTmoIfor4YiLCJpc3MiOiLpooHlj5HogIUiLCJzdWIiOiLkuLvpopgiLCJteWNpdHkiOiJzeiIsIm15YWRkcmVzcyI6ImNuIn0.VbuggDeIH66QlRAWGxoWPIKaRkCZOy45G-hAyz0Nq_k";
        String  st = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiLllK_kuIDnmoTmoIfor4YiLCJpc3MiOiLpooHlj5HogIUiLCJzdWIiOiLkuLvpopgiLCJleHAiOjE1NjY5ODU0NTMsIm15Y2l0eSI6InN6IiwibXlhZGRyZXNzIjoiY24ifQ.KtmMC-Hu1qlmYQgmLphoITQSZWRVv8YDssLZURKyczY";
        //解析令牌
        Jws<Claims> itcast = Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws(st);
        System.out.println(itcast.getBody());
    }
}
