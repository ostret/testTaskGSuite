package com.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.infrastructure.ProjectConfig;
import com.infrastructure.driver.ChromeDriverProvider;
import com.infrastructure.driver.GridProvider;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {


    @BeforeClass
    protected void createWebDriver() {
        Configuration.timeout = 30000L;
        if (ProjectConfig.getGridMode()) {
            Configuration.browser = GridProvider.class.getName();
            ((RemoteWebDriver)WebDriverRunner.getWebDriver()).setFileDetector(new LocalFileDetector());
        } else {
            Configuration.browser = ChromeDriverProvider.class.getName();
        }

    }

    @AfterMethod(alwaysRun = true)
    protected void closeBrowser() {
        Selenide.close();
    }
}
