package com.tests;

import com.infrastructure.util.FileReaderUtil;
import com.infrastructure.util.RouterUtil;
import org.testng.annotations.Test;

public class testTranslate extends BaseTest {
    public testTranslate() {
    }

    @Test
    public void testTranslate() {
        String originalFileName = "original.txt";
        String translationFileName = "correct translation.txt";

        RouterUtil.openTranslatePage()
                .selectSourceLanguage("English")
                .verifySourceLanguageIsSelected("English")
                .selectTargetLanguage("Spanish")
                .verifyTargetLanguageIsSelected("Spanish")
                .enterSourceText(FileReaderUtil.getTextFromResourceFile(originalFileName))
                .verifyTranslationText(FileReaderUtil.getTextFromResourceFile(translationFileName));
    }
}