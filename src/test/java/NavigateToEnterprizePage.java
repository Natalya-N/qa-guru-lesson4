import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NavigateToEnterprizePage {

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1366x768";
    }

    @Test
    void navigateToEnterprizePageTest() {
        open("https://github.com/");
        $x("//button[contains(text(), 'Solutions')]").hover();
        $("a[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered")).shouldHave(text("developer platform."));
    }
}

