package com.domain.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

public class DriveLandingPage {
    private SelenideElement goToDriveButton = Selenide.$(".one-whole .go-to-drive");


    @Step("Click go to Drive button")
    public AccountPage gotoDrive() {
        this.goToDriveButton.click();
        return new AccountPage();
    }
}