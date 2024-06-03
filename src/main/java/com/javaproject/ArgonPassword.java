package com.javaproject;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class ArgonPassword {

    public static void main(String[] args) {
        // 创建 Argon2 实例，使用 Argon2id 模式
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        // 将密码定义在 try 块外部
        char[] password = "123456".toCharArray(); // 这里输入你要加密的密码

        try {
            // 生成密码哈希
            String hash = argon2.hash(2, 65536, 1, password);
            System.out.println("Generated hash: " + hash);

            // 验证密码哈希
            boolean success = argon2.verify(hash, password);
            System.out.println("Password verification status: " + success);
        } finally {
            // 清理可能留在内存中的密码
            argon2.wipeArray(password);
        }
    }
}
