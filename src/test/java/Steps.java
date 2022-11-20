import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class Steps {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "Listeners NamedBy";

    @Step("Открыть главную страницу gitHub")
    public void openGithub() {

        open("https://github.com");

    }

    @Step("Найти через поисковую строку репозиторий " + REPOSITORY)
    public void findRepo() {
        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").sendKeys("eroshenkoam/allure-example");
        $("[data-test-selector='nav-search-input']").pressEnter();
    }

    @Step("Зайти в репозиторий " + REPOSITORY)
    public void enterRepo() {
        $(By.linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Зайти на вкладку Issues")
    public void enterIssues() {

        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue с заголовком " + ISSUE)
    public void checkIssue() {

        $(withText(ISSUE)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

