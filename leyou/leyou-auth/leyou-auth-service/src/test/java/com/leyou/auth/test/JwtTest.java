package com.leyou.auth.test;

import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.auth.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "D:\\tools\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\tools\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "leyou@Login(Auth}*^31)&heiMa%");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        //String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU4NTI5MDYwNX0.BCgbg-PMDxPeajO2Hfwred3LEcoLdLlw-fe20ZsRBlkPQNyY6RvCbXuqfJ8109sPp2YePn7lJUwLrFPjaGIi_IaA9SgdT2sMGfpZLpZhWBJwku8-vPHYXDYEZcUDnUjocdhx7HH6WaQ7RViMEzdyE8I4XhnVK8v1d4H4RFDxakg";
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MzIsInVzZXJuYW1lIjoibGl4aWFvbHUiLCJleHAiOjE1ODUyOTIzMzd9.HuPNmBcsWKn0NJlrgvjTHIptKgu_f7hQk1a6D0Mf9JUTWkRnSONQRYxtfDFOPm8SQyaFmGFG2RJUazTk6oerSSa8LlVL3KOn3FLyjyh3yK82gSQkTuAdmZ052BRNOslIFFDn1t4ypEnqIactsTnWQ3KlyqTnmeLNRvM22MopUIw";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}