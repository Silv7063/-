package com.javaproject;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.Scanner;

public class ArgonPassword {

    public static void main(String[] args) {
        // 創建 Argon2 實例，使用 Argon2id 模式
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        // 使用 Scanner 讀取用戶輸入
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input your password: ");
        String inputPassword = scanner.nextLine();
        char[] password = inputPassword.toCharArray();

        try {
            // 生成密碼哈希
            String hash = argon2.hash(2, 65536, 1, password);
            System.out.println("Hash: " + hash);

            // 驗證密碼哈希
            boolean success = argon2.verify(hash, password);
            System.out.println("Verify: " + success);
        } finally {
            // 清理可能留在內存中的密碼
            argon2.wipeArray(password);
            scanner.close();
        }
    }
}
