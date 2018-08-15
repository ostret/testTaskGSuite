package com.domain.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import static com.codeborne.selenide.Selenide.$;

public class TranslatePage {
    private SelenideElement languageBar = Selenide.$(By.id("gt-langs")),
    sourceLangSelect =languageBar.$(By.id("gt-lang-src")),
    targetLangSelect= languageBar.$(By.id("gt-lang-tgt")),
    langMenuSource = $(By.id("gt-sl-gms-menu")),
    langMenuResult = $(By.id("gt-tl-gms-menu")),
    sourceTextInput = $(By.id("gt-src-p")).$("textarea#source"),
    translatedTextSpan = $(By.id("gt-res-content")).$("span#result_box");


    public TranslatePage openSourceLangDropdown() {
        sourceLangSelect.$(By.id("gt-sl-gms")).click();
        return this;
    }

    public TranslatePage openResulteLangDropdown() {
        targetLangSelect.$(By.id("gt-tl-gms")).click();
        return this;
    }

    @Step("Set source language to {0}")
    public TranslatePage selectSourceLanguage(String language) {
        openSourceLangDropdown();
        langMenuSource.$$(".goog-menuitem-content").findBy(Condition.text(language)).click();
        return this;
    }

    @Step("Set target language to {0}")
    public TranslatePage selectTargetLanguage(String language) {
        openResulteLangDropdown();
        langMenuResult.$$(".goog-menuitem-content").findBy(Condition.text(language)).click();
        return this;
    }

    @Step("Verify source language is {0}")
    public TranslatePage verifySourceLanguageIsSelected(String language) {
        sourceLangSelect.$$(".jfk-button").findBy(Condition.text(language))
                .waitUntil(Condition.attribute("aria-pressed", "true"), 1000);
        return this;
    }

    @Step("Verify target language is {0}")
    public TranslatePage verifyTargetLanguageIsSelected(String language) {
        targetLangSelect.$$(".jfk-button").findBy(Condition.text(language))
                .waitUntil(Condition.attribute("aria-pressed", "true"), 1000);
        return this;
    }

    @Step("Enter text into source input")
    public TranslatePage enterSourceText(String sourceText) {
        sourceTextInput.setValue(sourceText);
        sourceTextInput.waitUntil(Condition.value(sourceText), 5000);
        return this;
    }

    @Step("Verify output text")
    public TranslatePage verifyTranslationText(String translatedText) {
        translatedTextSpan.waitUntil(Condition.not(Condition.empty), 5000);
        String tr = translatedTextSpan.text().replaceAll("\\n", "").replaceAll("\\r", "");
        String et = translatedText.replaceAll("\\n", "").replaceAll("\\r", "");
        Assert.assertEquals(tr, et);
        return this;
    }
}
