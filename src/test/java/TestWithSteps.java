import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class TestWithSteps {

    @Test
    public void testWithSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        steps.openGithub();
        steps.findRepo();
        steps.enterRepo();
        steps.enterIssues();
        steps.checkIssue();
    }
}
