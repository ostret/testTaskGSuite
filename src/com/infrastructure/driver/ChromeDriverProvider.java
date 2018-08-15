package com.infrastructure.driver;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverProvider implements WebDriverProvider {
    public ChromeDriverProvider() {
    }

    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        ChromeDriverManager.getInstance().setup();
        HashMap<String, Object> chromePrefs = new HashMap();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments(new String[]{"--window-size=1600,800"});
        options.addArguments(new String[]{"--no-sandbox"});
        return new ChromeDriver(options);
    }
}
