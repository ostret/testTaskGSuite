package com.tests;

import com.infrastructure.util.RouterUtil;
import org.testng.annotations.Test;

public class testDriveUpload extends BaseTest {
    public testDriveUpload() {
    }

    @Test
    public void testDriveUpload() throws InterruptedException {
        String fileForUpload = "file to upload.csv";

        RouterUtil.openDrivePage()
                .gotoDrive()
                .enterDefaultEmail()
                .clickNext()
                .enterDefaultPassword()
                .clickNext()
                .deleteAllFiles()
                .uploadNewFile(fileForUpload)
                .verifyFilePresent(fileForUpload);

    }
}