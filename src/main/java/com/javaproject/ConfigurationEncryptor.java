package com.javaproject;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
import java.util.Scanner;

public class ConfigurationEncryptor {
    public static void main(String[] args) {
        // 創建加密器實例
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("yekgF4qM69fmDP0vuN4iy6a12u3sFFPW"); // 設置加密密鑰
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());

        try ( // 使用 Scanner 讀取用戶輸入
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Original: ");
            String mySecret = scanner.nextLine(); // 讀取敏感信息
            // 加密敏感信息
            String myEncryptedSecret = encryptor.encrypt(mySecret);
            System.out.println("After: " + myEncryptedSecret);
            // 關閉 Scanner
        }
    }
}
