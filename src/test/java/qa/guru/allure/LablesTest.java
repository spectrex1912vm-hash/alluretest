package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LablesTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Lasta")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизованного пользователя")
    public void testStaticLables() {

    }

    @Test
    public void testDinamicLables() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "Lasta");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");

    }

}
