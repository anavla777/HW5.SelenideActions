import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GithubSolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="3840x2160";
    }

    @Test
    void openEnterprisePage() {
        open("https://github.com");
        $("nav").$(byTagAndText("button","Solutions")).hover();
        $("[href='/enterprise']").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }
}
