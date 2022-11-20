import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestWithSteps {

    @Test
    @Feature("Issue в репозитории")
    @Story("Поиск Issue")
    @Owner("Daria Cherchimtseva")
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Поиск Issue по названию")
    public void testWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Steps steps = new Steps();
        steps.openGithub();
        steps.findRepo();
        steps.enterRepo();
        steps.enterIssues();
        steps.checkIssue();
        steps.takeScreenshot();
    }
}
