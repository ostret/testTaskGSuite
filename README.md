# testTaskGSuite

1. Write an automated test in Java using Selenide which tests Google translate app (translate.google.com) by passing text to it contained in "original" file. The goal of the test is to check if the text in "original" file is translated correctly to Spanish. The correct translation is in "correct translation" file.

2. Write a preparation for test cases set that should clean up a google drive (remove all contents from it) and the upload a file to that google drive.Google drive credentials a passed through environment variables.File to upload is "file to upload.csv"

To run:
mvn clean -e test -Dsuite=tests.xml -DdriveEmail=%your gouugle account name% -DdrivePassword=%your password%

Generate allure report:
allure generate target/allure-results
