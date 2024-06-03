package com.javaproject;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;

public class ConfigurationEncryptor {
    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("yekgF4qM69fmDP0vuN4iy6a12u3sFFPW"); // 设置加密密钥
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());
        String mySecret = "ntoujava2024"; // 需要加密的敏感信息
        String myEncryptedSecret = encryptor.encrypt(mySecret);
        System.out.println("Encrypted: " + myEncryptedSecret);
    }
}
