package com.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.infrastructure.ProjectConfig;
import ru.yandex.qatools.allure.annotations.Step;

public class PasswordPage {
    private SelenideElement passwordInput = Selenide.$("#password input");
    private SelenideElement nextButton = Selenide.$("#passwordNext");


    @Step("Enter password")
    public PasswordPage enterPassword(String password) {
        passwordInput.setValue(password);
        passwordInput.waitUntil(Condition.value(password), 5000);
        return this;
    }

    @Step("Click Next")
    public DriveHome clickNext() {
        nextButton.click();
        return new DriveHome();
    }

    public PasswordPage enterDefaultPassword() {
        return enterPassword(ProjectConfig.getDrivePassword());
    }
}
