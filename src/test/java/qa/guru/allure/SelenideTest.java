package qa.guru.allure;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase{

    @Test
    public void testIssueSearch() {
        open("https://github.com");

        $(".header-search-button").click();
        $("#query-builder-test")
                .setValue("selenide/selenide")
                .pressEnter();

        $(linkText("selenide/selenide")).click();

        $("#issues-tab").click();

        $(withText("3261")).should(exist);

//        sleep(5000);





    }
}
