package com.javaproject;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jasypt.util.text.AES256TextEncryptor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static final HikariDataSource dataSource;
    public static String decryptedUser;
    public static String decryptedPass;
    private static String URL;

    static {
        try {
            Properties prop = new Properties();

            try (InputStream input = new FileInputStream("config.properties")) {
                prop.load(input);
                URL = prop.getProperty("database.url");
                String USER = prop.getProperty("database.user");
                String PASSWORD = prop.getProperty("database.password");
                AES256TextEncryptor decryptor = new AES256TextEncryptor();
                String encryptionKey = "yekgF4qM69fmDP0vuN4iy6a12u3sFFPW";
                decryptor.setPassword(encryptionKey);
                decryptedUser = decryptor.decrypt(USER);
                decryptedPass = decryptor.decrypt(PASSWORD);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(URL);
            config.setUsername(decryptedUser);
            config.setPassword(decryptedPass);
            config.setMaximumPoolSize(10); // 調整連接池的最大連接數
            config.setMinimumIdle(5); // 設置最小閒置連接數
            config.setConnectionTimeout(30000); // 設置連接超時時間
            config.setIdleTimeout(600000); // 設置連接閒置超時時間
            config.setMaxLifetime(1800000); // 設置連接的最大存活時間
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            config.addDataSourceProperty("useServerPrepStmts", "true");
            dataSource = new HikariDataSource(config);
        } catch (Exception e) {
            throw new RuntimeException("Error initializing HikariCP connection pool", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}
