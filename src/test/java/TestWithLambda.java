import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestWithLambda {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "С Новым Годом (2022)";

    @Test
    public void lambdaTest() {

        step("Открыть главную страницу gitHub", () -> {
                    open("https://github.com");
                }
        );
        step("Найти через поисковую строку репозиторий " + REPOSITORY, () -> {
                    $("[data-test-selector='nav-search-input']").click();
                    $("[data-test-selector='nav-search-input']").sendKeys("eroshenkoam/allure-example");
                    $("[data-test-selector='nav-search-input']").pressEnter();
                }
        );
        step("Зайти в репозиторий " + REPOSITORY, () -> {
                    $(By.linkText("eroshenkoam/allure-example")).click();
                }
        );
        step("Зайти на вкладку Issues", () -> {
                    $("#issues-tab").click();
                }
        );
        step("Проверить наличие Issue с заголовком " + ISSUE, () -> {
                    $(withText(ISSUE)).should(Condition.exist);
                }
        );
    }
}
