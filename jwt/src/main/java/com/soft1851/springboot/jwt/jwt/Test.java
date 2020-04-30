package com.soft1851.springboot.jwt.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zxl
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 生成token
        Encrypt encrypt = new Encrypt();
        String id = StringUtil.getRandomString();
        String token = encrypt.getToken(true, id, "软件1851");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        Decrypt decrypt = new Decrypt();
        DecodedJWT jwt = decrypt.deToken(token, id);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("id: " + jwt.getClaim("id").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());
        long current = System.currentTimeMillis();
        long time = jwt.getExpiresAt().getTime();
        while(current <= time){
            current = System.currentTimeMillis();
        }
        System.out.println("token已经失效");

    }
}
