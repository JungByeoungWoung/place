package com.market.place;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA 암호화 방식 테스트
 * place 프로젝트랑 연관 성 없음
 */
public class SecretTest {

    @Test
    void doItEncryptDecrypt() {
        Map<String, String> keyPair = createKeyPublicPrivate();
        String publicKey = keyPair.get("publicKey");
        String privateKey = keyPair.get("privateKey");

        String plainText = "Test";
        String encryptText = encrypt(plainText, publicKey);
        System.out.println("enctyptText >>>>" + encryptText);
        String decryptText = decrypt(encryptText, privateKey);
        System.out.println("dectyptText >>>>" + decryptText);

        Assertions.assertThat(decryptText).isEqualTo(plainText);
    }
    /**
     * 공개키 개인키 생성
     * @return stringKeyPair
     */
    public Map<String, String> createKeyPublicPrivate() {
        HashMap<String, String> stringKeyPair = new HashMap<>();
        try {
            SecureRandom secureRandom = new SecureRandom();
            // 암호화 방식 선언
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048, secureRandom);
            // 키 쌍 생성
            KeyPair keyPair = generator.genKeyPair();
            // 공개키, 개인키 한 쌍 생성
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // 키 전송 시 데이터 손실을 막기 위한 Base64 인코딩
            String publicKeyToStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyToStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            stringKeyPair.put("publicKey", publicKeyToStr);
            stringKeyPair.put("privateKey", privateKeyToStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringKeyPair;
    }

    /**
     * 평문 공개키를 이용해서 암호화
     * @param plainText
     * @param publicKey
     * @return 암호화된 평문
     */
    public static String encrypt(String plainText, String publicKey) {
        String encryptPlainText = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] publicKeyToByte = Base64.getDecoder().decode(publicKey.getBytes());

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyToByte);
            PublicKey publicK = keyFactory.generatePublic(publicKeySpec);

            // 공개키 객체로 암호화 설정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicK);

            byte[] encryptPlainTextToByte = cipher.doFinal(plainText.getBytes());
            encryptPlainText = Base64.getEncoder().encodeToString(encryptPlainTextToByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptPlainText;
    }

    public static String decrypt(String encryptText, String privateKey) {
        String decryptText = null;
        try {
            // 1. 공개키 객체 생성
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] privateKeyToByte = Base64.getDecoder().decode(privateKey.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyToByte);
            PrivateKey privateK = keyFactory.generatePrivate(privateKeySpec);

            // 2. cipher 라이브러리를 이용한 복호화
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateK);

            byte[] encryptTextToByte = Base64.getDecoder().decode(encryptText.getBytes());
            byte[] decryptByte = cipher.doFinal(encryptTextToByte);
            decryptText = new String(decryptByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptText;
    }
}
