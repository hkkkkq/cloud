package com.lwhtarena.oauth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liwh
 * @Title: CreateJwtTestDemo
 * @Package com.lwhtarena.oauth
 * @Description: 令牌的创建和解析
 *
 * @Version 1.0.0
 * @date 2020/7/19 01:55
 */
public class CreateJwtTestDemo {

    /**
     * 创建令牌
     */
    @Test
    public void testCreateToken(){
        /**1、加载证书*/
        ClassPathResource resource =new ClassPathResource("changgou.jks");

        /**2、读取证书*/
        KeyStoreKeyFactory keyFactory =new KeyStoreKeyFactory(resource,"changgou".toCharArray());

        /**3、获取秘钥**/
        KeyPair keyPair = keyFactory.getKeyPair("changgou", "changgou".toCharArray());
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        //自定义Payload
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("id", "1");
        tokenMap.put("name", "itheima");
        tokenMap.put("roles", "ROLE_VIP,ROLE_USER");

        /**4、创建令牌**/
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(tokenMap), new RsaSigner(privateKey));
        String token =jwt.getEncoded();
        System.out.println(token);
        System.out.println(jwt.getClaims());
    }

    /**
     * 解析令牌
     */
    @Test
    public void testParseToken(){
        String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJpdGhlaW1hIiwiaWQiOiIxIn0.dMzouwYilrZu3jKf1KKiu6A2H_5PzCChUIDXDLRIendUF6pTgX8Vc5RJ41ZBIMSr1Cgcc4emUobe5BPAuF9BD_yF5eYsInYAS1bX9RD5-wdU8Pa1cuiUtKqwgN9ZZAakhsJswx89pNhkj27ParQb-R6NlSi-rbb4N1KcfxdJVe7fuyEMhEaAN5Igllcf_o2xisbq29a4By-z8fYZawrljuCbcm2m6obNI0zRKOLQxxMujbli0X1XoW2t-BMXt2obzkuNXU38HYSRkxlbQq8Frjzc4P-rpBGtwuhnBpfhA4ef6At5_tgF5oVAlDb0kh6WZ4ExEa1SBMc-DWZiqBrJxw";

        /**1、加载证书*/
        ClassPathResource resource =new ClassPathResource("changgou.jks");

        /**2、读取证书*/
        KeyStoreKeyFactory keyFactory =new KeyStoreKeyFactory(resource,"changgou".toCharArray());

        /**3、获取秘钥**/
        KeyPair keyPair = keyFactory.getKeyPair("changgou", "changgou".toCharArray());
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();


        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publicKey));
        System.out.println(jwt.getClaims());
        System.out.println(jwt.getEncoded());
    }

    /**
     * 解析令牌
     */
    @Test
    public void testParseToken2(){
        //令牌
        String token ="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJpdGhlaW1hIiwiaWQiOiIxIn0.dMzouwYilrZu3jKf1KKiu6A2H_5PzCChUIDXDLRIendUF6pTgX8Vc5RJ41ZBIMSr1Cgcc4emUobe5BPAuF9BD_yF5eYsInYAS1bX9RD5-wdU8Pa1cuiUtKqwgN9ZZAakhsJswx89pNhkj27ParQb-R6NlSi-rbb4N1KcfxdJVe7fuyEMhEaAN5Igllcf_o2xisbq29a4By-z8fYZawrljuCbcm2m6obNI0zRKOLQxxMujbli0X1XoW2t-BMXt2obzkuNXU38HYSRkxlbQq8Frjzc4P-rpBGtwuhnBpfhA4ef6At5_tgF5oVAlDb0kh6WZ4ExEa1SBMc-DWZiqBrJxw";

        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi7Drp7TubteIxAM71vQfH1trXsobxVrCAdONO3Moh6e+St0pP1IcLXBS5QtwF3dCIeCp9h9Tug0WZ3NRPJxBOl+h23nKgfnBpbqjQRa4/pZty4T4R9pqeVQtXpyUD1SyDCfy8hqVbd5wX+3l8+zHgKf3DmpEvfRxh0eRXcRV/5luU6T7Cu+7fu0eTbQpKT7gwDFRNRwhDIe+1uLgzmn/9ZpwtM7f3aumN97wFltsTMFlVFCr/3UDJXRt8opm2Qm3Z+vDA4x7qFgW5dVmXU3nCp7pjBK1zRMDnemRjiizo3Ha1mR9SJBA6zYgt1ZV71kndOjn5pPnq9f3RIZIAMgDyQIDAQAB-----END PUBLIC KEY-----";

        //校验Jwt
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容 载荷
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
