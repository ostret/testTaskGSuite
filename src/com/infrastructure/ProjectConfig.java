package com.infrastructure;

import java.io.File;
import org.testng.Reporter;

public class ProjectConfig {
    private static String translateUrl = getSystemProperty("translateUrl", "https://translate.google.com/");
    private static String resourceDir = (new File("src/com/tests/resources")).getAbsolutePath();
    private static String driveUrl = getSystemProperty("driveUrl", "https://drive.google.com/");
    private static String driveEmail = getSystemProperty("driveEmail");
    private static String drivePassword = getSystemProperty("drivePassword");
    private static Boolean gridMode = getSystemProperty("gridMode", false);
    private static String gridURL = getSystemProperty("gridURL", "http://192.168.99.100:31046/wd/hub");

    public ProjectConfig() {
    }

    public static String getTranslateUrl() {
        return translateUrl;
    }

    public static String getResourceDir() {
        return resourceDir;
    }

    public static String getDriveUrl() {
        return driveUrl;
    }

    public static String getDriveEmail() {
        return driveEmail;
    }

    public static String getDrivePassword() {
        return drivePassword;
    }

    public static String getGridURL() {
        return gridURL;
    }

    public static Boolean getGridMode() {
        return gridMode;
    }

    public static String getSystemProperty(String property, String defaultValue) {
        String propertyString = defaultValue;

        try {
            propertyString = System.getProperty(property, defaultValue);
        } catch (RuntimeException var4) {
            Reporter.log(" LOG - Can't extract property " + property, true);
        }

        return propertyString;
    }

    public static String getSystemProperty(String property) {
        String propertyString = "";

        try {
            propertyString = System.getProperty(property);
        } catch (RuntimeException var3) {
            Reporter.log(" LOG - Can't extract property " + property, true);
        }

        return propertyString;
    }

    public static Boolean getSystemProperty(String property, Boolean defaultValue) {
        String propertyString = defaultValue.toString();

        try {
            propertyString = System.getProperty(property, defaultValue.toString());
        } catch (RuntimeException var4) {
            Reporter.log(" LOG - Can't extract property " + property, true);
        }

        return Boolean.parseBoolean(propertyString);
    }
}
