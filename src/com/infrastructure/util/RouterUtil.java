package com.infrastructure.util;

import com.codeborne.selenide.Selenide;
import com.domain.pages.DriveLandingPage;
import com.domain.pages.TranslatePage;
import com.infrastructure.ProjectConfig;
import ru.yandex.qatools.allure.annotations.Step;

public class RouterUtil {

    @Step("Open Translate page")
    public static TranslatePage openTranslatePage() {
        Selenide.open(ProjectConfig.getTranslateUrl());
        return new TranslatePage();
    }

    @Step("Open Drive page")
    public static DriveLandingPage openDrivePage() {
        Selenide.open(ProjectConfig.getDriveUrl());
        return new DriveLandingPage();
    }
}