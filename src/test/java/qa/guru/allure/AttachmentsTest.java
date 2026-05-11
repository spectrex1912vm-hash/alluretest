package qa.guru.allure;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest extends TestBase{


    @Test
    public void testAttachmentsAttachments() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });


   }

    @Test
    public void testAnnotatedsStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}
