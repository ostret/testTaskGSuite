package com.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.infrastructure.ProjectConfig;
import ru.yandex.qatools.allure.annotations.Step;

public class AccountPage {
    SelenideElement identifierId = Selenide.$("#identifierId");
    SelenideElement nextButton = Selenide.$("#identifierNext");


    @Step("Enter email")
    public AccountPage enterEmailOrPhone(String id) {
        this.identifierId.setValue(id);
        this.identifierId.waitUntil(Condition.value(id), 5000L);
        return this;
    }

    @Step("Click next")
    public PasswordPage clickNext() {
        this.nextButton.click();
        return new PasswordPage();
    }

    public AccountPage enterDefaultEmail() {
        return enterEmailOrPhone(ProjectConfig.getDriveEmail());
    }
}
