package com.waimou.epidemic_personnel_management_system.im.zego.serverassistant.sample;

import com.waimou.epidemic_personnel_management_system.im.zego.serverassistant.utils.TokenServerAssistant;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Base64;

public class Token04Sample {
    @Test
    public static void main(String[] args) {
        long appId = 1994355029;    // 由即构提供
        String secretKey = "48d8e39fe1a3772e425115ecb5326633";  // 由即构提供
        String userId = "test_user";    // 用户 ID，同一 appId 下全网唯一
        int effectiveTimeInSeconds = 300;   // 有效时间，单位：秒

        String payload = "{\"payload\":\"payload\"}";// 普通token，payload字段可传空
        TokenServerAssistant.VERBOSE = false;    // 调试时，置为 true, 可在控制台输出更多信息；正式运行时，最好置为 false
        TokenServerAssistant.TokenInfo token =
                TokenServerAssistant.generateToken04(appId,
                        userId, secretKey,
                        effectiveTimeInSeconds,
                        payload);
        System.out.println(token.data);

        if (token.error == null || token.error.code == TokenServerAssistant.ErrorCode.SUCCESS) {
            System.out.println("\r\ndecrypt the token ...");
            decryptToken(token.data, secretKey);
        }
    }

    static private void decryptToken(String token, String secretKey) {
        String noVersionToken = token.substring(2);

        byte[] tokenBytes = Base64.getDecoder().decode(noVersionToken.getBytes());
        ByteBuffer buffer = ByteBuffer.wrap(tokenBytes);
        buffer.order(ByteOrder.BIG_ENDIAN);
        long expiredTime = buffer.getLong();
        System.out.println("expiredTime: " + expiredTime);
        int IVLength = buffer.getShort();
        byte[] ivBytes = new byte[IVLength];
        buffer.get(ivBytes);
        int contentLength = buffer.getShort();
        byte[] contentBytes = new byte[contentLength];
        buffer.get(contentBytes);

        try {
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
            IvParameterSpec iv = new IvParameterSpec(ivBytes);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);

            byte[] rawBytes = cipher.doFinal(contentBytes);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new String(rawBytes));
            System.out.println(json);
        } catch (Exception e) {
            System.out.println("decrypt failed: " + e);
        }
    }

}
