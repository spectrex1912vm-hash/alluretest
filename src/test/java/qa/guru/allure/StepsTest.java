package qa.guru.allure;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase{
    private static final String REPOSITORY = "selenide/selenide";
    private static final int ISSUE = 3261;

    @Test
    public void testLambdaStep() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test")
                    .setValue(REPOSITORY)
                    .pressEnter();
        });

        step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем наличие Issues с номером " + ISSUE, () ->{
            $(withText("" + ISSUE)).should(exist);
        });


//        sleep(5000);
    }

    @Test
    public void testAnnotatedsStep() {
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE);

    }
}
