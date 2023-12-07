package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/admin.properties")) {
            properties.load(fis);
        } catch (IOException exception) {
            System.out.println("File application.properties Not Found!");
        }
    }

    public static String getAdminUsername() {
        return properties.getProperty("adminUsername");
    }
    public static String getAdminPassword() {
        return properties.getProperty("adminPassword");
    }
}
