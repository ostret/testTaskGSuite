package com.infrastructure.driver;

import com.codeborne.selenide.WebDriverProvider;
import com.infrastructure.ProjectConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridProvider implements WebDriverProvider {
    public GridProvider() {
    }

    public WebDriver createDriver(DesiredCapabilities capabilities) {
        String hubURL = ProjectConfig.getGridURL();
        HashMap<String, Object> chromePrefs = new HashMap();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments(new String[]{"start-maximized"});
        options.addArguments(new String[]{"--window-size=1600,800"});
        options.addArguments(new String[]{"--no-sandbox"});
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("goog:chromeOptions", options);
        capabilities.setCapability("acceptSslCerts", true);

        try {
            return new RemoteWebDriver(new URL(hubURL), capabilities);
        } catch (MalformedURLException var6) {
            throw new RuntimeException(var6);
        }
    }
}
