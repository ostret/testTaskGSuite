package com.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.infrastructure.ProjectConfig;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$$;

import ru.yandex.qatools.allure.annotations.Step;

public class DriveHome {
    private SelenideElement mainContainer = Selenide.$(Selectors.by("guidedhelpid", "main_container")),
    listBox = mainContainer.$(by("role", "listbox")),
    removeButton = $(byXpath("//div[@role='toolbar']//div[@aria-label='Remove']")),
    newButton = $$("button").findBy(Condition.attribute("guidedhelpid", "new_menu_button")),
    fileUpload = $$(by("role", "menuitem")).findBy(Condition.text("File upload"));


    public DriveHome ensurePageLoaded() {
        Selenide.$(Selectors.by("aria-label", "Drive")).waitUntil(Condition.appears, 10000);
        return this;
    }

    private List<SelenideElement> getAllFiles() {
        return this.listBox.$$(Selectors.by("role", "option"));
    }

    @Step("Try to delete all files")
    public DriveHome deleteAllFiles() {
        if (!this.isDriveEmpty()) {
            this.getAllFiles().forEach((item) -> {
                if (item.has(Condition.attribute("aria-selected", "false"))) {
                    item.click();
                }

                this.removeButton.waitUntil(Condition.attribute("aria-disabled", "false"), 2000);
                this.removeButton.click();
            });
        }

        return this;
    }

    @Step("Check if files are present")
    private Boolean isDriveEmpty() {
        return Selenide.$(By.id("empty-view-content-mydrive")).isDisplayed();
    }

    @Step("Upload new file")
    public DriveHome uploadNewFile(String fileName) {
        this.newButton.click();
        this.fileUpload.waitUntil(Condition.visible, 3000);
        this.fileUpload.click();
        Selenide.$(Selectors.byXpath("//input[@type='file']")).uploadFile(new File[]{new File(ProjectConfig.getResourceDir() + File.separator + fileName)});
        return this;
    }

    @Step("Verify file is present")
    public DriveHome verifyFilePresent(String fileName) {
        this.listBox.$$(Selectors.byXpath("//div[@role='option']//span")).findBy(Condition.text(fileName)).shouldBe(new Condition[]{Condition.visible});
        return this;
    }
}